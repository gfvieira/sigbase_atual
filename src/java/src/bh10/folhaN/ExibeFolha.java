package src.bh10.folhaN;

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
import src.dao.DaoFolhaN;
import src.modelo.FolhanItem;

public class ExibeFolha extends HttpServlet {

    String om;
    int tipo;
    DaoFolhaN daofolha = null;
    ArrayList<FolhanItem> folhaEquipamento = null;
    ArrayList<FolhanItem> folhaEquipagem = null;
    ArrayList<FolhanItem> folhaEmprestimo = null;
    ArrayList<FolhanItem> folhaOm = null;
    double totalEquipamento = 0;
    double totalEquipagem = 0;
    double totalEmprestimo = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("tipo")) {
                    tipo = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("om")) {
                    om = request.getParameterValues(key)[0];
                }
            }
            daofolha = new DaoFolhaN();
            switch (tipo) {
                case 0:
                    folhaEquipamento = new ArrayList<>();
                    folhaEquipagem = new ArrayList<>();
                    folhaEmprestimo = new ArrayList<>();
                    folhaEquipamento = daofolha.folhan_equip(om, 1);
                    folhaEquipagem = daofolha.folhan_equip(om, 2);
                    folhaEmprestimo = daofolha.folhan_equip(om, 3);
                    request.setAttribute("tipo", "0");
                    request.setAttribute("equipamento", folhaEquipamento);
                    request.setAttribute("equipagem", folhaEquipagem);
                    request.setAttribute("emprestimo", folhaEmprestimo);
                    rd = request.getRequestDispatcher("folhan_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 1:
                    folhaEquipamento = new ArrayList<>();
                    folhaEquipagem = new ArrayList<>();
                    folhaEmprestimo = new ArrayList<>();
                    folhaEquipamento = daofolha.folhan_equip(1);
                    folhaEquipagem = daofolha.folhan_equip(2);
                    folhaEmprestimo = daofolha.folhan_equip(3);
                    request.setAttribute("tipo", "1");
                    request.setAttribute("equipamento", folhaEquipamento);
                    request.setAttribute("equipagem", folhaEquipagem);
                    request.setAttribute("emprestimo", folhaEmprestimo);
                    for (FolhanItem folhaitem : folhaEquipamento){
                        totalEquipamento = totalEquipamento + folhaitem.getVlUnitario();
                    }
                    for (FolhanItem folhaitem : folhaEquipagem){
                        totalEquipagem = totalEquipagem + folhaitem.getVlUnitario();
                    }
                    for (FolhanItem folhaitem : folhaEmprestimo){
                        totalEmprestimo = totalEmprestimo + folhaitem.getVlUnitario();
                    }
                    rd = request.getRequestDispatcher("folhan_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
                    break;
                case 2:
                    folhaOm = new ArrayList<>();
                    folhaOm = daofolha.buscaOM();
                    request.setAttribute("tipo", "2");
                    request.setAttribute("folhaOm", folhaOm);
                    rd = request.getRequestDispatcher("folhan_exibe.jsp");//?? manda pro inserir ou lista??
                    rd.forward(request, response);
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
