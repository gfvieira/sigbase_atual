/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh10.folhaN;

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
import src.dao.DaoFolhaN;
import src.modelo.FolhanOm;

public class ExibeOM extends HttpServlet {

    DaoFolhaN daofolha = null;
    ArrayList<FolhanOm> om = null;
    int tipo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = null;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("tipo")) {
                    tipo = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daofolha = new DaoFolhaN();
            switch (tipo) {
                case 1:
                    om = new ArrayList<>();
                    om = daofolha.folhan_om();
                    request.setAttribute("tipo", "1");
                    request.setAttribute("om", om);
                    rd = request.getRequestDispatcher("folhan_om_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 2:
                    om = new ArrayList<>();
                    om = daofolha.folhan_om("TERRA");
                    request.setAttribute("tipo", "2");
                    request.setAttribute("om", om);
                    rd = request.getRequestDispatcher("folhan_om_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 3:
                    om = new ArrayList<>();
                    om = daofolha.folhan_om("NAVIO");
                    request.setAttribute("tipo", "3");
                    request.setAttribute("om", om);
                    rd = request.getRequestDispatcher("folhan_om_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                default:
                    break;
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
