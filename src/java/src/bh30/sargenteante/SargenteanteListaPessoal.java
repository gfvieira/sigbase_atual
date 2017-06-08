package src.bh30.sargenteante;

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
import src.dao.DaoSargenteante;
import src.modelo.Pessoal_model;

public class SargenteanteListaPessoal extends HttpServlet {

    int type = -1;
    String type2 = "";
    String access = "";
    DaoSargenteante daobh30 = null;
    ArrayList<Pessoal_model> servidorarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            type2 = "";
            type = -1;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("type2")) {
                    type2 = request.getParameterValues(key)[0];
                }
                if (key.equals("access")) {
                    access = request.getParameterValues(key)[0];
                }
            }
            daobh30 = new DaoSargenteante();
            switch (Integer.parseInt(access)) {
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                    servidorarray = Util.listarPessoalSargenteanteDep(type, access);
                    break;
                case 1: case 4: case 8: case 11: case 12: 
                case 21: case 22: case 23: case 24: case 25:
                case 31: case 32: case 33: case 34:
                case 41: case 42: case 43: case 44:
                case 51: case 52: case 53: case 54:
                    servidorarray = Util.listarPessoalSargenteanteDiv(type, access);
                    break;
            }
            switch (type) {
                case 0: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_dep.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 1:
                case 12:
                case 13:
                case 14:
                case 15: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_listar_praca.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 2: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_listar_oficial.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 3: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_listar_ttc.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 4: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_listar_civil.jsp");
                    rd.forward(request, response);
                    break;
                }
                default:
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("sargenteante_dep.jsp");
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
