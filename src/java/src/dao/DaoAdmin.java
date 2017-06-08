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
import src.modelo.Logon;
import src.modelo.Usuario;

public class DaoAdmin {

    private ConnectDataBase connectDataBase = null;
    private Statement statement;
    private Error log = null;

    public DaoAdmin() {
        connectDataBase = new ConnectDataBase();
    }

    public Usuario buscaUsuario(Usuario usuario) {
        String selectTableSQL = "SELECT * from usuario WHERE nip='" + usuario.getNip() + "';";
        Usuario usuarioRetorno = null;

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(usuario.getNip());
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
            }
            return usuarioRetorno;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_buscaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereUsuario(Usuario usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insere2TableSQL = "insert into usuarIo (atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, access, data_cad, hora_cad)"
                + "  values ('1', '1', '" + usuario.getNip() + "', 'Marinha123456', '" + usuario.getNome() + "', '" + usuario.getPost() + "', '" + usuario.getGuerra() + "', '" + usuario.getSetor() + "', '" + usuario.getRamal() + "', '" + usuario.getPri() + "', '" + usuario.getTypeAccess() + "', '" + date + "', '" + thisSec + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insere2TableSQL);
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_insereUsuario");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuario() {
        String selectTableSQL = "SELECT * from usuario ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean atualizaUsuario(Usuario usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "";
        if (usuario.getPassword() == 1) {
            insereTableSQL = "UPDATE usuario SET atv='" + usuario.getAtivo() + "', pass='" + usuario.getPassword() + "', "
                    + "senha='Marinha123456', nip='" + usuario.getNip() + "', nome='" + usuario.getNome() + "', "
                    + "posto_grad='" + usuario.getPost() + "', guerra='" + usuario.getGuerra() + "', setor='" + usuario.getSetor() + "', "
                    + "ramal='" + usuario.getRamal() + "', pri='" + usuario.getPri() + "', access='" + usuario.getTypeAccess() + "' "
                    + "WHERE id_usuario='" + usuario.getId() + "';";
        } else {
            insereTableSQL = "UPDATE usuario SET atv='" + usuario.getAtivo() + "', pass='" + usuario.getPassword() + "', "
                    + "nip='" + usuario.getNip() + "', nome='" + usuario.getNome() + "', "
                    + "posto_grad='" + usuario.getPost() + "', guerra='" + usuario.getGuerra() + "', setor='" + usuario.getSetor() + "', "
                    + "ramal='" + usuario.getRamal() + "', pri='" + usuario.getPri() + "', access='" + usuario.getTypeAccess() + "' "
                    + "WHERE id_usuario='" + usuario.getId() + "';";
        }
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
            log.Gravar(e.getMessage(), "DaoLogin_atualizaUsuario");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioDesativados() {
        String selectTableSQL = "SELECT * from usuario where atv = '0' ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioComando() {
        String selectTableSQL = "SELECT * from usuario where pri = 'TOTAL' and atv = '1' ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioAss(String ass) {
        String selectTableSQL = "SELECT * from usuario where pri = '" + ass + "' and atv = '1' ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioDep(String dep) {
        String selectTableSQL = "SELECT * from usuario where pri = '" + dep + "' and atv = '1' ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioSargenteante() {
        String selectTableSQL = "SELECT * from usuario where pri = 'SARGENTEANTE' and atv = '1' ORDER BY posto_grad DESC;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Usuario> listaUsuarioLogon() {//
        String selectTableSQL = "select * from control_logon A, usuario B where "
                + "data_access = '2016-10-05' and A.nip = B.nip ORDER BY hora_access asc;";
        Usuario usuarioRetorno = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getString("id_usuario"));
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Logon> listaUsuarioLogonNow() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String selectTableSQL = "select * from control_logon A, usuario B where "
                + "data_access = '" + date + "' and A.nip = B.nip ORDER BY hora_access asc;";
        Logon usuarioRetorno = null;
        ArrayList<Logon> lista = new ArrayList<>();
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
                usuarioRetorno.setNip(rs.getString("nip"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setPost(rs.getString("posto_grad"));
                usuarioRetorno.setGuerra(rs.getString("guerra"));
                usuarioRetorno.setSetor(rs.getString("setor"));
                usuarioRetorno.setRamal(rs.getString("ramal"));
                usuarioRetorno.setPri(rs.getString("pri"));
                usuarioRetorno.setDataCad(rs.getString("data_cad"));
                usuarioRetorno.setLastAccess(rs.getString("last_access"));
                usuarioRetorno.setAtivo(rs.getInt("atv"));
                usuarioRetorno.setPassword(rs.getInt("pass"));
                usuarioRetorno.setTypeAccess(rs.getString("access"));
                usuarioRetorno.setId_session(rs.getString("id_session"));
                usuarioRetorno.setIp(rs.getString("ip_logon"));
                usuarioRetorno.setHora(LocalTime.parse(rs.getString("hora_access")));

                lista.add(usuarioRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoLogin_listaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
