package src.bh30.bh34.indicadores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIndicadores;
import src.dao.DaoIndicadoresbh30;
import src.modelo.Indicador_model;

public class BH34_anual extends HttpServlet {

    String type = "";
    String access = "";
    String feed = "";
    int total = 0, totalH = 0, totalL = 0;
    int totalT = 0, totalR = 0;
    DaoIndicadoresbh30 daoindic = null;
    ArrayList<Indicador_model> sate = null;
    Indicador_model hard = null, rede = null, lotus = null, tel = null, som = null, fono = null;

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
                if (key.equals("ind")) {
                    type = req.getParameterValues(key)[0];
                }
                if (key.equals("access")) {
                    access = req.getParameterValues(key)[0];
                }
                if (key.equals("feed")) {
                    feed = req.getParameterValues(key)[0];
                }
            }
            total = 0;
            daoindic = new DaoIndicadoresbh30();
            sate = new ArrayList<>();
            sate = daoindic.buscaindAnual();
            hard = new Indicador_model();
            rede = new Indicador_model();
            lotus = new Indicador_model();
            tel = new Indicador_model();
            som = new Indicador_model();
            fono = new Indicador_model();
            if (sate == null || sate.isEmpty()) {//testar com 1 oficina sem resultado
                rede.setFinalizado(0);
                rede.setEm_andamento(0);
                rede.setNao_iniciado(0);
                rede.setTotal(0);
                hard = lotus = tel = fono = som = rede ;
            } else {
                sate.stream().forEach((sate1) -> {
                    total += sate1.getTotal();
                    if (sate1.getOficina().equals("REDE")) {
                        rede = sate1;
                    }
                    if (sate1.getOficina().equals("HARDWARE")) {
                        hard = sate1;
                    }
                    if (sate1.getOficina().equals("LOTUS")) {
                        lotus = sate1;
                    }
                    if (sate1.getOficina().equals("TELEFONIA")) {
                        tel = sate1;
                    }
                    if (sate1.getOficina().equals("SOM")) {
                        som = sate1;
                    }
                    if (sate1.getOficina().equals("FONOCLAMA")) {
                        fono = sate1;
                    }
                });
            }if (type.equals("HOME")) {
                req.setAttribute("qnt", total);
                req.setAttribute("rede", rede);
                req.setAttribute("hard", hard);
                req.setAttribute("lotus", lotus);
                req.setAttribute("tel", tel);
                req.setAttribute("som", som);
                req.setAttribute("fono", fono);
                RequestDispatcher rd = req.getRequestDispatcher("oficina34_home.jsp");
                rd.forward(req, response);
            } else {
                req.setAttribute("qnt", total);
                req.setAttribute("rede", rede);
                req.setAttribute("hard", hard);
                req.setAttribute("lotus", lotus);
                req.setAttribute("tel", tel);
                req.setAttribute("som", som);
                req.setAttribute("fono", fono);
                RequestDispatcher rd = req.getRequestDispatcher("oficina34_indicadores.jsp");
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