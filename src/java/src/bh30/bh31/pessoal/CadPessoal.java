package src.bh30.bh31.pessoal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoBh30Pessoal;
import src.modelo.Pessoal_model;

public class CadPessoal extends HttpServlet {

    int type = 0;
    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("nome")) {
                    servidor.setNome(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("nip")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("grad")) {
                    servidor.setGrad(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("quadro")) {
                    servidor.setQuadro(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("esp")) {
                    servidor.setEsp(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("ramal")) {
                    servidor.setRamal(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("dep")) {
                    servidor.setDep(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("div")) {
                    servidor.setDiv(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("guerra")) {
                    servidor.setGuerra(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("promo")) {
                    servidor.setPromoCad(Util.setData2(request.getParameterValues(key)[0]));
                }
                if (key.equals("nasc")) {
                    servidor.setNascCad(Util.setData2(request.getParameterValues(key)[0]));
                }
                if (key.equals("emb")) {
                    servidor.setEmbCad(Util.setData2(request.getParameterValues(key)[0]));
                }
                if (key.equals("funcao")) {
                    servidor.setFuncao(request.getParameterValues(key)[0].toUpperCase());
                }
                if (key.equals("os")) {
                    servidor.setOs(request.getParameterValues(key)[0]);
                }
                if (key.equals("ass")) {
                    servidor.setAss(request.getParameterValues(key)[0]);
                }
                if (key.equals("user")) {
                    servidor.setUsercad(request.getParameterValues(key)[0]);
                }
                if (key.equals("type")) {
                    type = Integer.parseInt(request.getParameterValues(key)[0]);
                }
            }
            daobh30 = new DaoBh30Pessoal();
            servidor.setIpcad(request.getRemoteAddr());
            boolean check = false;
            Pessoal_model servidorTemp = new Pessoal_model();
            servidorTemp = daobh30.buscaOficial(servidor.getNip());
            if (servidorTemp == null) {
                servidorTemp = daobh30.buscaPraca(servidor.getNip());
                if (servidorTemp == null) {
                    servidorTemp = daobh30.buscaCivil(servidor.getNip());
                    if (servidorTemp == null) {
                        servidorTemp = daobh30.buscaTTC(servidor.getNip());
                        if (servidorTemp == null) {
                            switch (type) {
                                case 1:
                                    check = daobh30.inserePraca(servidor);
                                    break;
                                case 2:
                                    check = daobh30.insereOficial(servidor);
                                    break;
                                case 3:
                                    check = daobh30.insereTTC(servidor);
                                    break;
                                case 4:
                                    check = daobh30.insereCivil(servidor);
                                    break;
                            }
                        }
                    }
                }
            }
            if (check == true) {
                switch (type) {
                    case 1: {
                        request.setAttribute("mensagem", "Praça Cadastrada com sucesso!");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_praca.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 2: {
                        request.setAttribute("mensagem", "Oficial Cadastrado com sucesso!");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_oficial.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 3: {
                        request.setAttribute("mensagem", "TTC Cadastrado com sucesso!");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_ttc.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 4: {
                        request.setAttribute("mensagem", "Civil Cadastrado com sucesso!");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_civil.jsp");
                        rd.forward(request, response);
                        break;
                    }
                }
            } else {
                String Resultado = "Servidor não cadastrado, ou já consta em nosso sistema!";
                switch (type) {
                    case 1: {
                        request.setAttribute("mensagem", "NO");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_praca.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 2: {
                        request.setAttribute("mensagem", "NO");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_oficial.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 3: {
                        request.setAttribute("mensagem", "NO");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_ttc.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    case 4: {
                        request.setAttribute("mensagem", "NO");
                        RequestDispatcher rd = request.getRequestDispatcher("bh31_cadastrar_civil.jsp");
                        rd.forward(request, response);
                        break;
                    }
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
