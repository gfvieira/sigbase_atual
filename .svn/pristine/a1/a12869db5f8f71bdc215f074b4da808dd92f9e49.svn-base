package src.bh30.bh34.host;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIp;
import src.modelo.Host_model;
import src.modelo.Host_move;

public class Hosts extends HttpServlet {

    int qnt = 0;
    String type = "";
    DaoIp daoip = null;
    Host_model host = null;
    ArrayList<Host_move> hostmovearray = null;
    ArrayList<Host_model> hostarray = null;
    ArrayList<Host_model> hostarrayDISP = null;
    String ip = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            host = new Host_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("hostname")) {
                    type = request.getParameterValues(key)[0];
                }
                if (key.equals("ip")) {
                    host.setIp(request.getParameterValues(key)[0]);
                }
            }
            daoip = new DaoIp();
            hostarray = new ArrayList<>();
            if (type.equals("EXIBIR")) {
                ip = host.getIp();
                hostmovearray = new ArrayList<>();
                host = daoip.buscaIp(host);
                hostmovearray =  daoip.buscaMove(host.getIp());
                if (ip.equals(host.getIp())) {
                    request.setAttribute("hostip", host);
                    request.setAttribute("movearray", hostmovearray);
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_exibir.jsp");
                    rd.forward(request, response);
                }
            } else {
                if (type.equals("ALL") || type.equals("DISP")) {
                    hostarray = daoip.buscaHostAll();
                } else {
                    hostarray = daoip.buscaHost(type);
                }
                qnt = hostarray.size();
                if (hostarray.isEmpty()) {
                    Host_model hostRetorno = new Host_model();
                    hostRetorno.setNome("-");
                    hostRetorno.setIp("0.0.0.0");
                    hostRetorno.setMac("-");
                    hostRetorno.setSetor("-");
                    hostRetorno.setTipo("-");
                    hostRetorno.setSo("-");
                    hostRetorno.setUser("-");
                    qnt = 0;
                    hostarray.add(hostRetorno);
                }
                if (type.equals("DISP")) {
                    String ip = "10.5.183.0";
                    hostarrayDISP = new ArrayList<>();
                    boolean equals = true;
                    for (int a = 183; a <= 184; a++) {
                        for (int b = 0; b <= 255; b++) {
                            ip = "10.5." + a + "." + b;
                            for (int c = 0; c < hostarray.size(); c++) {
                                equals = hostarray.get(c).getIp().equals(ip);
                                if (equals == true) {
                                    break;
                                }
                            }
                            if (equals == false) {
                                Host_model hostRetorno = new Host_model();
                                hostRetorno.setIp(ip);
                                hostarrayDISP.add(hostRetorno);
                            }
                        }
                    }
                    request.setAttribute("qnt", hostarray.size());
                    request.setAttribute("hostarray", hostarrayDISP);
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_disponivel.jsp");
                    rd.forward(request, response);

                } else {
                    request.setAttribute("qnt", hostarray.size());
                    request.setAttribute("hostarray", hostarray);
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host.jsp");
                    rd.forward(request, response);
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
