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
import src.modelo.Pessoal_movi;

public class BuscarPessoal extends HttpServlet {

    int type = 0;
    String nome = "";
    String nip = "";
    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;
    Pessoal_model servidorTemp = null;
    String dia = "", mes = "", ano = "", nasc = "";
    ArrayList<Pessoal_movi> servidorarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            servidorTemp = new Pessoal_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    servidor.setGuerra(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
            }
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            ArrayList<Pessoal_model> servidoresEncontrados = new ArrayList<>();
            servidoresEncontrados.addAll(daobh30.buscaOficial(servidor.getNip(), servidor.getGuerra()));
            servidoresEncontrados.addAll(daobh30.buscaPraca(servidor.getNip(), servidor.getGuerra()));
            servidoresEncontrados.addAll(daobh30.buscaCivil(servidor.getNip(), servidor.getGuerra()));
            servidoresEncontrados.addAll(daobh30.buscaTTC(servidor.getNip(), servidor.getGuerra()));
            if (!servidoresEncontrados.isEmpty()) {
                check = true;
            } else {
                check = false;
            }
            if (check == true) {
                request.setAttribute("servidorarray", servidoresEncontrados);
                RequestDispatcher rd = request.getRequestDispatcher("bh31_dep.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "NO");
                RequestDispatcher rd = request.getRequestDispatcher("bh31_buscar.jsp");
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
