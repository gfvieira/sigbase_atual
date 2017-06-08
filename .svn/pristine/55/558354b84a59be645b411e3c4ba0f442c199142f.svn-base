package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.dao.DaoLogin;
import src.modelo.Logon;

public class AltSenha extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String senha1 = "";
            String senha2 = "";
            String senha3 = "";
            Logon usuario = null;
            DaoLogin daologin = null;
            usuario = new Logon();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("senha1")) {
                    senha1 = request.getParameterValues(key)[0];
                }
                if (key.equals("senha2")) {
                    senha2 = request.getParameterValues(key)[0];
                }
                if (key.equals("senha3")) {
                    senha3 = request.getParameterValues(key)[0];
                }
                if (key.equals("nip")) {
                    usuario.setNip(request.getParameterValues(key)[0]);
                }
            }
            if (senha1.equals(senha2)) {
                usuario.setSenha(senha1);
                daologin = new DaoLogin();
                usuario.setIp(request.getRemoteAddr());
                usuario.setId(daologin.idUsuario(usuario));
                boolean check = daologin.attSenhaUsuario(usuario);
                if (check == true) {
                    usuario.setSenha(senha1);
                    usuario = daologin.loginUsuario(usuario.getNip(), usuario.getSenha());
                    if (usuario == null) {
                        request.setAttribute("mensagem", "Usuario ou Senha inválida.");
                        RequestDispatcher rd = request.getRequestDispatcher("loginSigbase.jsp");
                        rd.forward(request, response);
                    } else if (usuario.getAtivo() == 0) {
                        request.setAttribute("mensagem", "Este usuario não possui acesso ao sistema.");
                        RequestDispatcher rd = request.getRequestDispatcher("loginSigbase.jsp");
                        rd.forward(request, response);
                    } else {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("usuario", usuario);
                        session.setMaxInactiveInterval(30 * 60);
                        usuario.setIp(request.getRemoteAddr());
                        usuario.setId_session(session.getId());
                        daologin.lastAccess(usuario);
                        response.sendRedirect(Util.login(usuario));

                    }
                } else {
                    request.setAttribute("mensagem", "não foi possível alterar a senha.");
                    RequestDispatcher rd = request.getRequestDispatcher("redefinir_senha.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("mensagem", "As senhas não conferem!.");
                RequestDispatcher rd = request.getRequestDispatcher("redefinir_senha.jsp");
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
