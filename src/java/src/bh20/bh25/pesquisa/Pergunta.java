package src.bh20.bh25.pesquisa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoPesquisa;
import src.modelo.pesquisa.Pergunta_model;

public class Pergunta extends HttpServlet {

    int type = 0;
    DaoPesquisa daopesquisa = null;
    Pergunta_model pesquisa = null;
    ArrayList<Pergunta_model> perguntaarray = null;

    protected Socket cliente = null;

    protected DataOutputStream o = null;
    protected DataInputStream s = null;

    private String MSGSER;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            pesquisa = new Pergunta_model();
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
                if (key.equals("perg1")) {
                    pesquisa.setPergunta1(request.getParameterValues(key)[0]);
                }
                if (key.equals("perg2")) {
                    pesquisa.setPergunta2(request.getParameterValues(key)[0]);
                }
                if (key.equals("perg3")) {
                    pesquisa.setPergunta3(request.getParameterValues(key)[0]);
                }
                if (key.equals("user")) {
                    pesquisa.setUsercad(request.getParameterValues(key)[0]);
                }
            }
            if (type == 99 || type == 98) {
                daopesquisa = new DaoPesquisa();
                perguntaarray = new ArrayList();
                perguntaarray = daopesquisa.buscaSate();
                if (perguntaarray.isEmpty()) {
                    pesquisa = new Pergunta_model();
                    pesquisa.setPergunta1("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setPergunta2("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setPergunta3("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setUsercad("Sem registro");
                    perguntaarray.add(pesquisa);
                }
                if (type == 98) {
                    request.setAttribute("pesq", perguntaarray);
                    RequestDispatcher rd = request.getRequestDispatcher("/cmd/cmd_history.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("pesq", perguntaarray);
                    RequestDispatcher rd = request.getRequestDispatcher("bh25_history.jsp");
                    rd.forward(request, response);
                }
            }
            if (type == 1 || type == 11) {
                daopesquisa = new DaoPesquisa();
                pesquisa = daopesquisa.buscaLastquestion();
                if (pesquisa == null) {
                    pesquisa = new Pergunta_model();
                    pesquisa.setPergunta1("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setPergunta2("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setPergunta3("Nenhuma Pergunta foi encontrada!");
                    pesquisa.setUsercad("Sem registro");
                }
                if (type == 11) {
                    request.setAttribute("pesq", pesquisa);
                    RequestDispatcher rd = request.getRequestDispatcher("/cmd/cmd_pergunta.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("pesq", pesquisa);
                    RequestDispatcher rd = request.getRequestDispatcher("bh25_pergunta.jsp");
                    rd.forward(request, response);
                }
            }
            if (type == 2 || type == 21) {
                daopesquisa = new DaoPesquisa();
                Date date = new Date();
                pesquisa.setDatacad(date);
                boolean check = daopesquisa.insereQuestion(pesquisa);
                if (check == true) {
                    Controle controller = new Controle();
                    String IP;
                    int PORT;
                    //------------- solicitacao da ip e da porta para conexao
                    IP = "10.5.183.187";
                    PORT = 9090;
                    //------------- instanciacao com a passagem de paramentro do ip e da porta
                    controller.Conectar(IP, PORT);
                    //------------- chama a tela e torna visisvel

                    //------------- metodo de recebimento de MSG
                    controller.enviarMSG("75");
                    boolean resposta = true;
                    while (resposta) {
                        String temp = controller.setInput();
                        if (!temp.equals("")) {
                            resposta = false;
                        }
                    }
                    if (resposta == true) {
                        RequestDispatcher rd = request.getRequestDispatcher("/SIG-BASE/503.html");
                        rd.forward(request, response);
                    } else {
                        if (type == 21) {
                            request.setAttribute("pesq", pesquisa);
                            RequestDispatcher rd = request.getRequestDispatcher("/cmd/cmd_pergunta.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("pesq", pesquisa);
                            RequestDispatcher rd = request.getRequestDispatcher("bh25_pergunta.jsp");
                            rd.forward(request, response);
                        }
                    }
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/SIG-BASE/503.html");
                    rd.forward(request, response);
                }

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
