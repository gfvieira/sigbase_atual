package src.bh30.bh33.identificador;

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
import src.dao.DaoIdentificacao;
import src.modelo.Identificacao_model;

public class Listar_identi extends HttpServlet {

    String type = "";
    String access = "";
    String status = "";
    int qnt = 1;
    Identificacao_model identificacao = null;
    DaoIdentificacao daoidenti = null;
    ArrayList<Identificacao_model> identificacaoarray = null;

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = req.getParameterValues(key)[0];
                }
            }
            daoidenti = new DaoIdentificacao();
            identificacaoarray = new ArrayList<>();
            if (type.equals("CARD")) {
                identificacaoarray = daoidenti.busca(access, type);
            }
            if (type.equals("PARK")) {
                identificacaoarray = daoidenti.busca(access, type);
            }

            if (identificacaoarray.isEmpty() || identificacaoarray == null) {
                Identificacao_model identificacao = new Identificacao_model();
                identificacao.setCracha("-");
                identificacao.setEstacionamento("-");
                identificacao.setNome("-");
                identificacao.setNip("-");
                identificacao.setCpf("-");
                identificacao.setDestino("-");
                identificacao.setTelefone("-");
                identificacaoarray.add(identificacao);
            }
            req.setAttribute("tipo", type);
            req.setAttribute("idiarray", identificacaoarray);
            RequestDispatcher rd = req.getRequestDispatcher("identi_list.jsp");
            rd.forward(req, response);
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
