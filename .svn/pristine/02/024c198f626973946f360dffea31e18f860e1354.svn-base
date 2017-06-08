package src.pedido.bh34;

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
import src.dao.DaoOficina34;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class Sate extends HttpServlet {

    Pedido_model sate = null;
    DaoOficina34 daosate = null;
    int param = 0;
    int i = 0;
    ArrayList<Pedido_move> satemovearray = null;
    public HttpServletRequest req;
    public HttpServletResponse resp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.req = request;
        this.resp = response;
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            sate = new Pedido_model();
            daosate = new DaoOficina34();
            param = daosate.buscaLastOs();
            if (param == -1) {
                resp.sendRedirect("500.jsp");
            }
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String da = new SimpleDateFormat("yyyyMMdd").format(tm);
            String t = new SimpleDateFormat("HHmm").format(tm);
            sate.setOs(da + t + Integer.toString(++param));
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            sate.setIp(req.getRemoteAddr());
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    sate.setNome(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("post")) {
                    sate.setPost(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    sate.setNip(req.getParameterValues(key)[0]);
                }
                if (key.equals("ramal")) {
                    sate.setRamal(req.getParameterValues(key)[0]);
                }
                if (key.equals("setor")) {
                    sate.setSetor(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("atendimento")) {
                    sate.setAtendimento(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("equi")) {
                    sate.setEquipamento(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("sol")) {
                    sate.setSolicitacao(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("des")) {
                    sate.setDescricao(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("obs")) {
                    sate.setObs(req.getParameterValues(key)[0].toUpperCase());
                }
            }
            sate.setStatus("AGUARDANDO ENCARREGADO");
            boolean check = daosate.insereSate(sate);
            if (check == true) {
                sate.setMove(sate.getNome() + " || ABERTURA DO PEDIDO NO SISTEMA");
                sate.setIp(req.getRemoteAddr());
                check = daosate.insereMov(sate);
                sate.setMove("SIGBASE || ENVIADO PARA APROVAÇÃO DO ENCARREGADO");
                sate.setIp("127.0.0.1");
                check = daosate.insereMov(sate);
                if (check == true) {
                    check = daosate.insereLast(param);
                }
            }
            if (check == false) {
                RequestDispatcher rd = req.getRequestDispatcher("SIG-BASE/500.jsp");
                rd.forward(req, resp);
            } else {
                satemovearray = daosate.buscaMove(sate.getOs(), sate.getAtendimento());
                req.setAttribute("sate", sate);
                req.setAttribute("satemove", satemovearray);
                RequestDispatcher rd = req.getRequestDispatcher("telematica_os_resultado.jsp");
                rd.forward(this.req, this.resp);
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
