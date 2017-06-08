package src.bh05.pesquisa;

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
import src.dao.DaoPesquisa;
import src.modelo.pesquisa.Pesquisa_model;
import src.modelo.Resposta_model;
import src.modelo.pesquisa.Pesquisa_habilidade;
import src.modelo.pesquisa.Pesquisa_nota;
import src.modelo.pesquisa.Pesquisa_sexo;
import src.modelo.pesquisa.Pesquisa_tempo;

public class ResultadoClimaOrg extends HttpServlet {

    String dep = "";
    int perg = 0;
    String pergunta = "";
    DaoPesquisa daopesquisa = null;
    ArrayList<Resposta_model> resultado = null;
    ArrayList<Resposta_model> resultadoNa = null;
    ArrayList<Pesquisa_model> protocolo = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("perg")) {
                    perg = Integer.parseInt(request.getParameterValues(key)[0].toUpperCase());
                }
            }
            daopesquisa = new DaoPesquisa();
            resultado = new ArrayList<>();
            resultadoNa = new ArrayList<>();
            protocolo = new ArrayList<>();
            if (perg == 0) {
                Pesquisa_sexo sexo = new Pesquisa_sexo();
                Pesquisa_nota nota = new Pesquisa_nota();
                Pesquisa_habilidade habilidade = new Pesquisa_habilidade();
                sexo = daopesquisa.BuscaSexo();
                nota = daopesquisa.BuscaNota();
                habilidade = daopesquisa.BuscaHabi();
                request.setAttribute("sexo", sexo);
                request.setAttribute("nota", nota);
                request.setAttribute("habilidade", habilidade);
                RequestDispatcher rd = request.getRequestDispatcher("ClimaOrg.jsp");
                rd.forward(request, response);
            }
            if (perg == 1) {
                resultado = new ArrayList<>();
                for (int i = 1; i < 104; i++) {
                    Resposta_model temp = new Resposta_model();
                    temp = daopesquisa.BuscaClimaOrgAll(i);
                    resultado.add(temp);
                }
                ArrayList<String> perguntas = daopesquisa.buscaPerguntas(1);
                request.setAttribute("resultado", resultado);
                request.setAttribute("pergunta", perguntas);
                RequestDispatcher rd = request.getRequestDispatcher("ClimaOrgAll.jsp");
                rd.forward(request, response);
            } else {
                for (int i = 0; i < 51; i++) {
                    if (i == 1 || i == 2 || i == 4 || i == 5
                            || i == 6 || i == 7 || i == 8
                            || i == 10 || i == 20 || i == 30
                            || i == 40 || i == 50) {
                        Resposta_model temp = new Resposta_model();
                        if (i == 1 || i == 2 || i == 4 || i == 5
                                || i == 6 || i == 7 || i == 8) {
                            dep = "BH-0" + i;
                        } else {
                            dep = "BH-" + i;
                        }
                        temp = daopesquisa.BuscaClimaOrg(dep, perg);
                        resultado.add(temp);
                    }
                }
                pergunta = daopesquisa.buscaPerguntas(1, perg);
                request.setAttribute("resultado", resultado);
                request.setAttribute("pergunta", pergunta);
                RequestDispatcher rd = request.getRequestDispatcher("ClimaOrg_resultado.jsp");
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
