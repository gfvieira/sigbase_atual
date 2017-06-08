/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.bh34.host;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIp;
import src.modelo.Host_model;
import src.modelo.Host_move;

public class HostIp extends HttpServlet {

    Host_model host, host2 = null;
    Host_move hostmove = null;
    DaoIp daoip = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            host = new Host_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("host")) {
                    host.setNome(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("ip")) {
                    host.setIp(request.getParameterValues(key)[0]);
                }
                if (key.equals("mac")) {
                    host.setMac(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("setor")) {
                    host.setSetor(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("type")) {
                    host.setTipo(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("so")) {
                    host.setSo(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    host.setUser(request.getParameterValues(key)[0]);
                }
                if (key.equals("lacre")) {
                    host.setLacre(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("resp")) {
                    host.setResp(request.getParameterValues(key)[0].toUpperCase());
                }
            }
            if(host.getSo().equals("OUTROS")){
               host.setObs(request.getParameter("obsInput"));
            } else {
                host.setObs("-");
            }
            daoip = new DaoIp();
            host2 = new Host_model();
            hostmove = new Host_move();
            host2 = daoip.buscaIp(host);
            boolean check = false;
            if (host2.getIp() == null) {
                check = daoip.insereIp(host);
                if (check == true) {
                    check = false;
                    hostmove.setUser(host.getUser());
                    hostmove.setIpcadmov(request.getRemoteAddr());
                    hostmove.setIp_host(host.getIp());
                    hostmove.setDescricao_move("IP: " + host.getIp() + " RETIRADO DA LISTA DE DISPONÍVEL");
                    check = daoip.insereMovIp(hostmove);
                    hostmove.setDescricao_move("MAC: " + host.getMac() + " CADASTRADO PARA O IP: " + host.getIp());
                    check = daoip.insereMovIp(hostmove);
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
            } else {
                request.setAttribute("mensagem", "Este IP ja está em uso");
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
