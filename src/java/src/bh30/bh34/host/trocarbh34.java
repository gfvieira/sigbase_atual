/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.bh34.host;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIp;
import src.modelo.Host_model;
import src.modelo.Host_move;

/**
 *
 * @author gustavo
 */
public class trocarbh34 extends HttpServlet {

    Host_model host, host2 = null;
    Host_move hostmove = null;
    ArrayList<Host_model> hostarray = null;

    DaoIp daoip = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            host = new Host_model();
            daoip = new DaoIp();
            hostarray = new ArrayList<>();
            hostmove = new Host_move();
            hostarray = daoip.buscaHostAll();
            boolean check = false;
            for (Host_model host1 : hostarray) {
                check = daoip.insereIp(host1);// incluir ip de cadastro
                if (check == true) {
                    check = false;
                    hostmove.setUser(host1.getUser());
                    hostmove.setIpcadmov(request.getRemoteAddr());
                    hostmove.setIp_host(host1.getIp());
                    hostmove.setDescricao_move("IP: " + host1.getIp() + " RETIRADO DA LISTA DE DISPONÍVEL");
                    check = daoip.insereMovIp(hostmove);
                    hostmove.setDescricao_move("MAC: " + host1.getMac() + " CADASTRADO PARA O IP: " + host1.getIp());
                    check = daoip.insereMovIp(hostmove);
                }
            }
            if (check == true) {
                request.setAttribute("mensagem", "OK1");
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_cadastro.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "Host's não foi cadastrado!");
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_cadastro.jsp");
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
