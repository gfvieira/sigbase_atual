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
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class DaoOficina50 {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoOficina50() {
        connectDataBase = new ConnectDataBase();
    }

    public int buscaLastOs() {
        String selectTableSQL = "SELECT last from last_os WHERE id_last_os ='1';";
        int temp = -1;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                temp = rs.getInt("last");
            }
            //statement.close();
            return temp;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaLastOs");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }    

    public boolean insereOficina(Pedido_model oficina) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh50 (os_bh50, post, nome, nip, ramal, setor, atendimento, "
                + "solicitacao, descricao, obs, status, priori, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + oficina.getOs() + "', '" + oficina.getPost() + "', '" + oficina.getNome() + "',"
                + " '" + oficina.getNip() + "', '" + oficina.getRamal() + "',"
                + "'" + oficina.getSetor() + "', '" + oficina.getAtendimento() + "', "
                + "'" + oficina.getSolicitacao() + "', '" + oficina.getDescricao() + "', '" + oficina.getObs() + "', "
                + "'" + oficina.getStatus() + "', '0', '" + date + "', '" + thisSec + "', '" + oficina.getIp() + "');";
        String insereTableSQL1 = "INSERT INTO oficinabh50_status (os) "
                + "VALUES ('" + oficina.getOs() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_insereOficina");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereOficinaGaragem(Pedido_model oficina) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh50 (os_bh50, post, nome, nip, ramal, setor, atendimento, "
                + "solicitacao, descricao, obs, pob, data_viatura, hora_viatura, hora_fim, status, priori, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + oficina.getOs() + "', '" + oficina.getPost() + "', '" + oficina.getNome() + "',"
                + " '" + oficina.getNip() + "', '" + oficina.getRamal() + "',"
                + "'" + oficina.getSetor() + "', '" + oficina.getAtendimento() + "', "
                + "'" + oficina.getSolicitacao() + "', 'NÃO DISPONIVEL', '" + oficina.getObs() + "', "
                + "'" + oficina.getPob() + "', '" + oficina.getDataevento() + "',"
                + " '" + oficina.getHoraevento() + "', '" + oficina.getHorafim() + "', "
                + "'" + oficina.getStatus() + "', '0', '" + date + "', '" + thisSec + "', '" + oficina.getIp() + "');";
        String insereTableSQL1 = "INSERT INTO oficinabh50_status (os) "
                + "VALUES ('" + oficina.getOs() + "');";

        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_insereOficinaGaragem");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereLast(int oficina) {
        String insereTableSQL = "UPDATE last_os SET last = '" + oficina + "' WHERE id_last_os ='1';";
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
            log.Gravar(e.getMessage(), "DaoOficina50_buscaLastOs");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficina(int type, String value) {
        String selectTableSQL = "";
        if (type == 1) {
            selectTableSQL = "SELECT * from oficinabh50 WHERE nip='" + value + "' ORDER BY data_cad ASC;;";
        }
        if (type == 2) {
            selectTableSQL = "SELECT * from oficinabh50 WHERE os_bh50='" + value + "';";
        }
        ArrayList<Pedido_model> lista = new ArrayList<>();
        int qnt = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficina(String type) {
        String selectTableSQL = "SELECT * from oficinabh50 WHERE atendimento='" + type + "' ORDER BY os_bh50 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficina() {
        String selectTableSQL = "SELECT * from oficinabh50 ORDER BY os_bh50 ASC;";
        int qnt = 0;
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
    public ArrayList<Pedido_model> buscaOficinaAll() {
        String selectTableSQL = "SELECT * from oficinabh50 ORDER BY os_bh50 DESC;";
        int qnt = 0;
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficina52() {
        String selectTableSQL = "SELECT * from oficinabh50 WHERE (atendimento = 'ELETRICA' "
                + "or atendimento = 'REFRIGERACAO' "
                + "or atendimento = 'METALURGIA' "
                + "or atendimento = 'CARPINTARIA') ORDER BY os_bh50 ASC;";
        int qnt = 0;
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina52");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficina53() {
        String selectTableSQL = "SELECT * from oficinabh50 where (atendimento = 'GARAGEM' or atendimento = 'PREFEITURA') ORDER BY os_bh50 ASC;";
        int qnt = 0;
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficina53");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaMes(String type) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh50 where atendimento='" + type + "' and data_cad between '01/" + d + "' and '" + d1 + "' ORDER BY os_bh50 ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaMes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaMes() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh50 where data_cad between '01/" + d + "' and '" + d1 + "' ORDER BY os_bh50 ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaMes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaMes52() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh50 where data_cad between '01/" + d + "' and '" + d1 + "' "
                + "AND (atendimento = 'ELETRICA' "
                + "or atendimento = 'REFRIGERACAO' "
                + "or atendimento = 'METALURGIA' "
                + "or atendimento = 'AGUADA' "
                + "or atendimento = 'CARPINTARIA') ORDER BY atendimento ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaMes52");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaMes53() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh50 where data_cad between '01/" + d + "' and '" + d1 + "' "
                + "AND (atendimento = 'GARAGEM' or atendimento = 'PREFEITURA') ORDER BY os_bh50 ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaMes53");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pedido_model buscaOficinaOs(String os) {
        String selectTableSQL = "SELECT * from oficinabh50 WHERE os_bh50 ='" + os + "';";
        Pedido_model oficinaRetorno = new Pedido_model();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                if (rs.getString("hora_viatura") != null) {
                    oficinaRetorno.setPob(rs.getInt("pob"));
                    oficinaRetorno.setDataevento(rs.getDate("data_viatura"));
                    oficinaRetorno.setHoraevento(LocalTime.parse(rs.getString("hora_viatura")));
                    oficinaRetorno.setHorafim(LocalTime.parse(rs.getString("hora_fim")));
                }
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
            }
            return oficinaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaOs");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_move> buscaMove(String os, String atendimento) {
        //String selectTableSQL = "SELECT * from movimento WHERE os='"+os+"' and oficina='"+atendimento+"';";
        String selectTableSQL = "SELECT * from oficinabh50_mov WHERE os ='" + os + "';";
        ArrayList<Pedido_move> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_move oficinaRetorno = new Pedido_move();
                oficinaRetorno.setOs(rs.getString("os"));
                oficinaRetorno.setOf(rs.getString("oficina"));
                oficinaRetorno.setId(rs.getInt("id_mov"));
                oficinaRetorno.setDescricao_move(rs.getString("desc_mov"));
                oficinaRetorno.setDatacadmov(rs.getDate("dataalt"));
                oficinaRetorno.setIp(rs.getString("ip_mov"));
                oficinaRetorno.setHoracadmov(LocalTime.parse(rs.getString("horaalt")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaMove");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereMov(Pedido_model oficina) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh50_mov (oficina, os, desc_mov, dataalt, horaalt, ip_mov) "
                + "VALUES ('" + oficina.getAtendimento() + "', '" + oficina.getOs() + "', "
                + "'" + oficina.getMove() + "', '" + date + "', '" + thisSec + "', '" + oficina.getIp() + "');";
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
            log.Gravar(e.getMessage(), "DaoOficina50_insereMov");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean altStatusAfi(Pedido_model sate, String usuario, int priori) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh50 SET status = '" + sate.getStatus() + "', priori = '" + priori + "' "
                + "WHERE os_bh50 ='" + sate.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh50_status SET data_afi = '" + date + "', "
                + "hora_afi = '" + thisSec + "', "
                + "user_afi = '" + usuario + "' WHERE os ='" + sate.getOs() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_altStatusAfi");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean altStatusOpen(Pedido_model oficina, String usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh50 SET status = '" + oficina.getStatus() + "' "
                + "WHERE os_bh50 ='" + oficina.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh50_status SET data_open = '" + date + "', "
                + "hora_open = '" + thisSec + "', "
                + "user_open = '" + usuario + "' WHERE os ='" + oficina.getOs() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_altStatusOpen");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean altStatusEnd(Pedido_model oficina, String usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh50 SET status = '" + oficina.getStatus() + "' "
                + "WHERE os_bh50 ='" + oficina.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh50_status SET data_fin = '" + date + "', "
                + "hora_fin = '" + thisSec + "', "
                + "user_fin = '" + usuario + "' WHERE os ='" + oficina.getOs() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL1);
            //statement.close();
            //connectDataBase.closeConnection();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_altStatusEnd");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaOther(String status) {
        String selectTableSQL = "SELECT * from oficinabh50 where status = '" + status + "' ORDER BY os_bh50 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaOther");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaOther52(String status) {
        String selectTableSQL = "SELECT * from oficinabh50 where status = '" + status + "' AND (atendimento = 'ELETRICA' "
                + "or atendimento = 'REFRIGERACAO' "
                + "or atendimento = 'METALURGIA' "
                + "or atendimento = 'CARPINTARIA') ORDER BY os_bh50 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaOther52");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaOther53(String status) {
        String selectTableSQL = "SELECT * from oficinabh50 where status = '" + status + "' AND (atendimento = 'GARAGEM' or atendimento = 'PREFEITURA') ORDER BY os_bh50 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaOther53");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaOficinaOther(String type, String status) {
        String selectTableSQL = "SELECT * from oficinabh50 WHERE atendimento='" + type + "' and status = '" + status + "' ORDER BY os_bh50 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model oficinaRetorno = new Pedido_model();
                oficinaRetorno.setOs(rs.getString("os_bh50"));
                oficinaRetorno.setPost(rs.getString("post"));
                oficinaRetorno.setNome(rs.getString("nome"));
                oficinaRetorno.setNip(rs.getString("nip"));
                oficinaRetorno.setRamal(rs.getString("ramal"));
                oficinaRetorno.setSetor(rs.getString("setor"));
                oficinaRetorno.setAtendimento(rs.getString("atendimento"));
                oficinaRetorno.setSolicitacao(rs.getString("solicitacao"));
                oficinaRetorno.setDescricao(rs.getString("descricao"));
                oficinaRetorno.setObs(rs.getString("obs"));
                oficinaRetorno.setPriori(rs.getInt("priori"));
                oficinaRetorno.setPob(rs.getInt("pob"));
                oficinaRetorno.setStatus(rs.getString("status"));
                oficinaRetorno.setIp(rs.getString("ip_cad"));
                oficinaRetorno.setDatacad(rs.getDate("data_cad"));
                oficinaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficinaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaOficinaOther");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean altOf(String os, String atendimento) {
        String insereTableSQL = "UPDATE oficinabh50 SET atendimento = '" + atendimento + "' WHERE os_bh50 ='" + os + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina50_altOf");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereFeedback(Pedido_model oficina) {
        String insereTableSQL = "UPDATE sate SET feedback = '" + oficina.getFeedback() + "' WHERE os ='" + oficina.getOs() + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina50_insereFeedback");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inseredoc(String temp, String fileName, String of, int ano, String contentType, String remoteAddr, String user) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh50_doc (doc, nome_doc, oficina, ano_doc, type_doc,"
                + " atv, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + temp + "', '" + fileName + "', "
                + "'" + of + "', '" + ano + "', '" + contentType + "', '1', '" + user + "', "
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
            log.Gravar(e.getMessage(), "DaoOficina50_inseredoc");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public String buscaUsuario(String user) {
        String selectTableSQL = "SELECT * from usuario WHERE nip='" + user + "';";
        String guerra = "", posto = "", retorno = "";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //atv, pass, nip, senha, nome, posto_grad, guerra, setor, ramal, pri, data_cad, last_access, access
                posto = rs.getString("posto_grad");
                guerra = rs.getString("guerra");
            }
            retorno = posto + "-" + guerra;
            return retorno;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina50_buscaUsuario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
