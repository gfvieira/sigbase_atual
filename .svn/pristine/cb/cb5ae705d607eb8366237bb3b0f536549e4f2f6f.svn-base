package src.pedido.bh50;

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
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;

public class OficinaBh50Consult extends HttpServlet {

    String nip, os;
    int id = 0;
    DaoOficina50 daooficina = null;
    Pedido_model oficina = null;
    ArrayList<Pedido_model> oficinaarray = null;

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
                if (key.equals("id")) {
                    id = Integer.parseInt(req.getParameterValues(key)[0]);
                }
                if (key.equals("nip")) {
                    nip = req.getParameterValues(key)[0];
                }
                if (key.equals("os")) {
                    os = req.getParameterValues(key)[0];
                }
            }
            switch (id) {
                case 1: {
                    daooficina = new DaoOficina50();
                    oficinaarray = new ArrayList<>();
                    oficinaarray = daooficina.buscaOficina(id, nip);
                    if (oficinaarray.isEmpty() || oficinaarray == null) {
                        Pedido_model sateRetorno = new Pedido_model();
                        sateRetorno.setOs("-");
                        sateRetorno.setNome("-");
                        sateRetorno.setNip("-");
                        sateRetorno.setRamal("-");
                        sateRetorno.setSetor("-");
                        sateRetorno.setAtendimento("-");
                        sateRetorno.setEquipamento("-");
                        sateRetorno.setSolicitacao("-");
                        sateRetorno.setDescricao("-");
                        sateRetorno.setObs("-");
                        sateRetorno.setStatus("-");
                        oficinaarray.add(sateRetorno);
                    }
                    req.setAttribute("oficinaarray", oficinaarray);
                    RequestDispatcher rd = req.getRequestDispatcher("oficinabh50_resultado.jsp");
                    rd.forward(req, response);
                    break;
                }
                case 2: {
                    daooficina = new DaoOficina50();
                    oficinaarray = new ArrayList<>();
                    oficinaarray = daooficina.buscaOficina(id, os);
                    if (oficinaarray.isEmpty() || oficinaarray == null) {
                        Pedido_model sateRetorno = new Pedido_model();
                        sateRetorno.setOs("-");
                        sateRetorno.setNome("-");
                        sateRetorno.setNip("-");
                        sateRetorno.setRamal("-");
                        sateRetorno.setSetor("-");
                        sateRetorno.setAtendimento("-");
                        sateRetorno.setEquipamento("-");
                        sateRetorno.setSolicitacao("-");
                        sateRetorno.setDescricao("-");
                        sateRetorno.setObs("-");
                        sateRetorno.setStatus("-");
                        oficinaarray.add(sateRetorno);
                    }
                    req.setAttribute("oficinaarray", oficinaarray);
                    RequestDispatcher rd = req.getRequestDispatcher("oficinabh50_resultado.jsp");
                    rd.forward(req, response);
                    break;
                }
                case 3:
                    daooficina = new DaoOficina50();
                    oficinaarray = new ArrayList<>();
                    oficinaarray = daooficina.buscaOficinaAll();
                    if (oficinaarray.isEmpty() || oficinaarray == null) {
                        Pedido_model sateRetorno = new Pedido_model();
                        sateRetorno.setOs("-");
                        sateRetorno.setNome("-");
                        sateRetorno.setNip("-");
                        sateRetorno.setRamal("-");
                        sateRetorno.setSetor("-");
                        sateRetorno.setAtendimento("-");
                        sateRetorno.setEquipamento("-");
                        sateRetorno.setSolicitacao("-");
                        sateRetorno.setDescricao("-");
                        sateRetorno.setObs("-");
                        sateRetorno.setStatus("-");
                        oficinaarray.add(sateRetorno);
                    }
                    req.setAttribute("oficinaarray", oficinaarray);
                    RequestDispatcher rd = req.getRequestDispatcher("oficinabh50_resultado_all.jsp");
                    rd.forward(req, response);
                    break;
                default:
                    break;
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
