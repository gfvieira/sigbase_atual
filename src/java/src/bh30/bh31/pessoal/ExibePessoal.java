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
import src.modelo.Pessoal_busca;
import src.modelo.Pessoal_model;
import src.modelo.Pessoal_movi;

public class ExibePessoal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int type = 0;
            String nip = "";
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("nip")) {
                    nip = request.getParameterValues(key)[0];
                }
                if (key.equals("servidor")) {
                    nip = request.getParameterValues(key)[0];
                }
            }
            DaoBh30Pessoal daobh30 = new DaoBh30Pessoal();
            Pessoal_model servidor = null;
            Pessoal_busca busca = null;
            switch (type) {
                case 1:
                case 11:
                case 21:
                    servidor = daobh30.buscaPraca(nip);
                    busca = daobh30.planodebuscaPraca(nip);
                    break;
                case 2:
                case 12:
                case 22:
                    servidor = daobh30.buscaOficial(nip);
                    busca = daobh30.planodebuscaOficial(nip);
                    break;
                case 3:
                case 13:
                case 23:
                    servidor = daobh30.buscaTTC(nip);
                    busca = daobh30.planodebuscaTTC(nip);
                    break;
                case 4:
                case 14:
                case 24:
                    servidor = daobh30.buscaCivil(nip);
                    busca = daobh30.planodebuscaCivil(nip);
                    break;
                default:
                    break;
            }
            if (busca == null) {
                busca = Util.setBusca(nip, type);
            }
            switch (type) {
                case 1: {
                    ArrayList<Pessoal_movi> servidorarray = new ArrayList<>();
                    request.setAttribute("pracaarray", servidorarray = daobh30.buscaMovi(servidor, type));
                    request.setAttribute("praca", servidor);
                    request.setAttribute("busca", busca);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_praca.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 2: {
                    ArrayList<Pessoal_movi> servidorarray = new ArrayList<>();
                    request.setAttribute("oficialarray", servidorarray = daobh30.buscaMovi(servidor, type));
                    request.setAttribute("oficial", servidor);
                    request.setAttribute("busca", busca);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_oficial.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 3: {
                    ArrayList<Pessoal_movi> servidorarray = new ArrayList<>();
                    request.setAttribute("ttcarray", servidorarray = daobh30.buscaMovi(servidor, type));
                    request.setAttribute("ttc", servidor);
                    request.setAttribute("busca", busca);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_ttc.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 4: {
                    ArrayList<Pessoal_movi> servidorarray = new ArrayList<>();
                    request.setAttribute("civilarray", servidorarray = daobh30.buscaMovi(servidor, type));
                    request.setAttribute("civil", servidor);
                    request.setAttribute("busca", busca);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_civil.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 11: {
                    request.setAttribute("praca", servidor);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_att_praca.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 12: {
                    request.setAttribute("oficial", servidor);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_att_oficial.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 13: {
                    request.setAttribute("ttc", servidor);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_att_ttc.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 14: {
                    request.setAttribute("civil", servidor);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_att_civil.jsp");
                    rd.forward(request, response);
                    break;
                }
                case 21:
                case 22:
                case 23:
                case 24: {
                    request.setAttribute("servidor", servidor);
                    request.setAttribute("busca", busca);
                    RequestDispatcher rd = request.getRequestDispatcher("bh31_att_busca.jsp");
                    rd.forward(request, response);
                    break;
                }

                default: {
                    RequestDispatcher rd = request.getRequestDispatcher("503.html");
                    rd.forward(request, response);
                    break;
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
