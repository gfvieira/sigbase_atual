/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.modelo.Usuario;

/**
 *
 * @author gustavo
 */
public class Util {

    protected static String login(Usuario usuario) {
        String retorno;
        if (usuario.getPassword() == 1) {
            retorno = "redefinir_senha.jsp";
        } else if (usuario.getPri().equals("ADMIN")) {
            retorno = "admin/admin_home.jsp";
        } else if (usuario.getPri().equals("TOTAL")) {
            retorno = "bhmn/cmd_home.jsp";
        } else if (usuario.getPri().equals("BH04")) {
            retorno = "bhmn/secom/secom_home.jsp";
        } else if (usuario.getPri().equals("BH08")) {
            retorno = "bhmn/bh08/bh08_home.jsp";
        } else if (usuario.getPri().equals("BH10")) {
            retorno = "bhmn/bh10/bh10_home.jsp";
        } else if (usuario.getPri().equals("BH25")) {
            retorno = "bhmn/bh25/Contador25.jsp";
        } else if (usuario.getPri().equals("BH30")) {
            retorno = "bhmn/bh30/bh30_home.jsp";
        } else if (usuario.getPri().equals("CHAPA")) {
            retorno = "bhmn/bh30/chapa/bh30_chapa.jsp";
        } else if (usuario.getPri().equals("SARGENTEANTE")) {
            retorno = "bhmn/bh30/sargenteante/Sargenteante.jsp?ind=HOME&access=" + usuario.getTypeAccess();
        } else if (usuario.getPri().equals("BH31")) {
            retorno = "bhmn/bh30/bh31/BH31.jsp?ind=HOME&access=" + usuario.getTypeAccess();
        } else if (usuario.getPri().equals("BH34")) {
            retorno = "bhmn/bh30/bh34/BH34.jsp?ind=HOME&access=" + usuario.getTypeAccess();
        } else if (usuario.getPri().equals("BH50")) {
            retorno = "bhmn/bh50/BH50.jsp?ind=HOME&access=" + usuario.getTypeAccess();
        } else if (usuario.getPri().equals("IDENTIFICADOR")) {
            retorno = "bhmn/identificador/Contador.jsp";
        } else {
            /*HttpSession session = request.getSession(true);
                        session.setAttribute("usuario", usuario);
                        session.setMaxInactiveInterval(30*60);
                        response.sendRedirect("home.jsp");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("usuario", usuario);
                        //setting session to expiry in 30 mins
                        session.setMaxInactiveInterval(30 * 60);
                        response.sendRedirect("home.jsp");*/
            retorno = "";
        }
        return retorno;

    }

}
