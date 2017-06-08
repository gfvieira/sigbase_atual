package src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import src.Error;
import src.modelo.Indicador_bh10_model;

public class DaoIndicadoresbh10 {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoIndicadoresbh10() {
        connectDataBase = new ConnectDataBase();
    }

    public boolean insereBh10(Indicador_bh10_model ind) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO indicador_bh10 (valor, reais, indicador, mes, ano, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + ind.getValue() + "', '" + ind.getReal() + "', '" + ind.getIndicador() + "', '" + ind.getMes() + "', '" + ind.getAno() + "',"
                + "'" + ind.getUser() + "', '" + date + "', '" + thisSec + "', '" + ind.getIp() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh10_insereBh10");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Indicador_bh10_model buscaIndExist(int mes, int ano, String indicador) {
        String selectTableSQL = "SELECT * from indicador_bh10 WHERE mes ='" + mes + "' and ano ='" + ano + "' and indicador = '" + indicador + "';";
        Indicador_bh10_model ind = new Indicador_bh10_model();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                ind.setAno(rs.getInt("ano"));
                ind.setMes(rs.getInt("mes"));
            }
            //statement.close();
            return ind;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh10_buscaIndExist");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Indicador_bh10_model indbh10(String indicador, int ano, int mes) {
        String selectTableSQL = "SELECT * from indicador_bh10 WHERE indicador='" + indicador + "' and mes = '" + mes + "' and ano = '20" + ano + "';";
        Indicador_bh10_model ind = new Indicador_bh10_model();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                ind.setValue(rs.getDouble("valor"));
                ind.setReal(rs.getDouble("reais"));
                ind.setMes(mes);
                ind.setAno(ano);
                ind.setIndicador(rs.getString("indicador"));
            }
            ind.setMes(mes);
            ind.setAno(ano);
            return ind;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh10_indbh10");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attBh10(Indicador_bh10_model ind) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE indicador_bh10  SET valor = '" + ind.getValue() + "', reais = '" + ind.getReal() + "' "
                + "WHERE ano='" + ind.getAno() + "' and mes='" + ind.getMes() + "' and indicador='" + ind.getIndicador() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh10_attBh10");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
