package src.bh50.pedido;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class Priori50 extends HttpServlet {

    String os, usuario, user;
    String access = "OFICINA";
    int type = 0, priori = 0;
    DaoOficina50 daooficina = null;
    Pedido_model oficina = null;
    ArrayList<Pedido_move> oficinamovearray = null;
    Boolean check;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("os")) {
                    os = request.getParameterValues(key)[0];
                }
                if (key.equals("user")) {
                    user = request.getParameterValues(key)[0];
                }
                if (key.equals("usuario")) {
                    usuario = request.getParameterValues(key)[0];
                }
                if (key.equals("priori")) {
                    priori = Integer.parseInt(request.getParameterValues(key)[0]) ;
                }
            }
            daooficina = new DaoOficina50();
            oficina = new Pedido_model();
            oficinamovearray = new ArrayList<>();
            oficina = daooficina.buscaOficinaOs(os);
            Boolean check = false;
            oficina.setStatus("NÃO INICIADO");
            check = daooficina.altStatusAfi(oficina, user, priori);
            if (check == true) {
                oficina.setMove(usuario + " || OS AUTORIZADA!");
                oficina.setIp(request.getRemoteAddr());
                check = daooficina.insereMov(oficina);
                oficina.setMove("SIGBASE || STATUS ALTERADO PARA: NÃO INICIADO");
                check = daooficina.insereMov(oficina);
                oficina.setMove(usuario + " || OS LIBERADA PARA A OFICINA");
                check = daooficina.insereMov(oficina);
            }
            if (check == false) {
                RequestDispatcher rd = request.getRequestDispatcher("503.html");
                rd.forward(request, response);
            } else {
                oficinamovearray = daooficina.buscaMove(os, oficina.getAtendimento());
                request.setAttribute("oficina", oficina);
                request.setAttribute("oficinamove", oficinamovearray);
                RequestDispatcher rd = request.getRequestDispatcher("oficina50_pedido_os.jsp");
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
