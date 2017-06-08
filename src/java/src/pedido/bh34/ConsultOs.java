package src.pedido.bh34;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoOficina34;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class ConsultOs extends HttpServlet {
    
    String os;
    DaoOficina34 daosate = null;
    Pedido_model sate = null;
    ArrayList<Pedido_move> satemovearray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            Map mapRequest = request.getParameterMap();  
            Map.Entry entryRequest;  
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;  
            while(iteratorRequest.hasNext()){  
               entryRequest = (Map.Entry) iteratorRequest.next();  
                key = (String)entryRequest.getKey();  
                if(key.equals("os")){
                    os = request.getParameterValues(key)[0];
                }
            }
        daosate = new DaoOficina34();
        sate = new Pedido_model();
        satemovearray = new ArrayList<>();
        sate = daosate.buscaSateOs(os);
        satemovearray = daosate.buscaMove(os, sate.getAtendimento());
        if(satemovearray.isEmpty()){
            Pedido_move sateRetorno = new Pedido_move();  
            sateRetorno.setOs("-");
            sateRetorno.setOf("-");
            sateRetorno.setId(0);
            sateRetorno.setDescricao_move("SEM MOVIMENTAÇÃO");
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String t = new SimpleDateFormat("HH:mm:ss").format(tm);
            Date date = new Date();
            LocalTime thisSec = LocalTime.parse(t);
            sateRetorno.setDatacadmov(date);
            sateRetorno.setHoracadmov(thisSec);
            satemovearray.add(sateRetorno);
        }
        request.setAttribute("sate", sate);
        request.setAttribute("satemove", satemovearray);
        RequestDispatcher rd = request.getRequestDispatcher("telematica_os_resultado.jsp");
        rd.forward(request, response);
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
