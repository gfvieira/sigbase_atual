package src.bh30.bh31.pessoal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.modelo.Pessoal_model;

public class AttPessoal extends HttpServlet {
    
    Pessoal_model servidor = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = Util.attPessoal(Util.getBusca(request));
            int tipo = 0;
            if(servidor != null)
                tipo = servidor.getType();
            switch (tipo) { // mandar exibir
                case 1: {
                    request.setAttribute("type", servidor.getType());
                    request.setAttribute("nip", servidor.getNip());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/bh31/ExibePessoal.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 2: {
                    request.setAttribute("type", servidor.getType());
                    request.setAttribute("nip", servidor.getNip());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/bh31/ExibePessoal.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 3: {
                    request.setAttribute("type", servidor.getType());
                    request.setAttribute("nip", servidor.getNip());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/bh31/ExibePessoal.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 4: {
                    request.setAttribute("type", servidor.getType());
                    request.setAttribute("nip", servidor.getNip());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/bh31/ExibePessoal.jsp");
                    rd.forward(request, response);
                    break;
                }
                default:
                    out.print("um erro foi encontrado");
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
