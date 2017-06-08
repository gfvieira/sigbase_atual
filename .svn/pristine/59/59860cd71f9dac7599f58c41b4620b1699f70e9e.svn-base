package src.bh30.bh33.identificador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import src.dao.DaoIdentificacao;
import src.dao.DaoOficina34;
import src.modelo.Identificacao_model;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class Cad_Identi extends HttpServlet {

    Identificacao_model identificacao = null;
    DaoIdentificacao daoidenti = null;
    public HttpServletRequest req;
    public HttpServletResponse resp;
    int type = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.req = request;
        this.resp = response;
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            identificacao = new Identificacao_model();
            daoidenti = new DaoIdentificacao();
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            identificacao.setIpcad(req.getRemoteAddr());
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    identificacao.setNome(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    identificacao.setNip(req.getParameterValues(key)[0]);
                }
                if (key.equals("cpf")) {
                    identificacao.setCpf(req.getParameterValues(key)[0]);
                }
                if (key.equals("emp")) {
                    identificacao.setEmpresa(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("dest")) {
                    identificacao.setDestino(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("tel")) {
                    identificacao.setTelefone(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("cra")) {
                    identificacao.setCracha(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("esta")) {
                    identificacao.setEstacionamento(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("user")) {
                    identificacao.setUsercad(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("type")) {
                    type = Integer.parseInt(req.getParameterValues(key)[0].toUpperCase());
                }
            }
            boolean check = daoidenti.insereCracha(identificacao, type);
            if (check == false) {
                request.setAttribute("mensagem", "OK3");
                String stringURL = "";
                if (type == 0) {
                    stringURL = "identi_cad_cracha.jsp";
                } else {
                    stringURL = "identi_cad_estacionamento.jsp";
                }
                RequestDispatcher rd = request.getRequestDispatcher(stringURL);
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "OK1");
                String stringURL = "";
                if (type == 0) {
                    stringURL = "identi_cad_cracha.jsp";
                } else {
                    stringURL = "identi_cad_estacionamento.jsp";
                }
                RequestDispatcher rd = request.getRequestDispatcher(stringURL);
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
