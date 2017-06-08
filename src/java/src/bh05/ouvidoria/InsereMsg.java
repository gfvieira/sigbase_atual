package src.bh05.ouvidoria;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoOuvidoria;
import src.modelo.Ouvidoria_model;

public class InsereMsg extends HttpServlet {

    Ouvidoria_model ouvidoria = null;
    DaoOuvidoria daoouvidoria = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ouvidoria = new Ouvidoria_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    ouvidoria.setNome(request.getParameterValues(key)[0]);
                }
                if (key.equals("email")) {
                    ouvidoria.setEmail(request.getParameterValues(key)[0]);
                }
                if (key.equals("contato")) {
                    ouvidoria.setContato(request.getParameterValues(key)[0]);
                }
                if (key.equals("mensagem")) {
                    ouvidoria.setMensagem(request.getParameterValues(key)[0]);
                }
            }
            Random gerador = new Random();
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    Timestamp tm = new Timestamp(System.currentTimeMillis());
                    String d1 = new SimpleDateFormat("yyyy").format(tm);
                    ouvidoria.setProtocolo(d1 + gerador.nextInt(9));
                } else {
                    ouvidoria.setProtocolo(ouvidoria.getProtocolo() + gerador.nextInt(9));
                }
            }
            daoouvidoria = new DaoOuvidoria();
            ouvidoria.setIpcad(request.getRemoteAddr());
            boolean check = false;
            check = daoouvidoria.insereMsg(ouvidoria);
            if (check == true) {
                request.setAttribute("protocolo", ouvidoria.getProtocolo()); //CODIGO DE ACESSO
                RequestDispatcher rd = request.getRequestDispatcher("bh05_protocolo.jsp");//?? manda pra pagina q exibe msg de protocolo
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
