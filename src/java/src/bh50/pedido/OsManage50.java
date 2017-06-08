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
import src.modelo.Pedido_move;

public class OsManage50 extends HttpServlet {

    String os, usuario;
    String access = "OFICINA";
    int type = 1;
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
                    usuario = request.getParameterValues(key)[0];
                }
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("access")) {
                    access = request.getParameterValues(key)[0].toUpperCase();
                }
            }
            os = os.replaceAll("\\s+", " ");
            os = os.replace(" ", "");
            daooficina = new DaoOficina50();
            oficina = new Pedido_model();
            oficinamovearray = new ArrayList<>();
            oficina = daooficina.buscaOficinaOs(os);
            Boolean check = false;
            RequestDispatcher rd = null;
            switch (type) {
                case 1:
                    oficinamovearray = daooficina.buscaMove(os, oficina.getAtendimento());
                    request.setAttribute("oficina", oficina);
                    request.setAttribute("oficinamove", oficinamovearray);
                    rd = request.getRequestDispatcher("oficina50_pedido_os.jsp");
                    rd.forward(request, response);
                    break;
                case 2:
                    if (oficina.getStatus().equals("NÃO INICIADO")) {
                        oficina.setStatus("EM ANDAMENTO");
                        check = daooficina.altStatusOpen(oficina, usuario);
                        if (check == true) {
                            oficina.setMove(usuario + " || OS INICIADA");
                            oficina.setIp(request.getRemoteAddr());
                            check = daooficina.insereMov(oficina);
                            oficina.setMove("SIGBASE || STATUS ALTERADO PARA: EM ANDAMENTO");
                            oficina.setIp("127.0.0.1");
                            check = daooficina.insereMov(oficina);
                        }
                    } else {
                        check = true;
                    }
                    if (check == false) {
                        rd = request.getRequestDispatcher("503.html");
                        rd.forward(request, response);
                    }else {
                        oficinamovearray = daooficina.buscaMove(os, oficina.getAtendimento());
                        request.setAttribute("oficina", oficina);
                        request.setAttribute("oficinamove", oficinamovearray);
                        rd = request.getRequestDispatcher("oficina50_pedido_os.jsp");
                        rd.forward(request, response);
                    }
                    break;
                default:
                    rd = request.getRequestDispatcher("503.html");
                    rd.forward(request, response);
                    break;
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
