/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.chapa;

import src.modelo.Chapa_Veiculo;
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
import src.dao.DaoApendiceChapa;
import src.modelo.Chapa_Apendice;
import src.modelo.Chapa_Dependente;
import src.modelo.Chapa_Permissionario;

/**
 *
 * @author admin
 */
public class ExibePermissionario extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            String nip = null, apto = null, bloco = null;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();

                switch (key) {
                    case "nip":
                        nip = request.getParameterValues(key)[0];
                        break;
                    case "apto":
                        apto = request.getParameterValues(key)[0];
                        break;
                    case "bloco":
                        bloco = request.getParameterValues(key)[0];
                        break;
                }
            }

            DaoChapa daochapa = new DaoChapa();
            Chapa_Permissionario perm = daochapa.buscaPermissionarioDoApto(nip, apto, bloco, 1);
            ArrayList<Chapa_Veiculo> veiculos = daochapa.buscaVeiculoPermissionario(perm);

            for (int i = 0; i < veiculos.size(); i++) {
                veiculos.get(i).setIp(request.getRemoteAddr());
            }
            
            ArrayList<Chapa_Dependente> dependentes = daochapa.buscaDependentesPermissionario(perm);

            perm.setIp(request.getRemoteAddr());
            
            DaoApendiceChapa daoApendice = new DaoApendiceChapa();
            
            Chapa_Apendice apendice = daoApendice.buscaApendiceChapa(nip);            

            request.setAttribute("perm", perm);
            request.setAttribute("veiculos", veiculos);
            request.setAttribute("dependentes", dependentes);
            request.setAttribute("apendice", apendice);
            
            RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_exibepermissionario.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
