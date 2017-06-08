package src.bh30.bh34.sate;

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
import src.dao.DaoOficina34;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class Priori34 extends HttpServlet {

    String os, usuario, user;
    String access = "OFICINA";
    int type = 0, priori = 0;
    DaoOficina34 daosate = null;
    Pedido_model sate = null;
    ArrayList<Pedido_move> satemovearray = null;
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
                    priori = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daosate = new DaoOficina34();
            sate = new Pedido_model();
            satemovearray = new ArrayList<>();
            sate = daosate.buscaSateOs(os);
            Boolean check = false;
            sate.setStatus("NÃO INICIADO");
            check = daosate.altStatusAfi(sate, user, priori);
            if (check == true) {
                sate.setMove(usuario + " || OS AUTORIZADA!");
                sate.setIp(request.getRemoteAddr());
                check = daosate.insereMov(sate);
                sate.setMove("SIGBASE || STATUS ALTERADO PARA: NÃO INICIADO");
                sate.setIp("127.0.0.1");
                check = daosate.insereMov(sate);
                sate.setMove(usuario + " || OS LIBERADA PARA A OFICINA");
                sate.setIp(request.getRemoteAddr());
                check = daosate.insereMov(sate);
            }
            if (check == false) {
                RequestDispatcher rd = request.getRequestDispatcher("503.html");
                rd.forward(request, response);
            }else {
                satemovearray = daosate.buscaMove(os, sate.getAtendimento());
                request.setAttribute("sate", sate);
                request.setAttribute("satemove", satemovearray);
                RequestDispatcher rd = request.getRequestDispatcher("oficina34_sate_os.jsp");
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
