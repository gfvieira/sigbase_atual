package src.bh50.viatura;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import src.dao.DaoOficina34;
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;
import src.modelo.Viatura_History;
import src.modelo.Viatura_model;

public class OficinaBh50_cadViatura extends HttpServlet {

    Viatura_model viatura = null;
    DaoOficina50 daooficina = null;
    ArrayList<Viatura_History> viaturamovearray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            viatura = new Viatura_model();
            daooficina = new DaoOficina50();
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String da = new SimpleDateFormat("yyyyMMdd").format(tm);
            String t = new SimpleDateFormat("HHmm").format(tm);
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            viatura.setIp(request.getRemoteAddr());
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("status")) {
                    viatura.setStatus(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("tipo")) {
                    viatura.setTipo(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("marca")) {
                    viatura.setMarca(request.getParameterValues(key)[0]);
                }
                if (key.equals("modelo")) {
                    viatura.setModelo(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("ano")) {
                    viatura.setAno(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("user")) {
                    viatura.setUser(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("dataVistoria")) {
                    viatura.setUser(request.getParameterValues(key)[0].toUpperCase());
                }                
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
