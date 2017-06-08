package src.bh30.chapa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoChapa;
import src.modelo.Chapa_model;

public class CadFila extends HttpServlet {

    int type = 0;
    DaoChapa daochapa = null;
    Chapa_model chapa = null;
    String dia = "", mes = "", ano = "", nasc = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            chapa = new Chapa_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    chapa.setNome(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    chapa.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("grad")) {
                    chapa.setGrad(Integer.parseInt(request.getParameterValues(key)[0].toUpperCase()));
                }
                if (key.equals("ramal")) {
                    chapa.setRamal(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("om")) {
                    chapa.setOm(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("user")) {
                    chapa.setUser(request.getParameterValues(key)[0]);
                }if (key.equals("msg")) {
                    chapa.setMsg(request.getParameterValues(key)[0]);
                }
            }
            chapa.setIp(request.getRemoteAddr());
            //buscar nip ja cadastrado
            daochapa = new DaoChapa();
            boolean check = true;
            check = daochapa.buscaNip(chapa.getNip());
            if(check == false)
            check = daochapa.insereFila(chapa);
            else{
            
                request.setAttribute("mensagem", "EXIST");
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_cadfila.jsp");
                rd.forward(request, response);
            }
            if (check == true) {
                request.setAttribute("mensagem", "OK");
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa_cadfila.jsp");
                rd.forward(request, response);
            }
            else{
                
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
