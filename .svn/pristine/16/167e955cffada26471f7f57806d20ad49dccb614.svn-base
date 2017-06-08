package src.pedido.bh50;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import src.bh30.bh31.pessoal.CadPessoal;
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class OficinaBh50 extends HttpServlet {

    Pedido_model oficina = null;
    DaoOficina50 daooficina = null;
    int param = 0;
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    int i = 0;
    ArrayList<Pedido_move> oficinamovearray = null;
    String dia = "", mes = "", ano = "", nasc = "";

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ParseException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            oficina = new Pedido_model();
            daooficina = new DaoOficina50();
            param = daooficina.buscaLastOs();
            if (param == -1) {
                resp.sendRedirect("500.jsp");
            }
            String da = new SimpleDateFormat("yyyyMMdd").format(tm);
            String t = new SimpleDateFormat("HHmm").format(tm);
            oficina.setOs(da + t + Integer.toString(++param));
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            oficina.setIp(req.getRemoteAddr());
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    oficina.setNome(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("post")) {
                    oficina.setPost(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    oficina.setNip(req.getParameterValues(key)[0]);
                }
                if (key.equals("ramal")) {
                    oficina.setRamal(req.getParameterValues(key)[0]);
                }
                if (key.equals("setor")) {
                    oficina.setSetor(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("atendimento")) {
                    oficina.setAtendimento(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("sol")) {
                    oficina.setSolicitacao(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("des")) {
                    oficina.setDescricao(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("obs")) {
                    oficina.setObs(req.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("pob")) {
                    oficina.setPob(Integer.parseInt(req.getParameterValues(key)[0].toUpperCase()));
                }
                if (key.equals("dateini")) {
                    nasc = req.getParameterValues(key)[0];
                    nasc = nasc.replaceAll("[^a-zZ-Z0-9 ]", "");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    if (!nasc.equals("")) {
                        dia = nasc.substring(0, 2);
                        mes = nasc.substring(2, 4);
                        ano = nasc.substring(4, 8);
                    }
                    nasc = (dia + "/" + mes + "/" + ano);
                    Date data = null;
                    try {
                        data = new Date(format.parse(nasc).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(CadPessoal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    oficina.setDataevento(data);
                }
                if (key.equals("horaini")) {
                    String str = req.getParameterValues(key)[0].toUpperCase();
                    String hr = str.substring(0, 2);
                    String min = str.substring(3, 5);
                    oficina.setHoraevento(LocalTime.of((Integer.parseInt(hr)), (Integer.parseInt(min))));
                }
                if (key.equals("horafim")) {
                    String str = req.getParameterValues(key)[0].toUpperCase();
                    String hr = str.substring(0, 2);
                    String min = str.substring(3, 5);
                    oficina.setHorafim(LocalTime.of((Integer.parseInt(hr)), (Integer.parseInt(min))));
                }
            }
            oficina.setStatus("AGUARDANDO ENCARREGADO");
            oficina.setIp(req.getRemoteAddr());
            boolean check;
            if (oficina.getDataevento() != null) {
                oficina.setDescricao("NAO DISPONIVEL");
                check = daooficina.insereOficinaGaragem(oficina);
            } else {
                check = daooficina.insereOficina(oficina);
            }
            if (check == true) {
                oficina.setMove("SIGBASE || ABERTURA DO PEDIDO NO SISTEMA");
                oficina.setIp(req.getRemoteAddr());
                check = daooficina.insereMov(oficina);
                oficina.setMove("SIGBASE || ENVIADO PARA APROVAÇÃO DO ENCARREGADO");
                oficina.setIp("127.0.0.1");
                check = daooficina.insereMov(oficina);
                if (check == true) {
                    check = daooficina.insereLast(param);
                }
            }
            if (check == false) {
                RequestDispatcher rd = req.getRequestDispatcher("SIG-BASE/500.jsp");
                rd.forward(req, resp);
            } else {
                oficinamovearray = daooficina.buscaMove(oficina.getOs(), oficina.getAtendimento());
                req.setAttribute("oficina", oficina);
                req.setAttribute("oficinamove", oficinamovearray);
                RequestDispatcher rd = req.getRequestDispatcher("oficinabh50_os_resultado.jsp");
                rd.forward(req, resp);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OficinaBh50.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OficinaBh50.class.getName()).log(Level.SEVERE, null, ex);
        }
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
