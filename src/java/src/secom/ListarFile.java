/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.secom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoSecom;
import src.modelo.Secom_doc;

/**
 *
 * @author gustavo
 */
public class ListarFile extends HttpServlet {

    DaoSecom daosecom = null;
    ArrayList<Secom_doc> secom = null;
    String type = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            type = request.getParameter("type");
            daosecom = new DaoSecom();
            secom = new ArrayList<>();
            secom = daosecom.listaDocs();
            switch (type) {
                case "OK":
                case "NOT":
                    {
                        request.setAttribute("menssagem", "OK");
                        request.setAttribute("secomarray", secom);
                        RequestDispatcher rd = request.getRequestDispatcher("listar_secom.jsp");
                        rd.forward(request, response);
                        break;
                    }
                case "index":
                    {
                        request.setAttribute("secomarray", secom);
                        RequestDispatcher rd = request.getRequestDispatcher("listar_secom.jsp");
                        rd.forward(request, response);
                        break;
                    }
                default:
                    {
                        request.setAttribute("secomarray", secom);
                        RequestDispatcher rd = request.getRequestDispatcher("secom_listar.jsp");
                        rd.forward(request, response);
                        break;
                    }
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
