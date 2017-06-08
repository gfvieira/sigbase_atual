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
import src.dao.DaoBh30Pessoal;
import src.dao.DaoLogin;
import src.modelo.Pessoal_model;
import src.modelo.Usuario;

/**
 *
 * @author gustavo
 */
public class SargenteanteDeleteFerias extends HttpServlet {

    Usuario usuario = null;
    DaoBh30Pessoal daobh30 = null;
    DaoLogin daologin = null;
    Pessoal_model servidor = null;
    ArrayList<Pessoal_model> servidorarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            usuario = new Usuario();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("senha")) {
                    usuario.setSenha(request.getParameterValues(key)[0]);
                }
                if (key.equals("user")) {
                    usuario.setNip(request.getParameterValues(key)[0]);
                    servidor.setUsercad(request.getParameterValues(key)[0]);
                }
                if (key.equals("ferias_id")) {
                    servidor.setId_ferias(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("servidor")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("type")) {
                    servidor.setType(Integer.parseInt(request.getParameterValues(key)[0]));
                }
            }
            daobh30 = new DaoBh30Pessoal();
            daologin = new DaoLogin();
            usuario = daologin.loginUsuario(usuario.getNip(), usuario.getSenha());
            boolean check = false;
            if (usuario != null) {
                servidor = daobh30.buscaFeriasId(servidor);
                servidor.setIpcad(request.getRemoteAddr());
                check = daobh30.deleteFerias(servidor);
                if (check == true) {
                    request.setAttribute("nip", servidor.getNip());
                    request.setAttribute("type", servidor.getType());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/sargenteante/SargenteanteExibePessoal.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "NO6");
                    request.setAttribute("nip", servidor.getNip());
                    request.setAttribute("type", servidor.getType());
                    RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/sargenteante/SargenteanteExibePessoal.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("mensagem", "NO5");
                request.setAttribute("nip", servidor.getNip());
                request.setAttribute("type", servidor.getType());
                RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh30/sargenteante/SargenteanteExibePessoal.jsp");
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
