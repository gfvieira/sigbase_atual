package src.bh50.pedido;

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
import src.dao.DaoOficina34;
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;

public class TrocarOf50 extends HttpServlet {

    String os, atendimento, usuario;
    String access = "OFICINA";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         Map mapRequest = request.getParameterMap();  
            Map.Entry entryRequest;  
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;  
            while(iteratorRequest.hasNext()){  
               entryRequest = (Map.Entry) iteratorRequest.next();  
                key = (String)entryRequest.getKey();  
                if(key.equals("os")){
                    os = request.getParameterValues(key)[0];
                }if(key.equals("user")){
                    usuario = request.getParameterValues(key)[0];
                }if(key.equals("atendimento")){
                    atendimento = request.getParameterValues(key)[0].toUpperCase();
                }if (key.equals("access")) {
                    access = request.getParameterValues(key)[0];
                }
            }
            os = os.replaceAll("\\s+"," ");
            os = os.replace(" ","");
            DaoOficina50 daooficina = new DaoOficina50();
            boolean check = daooficina.altOf(os,atendimento);
            if(check == true){
                Pedido_model sate = new Pedido_model();
                sate = daooficina.buscaOficinaOs(os);
                sate.setMove(usuario + " || OFICINA ALTERADA PARA: "+atendimento);
                check = daooficina.insereMov(sate);
            }
            if(check == false){
                    RequestDispatcher rd = request.getRequestDispatcher("503.html");
                    rd.forward(request, response);
                }
            else{
                request.setAttribute("os", os);
                request.setAttribute("user", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh50/OsManage50.jsp");
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
