package src.bh30.bh33.identificador;

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
import src.dao.DaoIdentificacao;
import src.dao.DaoIndicadores;
import src.modelo.Indicador_model;

public class Contador extends HttpServlet {

    String type = "";
    String access = "";
    String feed = "";
    int totalH = 0, totalL = 0;
    int totalT = 0, totalR = 0;
    DaoIdentificacao daoidenti = null;

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            daoidenti = new DaoIdentificacao();
            int cracha = 0, estacionamento = 0, total = 0;
            cracha = daoidenti.totalCracha();
            estacionamento = daoidenti.totalEstacionamento();
            req.setAttribute("cracha", cracha);
            req.setAttribute("estacionamento", estacionamento);
            RequestDispatcher rd = req.getRequestDispatcher("identi_home.jsp");
            rd.forward(req, response);
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
