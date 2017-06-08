/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.chapa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
import src.dao.DaoApendiceChapa;
import src.dao.DaoChapa;
import src.modelo.Chapa_Apendice;
import src.modelo.Chapa_Permissionario;
import src.modelo.Chapa_Veiculo;

import src.modelo.Chapa_Veiculo;
import src.modelo.Chapa_Dependente;

/**
 *
 * @author admin
 */
public class AtualizaPermissionario extends HttpServlet {

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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

            int qtdDep = Integer.parseInt(getValue(inputsForm, "qtdD"));
            int qtdVeiculos = Integer.parseInt(getValue(inputsForm, "qtdC"));

            Chapa_Permissionario chapa = new Chapa_Permissionario();
            chapa.setId(Integer.parseInt(getValue(inputsForm, "idHidden")));
            chapa.setBloco(getValue(inputsForm, "bloco"));
            chapa.setApto(getValue(inputsForm, "apto"));
            chapa.setNome(getValue(inputsForm, "nomeHidden"));
            chapa.setNip(getValue(inputsForm, "nipHidden"));
            chapa.setGrad(Integer.parseInt(getValue(inputsForm, "grad")));
            chapa.setOm(Integer.parseInt(getValue(inputsForm, "om")));
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

            DaoChapa dao = new DaoChapa();

            boolean atualizou = dao.atualizaPermissionario(chapa);

            Chapa_Permissionario perm = dao.buscaPermissionarioDoApto(chapa.getNip(), chapa.getApto(), chapa.getBloco(), 1);
            perm.setIp(request.getRemoteAddr());

            ArrayList<Chapa_Dependente> dependentes = new ArrayList<>();
            ArrayList<Chapa_Dependente> dependentesExistentes = dao.buscaDependentesPermissionario(perm);

            for (int i = 0; i < qtdDep; i++) {
                dependentes.add(new Chapa_Dependente());
                dependentes.get(i).setId_chapa(perm.getId());
                dependentes.get(i).setId_chapa_dependentes(Integer.parseInt(getValue(inputsForm, "id_dep" + i)));
                dependentes.get(i).setChapa_active(1);
                dependentes.get(i).setNome(getValue(inputsForm, "nomeDep" + i));
                dependentes.get(i).setParentesco(getValue(inputsForm, "parentescoDep" + i));
                dependentes.get(i).setIdade(Integer.parseInt(getValue(inputsForm, "idadeDep" + i)));
                dependentes.get(i).setIdent(getValue(inputsForm, "ident" + i));
                dependentes.get(i).setUser_cad(perm.getUser());
                dependentes.get(i).setNip(getValue(inputsForm, "nip" + i));
                dependentes.get(i).setIp_cad(request.getRemoteAddr());
            }

            boolean depExiste = false;
            for (int i = 0; i < dependentes.size(); i++) {
                for (int j = 0; j < dependentesExistentes.size(); j++) {
                    if (dependentes.get(i).getId_chapa_dependentes() == dependentesExistentes.get(j).getId_chapa_dependentes()) {
                        depExiste = true;
                    }
                }
                if (depExiste) {
                    dao.atualizaDependente(dependentes.get(i));
                } else {
                    dao.insereDependente(dependentes.get(i));
                }
                depExiste = false;
            }

            ArrayList<Chapa_Veiculo> veiculos = new ArrayList<>();
            ArrayList<Chapa_Veiculo> veiculosExistentes = dao.buscaVeiculoPermissionario(perm);
            boolean veiExiste = false;
            for (int i = 0; i < qtdVeiculos; i++) {
                veiculos.add(new Chapa_Veiculo());
                veiculos.get(i).setId_Veiculo(Integer.parseInt(getValue(inputsForm, "id_vei" + i)));
                veiculos.get(i).setId_chapa(perm.getId());
                veiculos.get(i).setModelo(getValue(inputsForm, "veiculo" + i));
                veiculos.get(i).setPlaca(getValue(inputsForm, "placa" + i));
                veiculos.get(i).setChapa_active(1);
                veiculos.get(i).setUser(perm.getUser());
                veiculos.get(i).setIp(request.getRemoteAddr());
            }

            for (int i = 0; i < veiculos.size(); i++) {
                for (int j = 0; j < veiculosExistentes.size(); j++) {
                    if (veiculos.get(i).getId_Veiculo() == veiculosExistentes.get(j).getId_Veiculo()) {
                        veiExiste = true;
                    }
                }
                if (veiExiste) {
                    dao.atualizaVeiculo(veiculos.get(i));
                } else {
                    dao.cadastraVeiculo(veiculos.get(i), 1, perm.getId(), perm.getUser(), perm.getIp());
                }
                veiExiste = false;
            }

            veiculos = dao.buscaVeiculoPermissionario(perm);
            dependentes = dao.buscaDependentesPermissionario(perm);

            DaoApendiceChapa daoApendice = new DaoApendiceChapa();            
            
            try {
                Uploader arq = new Uploader(items, request, perm.getId());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            Chapa_Apendice apendiceOld = daoApendice.buscaApendiceChapa(chapa.getNip());

            if (atualizou) {
                request.setAttribute("perm", perm);
                request.setAttribute("veiculos", veiculos);
                request.setAttribute("dependentes", dependentes);
                request.setAttribute("apendice", apendiceOld);
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_exibepermissionario.jsp");
                rd.forward(request, response);
            }
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
        String action = request.getParameter("action");
        if (action.equals("deleteVeiculo") || action.equals("deleteDep")) {
            doDelete(request, response);
        } else {
            try {
                processRequest(request, response);
            } catch (FileUploadException ex) {
                ex.printStackTrace();
                Logger.getLogger(AtualizaPermissionario.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            ex.printStackTrace();
            Logger.getLogger(AtualizaPermissionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("deleteVeiculo")) {
                deletaVeiculo(request, response);
            } else if (action.equals("deleteDep")) {
                deletaDependente(request, response);
            }

        }
    }

    protected void deletaVeiculo(HttpServletRequest request, HttpServletResponse response) {
        String modelo = request.getParameter("modelo");
        String placa = request.getParameter("placa");
        String id_Veiculo = request.getParameter("id_Veiculo");

        DaoChapa dao = new DaoChapa();

        dao.deletaVeiculo(id_Veiculo, modelo, placa);

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

    private void deletaDependente(HttpServletRequest request, HttpServletResponse response) {
        int id_dep = Integer.parseInt(request.getParameter("id_dep"));

        DaoChapa dao = new DaoChapa();

        dao.deletaDependente(id_dep);

    }

}
