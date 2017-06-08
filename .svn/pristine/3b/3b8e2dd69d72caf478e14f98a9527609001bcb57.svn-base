package src.bh50.indicadores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.bh30.bh31.pessoal.CadPessoal;
import src.dao.DaoIndicadores;
import src.modelo.Indicador_model;
import src.modelo.Indicador_model_anual;

public class BH50_anual extends HttpServlet {

    String type = "";
    String access = "";
    String year = "";
    String mensal = "";
    int total = 0, totalH = 0, totalL = 0;

    String dia = "", mes = "", ano = "", ini = "";
    Date data_ini, data_fim = null;
    int totalT = 0, totalR = 0;
    DaoIndicadores daoindic = null;
    ArrayList<Indicador_model> oficina = null;
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
                if (key.equals("ind")) {
                    type = request.getParameterValues(key)[0];
                }
            }
            if (type.equals("iaoe")
                    || type.equals("iaor")
                    || type.equals("iaom")
                    || type.equals("iaoc")
                    || type.equals("iapv")) {
                total = 0;
                daoindic = new DaoIndicadores();
                oficina = new ArrayList<>();
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
                    ArrayList<Indicador_model> temp = new ArrayList<>();
                    if (type.equals("iaoe")) {
                        temp = daoindic.buscaindOfElMensal50(mensal, year);
                        oficina.addAll(temp);
                    }
                    if (type.equals("iaor")) {
                        temp = daoindic.buscaindOfMoMensal50(mensal, year);
                        oficina.addAll(temp);
                    }
                    if (type.equals("iaom")) {
                        temp = daoindic.buscaindOfMtMensal50(mensal, year);
                        oficina.addAll(temp);
                    }
                    if (type.equals("iaoc")) {
                        temp = daoindic.buscaindOfCpMensal50(mensal, year);
                        oficina.addAll(temp);
                    }
                    if (type.equals("iapv")) {
                        temp = daoindic.buscaindOfVtMensal50(mensal, year);
                        oficina.addAll(temp);
                    }
                    if (oficina == null || oficina.isEmpty()) {//testar com 1 oficina sem resultado
                    } else {
                        oficina.stream().forEach((sate1) -> {
                            if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("ELETRICA"))) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("ELETRICA");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("REFRIGERACAO"))) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("REFRIGERACAO");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("METALURGIA"))) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("METALURGIA");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("CARPINTARIA"))) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("CARPINTARIA");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && (sate1.getOficina().equals("GARAGEM"))) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("GARAGEM");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                        });
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                if (type.equals("iaoe")) {
                    rd = request.getRequestDispatcher("bh50_indicador_iaoe.jsp");
                }
                if (type.equals("iaor")) {
                    rd = request.getRequestDispatcher("bh50_indicador_iaor.jsp");
                }
                if (type.equals("iaom")) {
                    rd = request.getRequestDispatcher("bh50_indicador_iaom.jsp");
                }
                if (type.equals("iaoc")) {
                    rd = request.getRequestDispatcher("bh50_indicador_iaoc.jsp");
                }
                if (type.equals("iapv")) {
                    rd = request.getRequestDispatcher("bh50_indicador_iapv.jsp");
                }
                rd.forward(request, response);
            } else if (type.equals("iaps")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("CHAPA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(5);
                        tempanual.setOficina("CHAPA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("CHAPA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }

                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_chapa.jsp");
                rd.forward(request, response);
            } else if (type.equals("icp")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(344);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("DETALHE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(463);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("DETALHE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("DETALHE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh31_icp.jsp");
                rd.forward(request, response);
            } else if (type.equals("imes")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(17);
                        tempanual.setTotalFechado(48);
                        tempanual.setOficina("DETALHE2");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("DETALHE2");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh31_imes.jsp");
                rd.forward(request, response);
            } else if (type.equals("ica")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(2);
                        tempanual.setTotalFechado(54);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(8);
                        tempanual.setTotalFechado(61);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh31_ica.jsp");
                rd.forward(request, response);
            } else if (type.equals("itis")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(5);
                        tempanual.setTotalFechado(10);
                        tempanual.setOficina("MEDICINA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(5);
                        tempanual.setTotalFechado(10);
                        tempanual.setOficina("MEDICINA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("MEDICINA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh32_itis.jsp");
                rd.forward(request, response);
            } else if (type.equals("casod")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(80);
                        tempanual.setTotalFechado(5);
                        tempanual.setOficina("ODONTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(77);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("ODONTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("ODONTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh32_casod.jsp");
                rd.forward(request, response);
            } else if (type.equals("iccv")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(117);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("VISITANTE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(110);
                        tempanual.setTotalFechado(10);
                        tempanual.setOficina("VISITANTE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("VISITANTE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh33_iccv.jsp");
                rd.forward(request, response);
            } else if (type.equals("iccm")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yyyy").format(tm);
                int ano = Integer.parseInt(year);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                mes = mes + 1;
                for (int i = 1; i < 13; i++) {
                    if (mes == 1) {
                        mes = 13;
                        year = Integer.toString(--ano);
                    }
                    mensal = Integer.toString(--mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(194);
                        tempanual.setTotalFechado(15);
                        tempanual.setOficina("MILITAR");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                    if (mensal.equals("3")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(74);
                        tempanual.setTotalFechado(9);
                        tempanual.setOficina("MILITAR");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(0);
                        tempanual.setOficina("MILITAR");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    }
                }
                request.setAttribute("sate", indicadorAnual);
                rd = request.getRequestDispatcher("bh30_indicador_bh33_iccm.jsp");
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
