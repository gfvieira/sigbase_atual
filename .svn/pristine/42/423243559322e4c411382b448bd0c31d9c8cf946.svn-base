/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.oficina.indicadores;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.modelo.CalendarDTO;

/**
 *
 * @author gustavo
 */
public class teste2 extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<CalendarDTO> l = new ArrayList();

        CalendarDTO c = new CalendarDTO();
        c.setId(1);
        c.setStart("2016-06-02");
        c.setEnd("2016-06-07");
        c.setTitle("Reunião");

        CalendarDTO d = new CalendarDTO();
        d.setId(2);
        d.setStart("2016-06-26 10:00");
        d.setEnd("2016-06-28 10:00");
        d.setTitle("IAM");
        d.setBackgroundColor("#378006");
        
        CalendarDTO f = new CalendarDTO();
        f.setId(2);
        f.setStart("2016-06-15 10:00");
        f.setEnd("2016-06-15 10:30");
        f.setTitle("Licença");
        f.setBackgroundColor("#378006");
        
        CalendarDTO e = new CalendarDTO();
        e.setId(2);
        e.setStart("2016-06-15 10:30");
        e.setEnd("2016-06-15 11:00");
        e.setTitle("Licença");
        e.setBackgroundColor("#378006");

        l.add(c);
        l.add(e);
        l.add(f);
        l.add(d);

        // convert "apps" to "events"		
        String json = new Gson().toJson(l);

        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

}
