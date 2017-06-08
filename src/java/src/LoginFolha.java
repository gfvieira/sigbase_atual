package src;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.dao.DaoLogin;
import src.modelo.Usuario;

/**
 *
 * @author Carina Esthela
 */
public class LoginFolha extends HttpServlet {

     Usuario usuario = null;
     DaoLogin daologin = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            
            String login = request.getParameter("nip");
            String senha = request.getParameter("senha");
            
            usuario = new Usuario();
            usuario.setNip(login); 
            usuario.setSenha(senha);
            
            daologin = new DaoLogin();
            usuario = daologin.loginUsuario(login, senha);
            
            if(usuario == null)
                response.sendRedirect("loginFolhanfailure.jsp");
            else if(usuario.getAtivo() == 1)
                response.sendRedirect("loginFolhanoacess.jsp");
            else if(usuario.getPassword() == 1)
                response.sendRedirect("Redefinisenha.jsp");
            else{
                /*HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                session.setMaxInactiveInterval(30*60);
                response.sendRedirect("home.jsp");*/
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", usuario.getNome());
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                response.sendRedirect("homeFolha.jsp");
                    
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
