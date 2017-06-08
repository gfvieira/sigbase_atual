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

public class BuscarFerias extends HttpServlet {

    int type = 0;
    String type2 = "";
    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;
    String dia = "", mes = "", ano = "", nasc = "";
    ArrayList<Pessoal_model> servidorarray = null;
    ArrayList<Pessoal_model> feriasarray = null;
    Pessoal_model servidorTemp = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            type = 0;
            type2 = "";
            servidor = new Pessoal_model();
            servidorTemp = new Pessoal_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("user")) {
                    servidor.setUsercad(request.getParameterValues(key)[0]);
                }
                if (key.equals("nip")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
            }
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            ArrayList<Pessoal_model> servidoresEncontrados = new ArrayList<>();
            if(servidoresEncontrados.addAll(daobh30.buscaOficial(servidor.getNip(), servidor.getGuerra()))){
                type = 2;
            }
            if(servidoresEncontrados.addAll(daobh30.buscaPraca(servidor.getNip(), servidor.getGuerra()))){
                type = 1;
            }
            if(servidoresEncontrados.addAll(daobh30.buscaCivil(servidor.getNip(), servidor.getGuerra()))){
                type = 4;
            }
            if(servidoresEncontrados.addAll(daobh30.buscaTTC(servidor.getNip(), servidor.getGuerra()))){
                type = 3;
            }
            check = !servidoresEncontrados.isEmpty();
            daobh30 = new DaoBh30Pessoal();
            servidorarray = new ArrayList<>();
            switch (type) {
                case 1:
                    servidor = daobh30.buscaPraca(servidor.getNip());
                    check = true;
                    break;
                case 2:
                    servidor = daobh30.buscaOficial(servidor.getNip());
                    check = true;
                    break;
                case 3:
                    servidor = daobh30.buscaTTC(servidor.getNip());
                    check = true;
                    break;
                case 4:
                    servidor = daobh30.buscaCivil(servidor.getNip());
                    check = true;
                    break;
                default:
                    break;
            }
            feriasarray = new ArrayList<>();
            feriasarray = daobh30.buscaFerias(servidor);
            if (check == true) {
                //if (type >= 0) {
                request.setAttribute("servidorarray", feriasarray);
                RequestDispatcher rd = request.getRequestDispatcher("bh31_buscar_ferias.jsp");
                rd.forward(request, response);
            }else {
                request.setAttribute("servidorarray", feriasarray);
                RequestDispatcher rd = request.getRequestDispatcher("bh31_buscar_ferias.jsp");
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
