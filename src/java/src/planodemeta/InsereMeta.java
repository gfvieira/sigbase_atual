package src.planodemeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoMeta;
import src.modelo.Meta_model;

public class InsereMeta extends HttpServlet {

    Meta_model meta = null;
    DaoMeta daometa = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            meta = new Meta_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("meta")) {
                    meta.setMeta(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("tipo")) {
                    meta.setTipo(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("ano")) {
                    meta.setAno(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("setor")) {
                    meta.setSetor(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("user")) {
                    meta.setUser(request.getParameterValues(key)[0]);
                }
                if (key.equals("userDiv")) {
                    meta.setUserDiv(Integer.parseInt(request.getParameterValues(key)[0]));
                }
            }
            daometa = new DaoMeta();
            boolean check = false;
            meta.setIpCad(request.getRemoteAddr());
            check = daometa.inserMeta(meta);
            if (check == true) {
                switch (meta.getUserDiv()) {
                    case 10:
                        request.setAttribute("mensagem", "OK");
                        RequestDispatcher rd10 = request.getRequestDispatcher("bh10_meta_inserir.jsp");//?? manda pro inserir ou lista??
                        rd10.forward(request, response);
                        break;
                    case 20:
                        request.setAttribute("mensagem", "OK");
                        RequestDispatcher rd20 = request.getRequestDispatcher("bh20_meta_inserir.jsp");//?? manda pro inserir ou lista??
                        rd20.forward(request, response);
                        break;
                    case 30:
                        request.setAttribute("mensagem", "OK");
                        RequestDispatcher rd = request.getRequestDispatcher("bh30_meta_inserir.jsp");//?? manda pro inserir ou lista??
                        rd.forward(request, response);
                        break;
                    case 40:
                        request.setAttribute("mensagem", "OK");
                        RequestDispatcher rd40 = request.getRequestDispatcher("bh40_meta_inserir.jsp");//?? manda pro inserir ou lista??
                        rd40.forward(request, response);
                        break;
                    case 50:
                        request.setAttribute("mensagem", "OK");
                        RequestDispatcher rd50 = request.getRequestDispatcher("bh50_meta_inserir.jsp");//?? manda pro inserir ou lista??
                        rd50.forward(request, response);
                        break;

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
