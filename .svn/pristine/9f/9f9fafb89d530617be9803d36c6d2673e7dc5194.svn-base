package src.bh30.chapa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoChapa;
import src.modelo.Chapa_Permissionario;

public class RetiraPermissionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Chapa_Permissionario chapa = new Chapa_Permissionario();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            String bloco = null;
            String apto = null;
            String nip = null;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("bloco")) {
                    bloco = request.getParameterValues(key)[0];
                }
                if (key.equals("apto")) {
                    apto = request.getParameterValues(key)[0];
                }
                if (key.equals("nip")) {
                    nip = request.getParameterValues(key)[0];
                }
            }
            chapa.setApto(apto);
            chapa.setBloco(bloco);
            chapa.setNip(nip);
            chapa.setIp(request.getRemoteAddr());
            DaoChapa daochapa = new DaoChapa();
            boolean check = daochapa.deletePermissionario(chapa);
            if (check) {
                request.setAttribute("mensagem", "OK");
                RequestDispatcher rd = request.getRequestDispatcher("ExibirAptos.jsp?blc=" + bloco);
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "ERROR");
                RequestDispatcher rd = request.getRequestDispatcher("bh30_chapa.jsp");
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
