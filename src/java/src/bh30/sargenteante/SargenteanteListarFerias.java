package src.bh30.sargenteante;

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
import src.dao.DaoSargenteante;
import src.modelo.Pessoal_model;

public class SargenteanteListarFerias extends HttpServlet {

    DaoSargenteante daosargenteante = null;
    Pessoal_model servidor = null;
    ArrayList<Pessoal_model> servidorarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("serv")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("typeServ")) {
                    servidor.setType(Integer.parseInt(request.getParameterValues(key)[0]));
                }
            }
            daosargenteante = new DaoSargenteante();
            servidorarray = new ArrayList<>();
            servidorarray = daosargenteante.buscaFerias(servidor);
            if(servidorarray.isEmpty()){
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId_ferias(0);
                servidorRetorno.setDiasFerias(0);
                servidorRetorno.setAnoFerias(0);
                servidorarray.add(servidorRetorno);                
            }
            request.setAttribute("servidor", servidor);
            request.setAttribute("servidorarray", servidorarray);
            RequestDispatcher rd = request.getRequestDispatcher("sargenteante_ferias.jsp");
            rd.forward(request, response);
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
