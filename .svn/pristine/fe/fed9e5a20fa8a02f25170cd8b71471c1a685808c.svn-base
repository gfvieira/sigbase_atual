/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import src.modelo.Meta_model;
import src.modelo.Ouvidoria_model;

/**
 *
 * @author root
 */
public class DaoOuvidoria {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoOuvidoria() {
        connectDataBase = new ConnectDataBase();
    }

    public boolean insereMsg(Ouvidoria_model ouvidoria) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO ouvidoria (protocolo, nome, email, contato, mensagem,"
                + "situacao, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + ouvidoria.getProtocolo() + "', '" + ouvidoria.getNome() + "',"
                + " '" + ouvidoria.getEmail() + "', '" + ouvidoria.getContato() + "',"
                + " '" + ouvidoria.getMensagem() + "', '0',"
                + " '" + date + "', '" + thisSec + "', '" + ouvidoria.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOuvidoria_insereMsg");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Ouvidoria_model> listaOuvidoria(int tipo) {
        String selectTableSQL = "SELECT * from ouvidoria WHERE situacao='" + tipo + "' ORDER BY data_cad ASC;";
        ArrayList<Ouvidoria_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Ouvidoria_model ouvidoriaRetorno = new Ouvidoria_model();
                ouvidoriaRetorno.setId(rs.getInt("id_ouvidoria"));
                ouvidoriaRetorno.setProtocolo(rs.getString("protocolo"));
                ouvidoriaRetorno.setNome(rs.getString("nome"));
                ouvidoriaRetorno.setEmail(rs.getString("email"));
                ouvidoriaRetorno.setContato(rs.getString("contato"));
                ouvidoriaRetorno.setMensagem(rs.getString("mensagem"));
                ouvidoriaRetorno.setSituacao(rs.getInt("situacao"));
                ouvidoriaRetorno.setDatacad(rs.getDate("data_cad"));
                ouvidoriaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(ouvidoriaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOuvidoria_listaOuvidoria");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Ouvidoria_model ouvidoria(String protocolo) {
        String selectTableSQL = "SELECT * from ouvidoria WHERE protocolo='" + protocolo + "';";
        Ouvidoria_model ouvidoriaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                ouvidoriaRetorno = new Ouvidoria_model();
                ouvidoriaRetorno.setId(rs.getInt("id_ouvidoria"));
                ouvidoriaRetorno.setProtocolo(rs.getString("protocolo"));
                ouvidoriaRetorno.setNome(rs.getString("nome"));
                ouvidoriaRetorno.setEmail(rs.getString("email"));
                ouvidoriaRetorno.setContato(rs.getString("contato"));
                ouvidoriaRetorno.setMensagem(rs.getString("mensagem"));
                ouvidoriaRetorno.setSituacao(rs.getInt("situacao"));
                ouvidoriaRetorno.setDatacad(rs.getDate("data_cad"));
                ouvidoriaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
            }
            return ouvidoriaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOuvidoria_listaOuvidoria");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
