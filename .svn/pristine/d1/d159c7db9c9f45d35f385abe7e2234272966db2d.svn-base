/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh05.pesquisa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoPesquisa;
import src.modelo.pesquisa.Pesquisa_model;

/**
 *
 * @author admin
 */
public class PesquisaClimaOrg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            Pesquisa_model pesquisa = new Pesquisa_model();

            DaoPesquisa daopesquisa = new DaoPesquisa();
            int param = daopesquisa.buscaUltimo();
            if (param == 0) {
                //resp.sendRedirect("500.jsp");
            }
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String da = new SimpleDateFormat("yyyyMMdd").format(tm);
            String t = new SimpleDateFormat("HHmmss").format(tm);
            pesquisa.setProtocolo(da + t + Integer.toString(++param));
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            pesquisa.setIpcad(request.getRemoteAddr());
            int temp = 5;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("setor")) {
                    pesquisa.setSetor(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("graduacao")) {
                    pesquisa.setGraduacao(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("sexo")) {
                    pesquisa.setSexo(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("tempoDeTrabalho")) {
                    pesquisa.setTempoDeTrab(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("perg" + temp)) {
                    pesquisa.getPerguntas().put("perg" + (temp - 4), Integer.parseInt(request.getParameterValues(key)[0]));
                    temp++;
                }
                if (key.equals("perg108")) {
                    pesquisa.setSelect108(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("perg110")) {
                    pesquisa.setSelect110(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("disc109")) {
                    pesquisa.setDisc109(request.getParameterValues(key)[0]);
                }
                if (key.equals("disc111")) {
                    pesquisa.setDisc111(request.getParameterValues(key)[0]);
                }
                if (key.equals("disc112")) {
                    pesquisa.setDisc112(request.getParameterValues(key)[0]);
                }
                if (key.equals("disc113")) {
                    pesquisa.setDisc113(request.getParameterValues(key)[0]);
                }

            }
            boolean check = daopesquisa.inserePesquisaClimaOrg(pesquisa);
            if (check == false) {
                request.setAttribute("mensagem", "Ocorreu um erro e sua pesquisa não foi salva! Por favor, tente novamente ou contate o administrador.");
                RequestDispatcher rd = request.getRequestDispatcher("pesquisa_clima_org.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", pesquisa.getProtocolo());
                RequestDispatcher rd = request.getRequestDispatcher("Protocolo.jsp");
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
