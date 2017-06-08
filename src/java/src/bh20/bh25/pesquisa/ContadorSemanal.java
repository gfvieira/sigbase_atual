package src.bh20.bh25.pesquisa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoPesquisa;
import src.modelo.pesquisa.Pergunta_model;
import src.modelo.Resposta_model;

public class ContadorSemanal extends HttpServlet {

    String type = "";
    String semana = "";
    String mes = "";
    int totalH = 0, totalL = 0;
    int totalT = 0, totalR = 0;
    DaoPesquisa daopesquisa = null;
    Resposta_model diario1 = null;
    Resposta_model diario2 = null;
    Resposta_model diario3 = null;
    Pergunta_model pesquisa = null;

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            daopesquisa = new DaoPesquisa();
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                /*if (key.equals("ini")) {
                    nasc = req.getParameterValues(key)[0];
                    nasc = nasc.replaceAll("[^a-zZ-Z0-9 ]", "");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    if (!nasc.equals("")) {
                        ano = nasc.substring(0, 4);
                        mes = nasc.substring(4, 6);
                        dia = nasc.substring(6, 8);
                    }
                    nasc = (dia + "/" + mes + "/" + ano);
                    Date data = null;
                    try {
                        data = new Date(format.parse(nasc).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(CadPessoal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    date = String.valueOf(data);
                }*/
                if (key.equals("semana")) {
                    semana = req.getParameterValues(key)[0];
                }
                if (key.equals("mes")) {
                    mes = req.getParameterValues(key)[0];
                }
            }
            int perg1 = 0, perg2 = 0, perg3 = 0, perg4 = 0, perg5 = 0;
            diario1 = new Resposta_model();
            diario2 = new Resposta_model();
            diario3 = new Resposta_model();
            diario1 = daopesquisa.semana(semana, mes, 1);
            diario2 = daopesquisa.semana(semana, mes, 2);
            diario3 = daopesquisa.semana(semana, mes, 3);
            pesquisa = new Pergunta_model();
            pesquisa = daopesquisa.buscaLastquestion();
            if (pesquisa == null) {
                pesquisa = new Pergunta_model();
                pesquisa.setPergunta1("Nenhuma Pergunta foi encontrada!");
                pesquisa.setPergunta2("Nenhuma Pergunta foi encontrada!");
                pesquisa.setPergunta3("Nenhuma Pergunta foi encontrada!");
                pesquisa.setUsercad("Sem registro");
            }
            req.setAttribute("perg1", diario1);
            req.setAttribute("perg2", diario2);
            req.setAttribute("perg3", diario3);
            req.setAttribute("perguntas", pesquisa);
            req.setAttribute("mes", mes);
            req.setAttribute("semana", semana);
            RequestDispatcher rd = req.getRequestDispatcher("bh25_resultado_semanal.jsp");
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
