package src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import src.Error;
import src.modelo.Secom_doc;

public class DaoSecom {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoSecom() {
        connectDataBase = new ConnectDataBase();
    }

    public boolean inseredoc(String fileName, int mes, int ano, String nome, String remoteAddr, String user, String contentType) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO secom (doc, nome_doc, ano_doc, mes_doc, type_doc,"
                + " atv, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + fileName + "', '" + nome + "', "
                + "'" + ano + "', '" + mes + "', '" + contentType + "', '1', '" + user + "', "
                + "'" + date + "', '" + thisSec + "', '" + remoteAddr + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoSecom_inseredoc");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Secom_doc> listaDocs() {
        String selectTableSQL = "SELECT * from secom WHERE atv='1' ORDER BY ano_doc ASC;";
        ArrayList<Secom_doc> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Secom_doc secom = new Secom_doc();
                secom.setId_doc(rs.getInt("id_secom"));
                secom.setDoc(rs.getString("doc"));
                secom.setNome_doc(rs.getString("nome_doc"));
                secom.setAno_doc(rs.getInt("ano_doc"));
                secom.setMes_doc(rs.getInt("mes_doc"));
                secom.setType_doc(rs.getString("type_doc"));
                secom.setAtv(rs.getInt("atv"));
                secom.setUser(rs.getString("user_cad"));
                secom.setDatacad(rs.getDate("data_cad"));
                secom.setIp(rs.getString("ip_cad"));
                secom.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(secom);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoSecom_listaDocs");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean retiradoc(int id) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE secom SET"
                + " atv ='0' where id_secom = '" + id + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoSecom_retiradoc");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
