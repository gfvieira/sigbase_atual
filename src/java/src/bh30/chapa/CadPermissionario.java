package src.bh30.chapa;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import src.dao.DaoChapa;
import src.modelo.Chapa_Permissionario;
import src.modelo.Chapa_Veiculo;
import src.modelo.Chapa_Dependente;
import src.modelo.Chapa_historico;
//import src.modelo.Chapa_model;

public class CadPermissionario extends HttpServlet {

    private int type = 0;
    private DaoChapa daochapa = null;
    private Chapa_Permissionario chapa = null;
    private String dia = "", mes = "", ano = "", nasc = "";

    protected String getValue(List<FileItem> formItens, String field) {
        String value = "";
        for (int i = 0; i < formItens.size(); i++) {
            if (formItens.get(i).getFieldName().equals(field)) {
                try {
                    byte[] data = formItens.get(i).get();
                    if (data != null && data.length > 0) {
                        value = new String(data, "UTF-8");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return value;
            }

        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        ArrayList<FileItem> inputsForm = new ArrayList<>();
        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                inputsForm.add(item);
            }
        }

        try (PrintWriter out = response.getWriter()) {
            chapa = new Chapa_Permissionario();

            daochapa = new DaoChapa();

            String qtdVei = getValue(inputsForm, "qtdCarros");
            int qtdVeiculos;

            if (qtdVei.length() > 0) {
                qtdVeiculos = Integer.parseInt(qtdVei);
            } else {
                qtdVeiculos = 0;
            }
            int qtdDep = Integer.parseInt(getValue(inputsForm, "qtdDep"));

            chapa.setNome(getValue(inputsForm, "nome"));
            chapa.setBloco(getValue(inputsForm, "bloco"));
            chapa.setApto(getValue(inputsForm, "apto"));
            chapa.setNip(getValue(inputsForm, "nipHidden"));
            chapa.setGrad(Util.Util.graduacaoParaInt(getValue(inputsForm, "gradHidden")));
            chapa.setOm(Util.Util.omParaInt(getValue(inputsForm, "omHidden")));
            chapa.setIdentidade(getValue(inputsForm, "rg"));
            chapa.setCpf(getValue(inputsForm, "cpf"));
            chapa.setEstadoCivil(Integer.parseInt(getValue(inputsForm, "estadoCivil")));
            chapa.setEndereco(getValue(inputsForm, "endereco"));
            chapa.setTelefone(getValue(inputsForm, "telefone"));
            chapa.setCelular(getValue(inputsForm, "celular"));
            chapa.setRamal(getValue(inputsForm, "ramalHidden"));
            chapa.setUser(getValue(inputsForm, "user"));

            chapa.setMsg(getValue(inputsForm, "msgHidden"));

            chapa.setIp(request.getRemoteAddr());

            boolean inseriu = false;
            inseriu = daochapa.inserePermissionario(chapa);//Insere na fila

            Date dataCad = new Date();

            Chapa_Permissionario perm = daochapa.buscaPermissionarioDoApto(chapa.getNip(), chapa.getApto(), chapa.getBloco(), 1);
            perm.setIp(request.getRemoteAddr());

            Chapa_historico historico = new Chapa_historico();
            Date date = new Date();

            historico.setId_chapa(perm.getId());
            historico.setNip(chapa.getNip());
            historico.setInicio_moradia(date);
            historico.setUseralt(chapa.getUser());
            historico.setIp_cad(request.getRemoteAddr());

            boolean inseriuHistorico = daochapa.insertHistoricoChapa(historico);

            ArrayList<Chapa_Dependente> dependentes = new ArrayList<>();

            for (int i = 0; i < qtdDep; i++) {
                dependentes.add(new Chapa_Dependente());
                dependentes.get(i).setId_chapa(perm.getId());
                dependentes.get(i).setChapa_active(1);
                dependentes.get(i).setNome(getValue(inputsForm, "nomeDep" + i));
                dependentes.get(i).setParentesco(getValue(inputsForm, "parentescoDep" + i));
                dependentes.get(i).setIdade(Integer.parseInt(getValue(inputsForm, "idadeDep" + i)));
                dependentes.get(i).setIdent(getValue(inputsForm, "ident" + i));
                dependentes.get(i).setUser_cad(perm.getUser());
                dependentes.get(i).setNip(getValue(inputsForm, "nip" + i));
                dependentes.get(i).setIp_cad(request.getRemoteAddr());
            }

            for (int i = 0; i < dependentes.size(); i++) {
                daochapa.insereDependente(dependentes.get(i));
            }

            ArrayList<Chapa_Veiculo> veiculos = new ArrayList<>();

            for (int i = 0; i < qtdVeiculos; i++) {
                veiculos.add(new Chapa_Veiculo());
                veiculos.get(i).setId_chapa(perm.getId());
                veiculos.get(i).setModelo(getValue(inputsForm, "veiculo" + i));
                veiculos.get(i).setPlaca(getValue(inputsForm, "placa" + i));
                veiculos.get(i).setChapa_active(1);
                veiculos.get(i).setUser(perm.getUser());
                veiculos.get(i).setIp(request.getRemoteAddr());
            }

            for (int i = 0; i < veiculos.size(); i++) {
                daochapa.cadastraVeiculo(veiculos.get(i), 1, perm.getId(), perm.getUser(), perm.getIp());
            }

            //Retirar da fila de espera
            boolean removeuFila = false;
            removeuFila = daochapa.removePermissionario(chapa);// setar fila = 1

            try {
                Uploader arq = new Uploader(items, request, perm.getId());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (inseriu && removeuFila) {
                request.setAttribute("mensagem", "OK");
                RequestDispatcher rdd = request.getRequestDispatcher("bh30_chapa_cadfila.jsp");
                rdd.forward(request, response);
            } else {
                System.out.println("cadastrou");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadPermissionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadPermissionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadPermissionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
