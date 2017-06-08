package src.bh30.bh31.pessoal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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

public class DBQPessoal extends HttpServlet {

    int type = 0;
    String user = "";
    Date dbq;
    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;
    ArrayList<Pessoal_movi> servidorarray = null;

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
                if (key.equals("user")) {
                    user = request.getParameterValues(key)[0];
                }
                if (key.equals("nip")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("dbq")) {
                    dbq = Util.setData2(request.getParameterValues(key)[0]);
                }
            }
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            Pessoal_model servidorTemp = new Pessoal_model();
            servidorTemp = daobh30.buscaOficial(servidor.getNip());
            if (servidorTemp == null) {
                servidorTemp = daobh30.buscaPraca(servidor.getNip());
                if (servidorTemp == null) {
                    servidorTemp = daobh30.buscaCivil(servidor.getNip());
                    if (servidorTemp == null) {
                        servidorTemp = daobh30.buscaTTC(servidor.getNip());
                        if (servidorTemp == null) {
                            type = 0;
                        } else {
                            servidor = servidorTemp;
                            type = 3;
                        }
                    } else {
                        servidor = servidorTemp;
                        type = 4;
                    }
                } else {
                    servidor = servidorTemp;
                    type = 1;
                }
            } else {
                servidor = servidorTemp;
                type = 2;
            }
            servidor.setUsercad(user);
            servidor.setIpcad(request.getRemoteAddr());
            servidor.setDbqCad(dbq);
            servidor.setAfast(1);
            switch (type) {
                case 1:
                    check = daobh30.dbqPraca(servidor);
                    break;
                case 2:
                    check = daobh30.dbqOficial(servidor);
                    break;
                case 3:
                    check = daobh30.dbqTTC(servidor);
                    break;
                case 4:
                    check = daobh30.dbqCivil(servidor);
                    break;
                default:
                    check = false;
            }
            if (check == true) {
                switch (type) {
                    case 1:
                        {
                            servidorarray = new ArrayList<>();
                            request.setAttribute("pracaarray", servidorarray = daobh30.buscaMovi(servidor, type));
                            request.setAttribute("praca", servidor);
                            RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_praca.jsp");
                            rd.forward(request, response);
                            break;
                        }
                    case 2:
                        {
                            servidorarray = new ArrayList<>();
                            request.setAttribute("oficialarray", servidorarray = daobh30.buscaMovi(servidor, type));
                            request.setAttribute("oficial", servidor);
                            RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_oficial.jsp");
                            rd.forward(request, response);
                            break;
                        }
                    case 3:
                        {
                            servidorarray = new ArrayList<>();
                            request.setAttribute("ttcarray", servidorarray = daobh30.buscaMovi(servidor, type));
                            request.setAttribute("ttc", servidor);
                            RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_ttc.jsp");
                            rd.forward(request, response);
                            break;
                        }
                    case 4:
                        {
                            servidorarray = new ArrayList<>();
                            request.setAttribute("civilarray", servidorarray = daobh30.buscaMovi(servidor, type));
                            request.setAttribute("civil", servidor);
                            RequestDispatcher rd = request.getRequestDispatcher("bh31_exibir_civil.jsp");
                            rd.forward(request, response);
                            break;
                        }
                    default:
                        {
                            RequestDispatcher rd = request.getRequestDispatcher("503.html");
                            rd.forward(request, response);
                            break;
                        }
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
