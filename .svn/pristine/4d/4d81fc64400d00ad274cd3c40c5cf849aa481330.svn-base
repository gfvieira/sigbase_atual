package src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import src.Error;
import src.modelo.Logon;
import src.modelo.Usuario;

public class DaoLogin {

    private ConnectDataBase connectDataBase = null;
    private Statement statement;
    private Error log = null;

    public DaoLogin() {
        connectDataBase = new ConnectDataBase();
    }

    public Logon loginUsuario(String usuario, String senha) {
        String selectTableSQL = "SELECT * from usuario WHERE nip='" + usuario + "' and senha='" + senha + "';";
        Logon usuarioRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Logon();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(usuario);
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
            }
            return usuarioRetorno;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_loginUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
//    public Logon loginUsuario(Usuario usuario) {
//        String selectTableSQL = "SELECT * from usuario WHERE nip='" + usuario.getNip() + "' and senha='" + usuario.getSenha() + "';";
//        Logon usuarioRetorno = null;
//        try {
//            if (connectDataBase.openConection() == null) {
//                return null;//criar uma variavel no usauario pra condicao do banco
//            }
//            statement = connectDataBase.openConection().createStatement();
//            //statement = dbConnection.createStatement();       
//            ResultSet rs = statement.executeQuery(selectTableSQL);
//            while (rs.next()) {
//                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
//                usuarioRetorno = new Logon();
//                usuarioRetorno.setId(rs.getString("id_usuario"));
//                usuarioRetorno.setNip(usuario.getNip());
//                usuarioRetorno.setNome(rs.getString("nome"));
//                usuarioRetorno.setPost(rs.getString("posto_grad"));
//                usuarioRetorno.setGuerra(rs.getString("guerra"));
//                usuarioRetorno.setSetor(rs.getString("setor"));
//                usuarioRetorno.setRamal(rs.getString("ramal"));
//                usuarioRetorno.setPri(rs.getString("pri"));
//                usuarioRetorno.setDataCad(rs.getString("data_cad"));
//                usuarioRetorno.setLastAccess(rs.getString("last_access"));
//                usuarioRetorno.setTypeAccess(rs.getString("access"));
//                usuarioRetorno.setAtivo(rs.getInt("atv"));
//                usuarioRetorno.setPassword(rs.getInt("pass"));
//            }
//            return usuarioRetorno;
//        } catch (SQLException e) {
//            log = new Error();
//            log.Gravar(e.getMessage(), "DaoLogin_loginUsuario");
//            return null;
//        } finally {
//            connectDataBase.closeConnection();
//        }
//    }

    public Boolean attSenhaUsuario(Logon usuario) {

        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE usuario SET "
                + "senha = '" + usuario.getSenha() + "', "
                + "pass = '0' WHERE nip ='" + usuario.getNip() + "';";
        String insereTableSQL1 = "INSERT INTO usuario_auditoria (id_usuario, auditoria, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + usuario.getId() + "', 'ALTERAÇÃO DE SENHA PADRÃO', "
                + "'" + date + "', '" + thisSec + "', '" + usuario.getIp() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL1);
            statement.executeUpdate(insereTableSQL);
            statement.close();
            connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_attSenhaUsuario");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean lastAccess(Logon usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE usuario SET last_access = '" + date + "' WHERE nip ='" + usuario.getNip() + "';";
        String insereTableSQL1 = "INSERT INTO control_logon (id_session, nip, data_access, hora_access, ip_logon) "
                + "VALUES ('" + usuario.getId_session() + "','" + usuario.getNip() + "', "
                + "'" + date + "', '" + thisSec + "', '" + usuario.getIp() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            statement.close();
            connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_lastAccess");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }
    
    public String idUsuario(Usuario usuario) {
        String selectTableSQL = "SELECT id_usuario from usuario WHERE nip='" + usuario.getNip() + "';";
        String usuarioRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = rs.getString("id_usuario");
            }
            return usuarioRetorno;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_loginUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
