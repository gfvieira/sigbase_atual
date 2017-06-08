package src.bh05.ouvidoria;

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
import src.dao.DaoOuvidoria;
import src.modelo.Ouvidoria_model;

public class ListarOuvidoria extends HttpServlet {

    String type;
    int tipo = 0;
    ArrayList<Ouvidoria_model> ouvidoriaarray = null;
    DaoOuvidoria daoouvidoria = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ouvidoriaarray = new ArrayList<>();
            tipo = 0;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = request.getParameterValues(key)[0];
                }
            }
            daoouvidoria = new DaoOuvidoria();
            switch (type) {
                case "NOT":
                    tipo = 0;
                    break;
                case "YES":
                    tipo = 1;
                    break;
                default:
                    tipo = 2;
                    break;
            }
            ouvidoriaarray = daoouvidoria.listaOuvidoria(tipo);
            if (!ouvidoriaarray.isEmpty()) {
                request.setAttribute("ouvidoriaarray", ouvidoriaarray);
                RequestDispatcher rd = request.getRequestDispatcher("cmd_ouvidorialistar.jsp");//?? manda pro inserir ou lista??
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
