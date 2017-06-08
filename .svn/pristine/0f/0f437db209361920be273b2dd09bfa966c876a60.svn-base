package src.bh30.bh34.host;

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
import src.dao.DaoIp;
import src.modelo.Host_model;
import src.modelo.Host_move;

public class AlterarIp extends HttpServlet {

    Host_model host = null, host2 = null;
    Host_move hostmove = null;
    ArrayList<Host_move> hostmovearray = null;
    DaoIp daoip = null;
    int temp = 0;
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
                if (key.equals("host")) {
                    host.setNome(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("id_host")) {
                    host.setId(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("ip")) {
                    host.setIp(request.getParameterValues(key)[0]);
                }
                if (key.equals("mac")) {
                    host.setMac(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("setor")) {
                    host.setSetor(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("type")) {
                    host.setTipo(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("so")) {
                    host.setSo(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    host.setUser(request.getParameterValues(key)[0]);
                }
                if (key.equals("lacre")) {
                    host.setLacre(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("resp")) {
                    host.setResp(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("id")) {
                    temp = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daoip = new DaoIp();
            if (temp == 1) {//carrega os dados e envia para a jsp antes de alterar
                ip = host.getIp();
                host = daoip.buscaIp(host);
                if (ip.equals(host.getIp())) {
                    request.setAttribute("hostip", host);
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_alterar.jsp");
                    rd.forward(request, response);
                }
            }
            if (temp == 2) {
                host2 = new Host_model();
                hostmove = new Host_move();
                hostmove.setUser(host.getUser());
                hostmove.setIpcadmov(request.getRemoteAddr());
                hostmove.setIp_host(host.getIp());
                host2 = daoip.buscaIp(host);//BUSCA O QUE ESTA ATUALMENTE NO BANCO PARA COMPARAÇÃO DE POSSIVEL MUDANÇA
                boolean check = false;
                check = daoip.attHost(host);
                if (check == true) {
                    check = false;
                    if (!host2.getNome().equals(host.getNome())) {
                        hostmove.setDescricao_move("NOME ALTERADO PARA: " + host.getNome());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getMac().equals(host.getMac())) {
                        hostmove.setDescricao_move("MAC ALTERADO PARA: " + host.getMac());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getSetor().equals(host.getSetor())) {
                        hostmove.setDescricao_move("SETOR ALTERADO PARA: " + host.getSetor());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getTipo().equals(host.getTipo())) {
                        hostmove.setDescricao_move("TIPO ALTERADO PARA: " + host.getTipo());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getSo().equals(host.getSo())) {
                        hostmove.setDescricao_move("S.O. ALTERADO PARA: " + host.getSo());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getLacre().equals(host.getLacre())) {
                        hostmove.setDescricao_move("LACRE ALTERADO PARA: " + host.getLacre());
                        check = daoip.insereMovIp(hostmove);
                    }
                    if (!host2.getResp().equals(host.getResp())) {
                        hostmove.setDescricao_move("RESPONSÁVELL ALTERADO PARA: " + host.getResp());
                        check = daoip.insereMovIp(hostmove);
                    }
                }
                if (check == true) {
                    request.setAttribute("mensagem", "OK2");
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_cadastro.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("hostip", host);
                    RequestDispatcher rd = request.getRequestDispatcher("oficina34_host_alterar.jsp");
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
