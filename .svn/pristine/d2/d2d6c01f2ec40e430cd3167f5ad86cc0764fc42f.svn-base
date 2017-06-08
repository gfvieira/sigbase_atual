package src.bh30.bh34.indicadores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoIndicadores;
import src.modelo.Indicador_model;
import src.modelo.Indicador_model_anual;

public class Exibe_indicador_34 extends HttpServlet {

    String type = "";
    String access = "";
    String year = "";
    String mensal = "";
    int total = 0, totalH = 0, totalL = 0;
    String dia = "", mes = "", ano = "", ini = "";
    Date data_ini, data_fim = null;
    int totalT = 0, totalR = 0;
    DaoIndicadores daoindic = null;
    ArrayList<Indicador_model> sate = null;
    Indicador_model_anual tempanual = null;
    ArrayList<Indicador_model_anual> indicadorAnual = null;
    Indicador_model hard = null, rede = null, lotus = null, tel = null, som = null, fono = null;
    RequestDispatcher rd = null;

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
                if (key.equals("data_ini")) {

                }
                if (key.equals("data_fim")) {

                }
                if (key.equals("ind")) {
                    type = request.getParameterValues(key)[0];
                }
                if (key.equals("mensal")) {
                    //mensal = request.getParameterValues(key)[0];
                }
                if (key.equals("ano")) {
                    //year = request.getParameterValues(key)[0];
                }

            }
            total = 0;
            daoindic = new DaoIndicadores();
            sate = new ArrayList<>();
            indicadorAnual = new ArrayList<>();
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            year = new SimpleDateFormat("yy").format(tm);
            int ano = Integer.parseInt(year);
            year = Integer.toString(ano);
            String d1 = new SimpleDateFormat("MM").format(tm);
            int mes = Integer.parseInt(d1);
            for (int i = 1; i <= 7; i++) {
                if (mes == 12) {
                    mes = 1;
                    mensal = Integer.toString(mes);
                    year = Integer.toString(++ano);
                } else if (i == 1 && mes > 6) {
                    mes -= 6;
                    mensal = Integer.toString(mes);
                } else if (i == 1 && mes == 6) {
                    mes = 1;
                    mensal = Integer.toString(mes);
                } else if (i == 1 && mes < 6) {
                    mes += 6;
                    mensal = Integer.toString(mes);
                } else {
                    ++mes;
                    mensal = Integer.toString(mes);
                }
                ArrayList<Indicador_model> temp;
                if (type.equals("iauo")) {
                    temp = daoindic.buscaindOfMensal34(mensal, year);
                    sate.addAll(temp);
                } else {
                    temp = daoindic.buscaindSomMensal34(mensal, year);
                    sate.addAll(temp);
                    temp = daoindic.buscaindTelMensal34(mensal, year);
                    sate.addAll(temp);
                    temp = daoindic.buscaindFonoMensal34(mensal, year);
                    sate.addAll(temp);
                }
                hard = new Indicador_model();
                rede = new Indicador_model();
                lotus = new Indicador_model();
                tel = new Indicador_model();
                if (sate == null || sate.isEmpty()) {//testar com 1 oficina sem resultado
                    rede.setFinalizado(0);
                    rede.setEm_andamento(0);
                    rede.setNao_iniciado(0);
                    rede.setTotal(0);
                    hard = lotus = tel = rede;
                } else {
                    sate.stream().forEach((sate1) -> {
                        if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("OFICINA"))) {
                            tempanual = new Indicador_model_anual();
                            tempanual.setTotal(sate1.getTotal());
                            tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                            tempanual.setTotalFechado(sate1.getFinalizado());
                            tempanual.setOficina("OFICINAS");
                            tempanual.setMes(mensal);
                            tempanual.setAno(year);
                            indicadorAnual.add(tempanual);
                        }
                        if (sate1.getMes().equals(mensal) && sate1.getOficina().equals("TELEFONIA")) {
                            tempanual = new Indicador_model_anual();
                            tempanual.setTotal(sate1.getTotal());
                            tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                            tempanual.setTotalFechado(sate1.getFinalizado());
                            tempanual.setOficina("TELEFONIA");
                            tempanual.setMes(mensal);
                            tempanual.setAno(year);
                            indicadorAnual.add(tempanual);
                        }
                        if (sate1.getMes().equals(mensal) && sate1.getOficina().equals("SOM")) {
                            tempanual = new Indicador_model_anual();
                            tempanual.setTotal(sate1.getTotal());
                            tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                            tempanual.setTotalFechado(sate1.getFinalizado());
                            tempanual.setOficina("SOM");
                            tempanual.setMes(mensal);
                            tempanual.setAno(year);
                            indicadorAnual.add(tempanual);
                        }
                        if (sate1.getMes().equals(mensal) && sate1.getOficina().equals("FONOCLAMA")) {
                            tempanual = new Indicador_model_anual();
                            total += sate1.getTotal();
                            tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                            tempanual.setTotalFechado(sate1.getFinalizado());
                            tempanual.setOficina("FONOCLAMA");
                            tempanual.setMes(mensal);
                            tempanual.setAno(year);
                            indicadorAnual.add(tempanual);
                        }
                    });
                }
            }
            request.setAttribute("sate", indicadorAnual);
            if (type.equals("iauo")) {
                rd = request.getRequestDispatcher("oficina34_indicador_iauo.jsp");
            }
            if (type.contentEquals("iaut")) {
                rd = request.getRequestDispatcher("oficina34_indicador_iaut.jsp");
            }
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
