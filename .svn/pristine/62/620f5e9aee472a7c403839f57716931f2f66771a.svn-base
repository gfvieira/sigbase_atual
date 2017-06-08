package src.bh30.bh34.sate;

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
import src.dao.DaoOficina34;
import src.modelo.Pedido_model;

public class List extends HttpServlet {

    String type = "";
    String access = "";
    String status = "";
    int qnt = 1;
    DaoOficina34 daosate = null;
    Pedido_model sate = null;
    ArrayList<Pedido_model> satearray = null;

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
                if (key.equals("access")) {
                    access = req.getParameterValues(key)[0];
                }
                if (key.equals("type")) {
                    type = req.getParameterValues(key)[0];
                }
            }
            if(access.equals("COMANDANTE")){
                access = "ENCARREGADOBH34";
            }
            daosate = new DaoOficina34();
            satearray = new ArrayList<>();
            if (type.equals("ALL")) {
                if (access.equals("SUPERVISORBH34")
                        || access.equals("ENCARREGADOBH34")
                        || access.equals("TOTAL")) {
                    satearray = daosate.buscaSate();
                } else {
                    satearray = daosate.buscaSate(access);
                }
                qnt = satearray.size();
            }
            if (type.equals("EM")) {
                status = "AGUARDANDO ENCARREGADO";
                if (access.equals("SUPERVISORBH34")
                        || access.equals("ENCARREGADOBH34")
                        || access.equals("TOTAL")) {
                    satearray = daosate.buscaSateOther(status);
                } else {
                    satearray = daosate.buscaSateOther(access, status);
                }
                qnt = satearray.size();
            }
            if (type.equals("NOT")) {
                status = "NÃO INICIADO";
                if (access.equals("SUPERVISORBH34")
                        || access.equals("ENCARREGADOBH34")
                        || access.equals("TOTAL")) {
                    satearray = daosate.buscaSateOther(status);
                } else {
                    satearray = daosate.buscaSateOther(access, status);
                }
                qnt = satearray.size();
            }
            if (type.equals("IN")) {
                status = "EM ANDAMENTO";
                if (access.equals("SUPERVISORBH34")
                        || access.equals("ENCARREGADOBH34")
                        || access.equals("TOTAL")) {
                    satearray = daosate.buscaSateOther(status);
                } else {
                    satearray = daosate.buscaSateOther(access, status);
                }
                qnt = satearray.size();
            }
            if (type.equals("MES")) {
                if (access.equals("SUPERVISORBH34")
                        || access.equals("ENCARREGADOBH34")
                        || access.equals("TOTAL")) {
                    satearray = daosate.buscaSateMes();
                } else {
                    satearray = daosate.buscaSateMes(access);
                }
                qnt = satearray.size();
            }
            if (satearray.isEmpty() || satearray == null) {
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
                qnt = 0;
                satearray.add(sateRetorno);
            }
            req.setAttribute("qnt", qnt);
            req.setAttribute("satearray", satearray);
            RequestDispatcher rd = req.getRequestDispatcher("oficina34_sate_resultado.jsp");
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
