package src.bh30.bh31.pessoal;

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
import src.dao.DaoBh30Pessoal;
import src.modelo.Pessoal_model;

public class ListPessoal extends HttpServlet {

    int type = -1;
    String type2 = "";
    DaoBh30Pessoal daobh30 = null;
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
            }
            daobh30 = new DaoBh30Pessoal();
            servidorarray = Util.listarPessoal(type);
            if (!type2.equals("")) {
                servidorarray = daobh30.buscaDep(Integer.parseInt(type2), 1);
                servidorarray.addAll(daobh30.buscaDep(Integer.parseInt(type2), 2));
                servidorarray.addAll(daobh30.buscaDep(Integer.parseInt(type2), 3));
                servidorarray.addAll(daobh30.buscaDep(Integer.parseInt(type2), 4));
            }
            switch (type) {
                case 0: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_dep.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 1:
                case 12:
                case 13:
                case 14:
                case 15: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_listar_praca.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 2: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_listar_oficial.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 3: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_listar_ttc.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 4: {
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_listar_civil.jsp");
                    rd.forward(request, response);
                    break;
                }
                default:
                    request.setAttribute("servidorarray", servidorarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_dep.jsp");
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
