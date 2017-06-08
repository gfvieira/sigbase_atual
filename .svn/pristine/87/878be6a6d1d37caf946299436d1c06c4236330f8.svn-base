package src.bh30.chapa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoChapa;
import src.modelo.Chapa_model;

public class RetiraFila extends HttpServlet {

    String user = "";
    String nip = "";
    DaoChapa daochapa = null;
    Chapa_model chapa = null;

    ArrayList<Chapa_model> chapaarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            chapa = new Chapa_model();
            chapa.setUser(request.getParameter("user"));
            chapa.setNip(request.getParameter("nip"));
            chapa.setIp(request.getRemoteAddr());
            daochapa = new DaoChapa();
            boolean check = false;
            check = daochapa.retiraFila(chapa);
            daochapa = new DaoChapa();
            chapaarray = new ArrayList<>();
            chapaarray = daochapa.buscaFila();
            request.setAttribute("chapa", chapaarray);
            if (check = true) {
                request.setAttribute("mensagem", "OK");
            } else {
                request.setAttribute("mensagem", "NOT");
            }
            RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_exibefila.jsp");
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
