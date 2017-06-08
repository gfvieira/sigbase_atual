package src.bh50.pedido;

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

public class OfList extends HttpServlet {

    String type = "";
    String access = "";
    String status = "";
    int qnt = 1;
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
                if (key.equals("access")) {
                    access = req.getParameterValues(key)[0];
                }
                if (key.equals("type")) {
                    type = req.getParameterValues(key)[0];
                }
            }
            daooficina = new DaoOficina50();
            oficinaarray = new ArrayList<>();
            if (type.equals("ALL")) {
                switch (access) {
                    case "CHEFEBH50":
                    case "TOTAL":
                        oficinaarray = daooficina.buscaOficina();
                        break;
                    case "ENCARREGADOBH52":
                        oficinaarray = daooficina.buscaOficina52();
                        break;
                    case "ENCARREGADOBH53":
                        oficinaarray = daooficina.buscaOficina53();
                        break;
                    default:
                        oficinaarray = daooficina.buscaOficina(access);
                        break;
                }
                qnt = oficinaarray.size();
            }
            if (type.equals("EM")) {
                status = "AGUARDANDO ENCARREGADO";
                switch (access) {
                    case "CHEFEBH50":
                    case "TOTAL":
                        oficinaarray = daooficina.buscaOficinaOther(status);
                        break;
                    case "ENCARREGADOBH52":
                        oficinaarray = daooficina.buscaOficinaOther52(status);
                        break;
                    case "ENCARREGADOBH53":
                        oficinaarray = daooficina.buscaOficinaOther53(status);
                        break;
                    default:
                        oficinaarray = daooficina.buscaOficinaOther(access, status);
                        break;
                }
                qnt = oficinaarray.size();
            }
            if (type.equals("NOT")) {
                status = "NÃO INICIADO";
                switch (access) {
                    case "CHEFEBH50":
                    case "TOTAL":
                        oficinaarray = daooficina.buscaOficinaOther(status);
                        break;
                    case "ENCARREGADOBH52":
                        oficinaarray = daooficina.buscaOficinaOther52(status);
                        break;
                    case "ENCARREGADOBH53":
                        oficinaarray = daooficina.buscaOficinaOther53(status);
                        break;
                    default:
                        oficinaarray = daooficina.buscaOficinaOther(access, status);
                        break;
                }
                qnt = oficinaarray.size();
            }
            if (type.equals("IN")) {
                status = "EM ANDAMENTO";
                switch (access) {
                    case "CHEFEBH50":
                    case "TOTAL":
                        oficinaarray = daooficina.buscaOficinaOther(status);
                        break;
                    case "ENCARREGADOBH52":
                        oficinaarray = daooficina.buscaOficinaOther52(status);
                        break;
                    case "ENCARREGADOBH53":
                        oficinaarray = daooficina.buscaOficinaOther53(status);
                        break;
                    default:
                        oficinaarray = daooficina.buscaOficinaOther(access, status);
                        break;
                }
                qnt = oficinaarray.size();
            }
            if (type.equals("MES")) {
                switch (access) {
                    case "CHEFEBH50":
                    case "TOTAL":
                        oficinaarray = daooficina.buscaOficinaMes();
                        break;
                    case "ENCARREGADOBH52":
                        oficinaarray = daooficina.buscaOficinaMes52();
                        break;
                    case "ENCARREGADOBH53":
                        oficinaarray = daooficina.buscaOficinaMes53();
                        break;
                    default:
                        oficinaarray = daooficina.buscaOficinaMes(access);
                        break;
                }
                qnt = oficinaarray.size();
            }
//            if (oficinaarray.isEmpty() || oficinaarray == null) {
//                Pedido_model oficinaRetorno = new Pedido_model();
//                oficinaRetorno.setOs("-");
//                oficinaRetorno.setNome("-");
//                oficinaRetorno.setNip("-");
//                oficinaRetorno.setRamal("-");
//                oficinaRetorno.setSetor("-");
//                oficinaRetorno.setAtendimento("-");
//                oficinaRetorno.setEquipamento("-");
//                oficinaRetorno.setSolicitacao("-");
//                oficinaRetorno.setDescricao("-");
//                oficinaRetorno.setObs("-");
//                oficinaRetorno.setStatus("-");
//                qnt = 0;
//                oficinaarray.add(oficinaRetorno);
//            }
            req.setAttribute("qnt", qnt);
            req.setAttribute("oficinaarray", oficinaarray);
            RequestDispatcher rd = req.getRequestDispatcher("oficina50_pedido_resultado.jsp");
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
