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
import src.modelo.Pessoal_model;

/**
 *
 * @author gustavo
 */
public class SargenteanteFerias extends HttpServlet {

    int access = 0;
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
            access = 0;
            type2 = "";
            naoiniciada = 0;
            parcial = 0;
            finalizada = 0;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("access")) {
                    access = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            servidorarray = new ArrayList<>();
            switch (access) {
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                    servidorarray = daobh30.buscaDep(access, 1);
                    servidorarray.addAll(daobh30.buscaDep(access, 2));
                    servidorarray.addAll(daobh30.buscaDep(access, 3));
                    servidorarray.addAll(daobh30.buscaDep(access, 4));
                    break;
                case 1: case 4: case 8: case 11: case 12: 
                case 21: case 22: case 23: case 24: case 25:
                case 31: case 32: case 33: case 34:
                case 41: case 42: case 43: case 44:
                case 51: case 52: case 53: case 54:
                    servidorarray = daobh30.buscaDivisao(access, 1);
                    servidorarray.addAll(daobh30.buscaDivisao(access, 2));
                    servidorarray.addAll(daobh30.buscaDivisao(access, 3));
                    servidorarray.addAll(daobh30.buscaDivisao(access, 4));
                    break;
            }
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
                RequestDispatcher rd = request.getRequestDispatcher("sargenteante_ferias_indicador.jsp");
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
