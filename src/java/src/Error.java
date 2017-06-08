package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import src.dao.ConnectDataBase;

public class Error {

    private ConnectDataBase connectDataBase = null;
    private Statement statement;
    private Error log = null;
    HttpServletResponse response;

    public Error() {
        connectDataBase = new ConnectDataBase();
    }

    public void Gravar(String message) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insere2TableSQL = "INSERT INTO erro(metodo, mensagem, data, hora)"
                + " VALUES ('sEM METODO', '" + message + "', '" + date + "', '" + thisSec + "');";
        try {
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insere2TableSQL);
        } catch (SQLException e) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out;
            try {
                out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ERRO</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>ERRO!!!!</h1>");
                out.println("</body>");
                out.println("</html>");
            } catch (IOException ex) {
                Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public void Gravar(String message, String lasteAccess) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insere2TableSQL = "INSERT INTO erro(metodo, mensagem, data, hora)"
                + " VALUES ('" + lasteAccess + "', '" + message + "', '" + date + "', '" + thisSec + "');";
        try {
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insere2TableSQL);
        } catch (SQLException e) {
           response.setContentType("text/html;charset=UTF-8");
            PrintWriter out;
            try {
                out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ERRO</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>ERRO!!!!</h1>");
                out.println("</body>");
                out.println("</html>");
            } catch (IOException ex) {
                Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
