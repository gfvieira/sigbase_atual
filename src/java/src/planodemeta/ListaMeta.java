package src.planodemeta;

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
import src.dao.DaoMeta;
import src.modelo.Meta_model;

public class ListaMeta extends HttpServlet {

    int setor;
    int tipo;
    int userDiv;
    int ano;
    DaoMeta daometa = null;
    ArrayList<Meta_model> metaarray = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            metaarray = new ArrayList<>();
            RequestDispatcher rd = null;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("setor")) {
                    setor = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("tipo")) {
                    tipo = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("userDiv")) {
                    userDiv = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("ano")) {
                    ano = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daometa = new DaoMeta();
            if (setor == 1) {
                //ArrayList<Meta_model> temp = new ArrayList<>();
                metaarray = daometa.listaMetaAll(ano, tipo);
                /*for (int i = 1; i <= 55; i++) {
                    for (Meta_model meta : temp) {
                        if (meta.getSetor() == i) {
                            metaarray.add(meta);
                        }
                    }
                }*/
            } else {
                metaarray = daometa.listaMetaSetor(setor, ano);
            }

            switch (userDiv) {
                case 1:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("cmd_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 10:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("bh10_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 20:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("bh20_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 30:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("bh30_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 40:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("bh40_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 50:
                    request.setAttribute("metaarray", metaarray);
                    request.setAttribute("setor", setor);
                    rd = request.getRequestDispatcher("bh50_meta_listar.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
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
