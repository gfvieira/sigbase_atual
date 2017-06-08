package src.bh30.sargenteante;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIndicadoresSargenteante;
import src.modelo.Servidor_indicador;

public class Sargenteante extends HttpServlet {

    String type = "";
    String access = "";
    String feed = "";
    int total = 0, totalH = 0, totalL = 0;
    int totalT = 0, totalR = 0;
    DaoIndicadoresSargenteante daoindic = null;
    Servidor_indicador pessoalOf = null;
    Servidor_indicador pessoalPr = null;
    Servidor_indicador pessoalCv = null;
    Servidor_indicador pessoalTtc = null;

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
                if (key.equals("ind")) {
                    type = req.getParameterValues(key)[0];
                }
                if (key.equals("access")) {
                    access = req.getParameterValues(key)[0];
                }
                if (key.equals("feed")) {
                    feed = req.getParameterValues(key)[0];
                }
            }
            daoindic = new DaoIndicadoresSargenteante();
            pessoalOf = new Servidor_indicador();
            pessoalPr = new Servidor_indicador();
            pessoalCv = new Servidor_indicador();
            pessoalTtc = new Servidor_indicador();
            switch (Integer.parseInt(access)) {
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                    pessoalOf = daoindic.buscaOfAllDep(access);
                    pessoalPr = daoindic.buscaPrAllDep(access);
                    pessoalCv = daoindic.buscaCvAllDep(access);
                    pessoalTtc = daoindic.buscaTtcAllDep(access);
                    break;
                case 1: case 4: case 8: case 11: case 12: 
                case 21: case 22: case 23: case 24: case 25:
                case 31: case 32: case 33: case 34:
                case 41: case 42: case 43: case 44:
                case 51: case 52: case 53: case 54:
                    pessoalOf = daoindic.buscaOfAllDivisao(access);
                    pessoalPr = daoindic.buscaPrAllDivisao(access);
                    pessoalCv = daoindic.buscaCvAllDivisao(access);
                    pessoalTtc = daoindic.buscaTtcAllDivisao(access);
                    break;

            }

            if (type.equals("HOME")) {
                req.setAttribute("oficial", pessoalOf);
                req.setAttribute("praca", pessoalPr);
                req.setAttribute("civil", pessoalCv);
                req.setAttribute("ttc", pessoalTtc);
                RequestDispatcher rd = req.getRequestDispatcher("sargenteante_home.jsp");
                rd.forward(req, response);
            } else {
                req.setAttribute("oficial", pessoalOf);
                req.setAttribute("praca", pessoalPr);
                req.setAttribute("civil", pessoalCv);
                req.setAttribute("ttc", pessoalTtc);
                RequestDispatcher rd = req.getRequestDispatcher("oficina31_indicadores.jsp");
                rd.forward(req, response);
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
