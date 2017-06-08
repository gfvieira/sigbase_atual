package src.bh30.bh31.indicadores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoBh30Pessoal;
import src.modelo.Pessoal_model;

/**
 *
 * @author gustavo
 */
public class Ferias extends HttpServlet {

    int type = 0;
    String type2 = "";
    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;
    int naoiniciada = 0, parcial = 0, finalizada = 0;
    ArrayList<Pessoal_model> servidorarray = null;
    ArrayList<Pessoal_model> servidorarrayFinal = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            type = 0;
            type2 = "";
            naoiniciada = 0;
            parcial = 0;
            finalizada = 0;
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            servidorarray = new ArrayList<>();
            servidorarray = daobh30.buscaPraca();
            servidorarray.addAll(daobh30.buscaOficial());
            servidorarray.addAll(daobh30.buscaTTC());
            servidorarray.addAll(daobh30.buscaCivil());
            servidorarrayFinal = new ArrayList<>();
            for (Pessoal_model serv : servidorarray) {
                ArrayList<Pessoal_model> servidorarrayTemp = new ArrayList<>();;
                servidorarrayTemp = daobh30.buscaFerias(serv);
                int total = 0;
                for (Pessoal_model serv2 : servidorarrayTemp) {
                    total = total + serv2.getDiasFerias();
                }
                serv.setDiasFerias(total);
                servidorarrayFinal.add(serv);
            }
            for (Pessoal_model serv : servidorarrayFinal) {
                switch (serv.getDiasFerias()) {
                    case 0:
                        naoiniciada++;
                        break;
                    case 30:
                        finalizada++;
                        break;
                    default:
                        parcial++;
                        break;
                }
                check = true;
            }
            if (check == true) {
                request.setAttribute("naoiniciada", naoiniciada);
                request.setAttribute("finalizada", finalizada);
                request.setAttribute("parcial", parcial);
                RequestDispatcher rd = request.getRequestDispatcher("bh31_ferias_indicador.jsp");
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
