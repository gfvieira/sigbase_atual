/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.sargenteante;

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
import src.dao.DaoSargenteante;
import src.modelo.Pessoal_model;

/**
 *
 * @author gustavo
 */
public class SargenteanteFeriasControle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int type = 0;
            String access = "";
            DaoSargenteante daobh30 = null;
            ArrayList<Pessoal_model> servidorarray = null;
            ArrayList<Pessoal_model> servidorarrayFinal = null;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("access")) {
                    access = request.getParameterValues(key)[0];
                }
            }
            daobh30 = new DaoSargenteante();
            servidorarray = new ArrayList<>();
            if ("10".equals(access) 
                    || "20".equals(access) 
                    || "30".equals(access) 
                    || "40".equals(access) 
                    || "50".equals(access)) {
                switch (type) {
                    case 1:
                        servidorarray = daobh30.buscaPracaDep(access);
                        break;
                    case 2:
                        servidorarray = daobh30.buscaOficialDep(access);
                        break;
                    case 3:
                        servidorarray = daobh30.buscaTTCDep(access);
                        break;
                    case 4:
                        servidorarray = daobh30.buscaCivilDep(access);
                        break;
                    default:
                        break;
                }
            }else{
                switch (type) {
                    case 1:
                        servidorarray = daobh30.buscaPracaDivisao(access);
                        break;
                    case 2:
                        servidorarray = daobh30.buscaOficialDivisao(access);
                        break;
                    case 3:
                        servidorarray = daobh30.buscaTTCDivisao(access);
                        break;
                    case 4:
                        servidorarray = daobh30.buscaCivilDivisao(access);
                        break;
                    default:
                        break;
                }
            }
            servidorarrayFinal = new ArrayList<>();
            for (Pessoal_model serv : servidorarray) {
                ArrayList<Pessoal_model> servidorarrayTemp = new ArrayList<>();
                servidorarrayTemp = daobh30.buscaFerias(serv);
                int total = 0;
                for (Pessoal_model serv2 : servidorarrayTemp) {
                    total = total + serv2.getDiasFerias();
                }
                serv.setDiasFerias(total);
                servidorarrayFinal.add(serv);
            }
            request.setAttribute("servidorarray", servidorarrayFinal);
            RequestDispatcher rd = request.getRequestDispatcher("sargenteante_ferias_listar.jsp");
            rd.forward(request, response);
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
