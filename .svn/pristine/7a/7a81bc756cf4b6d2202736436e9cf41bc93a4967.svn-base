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
import src.modelo.Pedido_model;

public class DaoMeta {

    private ConnectDataBase connectDataBase = null;
    private Statement statement;
    private Error log = null;

    public DaoMeta() {
        connectDataBase = new ConnectDataBase();
    }

    public boolean inserMeta(Meta_model meta) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO plano_meta (meta, tipo, concluido, divisao, ano, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + meta.getMeta() + "', '" + meta.getTipo() + "', '0',"
                + " '" + meta.getSetor() + "', '" + meta.getAno() + "',"
                + " '" + date + "', '" + thisSec + "', '" + meta.getIpCad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoMeta_inserMeta");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Meta_model> listaMetaSetor(int setor, int ano) {
        String selectTableSQL = "SELECT * from plano_meta WHERE divisao='" + setor + "' and ano='" + ano + "' ORDER BY tipo ASC;";
        ArrayList<Meta_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Meta_model metaRetorno = new Meta_model();
                metaRetorno.setId(rs.getInt("id_meta"));
                metaRetorno.setMeta(rs.getString("meta"));
                metaRetorno.setSetor(rs.getInt("divisao"));
                metaRetorno.setTipo(rs.getInt("tipo"));
                metaRetorno.setConcluido(rs.getInt("concluido"));
                metaRetorno.setAno(ano);
                lista.add(metaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoMeta_listaMetaSetor");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Meta_model> listaMetaAll(int ano, int tipo) {
        String selectTableSQL = "SELECT * from plano_meta WHERE ano='" + ano + "' and tipo = '" + tipo + "' ORDER BY divisao ASC;";
        ArrayList<Meta_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Meta_model metaRetorno = new Meta_model();
                metaRetorno.setId(rs.getInt("id_meta"));
                metaRetorno.setMeta(rs.getString("meta"));
                metaRetorno.setSetor(rs.getInt("divisao"));
                metaRetorno.setTipo(rs.getInt("tipo"));
                metaRetorno.setConcluido(rs.getInt("concluido"));
                metaRetorno.setAno(ano);
                lista.add(metaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoMeta_listaMetaSetor");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attMeta(int porcent, int id, String user, String ip) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE plano_meta SET concluido = '" + porcent + "' WHERE id_meta ='" + id + "';";
        String insereTableSQL2 = "INSERT INTO plano_meta_control (id_meta, controle, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + id + "', 'ALTEROU PORCENTAGEM CONCLUIDA PARA: "+porcent+"',"
                + " '" + user + "',"
                + " '" + date + "', '" + thisSec + "', '" + ip + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);//testar
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_insereLast");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
