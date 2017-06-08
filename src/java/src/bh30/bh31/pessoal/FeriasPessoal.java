/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.bh31.pessoal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import src.dao.DaoBh30Pessoal;
import src.modelo.Pessoal_model;

/**
 *
 * @author gustavo
 */
public class FeriasPessoal extends HttpServlet {

    DaoBh30Pessoal daobh30 = null;
    Pessoal_model servidor = null;
    String dia = "", mes = "", ano = "", nasc = "";
    ArrayList<Pessoal_model> servidorarray = null;
    SimpleDateFormat format = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servidor = new Pessoal_model();
            format = new SimpleDateFormat("dd/MM/yyyy");
            Map mapRequest = request.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("user")) {
                    servidor.setUsercad(request.getParameterValues(key)[0]);
                }
                if (key.equals("nip")) {
                    servidor.setNip(request.getParameterValues(key)[0]);
                }
                if (key.equals("ano")) {
                    servidor.setAnoFerias(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("dias")) {
                    servidor.setDiasFerias(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("type")) {
                    servidor.setType(Integer.parseInt(request.getParameterValues(key)[0]));
                }
                if (key.equals("ini")) {
                    servidor.setDate_ini(Util.setData2(request.getParameterValues(key)[0]));
                }
                if (key.equals("ter")) {
                    servidor.setDate_ter(Util.setData2(request.getParameterValues(key)[0]));
                }
            }
            daobh30 = new DaoBh30Pessoal();
            boolean check = false;
            Calendar data1 = Calendar.getInstance();
            Calendar data2 = Calendar.getInstance();
            Calendar dataEnd = Calendar.getInstance();
            Calendar dataStart = Calendar.getInstance();
            try {
                data1.setTime(format.parse(new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ini())));
            } catch (ParseException ex) {
                Logger.getLogger(FeriasPessoal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                data2.setTime(format.parse(new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ter())));
            } catch (ParseException ex) {
                Logger.getLogger(FeriasPessoal.class.getName()).log(Level.SEVERE, null, ex);
            }

            int dias = 0;
            if (data2.get(Calendar.YEAR) != data1.get(Calendar.YEAR)) {
                try {
                    dataEnd.setTime(format.parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date(format.parse("31/12/" + data1.get(Calendar.YEAR)).getTime()))));
                } catch (ParseException ex) {
                    Logger.getLogger(FeriasPessoal.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    dataStart.setTime(format.parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date(format.parse("01/01/" + data2.get(Calendar.YEAR)).getTime()))));
                } catch (ParseException ex) {
                    Logger.getLogger(FeriasPessoal.class.getName()).log(Level.SEVERE, null, ex);
                }
                dias = (dataEnd.get(Calendar.DAY_OF_YEAR) - data1.get(Calendar.DAY_OF_YEAR))
                        + (data2.get(Calendar.DAY_OF_YEAR) - dataStart.get(Calendar.DAY_OF_YEAR));
                dias++;

            } else {
                dias = data2.get(Calendar.DAY_OF_YEAR) - data1.get(Calendar.DAY_OF_YEAR);
            }
            if (++dias == servidor.getDiasFerias() && dias <= 30) {
                ArrayList<Pessoal_model> servidorarrayTemp = new ArrayList<>();
                servidorarrayTemp = daobh30.buscaFerias(servidor, servidor.getAnoFerias());
                int total = 0;
                for (Pessoal_model serv2 : servidorarrayTemp) {
                    total = total + serv2.getDiasFerias();
                }
                if (total < 30) {
                    if ((total + dias) <= 30) {
                        servidor.setIpcad(request.getRemoteAddr());
                        check = daobh30.insereFerias(servidor);
                    } else {
                        request.setAttribute("mensagem", "NO3");
                        request.setAttribute("nip", servidor.getNip());
                        request.setAttribute("typeferias", servidor.getType());
                        RequestDispatcher rd = request.getRequestDispatcher("ExibePessoal.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("mensagem", "NO4");
                    request.setAttribute("nip", servidor.getNip());
                    request.setAttribute("typeferias", servidor.getType());
                    RequestDispatcher rd = request.getRequestDispatcher("ExibePessoal.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("mensagem", "NO2");
                request.setAttribute("nip", servidor.getNip());
                request.setAttribute("typeferias", servidor.getType());
                RequestDispatcher rd = request.getRequestDispatcher("ExibePessoal.jsp");
                rd.forward(request, response);
            }
            if (check == true) {
                request.setAttribute("nip", servidor.getNip());
                request.setAttribute("type", servidor.getType());
                RequestDispatcher rd = request.getRequestDispatcher("ExibePessoal.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("mensagem", "NO");
                request.setAttribute("nip", servidor.getNip());
                request.setAttribute("typeferias", servidor.getType());
                RequestDispatcher rd = request.getRequestDispatcher("ExibePessoal.jsp");
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
