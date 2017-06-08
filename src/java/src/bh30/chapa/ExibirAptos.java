/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.chapa;

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
import src.dao.DaoChapa;
import src.modelo.Chapa_Apto_model;
import src.modelo.Chapa_Permissionario;
import src.modelo.Chapa_model;

/**
 *
 * @author admin
 */
public class ExibirAptos extends HttpServlet {

    private String blc = "";
    private String msg = null;
    private DaoChapa daochapa = null;
    private ArrayList<Chapa_model> chapaarray = null;
    private ArrayList<Object> blocos;

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
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("blc")) {
                    blc = request.getParameterValues(key)[0];
                }
            }
            Chapa_Apto_model aptos_chapa = new Chapa_Apto_model();
            ArrayList<String[]> apts = aptos_chapa.getAptos();
            daochapa = new DaoChapa();
            ArrayList<Chapa_Permissionario> moradoresDoBloco = daochapa.buscaPermissionario(blc);
            Map.Entry aptoDaVez;
            //int blcRequest = Integer.parseInt(blc);
            ArrayList<String> aptReturn = new ArrayList<>();
            for (int i = 0; i < apts.size(); i++) {
                if (apts.get(i)[1].equals(blc)) {
                    aptReturn.add(apts.get(i)[0]);
                }
            }           

            if (blc.equals("index")) {
                request.setAttribute("chapa", chapaarray);
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_fila.jsp");
                rd.forward(request, response);
            } else { //home
                request.setAttribute("aptos", aptReturn);
                request.setAttribute("bloco", blc);
                request.setAttribute("moradoresDoBloco", moradoresDoBloco);
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_exibeApto.jsp");
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
