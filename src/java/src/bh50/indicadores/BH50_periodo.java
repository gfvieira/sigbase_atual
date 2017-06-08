package src.bh50.indicadores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.bh30.bh31.pessoal.CadPessoal;
import src.dao.DaoIndicadores;
import src.dao.DaoIndicadoresbh50;
import src.modelo.Indicador_model;

public class BH50_periodo extends HttpServlet {

    String type = "";
    String access = "";
    String year = "";
    String mensal = "";
    int total = 0, totalH = 0, totalL = 0;
    String dia = "", mes = "", ano = "", ini = "";
    Date data_ini, data_fim = null;
    int totalT = 0, totalR = 0;
    DaoIndicadoresbh50 daoindic = null;
    ArrayList<Indicador_model> sate = null;
    String feed = "";
    ArrayList<Indicador_model> oficina = null;
    Indicador_model el = null, mo = null, mt = null, cp = null, cav = null, prefe = null, moto = null;

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("data_ini")) {
                    ini = req.getParameterValues(key)[0];
                    ini = ini.replaceAll("[^a-zZ-Z0-9 ]", "");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    if (!ini.equals("")) {
                        ano = ini.substring(0, 4);
                        mes = ini.substring(4, 6);
                        dia = ini.substring(6, 8);
                    }
                    ini = (dia + "/" + mes + "/" + ano);
                     
                    try {
                        data_ini = new Date(format.parse(ini).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(CadPessoal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.equals("data_fim")) {
                    ini = req.getParameterValues(key)[0];
                    ini = ini.replaceAll("[^a-zZ-Z0-9 ]", "");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    if (!ini.equals("")) {
                        ano = ini.substring(0, 4);
                        mes = ini.substring(4, 6);
                        dia = ini.substring(6, 8);
                    }
                    ini = (dia + "/" + mes + "/" + ano);
                     
                    try {
                        data_fim = new Date(format.parse(ini).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(CadPessoal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.equals("type")) {
                    type = req.getParameterValues(key)[0];
                }
                if (key.equals("mensal")) {
                    mensal = req.getParameterValues(key)[0];
                }if (key.equals("ano")) {
                    year = req.getParameterValues(key)[0];
                }
                
            }
            total = 0;
            daoindic = new DaoIndicadoresbh50();
            oficina = new ArrayList<>();
            if (type.equals("1")) {
                oficina = daoindic.buscaindData50(data_ini, data_fim);
            } else {
                oficina = daoindic.buscaindMensal50(mensal, year);
            }
            el = new Indicador_model();
            mo = new Indicador_model();
            mt = new Indicador_model();
            cp = new Indicador_model();
            cav = new Indicador_model();
            prefe = new Indicador_model();
            moto = new Indicador_model();
            if (oficina == null || oficina.isEmpty()) {//testar com 1 oficina sem resultado
                mo.setFinalizado(0);
                mo.setEm_andamento(0);
                mo.setNao_iniciado(0);
                mo.setTotal(0);
                prefe = cav = moto = el = mt = cp = mo;
            } else {
                oficina.stream().forEach((sate1) -> {
                    total += sate1.getTotal();
                    if (sate1.getOficina().equals("ELETRICA")) {
                        el = sate1;
                    }
                    if (sate1.getOficina().equals("REFRIGERACAO")) {
                        mo = sate1;
                    }
                    if (sate1.getOficina().equals("CARPINTARIA")) {
                        cp = sate1;
                    }
                    if (sate1.getOficina().equals("METALURGIA")) {
                        mt = sate1;
                    }
                    if (sate1.getOficina().equals("AGUADA")) {
                        cav = sate1;
                    }
                    if (sate1.getOficina().equals("PREFEITURA")) {
                        prefe = sate1;
                    }
                    if (sate1.getOficina().equals("GARAGEM")) {
                        moto = sate1;
                    }
                });
            }
            if (type.equals("HOME")) {
                req.setAttribute("qnt", total);
                req.setAttribute("eletrica", el);
                req.setAttribute("refrigeracao", mo);
                req.setAttribute("carpintaria", cp);
                req.setAttribute("metalurgia", mt);
                req.setAttribute("cav", cav);
                req.setAttribute("prefeitura", prefe);
                req.setAttribute("garagem", moto);
                RequestDispatcher rd = req.getRequestDispatcher("oficina50_home.jsp");
                rd.forward(req, response);
            } else {
                req.setAttribute("qnt", total);
                req.setAttribute("eletrica", el);
                req.setAttribute("refrigeracao", mo);
                req.setAttribute("carpintaria", cp);
                req.setAttribute("metalurgia", mt);
                req.setAttribute("cav", cav);
                req.setAttribute("prefeitura", prefe);
                req.setAttribute("garagem", moto);
                RequestDispatcher rd = req.getRequestDispatcher("oficina50_indicadores.jsp");
                rd.forward(req, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

