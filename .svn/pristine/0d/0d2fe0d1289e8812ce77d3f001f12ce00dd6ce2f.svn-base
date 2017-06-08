package src.admin;

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
import src.dao.DaoAdmin;
import src.modelo.Usuario;

public class ListarUsuariosAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Usuario> lista = new ArrayList<>();;
            DaoAdmin daoadmin = new DaoAdmin();
            int type = 0;
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = Integer.parseInt(req.getParameterValues(key)[0].toUpperCase());
                }
            }
            switch (type) {
                case 0:
                    lista = daoadmin.listaUsuario();
                    req.setAttribute("lista", lista);
                    break;
                case 1:
                    lista = daoadmin.listaUsuarioComando();
                    req.setAttribute("lista", lista);
                    break;
                case 2:
                    lista = daoadmin.listaUsuarioAss("BH04");
                    lista.addAll(daoadmin.listaUsuarioAss("BH05"));
                    lista.addAll(daoadmin.listaUsuarioAss("BH06"));
                    lista.addAll(daoadmin.listaUsuarioAss("BH07"));
                    lista.addAll(daoadmin.listaUsuarioAss("BH08"));
                    req.setAttribute("lista", lista);
                    break;
                case 3:
                    lista = daoadmin.listaUsuarioDep("BH10");
                    req.setAttribute("lista", lista);
                    break;
                case 4:
                    lista = daoadmin.listaUsuarioDep("BH20");
                    lista.addAll(daoadmin.listaUsuarioDep("BH25"));
                    req.setAttribute("lista", lista);
                    break;
                case 5:
                    lista = daoadmin.listaUsuarioDep("BH30");
                    lista.addAll(daoadmin.listaUsuarioDep("CHAPA"));
                    lista.addAll(daoadmin.listaUsuarioDep("BH31"));
                    lista.addAll(daoadmin.listaUsuarioDep("BH32"));
                    lista.addAll(daoadmin.listaUsuarioDep("BH33"));
                    lista.addAll(daoadmin.listaUsuarioDep("BH34"));
                    req.setAttribute("lista", lista);
                    break;
                case 6:
                    lista = daoadmin.listaUsuarioDep("BH40");
                    req.setAttribute("lista", lista);
                    break;
                case 7:
                    lista = daoadmin.listaUsuarioDep("BH50");
                    req.setAttribute("lista", lista);
                    break;
                case 8:
                    lista = daoadmin.listaUsuarioSargenteante();
                    req.setAttribute("lista", lista);
                    break;
                case 9:
                    lista = daoadmin.listaUsuarioDesativados();
                    req.setAttribute("lista", lista);
                    break;

            }

            RequestDispatcher rd = req.getRequestDispatcher("admin_listarusuario.jsp");
            rd.forward(req, response);

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
