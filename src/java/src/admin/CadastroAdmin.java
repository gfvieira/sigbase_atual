package src.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoAdmin;
import src.modelo.Usuario;

public class CadastroAdmin extends HttpServlet {

    Usuario usuario, usuario2 = null;
    DaoAdmin daoadmin = null;
    boolean check;

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            usuario = new Usuario();
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    usuario.setNome(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    usuario.setNip(req.getParameterValues(key)[0]);
                }
                if (key.equals("guerra")) {
                    usuario.setGuerra(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("grad")) {
                    usuario.setPost(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("ramal")) {
                    usuario.setRamal(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("type")) {
                    usuario.setTypeAccess(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("reset")) {
                    usuario.setPassword(Integer.parseInt(req.getParameterValues(key)[0]));
                }
                if (key.equals("active")) {
                    usuario.setAtivo(Integer.parseInt(req.getParameterValues(key)[0]));
                }
            }
            usuario.setPri(Util.privilegio(usuario.getTypeAccess()));
            usuario.setSetor(Util.setor(usuario.getTypeAccess()));
            daoadmin = new DaoAdmin();
            usuario2 = new Usuario();
            usuario2 = daoadmin.buscaUsuario(usuario);
            if (usuario2 != null) {
                req.setAttribute("mensagem", "Este usuario ja possui cadastro");
                RequestDispatcher rd = req.getRequestDispatcher("admin_cadastro.jsp");
                rd.forward(req, response);
            } else {
                check = daoadmin.insereUsuario(usuario);
                if (check == true) {
                    req.setAttribute("mensagem", "OK1");
                    RequestDispatcher rd = req.getRequestDispatcher("admin_cadastro.jsp");
                    rd.forward(req, response);
                } else {
                    req.setAttribute("mensagem", "ERROR");
                    RequestDispatcher rd = req.getRequestDispatcher("admin_cadastro.jsp");
                    rd.forward(req, response);
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
