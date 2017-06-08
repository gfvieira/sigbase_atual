    package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import src.Error;

public class ConnectDataBaseFolhaN {  
        public static Connection connection = null;
        Error log = null;
      
    public ConnectDataBaseFolhaN(){  
        try {  
            Class.forName("org.postgresql.Driver"); 
            //Class.forName("org.firebirdsql.jdbc.FBDriver");//org.firebirdsql.jdbc.FBDriver  
        } catch (ClassNotFoundException e) {  
                log = new Error();
                log.Gravar(e.getMessage());

        }  
    }  
      
    public Connection openConection(){  
        if(connection == null){  
            try {  
                //connection = DriverManager.getConnection("jdbc:postgresql://10.5.185.11:5432/sigbase_new", "postgres", "bodeverde2001");  
                //connection = DriverManager.getConnection("jdbc:postgresql://10.5.185.11:5432/sigbase_teste", "postgres", "bodeverde2001");  
                //connection = DriverManager.getConnection("jdbc:postgresql://10.5.185.11:5432/folhan", "postgres", "bodeverde2001");  
                connection = DriverManager.getConnection("jdbc:postgresql://10.5.185.11:5432/folhan", "postgres", "bodeverde2001");  
                //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sigbase_teste", "postgres", "bodeverde2001"); 
                //connection = DriverManager.getConnection("jdbc:firebirdsql://localhost/3050:C:\\Firebird\\sisfolhan\\bd\\SISFOLHAN.GBD", "SYSDBA", "masterkey");  
                //connection = DriverManager.getConnection("jdbc:firebirdsql://10.5.176.4:3050/c:\\sistemas\\sisfolhan\\bd\\sisfolhan.gdb", "SYSDBA", "masterkey");  
                int i =0;
            } catch (SQLException e) { 
                log = new Error();
                log.Gravar(e.getMessage());
                return null;
            } 
        }  
        return connection;  
    }  
      
    public void closeConnection(){  
        if(connection != null){  
            try {  
                connection.close();
                connection = null;
            } catch (SQLException e) {  
                log = new Error();
                log.Gravar(e.getMessage());
            }  
        }  
    }  
}  
