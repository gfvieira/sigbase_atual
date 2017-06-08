package src.chm;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.dao.DaoEngenharia;
import src.modelo.Consumo_model;
import src.modelo.Mare_charts;

public class Mare extends HttpServlet {

    DaoEngenharia daoengenharia = null;
    ArrayList<Consumo_model> consumo1 = null;
    ArrayList<Consumo_model> consumo2 = null;

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("type"));
        String dia = request.getParameter("day");
        System.out.print(tipo);
        System.out.print(dia);
        ArrayList<Mare_charts> l = new ArrayList();
        daoengenharia = new DaoEngenharia();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(tm));
        if (tipo == 1) {
            String dia_temp = dia;
            if (!dia_temp.equals("")) {
                String day = "", mes = "", ano = "";
                dia_temp = dia_temp.replaceAll("[^a-zZ-Z0-9 ]", "");
                if (!dia_temp.equals("")) {
                    day = dia_temp.substring(0, 2);
                    mes = dia_temp.substring(2, 4);
                    ano = dia_temp.substring(4, 8);
                }
                dia_temp = (ano + "-" + mes + "-" + day);
            }
            consumo1 = daoengenharia.buscaMare(dia_temp, 1);//observado
            consumo2 = daoengenharia.buscaMare(dia_temp, 2);//previsto

            for (int i = 0; i < 24; i++) {
                Mare_charts a = new Mare_charts();
                String mes = "";
                if (i < 10) {
                    mes = "0" + i + ":00";
                } else {
                    mes = i + ":00";
                }
                a.setPeriod(mes);
                a.setPrevisto(consumo2.get(i).getConsumo());
                if (consumo1.size() > i) {
                    a.setReal(consumo1.get(i).getConsumo());
                } else {
                    a.setReal();
                }
                l.add(a);
            }
        } else if (tipo == 2) {
            int day = 0;
            String mes = "", ano = "";
            for (int k = 0; k < 5; k++) {
                String dia_temp = dia;
                if (!dia_temp.equals("")) {
                    dia_temp = dia_temp.replaceAll("[^a-zZ-Z0-9 ]", "");
                    if (!dia_temp.equals("")&& k == 0) {
                        day = Integer.parseInt(dia_temp.substring(0, 2));
                        mes = dia_temp.substring(2, 4);
                        ano = dia_temp.substring(4, 8);
                    }
                    if (day < 10) {
                        dia_temp = (ano + "-" + mes + "-0" + day);
                    } else {
                        dia_temp = (ano + "-" + mes + "-" + day);
                    }
                }
                consumo1 = daoengenharia.buscaMare(dia_temp, 1);//observado
                consumo2 = daoengenharia.buscaMare(dia_temp, 2);//previsto

                for (int i = 0; i < 24; i++) {
                    Mare_charts a = new Mare_charts();
                    String hora;
                    if (i < 10) {
                        hora = "0" + i + ":00/" + day;
                    } else {
                        hora = i + ":00/" + day;
                    }
                    a.setPeriod(hora);
                    a.setPrevisto(consumo2.get(i).getConsumo());
                    if (consumo1.size() > i) {
                        a.setReal(consumo1.get(i).getConsumo());
                    } else {
                        a.setReal();
                    }
                    l.add(a);
                }
                day++;
            }
        }
        // convert "apps" to "events"		
        String json = new Gson().toJson(l);
        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
