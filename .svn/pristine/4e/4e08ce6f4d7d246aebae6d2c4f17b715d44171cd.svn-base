package src.bh30.bh31.pessoal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoBh30Pessoal;
import src.modelo.Pessoal_model;

public class trocar extends HttpServlet {
   
    DaoBh30Pessoal daobh30 = null;
    ArrayList<Pessoal_model> servidorarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            servidorarray = new ArrayList<>();
            servidorarray = daobh30.buscaPraca();
            for (Pessoal_model serv : servidorarray) {
                check = daobh30.inserePracaNew(serv);
            }
            servidorarray = new ArrayList<>();
            servidorarray = daobh30.buscaOficial();
            for (Pessoal_model serv : servidorarray) {
                check = daobh30.insereOficialNew(serv);
            }
            servidorarray = new ArrayList<>();
            servidorarray = daobh30.buscaTTC();
            for (Pessoal_model serv : servidorarray) {
                check = daobh30.insereTTCNew(serv);
            }
            servidorarray = new ArrayList<>();
            servidorarray = daobh30.buscaCivil();
            for (Pessoal_model serv : servidorarray) {
                check = daobh30.insereCivilNew(serv);
            }
            if (check == true) {
                request.setAttribute("mensagem", "Usuario Cadastrado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_praca.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "Usuario Cadastrado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_praca.jsp");
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
