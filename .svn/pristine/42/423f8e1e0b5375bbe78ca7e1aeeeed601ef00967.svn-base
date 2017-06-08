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
import src.modelo.Oficina34_doc;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;

public class DaoOficina34 {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoOficina34() {
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
            log.Gravar(e.getMessage(), "DaoOficina34_buscaLastOs");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereSate(Pedido_model sate) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh34 (os_bh34, post, nome, nip, ramal, setor, atendimento, equipamento,"
                + "solicitacao, descricao, obs, status, priori, feed, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + sate.getOs() + "', '" + sate.getPost() + "','" + sate.getNome() + "',"
                + " '" + sate.getNip() + "', '" + sate.getRamal() + "',"
                + "'" + sate.getSetor() + "', '" + sate.getAtendimento() + "', '" + sate.getEquipamento() + "',"
                + "'" + sate.getSolicitacao() + "', '" + sate.getDescricao() + "', '" + sate.getObs() + "', "
                + "'" + sate.getStatus() + "', '0', '0', '" + date + "', '" + thisSec + "', '" + sate.getIp() + "');";
        String insereTableSQL1 = "INSERT INTO oficinabh34_status (os) "
                + "VALUES ('" + sate.getOs() + "');";
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
            log.Gravar(e.getMessage(), "DaoOficina34_insereSate");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereLast(int sate) {
        String insereTableSQL = "UPDATE last_os SET last = '" + sate + "' WHERE id_last_os ='1';";
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
            log.Gravar(e.getMessage(), "DaoOficina34_insereLast");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSate(int type, String value) {
        String selectTableSQL = "";
        if (type == 1) {
            selectTableSQL = "SELECT * from oficinabh34 WHERE nip='" + value + "' ORDER BY data_cad ASC;;";
        }
        if (type == 2) {
            selectTableSQL = "SELECT * from oficinabh34 WHERE os_bh34='" + value + "';";
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
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSate");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSate(String type) {
        String selectTableSQL = "SELECT * from oficinabh34 WHERE atendimento='" + type + "' ORDER BY os_bh34 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSate");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSate() {
        String selectTableSQL = "SELECT * from oficinabh34 ORDER BY os_bh34 ASC;";
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
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSate");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
    
    public ArrayList<Pedido_model> buscaSateAll() {
        String selectTableSQL = "SELECT * from oficinabh34 ORDER BY os_bh34 desc;";
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
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                qnt++;
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSate");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSateMes(String type) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh34 where atendimento='" + type + "' and data_cad between '01/" + d + "' and '" + d1 + "' ORDER BY os_bh34 ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSateMes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSateMes() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select * from oficinabh34 where data_cad between '01/" + d + "' and '" + d1 + "' ORDER BY os_bh34 ASC;";
        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSateMes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pedido_model buscaSateOs(String os) {
        String selectTableSQL = "SELECT * from oficinabh34 WHERE os_bh34 ='" + os + "';";
        Pedido_model sateRetorno = new Pedido_model();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
            }
            return sateRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSateOs");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_move> buscaMove(String os, String atendimento) {
        String selectTableSQL = "SELECT * from oficinabh34_mov WHERE os ='" + os + "';";
        ArrayList<Pedido_move> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_move sateRetorno = new Pedido_move();
                sateRetorno.setOs(rs.getString("os"));
                sateRetorno.setOf(rs.getString("oficina"));
                sateRetorno.setId(rs.getInt("id_mov"));
                sateRetorno.setDescricao_move(rs.getString("desc_mov"));
                sateRetorno.setDatacadmov(rs.getDate("dataalt"));
                sateRetorno.setIp(rs.getString("ip_mov"));
                sateRetorno.setHoracadmov(LocalTime.parse(rs.getString("horaalt")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaMove");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereMov(Pedido_model sate) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh34_mov (oficina, os, desc_mov, dataalt, horaalt, ip_mov) "
                + "VALUES ('" + sate.getAtendimento() + "', '" + sate.getOs() + "', "
                + "'" + sate.getMove() + "', '" + date + "', '" + thisSec + "', '" + sate.getIp() + "');";
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
            log.Gravar(e.getMessage(), "DaoOficina34_insereMov");
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
        String insereTableSQL = "UPDATE oficinabh34 SET status = '" + sate.getStatus() + "', priori = '" + priori + "' "
                + "WHERE os_bh34 ='" + sate.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh34_status SET data_afi = '" + date + "', "
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
            log.Gravar(e.getMessage(), "DaoOficina34_altStatusAfi");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean altStatusOpen(Pedido_model sate, String usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh34 SET status = '" + sate.getStatus() + "' "
                + "WHERE os_bh34 ='" + sate.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh34_status SET data_open = '" + date + "', "
                + "hora_open = '" + thisSec + "', "
                + "user_open = '" + usuario + "' WHERE os ='" + sate.getOs() + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina34_altStatusOpen");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Boolean altStatusEnd(Pedido_model sate, String usuario) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh34 SET status = '" + sate.getStatus() + "' "
                + "WHERE os_bh34 ='" + sate.getOs() + "';";
        String insereTableSQL1 = "UPDATE oficinabh34_status SET data_fin = '" + date + "', "
                + "hora_fin = '" + thisSec + "', "
                + "user_fin = '" + usuario + "' WHERE os ='" + sate.getOs() + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina34_altStatusEnd");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSateOther(String status) {
        String selectTableSQL = "SELECT * from oficinabh34 where status = '" + status + "' ORDER BY os_bh34 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSateOther");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pedido_model> buscaSateOther(String type, String status) {
        String selectTableSQL = "SELECT * from oficinabh34 WHERE atendimento='" + type + "' and status = '" + status + "' ORDER BY os_bh34 ASC;";

        ArrayList<Pedido_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pedido_model sateRetorno = new Pedido_model();
                sateRetorno.setOs(rs.getString("os_bh34"));
                sateRetorno.setPost(rs.getString("post"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                sateRetorno.setObs(rs.getString("obs"));
                sateRetorno.setPriori(rs.getInt("priori"));
                sateRetorno.setStatus(rs.getString("status"));
                sateRetorno.setDatacad(rs.getDate("data_cad"));
                sateRetorno.setIp(rs.getString("ip_cad"));
                sateRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_buscaSateOther");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean altOf(String os, String atendimento) {
        String insereTableSQL = "UPDATE oficinabh34 SET atendimento = '" + atendimento + "' WHERE os_bh34 ='" + os + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina34_altOf");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereFeedback(Pedido_model sate) {
        String insereTableSQL = "UPDATE sate SET feedback = '" + sate.getFeedback() + "' WHERE os ='" + sate.getOs() + "';";
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
            log.Gravar(e.getMessage(), "DaoOficina34_insereFeedback");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereSw(String temp, String fileName, int so, int vs, String remoteAddr, String user, String contentType, long length) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO oficinabh34_doc_sw (sw, nome_sw, so_sw, tam_sw, vs_sw, type_sw,"
                + " atv, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + temp + "', '" + fileName + "', "
                + "'" + so + "', '" + length + "', '" + vs + "',"
                + " '" + contentType + "', '1', '" + user + "', "
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
            log.Gravar(e.getMessage(), "DaoOficina34_insereSw");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Oficina34_doc> listaDocs() {
        String selectTableSQL = "SELECT * from oficinabh34_doc_sw WHERE atv='1' ORDER BY so_sw ASC;";
        ArrayList<Oficina34_doc> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Oficina34_doc oficina = new Oficina34_doc();
                oficina.setId_sw(rs.getInt("id_doc_sw"));
                oficina.setSw(rs.getString("sw"));
                oficina.setNome_sw(rs.getString("nome_sw"));
                oficina.setSo_sw(rs.getInt("so_sw"));
                double tam = rs.getDouble("tam_sw");
                oficina.setTam_sw(tam/1000000);
                oficina.setVs_sw(rs.getInt("vs_sw"));
                oficina.setType_sw(rs.getString("type_sw"));
                oficina.setAtv(rs.getInt("atv"));
                oficina.setUser(rs.getString("user_cad"));
                oficina.setDatacad(rs.getDate("data_cad"));
                oficina.setIp(rs.getString("ip_cad"));
                oficina.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                lista.add(oficina);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_listaDocs");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean retirasw(int id) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE oficinabh34_doc_sw SET"
                + " atv ='0' where id_doc_sw = '" + id + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoOficina34_retirasw");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
