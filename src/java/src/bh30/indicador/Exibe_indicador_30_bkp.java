package src.bh30.indicador;

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

public class Exibe_indicador_30_bkp extends HttpServlet {

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
            if (type.equals("iauo") || type.equals("iaut")) {
                total = 0;
                daoindic = new DaoIndicadores();
                sate = new ArrayList<>();
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 6; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    ArrayList<Indicador_model> temp = new ArrayList<>();
                    temp = daoindic.buscaindOfMensal34(mensal, year);
                    sate.addAll(temp);
                    temp = daoindic.buscaindSomMensal34(mensal, year);
                    sate.addAll(temp);
                    temp = daoindic.buscaindTelMensal34(mensal, year);
                    sate.addAll(temp);
                    temp = daoindic.buscaindFonoMensal34(mensal, year);
                    sate.addAll(temp);
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
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("OFICINAS");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && sate1.getOficina().equals("TELEFONIA")) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
                                tempanual.setTotalAberto(sate1.getAguadando_enc() + sate1.getEm_andamento() + sate1.getNao_iniciado());
                                tempanual.setTotalFechado(sate1.getFinalizado());
                                tempanual.setOficina("TELEFONIA");
                                tempanual.setMes(mensal);
                                tempanual.setAno(year);
                                indicadorAnual.add(tempanual);
                            }
                            if (sate1.getMes().equals(mensal) && sate1.getOficina().equals("SOM")) {
                                tempanual = new Indicador_model_anual();
                                total += sate1.getTotal();
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
                    rd = request.getRequestDispatcher("bh30_indicador_bh34_iauo.jsp");
                }
                if (type.contentEquals("iaut")) {
                    rd = request.getRequestDispatcher("bh30_indicador_bh34_iaut.jsp");
                }
                rd.forward(request, response);
            } else if (type.equals("iaps")) {
                indicadorAnual = new ArrayList<>();
                Timestamp tm = new Timestamp(System.currentTimeMillis());
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("CHAPA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3")) {
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("12") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(7);
                        tempanual.setTotalFechado(29);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("11") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(40);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("10") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(46);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("9") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(3);
                        tempanual.setTotalFechado(46);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("8") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(2);
                        tempanual.setTotalFechado(73);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("7") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(1);
                        tempanual.setTotalFechado(59);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("6") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(2);
                        tempanual.setTotalFechado(74);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("5") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(4);
                        tempanual.setTotalFechado(51);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("4") && year.equals("2015")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(0);
                        tempanual.setTotalFechado(60);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("2") && year.equals("2016")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(2);
                        tempanual.setTotalFechado(54);
                        tempanual.setOficina("ADESTRAMENTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3") && year.equals("2016")) {
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(5);
                        tempanual.setTotalFechado(10);
                        tempanual.setOficina("MEDICINA");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3")) {
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(80);
                        tempanual.setTotalFechado(5);
                        tempanual.setOficina("ODONTO");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3")) {
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(117);
                        tempanual.setTotalFechado(3);
                        tempanual.setOficina("VISITANTE");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3")) {
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
                year = new SimpleDateFormat("yy").format(tm);
                int ano = Integer.parseInt(year);
                year = Integer.toString(--ano);
                String d1 = new SimpleDateFormat("MM").format(tm);
                int mes = Integer.parseInt(d1);
                for (int i = 1; i < 13; i++) {
                    if (mes == 12) {
                        mes = 0;
                        year = Integer.toString(++ano);
                    }
                    mensal = Integer.toString(++mes);
                    if (mensal.equals("2")) {
                        tempanual = new Indicador_model_anual();
                        tempanual.setTotalAberto(194);
                        tempanual.setTotalFechado(15);
                        tempanual.setOficina("MILITAR");
                        tempanual.setMes(mensal);
                        tempanual.setAno(year);
                        indicadorAnual.add(tempanual);
                    } else if (mensal.equals("3")) {
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
