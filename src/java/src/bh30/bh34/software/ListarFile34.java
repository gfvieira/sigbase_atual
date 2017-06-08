/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.bh34.software;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoOficina34;
import src.modelo.Oficina34_doc;

/**
 *
 * @author gustavo
 */
public class ListarFile34 extends HttpServlet {

    DaoOficina34 daooficina = null;
    ArrayList<Oficina34_doc> oficina = null;
    String type = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            type = request.getParameter("type");
            daooficina = new DaoOficina34();
            oficina = new ArrayList<>();
            oficina = daooficina.listaDocs();
            if (oficina.isEmpty()) {
                request.setAttribute("oficinaarray", oficina);
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_sw_listar.jsp");
                rd.forward(request, response);
            } else if (type.equals("OK") || type.equals("NOT")) {
                request.setAttribute("menssagem", "OK");
                request.setAttribute("oficinaarray", oficina);
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_sw_listar.jsp");
                rd.forward(request, response);
            }else if (type.equals("index")) {
                request.setAttribute("oficinaarray", oficina);
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_sw_listar.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("oficinaarray", oficina);
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_sw_listar.jsp");
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
