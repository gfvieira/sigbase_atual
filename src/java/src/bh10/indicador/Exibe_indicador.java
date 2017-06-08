/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh10.indicador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIndicadoresbh10;
import src.modelo.Indicador_bh10_model;

public class Exibe_indicador extends HttpServlet {

    DaoIndicadoresbh10 daoind = null;
    Indicador_bh10_model ind, ind1, ind2, ind3, ind4, ind5, ind6, ind7, ind8, ind9, ind10, ind11, ind12 = null;
    ArrayList<Indicador_bh10_model> indbh10 = null;

    String year = "";
    String mensal = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ind = new Indicador_bh10_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("ind")) {
                    ind.setIndicador(request.getParameterValues(key)[0].toUpperCase());
                }
            }
            daoind = new DaoIndicadoresbh10();
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            year = new SimpleDateFormat("yy").format(tm);
            int ano = Integer.parseInt(year);
            year = Integer.toString(ano);
            String d1 = new SimpleDateFormat("MM").format(tm);
            int mes = Integer.parseInt(d1);
            indbh10 = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                if (mes == 12) {
                    mes = 1;
                    mensal = Integer.toString(mes);
                    year = Integer.toString(++ano);
                } else if (i == 1 && mes > 6) {
                    mes -= 6;
                    mensal = Integer.toString(mes);
                } else if (i == 1 && mes == 6) {
                    mes = 1;
                    mensal = Integer.toString(mes);
                } else if (i == 1 && mes < 6) {
                    mes += 6;
                    mensal = Integer.toString(mes);
                } else {
                    ++mes;
                    mensal = Integer.toString(mes);
                }
                /*if (mes == 0) {
                    mes = 12;
                    ano--;
                }*/
                ind1 = new Indicador_bh10_model();
                ind1 = daoind.indbh10(ind.getIndicador(), ano, mes);
                indbh10.add(ind1);
            }
            if (ind.getIndicador().equals("IAEQ")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh11_iaeq.jsp");
                rd.forward(request, response);
            }
            if (ind.getIndicador().equals("IAER")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh11_iaer.jsp");
                rd.forward(request, response);
            }
            if (ind.getIndicador().equals("IASO")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh11_iaso.jsp");
                rd.forward(request, response);
            }
            if (ind.getIndicador().equals("IID")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh12_iid.jsp");
                rd.forward(request, response);
            }
            if (ind.getIndicador().equals("IMNP")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh12_imnp.jsp");
                rd.forward(request, response);
            }
            if (ind.getIndicador().equals("IMNQ")) {
                request.setAttribute("array", indbh10);
                RequestDispatcher rd = request.getRequestDispatcher("bh10_indicador_bh12_imnq.jsp");
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
