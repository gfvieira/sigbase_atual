package src.oficina.indicadores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author gustavo
 */
public class Teste extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*List l = new ArrayList();
            
            CalendarDTO c = new CalendarDTO();
            c.setId(1);
            c.setStart("2016-02-20");
            c.setEnd("2016-02-20");
            c.setTitle("Task in Progress");
            
            CalendarDTO d = new CalendarDTO();
            d.setId(2);
            d.setStart("2016-02-21");
            d.setEnd("2016-02-21");
            d.setTitle("Task in Progress1");
            
            l.add(c);
            l.add(d);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write(new Gson().toJson(l));*/

        //Cria um Objeto JSON
        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;

        //Armazena dados em um Objeto JSON
        jsonObject.put("escala", "Allan");
        jsonObject.put("sobrenome", "Romanato");
        jsonObject.put("pais", "Brasil");
        jsonObject.put("estado", "SP");

        try {
            writeFile = new FileWriter("saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Imprimne na Tela o Objeto JSON para vizualização
        System.out.println(jsonObject);
        PrintWriter out = response.getWriter();
        out.write(jsonObject.toJSONString());

    }

}
