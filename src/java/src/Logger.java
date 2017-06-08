package src;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;

public class Logger {

    public void Gravar(String texto) {
        String conteudo = texto;
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(tm);
        String d1 = new SimpleDateFormat("MM").format(tm);
        String d2 = new SimpleDateFormat("yyyy").format(tm);
        int d3 = Integer.parseInt(d1);
        try {
            // o true significa q o arquivo será constante  
            FileWriter x = new FileWriter(new File("C:\\Users\\admin\\Desktop\\"+d+".txt"));
            //FileWriter x = new FileWriter(new File("//opt//tomcat//apache-tomcat-8.0.30//webapps//docs_sigbase//log_sigbase//" + d2 + "//" + d3 + "//" + d + ".txt"));
            //FileWriter x = new FileWriter(new File("C:\\Users\\Carina Esthela\\Desktop\\"+d+".txt"));
            //"C:\\Users\\oficina\\Desktop",true

            conteudo += "\n\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            x.close(); // cria o arquivo
        } // em caso de erro apreenta mensagem abaixo
        catch (Exception e) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void Gravar(String message, String lasteAccess) {
        String conteudo = message;
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(tm);
        String d1 = new SimpleDateFormat("MM").format(tm);
        String d2 = new SimpleDateFormat("yyyy").format(tm);
        int d3 = Integer.parseInt(d1);
        try {
            // o true significa q o arquivo será constante  
            FileWriter x = new FileWriter(new File("C:\\Users\\admin\\Desktop\\"+lasteAccess+"_" + d + ".txt"));
            //FileWriter x = new FileWriter(new File("//opt//tomcat//apache-tomcat-8.0.30//webapps//docs_sigbase//log_sigbase//" + d2 + "//" + d3 + "//"+lasteAccess+"_" + d + ".txt"));
            //FileWriter x = new FileWriter(new File("C:\\Users\\Carina Esthela\\Desktop\\"+d+".txt"));
            //"C:\\Users\\oficina\\Desktop",true

            conteudo += "\n\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            x.close(); // cria o arquivo
        } // em caso de erro apreenta mensagem abaixo
        catch (Exception e) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
