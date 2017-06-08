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
import src.modelo.Pessoal_busca;
import src.modelo.Pessoal_model;
import src.modelo.Pessoal_movi;

public class DaoBh30Pessoal {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoBh30Pessoal() {
        connectDataBase = new ConnectDataBase();
    }

    public static String setData(String date) {
        if (!date.equals("")) {
            String dia = "", mes = "", ano = "";
            date = date.replaceAll("[^a-zZ-Z0-9 ]", "");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            if (!date.equals("")) {
                ano = date.substring(0, 4);
                mes = date.substring(4, 6);
                dia = date.substring(6, 8);
            }
            date = (dia + "/" + mes + "/" + ano);
        }
        return date;
    }
    //================================================================================== INSERIR TABELA

    public boolean inserePraca(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_praca("
                + "afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getPromoCad() + "', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + date + "', '" + thisSec + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_praca_mov("
                + "nip_praca, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePraca");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereOficial(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_oficial("
                + "afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getPromoCad() + "', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + date + "', '" + thisSec + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_oficial_mov("
                + "nip_oficial, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereOficial");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereCivil(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_civil("
                + "afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, os, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('0', '" + servidor.getNome() + "', "
                + "'civil'" + ", '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', 'civil', 'civil',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getOs() + "',"
                + " '" + date + "', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + date + "', '" + thisSec + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_civil_mov("
                + "nip_civil, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereCivil");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereTTC(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_ttc("
                + "afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + date + "', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + date + "', '" + thisSec + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_ttc_mov("
                + "nip_ttc, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereTTC");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== BUSCA LISTA
    public ArrayList<Pessoal_model> buscaPraca() {
        String selectTableSQL = "SELECT * from pessoal_praca where afast = '0' ORDER BY grad DESC";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_praca"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                //servidorRetorno.setPromo(rs.getDate("data_promo"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setDatacad(rs.getDate("data_cad"));//acerta os set's
                servidorRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                servidorRetorno.setUsercad(rs.getString("user_cad"));
                servidorRetorno.setIpcad(rs.getString("ip_cad"));
                servidorRetorno.setType(1);
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaPraca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaPraca(int grad) {
        String selectTableSQL = "SELECT * from pessoal_praca where afast = '0' AND grad = '" + grad + "' ORDER BY grad DESC";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_praca"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setDatacad(rs.getDate("data_cad"));//acerta os set's
                servidorRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                servidorRetorno.setUsercad(rs.getString("user_cad"));
                servidorRetorno.setIpcad(rs.getString("ip_cad"));
                servidorRetorno.setType(1);
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaPraca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaOficial() {
        String selectTableSQL = "SELECT * from pessoal_oficial where afast = '0' ORDER BY grad DESC";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_oficial"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setDatacad(rs.getDate("data_cad"));//acerta os set's
                servidorRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                servidorRetorno.setUsercad(rs.getString("user_cad"));
                servidorRetorno.setIpcad(rs.getString("ip_cad"));
                servidorRetorno.setType(2);
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaOficial");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaTTC() {
        String selectTableSQL = "SELECT * from pessoal_ttc where afast = '0' ORDER BY grad DESC;";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_ttc"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("nome"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setDatacad(rs.getDate("data_cad"));//acerta os set's
                servidorRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                servidorRetorno.setUsercad(rs.getString("user_cad"));
                servidorRetorno.setIpcad(rs.getString("ip_cad"));
                servidorRetorno.setType(3);
                lista.add(servidorRetorno);

            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaTTC");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaCivil() {
        String selectTableSQL = "SELECT * from pessoal_civil where afast = '0' ORDER BY grad DESC";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_civil"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("nome"));
                servidorRetorno.setOs(rs.getString("os"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setDatacad(rs.getDate("data_cad"));//acerta os set's
                servidorRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                servidorRetorno.setUsercad(rs.getString("user_cad"));
                servidorRetorno.setIpcad(rs.getString("ip_cad"));
                servidorRetorno.setType(4);
                lista.add(servidorRetorno);

            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaCivil");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== BUSCA COMPLETA POR NIP 
    public Pessoal_model buscaPraca(String nip) {
        String selectTableSQL = "SELECT * from pessoal_praca WHERE nip = '" + nip + "';";
        Pessoal_model servidorRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_praca"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setType(1);
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
            }
            return servidorRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaPraca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_model buscaOficial(String nip) {
        String selectTableSQL = "SELECT * from pessoal_oficial WHERE nip = '" + nip + "';";
        Pessoal_model servidorRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_oficial"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setType(2);
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
            }
            return servidorRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaOficial");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_model buscaTTC(String nip) {
        String selectTableSQL = "SELECT * from pessoal_ttc WHERE nip = '" + nip + "';";
        Pessoal_model servidorRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_ttc"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setType(3);
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
            }
            return servidorRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaTTC");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_model buscaCivil(String nip) {
        String selectTableSQL = "SELECT * from pessoal_civil WHERE nip = '" + nip + "';";
        Pessoal_model servidorRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_civil"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setType(4);
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setOs(rs.getString("os"));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
            }
            return servidorRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaCivil");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== ATUALIZAR TABELA
    public boolean attPraca(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE pessoal_praca SET nome='" + servidor.getNome() + "',"
                + " guerra='" + servidor.getGuerra() + "', nip='" + servidor.getNip() + "',"
                + " grad='" + servidor.getGrad() + "', quadro='" + servidor.getQuadro() + "',"
                + " esp='" + servidor.getEsp() + "', data_promo='" + servidor.getPromo() + "',"
                + "data_emb='" + servidor.getEmb() + "', data_niver='" + servidor.getNasc() + "',"
                + " depto='" + servidor.getDep() + "', divisao='" + servidor.getDiv() + "',"
                + " ramal='" + servidor.getRamal() + "', funcao='" + servidor.getFuncao() + "'"
                + " where id_praca = '" + servidor.getId() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attPraca");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attTTC(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE pessoal_ttc SET nome='" + servidor.getNome() + "',"
                + " guerra='" + servidor.getGuerra() + "', nip='" + servidor.getNip() + "',"
                + " grad='" + servidor.getGrad() + "', quadro='" + servidor.getQuadro() + "',"
                + " esp='" + servidor.getEsp() + "',"
                + "data_emb='" + servidor.getEmb() + "', data_niver='" + servidor.getNasc() + "',"
                + " depto='" + servidor.getDep() + "', divisao='" + servidor.getDiv() + "',"
                + " ramal='" + servidor.getRamal() + "', funcao='" + servidor.getFuncao() + "'"
                + " where id_ttc = '" + servidor.getId() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attTTC");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attOficial(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE pessoal_oficial SET nome='" + servidor.getNome() + "',"
                + " guerra='" + servidor.getGuerra() + "', nip='" + servidor.getNip() + "',"
                + " grad='" + servidor.getGrad() + "', quadro='" + servidor.getQuadro() + "',"
                + " esp='" + servidor.getEsp() + "', data_promo='" + servidor.getPromo() + "',"
                + "data_emb='" + servidor.getEmb() + "', data_niver='" + servidor.getNasc() + "',"
                + " depto='" + servidor.getDep() + "', divisao='" + servidor.getDiv() + "',"
                + " ramal='" + servidor.getRamal() + "', funcao='" + servidor.getFuncao() + "'"
                + " where id_oficial = '" + servidor.getId() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attOficial");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attCivil(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE pessoal_civil SET nome='" + servidor.getNome() + "', nip='" + servidor.getNip() + "',"
                + " grad='" + servidor.getGrad() + "', os ='" + servidor.getOs() + "',"
                + "data_emb='" + servidor.getEmb() + "', data_niver='" + servidor.getNasc() + "',"
                + " depto='" + servidor.getDep() + "', divisao='" + servidor.getDiv() + "',"
                + " ramal='" + servidor.getRamal() + "', funcao='" + servidor.getFuncao() + "'"
                + " where id_civil = '" + servidor.getId() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attCivil");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== BUSCA POR DEPARTAMENTO
    public ArrayList<Pessoal_model> buscaDep(int temp, int type) {
        String selectTableSQL = "";
        int temp1 = type;
        int tipo = 0;
        switch (temp1) {
            case 1:
                selectTableSQL = "SELECT * from pessoal_oficial where depto='" + temp + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 2;
                break;
            case 2:
                selectTableSQL = "SELECT * from pessoal_praca where depto='" + temp + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 1;
                break;
            case 3:
                selectTableSQL = "SELECT * from pessoal_ttc where depto='" + temp + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 3;
                break;
            case 4:
                selectTableSQL = "SELECT * from pessoal_civil where depto='" + temp + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 4;
                break;
            default:
                break;
        }

        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setGuerra(rs.getString("nome"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setType(tipo);
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaDep");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== BUSCA POR DEPARTAMENTO
    public ArrayList<Pessoal_model> buscaDivisao(int temp, int type) {
        String selectTableSQL = "";
        String div = "";
        if (temp == 1 || temp == 4 || temp == 8) {
            div = "0" + temp;
        } else {
            div = "" + temp;
        }
        int tipo = 0;
        switch (type) {
            case 1:
                selectTableSQL = "SELECT * from pessoal_oficial where divisao='" + div + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 2;
                break;
            case 2:
                selectTableSQL = "SELECT * from pessoal_praca where divisao='" + div + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 1;
                break;
            case 3:
                selectTableSQL = "SELECT * from pessoal_ttc where divisao='" + div + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 3;
                break;
            case 4:
                selectTableSQL = "SELECT * from pessoal_civil where divisao='" + div + "' and afast = '0' ORDER BY grad DESC;";
                tipo = 4;
                break;
            default:
                break;
        }

        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setGuerra(rs.getString("nome"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setType(tipo);
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaDep");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== BUSCA COMPLETA POR NIP E NOME
    public ArrayList<Pessoal_model> buscaPraca(String nip, String nome) {
        String selectTableSQL = "";
        if ("".equals(nome)) {
            selectTableSQL = "SELECT * from pessoal_praca WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        } else {
            selectTableSQL = "SELECT * from pessoal_praca WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        }
        Pessoal_model servidorRetorno = null;
        try {
            ArrayList<Pessoal_model> retorno = new ArrayList<>();
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_praca"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setType(1);
                retorno.add(servidorRetorno);
            }
            return retorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaPraca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaOficial(String nip, String nome) {
        String selectTableSQL = "";
        if ("".equals(nome)) {
            selectTableSQL = "SELECT * from pessoal_oficial WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        } else {
            selectTableSQL = "SELECT * from pessoal_oficial WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        }
        Pessoal_model servidorRetorno = null;
        ArrayList<Pessoal_model> retorno = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_oficial"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setType(2);
                retorno.add(servidorRetorno);
            }
            return retorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaOficial");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaTTC(String nip, String nome) {
        String selectTableSQL = "";
        if ("".equals(nome)) {
            selectTableSQL = "SELECT * from pessoal_ttc WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        } else {
            selectTableSQL = "SELECT * from pessoal_ttc WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        }
        Pessoal_model servidorRetorno = null;
        try {
            ArrayList<Pessoal_model> retorno = new ArrayList<>();
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_ttc"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setGuerra(rs.getString("guerra"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setQuadro(rs.getString("quadro"));
                servidorRetorno.setEsp(rs.getString("esp"));
                servidorRetorno.setPromo(setData(rs.getString("data_promo")));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setType(3);
                retorno.add(servidorRetorno);
            }
            return retorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaTTC");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaCivil(String nip, String nome) {
        String selectTableSQL = "";
        if ("".equals(nome)) {
            selectTableSQL = "SELECT * from pessoal_civil WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        } else {
            selectTableSQL = "SELECT * from pessoal_civil WHERE (nip = '" + nip + "' OR guerra = '" + nome + "') and afast != 1;";
        }
        Pessoal_model servidorRetorno = null;
        try {
            ArrayList<Pessoal_model> retorno = new ArrayList<>();
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId(rs.getInt("id_civil"));
                servidorRetorno.setAfast(rs.getInt("afast"));
                servidorRetorno.setNome(rs.getString("nome"));
                servidorRetorno.setNip(rs.getString("nip"));
                servidorRetorno.setGrad(Util.graduacao(rs.getInt("grad")));
                servidorRetorno.setGradInt(rs.getInt("grad"));
                servidorRetorno.setOs(rs.getString("os"));
                servidorRetorno.setEmb(setData(rs.getString("data_emb")));
                servidorRetorno.setNasc(setData(rs.getString("data_niver")));
                servidorRetorno.setDep(rs.getInt("depto"));
                servidorRetorno.setDiv(rs.getString("divisao"));
                servidorRetorno.setRamal(rs.getString("ramal"));
                servidorRetorno.setFuncao(rs.getString("funcao"));
                servidorRetorno.setType(4);
                retorno.add(servidorRetorno);
            }
            return retorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaCivil");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== TROCAR TABELA
    public boolean inserePracaNew(Pessoal_model servidor) {
        String insereTableSQL = "INSERT INTO pessoal_praca("
                + "id_praca, afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + servidor.getId() + "', '0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getPromo() + "', '" + servidor.getEmb() + "',"
                + " '" + servidor.getNascCad() + "','" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_praca_mov("
                + "nip_praca, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePracaNew");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereOficialNew(Pessoal_model servidor) {
        String insereTableSQL = "INSERT INTO pessoal_oficial("
                + "id_oficial, afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + servidor.getId() + "', '0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getPromoCad() + "', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_oficial_mov("
                + "nip_oficial, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereOficialNew");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereTTCNew(Pessoal_model servidor) {
        String insereTableSQL = "INSERT INTO pessoal_ttc("
                + "id_ttc, afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + servidor.getId() + "', '0', '" + servidor.getNome() + "', "
                + "'" + servidor.getGuerra() + "', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '2000-01-01', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_ttc_mov("
                + "nip_ttc, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereTTCNew");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereCivilNew(Pessoal_model servidor) {
        String insereTableSQL = "INSERT INTO pessoal_civil("
                + "id_civil, afast, nome, guerra, nip, grad, quadro, esp, depto, "
                + "divisao, ramal, funcao, os, data_promo, data_emb, data_niver, data_cad, "
                + "hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + servidor.getId() + "', '0', '" + servidor.getNome() + "', "
                + "'-', '" + servidor.getNip() + "',"
                + " '" + servidor.getGrad() + "', '" + servidor.getQuadro() + "', '" + servidor.getEsp() + "',"
                + " '" + servidor.getDep() + "', '" + servidor.getDiv() + "', '" + servidor.getRamal() + "',"
                + " '" + servidor.getFuncao() + "', '" + servidor.getOs() + "',"
                + " '2000-01-01', '" + servidor.getEmbCad() + "',"
                + " '" + servidor.getNascCad() + "','" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_civil_mov("
                + "nip_civil, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'CADASTRO CONCLUIDO COM SUCESSO', "
                + "'" + servidor.getUsercad() + "', '" + servidor.getDatacad() + "', '" + servidor.getHoracad() + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereCivilNew");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //================================================================================== DBQ
    public boolean dbqPraca(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String dbq = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDbqCad());
        String insereTableSQL = "UPDATE pessoal_praca SET afast='1', data_dbq='" + servidor.getDbqCad() + "' "
                + "where nip = '" + servidor.getNip() + "';";
        String insereTableSQL2 = "INSERT INTO pessoal_praca_mov("
                + "nip_praca, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'DESEMBARQUE DIA: " + dbq + "', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_dbqPraca");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean dbqOficial(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String dbq = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDbqCad());
        String insereTableSQL = "UPDATE pessoal_oficial SET afast='1', data_dbq='" + servidor.getDbqCad() + "' "
                + "where nip = '" + servidor.getNip() + "';";
        String insereTableSQL2 = "INSERT INTO pessoal_oficial_mov("
                + "nip_oficial, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'DESEMBARQUE DIA: " + dbq + "', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_dbqOficial");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean dbqTTC(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String dbq = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ini());
        String insereTableSQL = "UPDATE pessoal_ttc SET afast='1', data_dbq='" + servidor.getDbqCad() + "' "
                + "where nip = '" + servidor.getNip() + "';";
        String insereTableSQL2 = "INSERT INTO pessoal_ttc_mov("
                + "nip_ttc, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'DESEMBARQUE DIA: " + dbq + "', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_dbqTTC");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean dbqCivil(Pessoal_model servidor) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String dbq = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ini());
        String insereTableSQL = "UPDATE pessoal_civil SET afast='1', data_dbq='" + servidor.getDbqCad() + "' "
                + "where nip = '" + servidor.getNip() + "';";
        String insereTableSQL2 = "INSERT INTO pessoal_civil_mov("
                + "nip_civil, desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'DESEMBARQUE DIA: " + dbq + "', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_dbqCivil");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_movi> buscaMovi(Pessoal_model servidor, int type) {
        try {
            String selectTableSQL = "";
            String id = "", nip = "", table = "";
            switch (type) {
                case 1:
                    table = "pessoal_praca_mov";
                    id = "id_praca_mov";
                    nip = "nip_praca";
                    break;
                case 2:
                    table = "pessoal_oficial_mov";
                    id = "id_oficial_mov";
                    nip = "nip_oficial";
                    break;
                case 3:
                    table = "pessoal_ttc_mov";
                    id = "id_ttc_mov";
                    nip = "nip_ttc";
                    break;
                case 4:
                    table = "pessoal_civil_mov";
                    id = "id_civil_mov";
                    nip = "nip_civil";
                    break;
                default:
                    break;
            }
            selectTableSQL = "SELECT " + id + ", " + nip + ", desc_mov, useralt, dataalt, horaalt, ipalt, posto_grad, guerra "
                    + "from " + table + " a, usuario b where a." + nip + "='" + servidor.getNip() + "' and a.useralt = b.nip "
                    + "ORDER BY dataalt ASC;";
            ArrayList<Pessoal_movi> lista = new ArrayList<>();
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_movi servidorRetorno = new Pessoal_movi();
                servidorRetorno.setId(rs.getInt(id));
                servidorRetorno.setNip(rs.getString(nip));
                servidorRetorno.setDesc_mov(rs.getString("desc_mov"));
                servidorRetorno.setUsercadmov(rs.getString("posto_grad") + " " + rs.getString("guerra"));
                servidorRetorno.setDatacadmov(rs.getDate("dataalt"));
                servidorRetorno.setHoracadmov(LocalTime.parse(rs.getString("horaalt")));
                servidorRetorno.setIpcadmov(rs.getString("ipalt"));
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaMovi");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereMov(Pessoal_movi servidormove, int type) {
        String table = "", nip = "";
        switch (type) {
            case 1:
                table = "pessoal_praca_mov";
                nip = "nip_praca";
                break;
            case 2:
                table = "pessoal_oficial_mov";
                nip = "nip_oficial";
                break;
            case 3:
                table = "pessoal_ttc_mov";
                nip = "nip_ttc";
                break;
            case 4:
                table = "pessoal_civil_mov";
                nip = "nip_civil";
                break;
            default:
                break;
        }
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL2 = "INSERT INTO " + table + "("
                + nip + ", desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidormove.getNip() + "', '" + servidormove.getDesc_mov() + "', "
                + "'" + servidormove.getUsercadmov() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidormove.getIpcadmov() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereMov");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereFerias(Pessoal_model servidor) {
        String table = "", nip = "";
        switch (servidor.getType()) {
            case 1:
                table = "pessoal_praca_mov";
                nip = "nip_praca";
                break;
            case 2:
                table = "pessoal_oficial_mov";
                nip = "nip_oficial";
                break;
            case 3:
                table = "pessoal_ttc_mov";
                nip = "nip_ttc";
                break;
            case 4:
                table = "pessoal_civil_mov";
                nip = "nip_civil";
                break;
            default:
                break;
        }
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String ini = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ini());
        String ter = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ter());
        String insereTableSQL1 = "INSERT INTO " + table + "("
                + nip + ", desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'FÉRIAS RELATIVA AO ANO: " + servidor.getAnoFerias() + " COM "
                + "DATA ÍNICIO: " + ini + " E DATA TÉRMINO: " + ter + " , "
                + "TOTAL DE " + servidor.getDiasFerias() + " DIAS', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "INSERT INTO pessoal_lic("
                + "afast, nip, tipo, dias, ano, data_ini, data_ter, data_cad, hora_cad, user_cad, ip_cad) "
                + "VALUES ('2', '" + servidor.getNip() + "', '" + servidor.getType() + "', '" + servidor.getDiasFerias() + "', "
                + "'" + servidor.getAnoFerias() + "', '" + servidor.getDate_ini() + "', '" + servidor.getDate_ter() + "', "
                + "'" + date + "', '" + thisSec + "', '" + servidor.getUsercad() + "', "
                + " '" + servidor.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL1);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_insereFerias");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaFerias(Pessoal_model serv) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        int t = Integer.parseInt(new SimpleDateFormat("yyyy").format(tm));
        String selectTableSQL = "SELECT * from pessoal_lic where nip = '" + serv.getNip() + "' and ano = '" + --t + "';";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setId_ferias(rs.getInt("id_lic"));
                servidorRetorno.setNip(serv.getNip());
                servidorRetorno.setType(serv.getType());
                servidorRetorno.setGrad(serv.getGrad());
                servidorRetorno.setGuerra(serv.getGuerra());
                servidorRetorno.setDep(serv.getDep());
                servidorRetorno.setDiasFerias(rs.getInt("dias"));
                servidorRetorno.setAnoFerias(rs.getInt("ano"));
                servidorRetorno.setDate_ini(rs.getDate("data_ini"));
                servidorRetorno.setDate_ter(rs.getDate("data_ter"));
                lista.add(servidorRetorno);

            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaFerias");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pessoal_model> buscaFerias(Pessoal_model servidor, int anoFerias) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        int t = Integer.parseInt(new SimpleDateFormat("yyyy").format(tm));
        String selectTableSQL = "SELECT * from pessoal_lic where nip = '" + servidor.getNip() + "' and ano = '" + anoFerias + "';";
        ArrayList<Pessoal_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pessoal_model servidorRetorno = new Pessoal_model();
                servidorRetorno.setGrad(servidor.getGrad());
                servidorRetorno.setGuerra(servidor.getGuerra());
                servidorRetorno.setDep(servidor.getDep());
                servidorRetorno.setDiasFerias(rs.getInt("dias"));
                servidorRetorno.setAnoFerias(rs.getInt("ano"));
                lista.add(servidorRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaFerias");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean deleteFerias(Pessoal_model servidor) {
        String table = "", nip = "";
        switch (servidor.getType()) {
            case 1:
                table = "pessoal_praca_mov";
                nip = "nip_praca";
                break;
            case 2:
                table = "pessoal_oficial_mov";
                nip = "nip_oficial";
                break;
            case 3:
                table = "pessoal_ttc_mov";
                nip = "nip_ttc";
                break;
            case 4:
                table = "pessoal_civil_mov";
                nip = "nip_civil";
                break;
            default:
                break;
        }
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String ini = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ini());
        String ter = new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDate_ter());
        String insereTableSQL1 = "INSERT INTO " + table + "("
                + nip + ", desc_mov, useralt, dataalt, horaalt, ipalt) "
                + "VALUES ('" + servidor.getNip() + "', 'REMOVIDO FÉRIAS RELATIVA AO ANO: " + servidor.getAnoFerias() + " COM "
                + "DATA ÍNICIO: " + ini + " E DATA TÉRMINO: " + ter + "', "
                + "'" + servidor.getUsercad() + "', '" + date + "', '" + thisSec + "',"
                + " '" + servidor.getIpcad() + "');";
        String insereTableSQL2 = "DELETE FROM pessoal_lic WHERE id_lic = '" + servidor.getId_ferias() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL1);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_deleteFerias");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_model buscaFeriasId(Pessoal_model serv) {
        String selectTableSQL = "SELECT * from pessoal_lic where nip = '" + serv.getNip() + "' and id_lic = '" + serv.getId_ferias() + "';";
        Pessoal_model servidorRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                servidorRetorno = new Pessoal_model();
                servidorRetorno.setId_ferias(rs.getInt("id_lic"));
                servidorRetorno.setNip(serv.getNip());
                servidorRetorno.setId_ferias(serv.getId_ferias());
                servidorRetorno.setType(serv.getType());
                servidorRetorno.setUsercad(serv.getUsercad());
                servidorRetorno.setDiasFerias(rs.getInt("dias"));
                servidorRetorno.setAnoFerias(rs.getInt("ano"));
                servidorRetorno.setDate_ini(rs.getDate("data_ini"));
                servidorRetorno.setDate_ter(rs.getDate("data_ter"));
            }
            return servidorRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_buscaFeriasId");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_busca planodebuscaPraca(String nip) {
        String selectTableSQL = "SELECT * from pessoal_praca_busca where nip_praca = '" + nip + "';";
        Pessoal_busca buscaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                buscaRetorno = new Pessoal_busca();
                buscaRetorno.setNip(nip);
                buscaRetorno.setCep(rs.getString("cep"));
                buscaRetorno.setLogradouro(rs.getString("logradouro"));
                buscaRetorno.setNumero(rs.getString("numero"));
                buscaRetorno.setBairro(rs.getString("bairro"));
                buscaRetorno.setComplemento(rs.getString("complemento"));
                buscaRetorno.setCidade(rs.getString("cidade"));
                buscaRetorno.setUf(rs.getString("uf"));
                buscaRetorno.setTelefone(rs.getString("telefone"));
                buscaRetorno.setCelular(rs.getString("celular"));
                buscaRetorno.setTipo(1);
            }
            return buscaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaPraca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_busca planodebuscaCivil(String nip) {
        String selectTableSQL = "SELECT * from pessoal_civil_busca where nip_civil = '" + nip + "';";
        Pessoal_busca buscaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                buscaRetorno = new Pessoal_busca();
                buscaRetorno.setNip(nip);
                buscaRetorno.setCep(rs.getString("cep"));
                buscaRetorno.setLogradouro(rs.getString("logradouro"));
                buscaRetorno.setNumero(rs.getString("numero"));
                buscaRetorno.setBairro(rs.getString("bairro"));
                buscaRetorno.setComplemento(rs.getString("complemento"));
                buscaRetorno.setCidade(rs.getString("cidade"));
                buscaRetorno.setUf(rs.getString("uf"));
                buscaRetorno.setTelefone(rs.getString("telefone"));
                buscaRetorno.setCelular(rs.getString("celular"));
                buscaRetorno.setTipo(4);
            }
            return buscaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaCivil");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_busca planodebuscaTTC(String nip) {
        String selectTableSQL = "SELECT * from pessoal_ttc_busca where nip_ttc = '" + nip + "';";
        Pessoal_busca buscaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                buscaRetorno = new Pessoal_busca();
                buscaRetorno.setNip(nip);
                buscaRetorno.setCep(rs.getString("cep"));
                buscaRetorno.setLogradouro(rs.getString("logradouro"));
                buscaRetorno.setNumero(rs.getString("numero"));
                buscaRetorno.setBairro(rs.getString("bairro"));
                buscaRetorno.setComplemento(rs.getString("complemento"));
                buscaRetorno.setCidade(rs.getString("cidade"));
                buscaRetorno.setUf(rs.getString("uf"));
                buscaRetorno.setTelefone(rs.getString("telefone"));
                buscaRetorno.setCelular(rs.getString("celular"));
                buscaRetorno.setTipo(3);
            }
            return buscaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaTTC");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pessoal_busca planodebuscaOficial(String nip) {
        String selectTableSQL = "SELECT * from pessoal_oficial_busca where nip_oficial = '" + nip + "';";
        Pessoal_busca buscaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                buscaRetorno = new Pessoal_busca();
                buscaRetorno.setNip(nip);
                buscaRetorno.setCep(rs.getString("cep"));
                System.out.println("CEP :" + rs.getString("cep"));
                buscaRetorno.setLogradouro(rs.getString("logradouro"));
                buscaRetorno.setNumero(rs.getString("numero"));
                buscaRetorno.setBairro(rs.getString("bairro"));
                buscaRetorno.setComplemento(rs.getString("complemento"));
                buscaRetorno.setCidade(rs.getString("cidade"));
                buscaRetorno.setUf(rs.getString("uf"));
                buscaRetorno.setTelefone(rs.getString("telefone"));
                buscaRetorno.setCelular(rs.getString("celular"));
                buscaRetorno.setTipo(2);
            }
            return buscaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaOficial");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean checkPlanodebuscaPraca(String nip) {
        String selectTableSQL = "SELECT id_praca_busca from pessoal_praca_busca where nip_praca = '" + nip + "';";
        boolean check = false;
        try {
            if (connectDataBase.openConection() == null) {
                return check;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                check = true;
            }
            return check;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaPraca");
            return check;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean checkPlanodebuscaCivil(String nip) {
        String selectTableSQL = "SELECT * from pessoal_civil_busca where nip_civil = '" + nip + "';";
        boolean check = false;
        try {
            if (connectDataBase.openConection() == null) {
                return check;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                check = true;
            }
            return check;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaPraca");
            return check;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean checkPlanodebuscaTTC(String nip) {
        String selectTableSQL = "SELECT * from pessoal_ttc_busca where nip_ttc = '" + nip + "';";
        boolean check = false;
        try {
            if (connectDataBase.openConection() == null) {
                return check;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                check = true;
            }
            return check;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaPraca");
            return check;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean checkPlanodebuscaOficial(String nip) {
        String selectTableSQL = "SELECT * from pessoal_oficial_busca where nip_oficial = '" + nip + "';";
        boolean check = false;
        try {
            if (connectDataBase.openConection() == null) {
                return check;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                check = true;
            }
            return check;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_planodebuscaPraca");
            return check;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePlanodebuscaPraca(Pessoal_busca pessoaBusca) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_praca_busca("
                + "nip_praca, cep, logradouro, numero, complemento, "
                + "bairro, cidade, uf, telefone, celular, useralt, dataalt, "
                + "horaalt, ipalt)"
                + "VALUES ('" + pessoaBusca.getNip() + "', "
                + "'" + pessoaBusca.getCep() + "', '" + pessoaBusca.getLogradouro() + "',"
                + " '" + pessoaBusca.getNumero() + "', '" + pessoaBusca.getComplemento() + "', '" + pessoaBusca.getBairro() + "',"
                + " '" + pessoaBusca.getCidade() + "', '" + pessoaBusca.getUf() + "',"
                + " '" + pessoaBusca.getTelefone() + "', '" + pessoaBusca.getCelular() + "',"
                + " '" + pessoaBusca.getUser() + "','" + date + "', '" + thisSec + "', "
                + "'" + pessoaBusca.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePlanodebuscaPraca");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePlanodebuscaOficial(Pessoal_busca pessoaBusca) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_oficial_busca("
                + "nip_oficial, cep, logradouro, numero, complemento, "
                + "bairro, cidade, uf, telefone, celular, useralt, dataalt, "
                + "horaalt, ipalt)"
                + "VALUES ('" + pessoaBusca.getNip() + "', "
                + "'" + pessoaBusca.getCep() + "', '" + pessoaBusca.getLogradouro() + "',"
                + " '" + pessoaBusca.getNumero() + "', '" + pessoaBusca.getComplemento() + "', '" + pessoaBusca.getBairro() + "',"
                + " '" + pessoaBusca.getCidade() + "', '" + pessoaBusca.getUf() + "',"
                + " '" + pessoaBusca.getTelefone() + "', '" + pessoaBusca.getCelular() + "',"
                + " '" + pessoaBusca.getUser() + "','" + date + "', '" + thisSec + "', "
                + "'" + pessoaBusca.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePlanodebuscaOficial");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePlanodebuscaTTC(Pessoal_busca pessoaBusca) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_ttc_busca("
                + "nip_ttc, cep, logradouro, numero, complemento, "
                + "bairro, cidade, uf, telefone, celular, useralt, dataalt, "
                + "horaalt, ipalt)"
                + "VALUES ('" + pessoaBusca.getNip() + "', "
                + "'" + pessoaBusca.getCep() + "', '" + pessoaBusca.getLogradouro() + "',"
                + " '" + pessoaBusca.getNumero() + "', '" + pessoaBusca.getComplemento() + "', '" + pessoaBusca.getBairro() + "',"
                + " '" + pessoaBusca.getCidade() + "', '" + pessoaBusca.getUf() + "',"
                + " '" + pessoaBusca.getTelefone() + "', '" + pessoaBusca.getCelular() + "',"
                + " '" + pessoaBusca.getUser() + "','" + date + "', '" + thisSec + "', "
                + "'" + pessoaBusca.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePlanodebuscaTTC");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePlanodebuscaCivil(Pessoal_busca pessoaBusca) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pessoal_civil_busca("
                + "nip_civil, cep, logradouro, numero, complemento, "
                + "bairro, cidade, uf, telefone, celular, useralt, dataalt, "
                + "horaalt, ipalt)"
                + "VALUES ('" + pessoaBusca.getNip() + "', "
                + "'" + pessoaBusca.getCep() + "', '" + pessoaBusca.getLogradouro() + "',"
                + " '" + pessoaBusca.getNumero() + "', '" + pessoaBusca.getComplemento() + "', '" + pessoaBusca.getBairro() + "',"
                + " '" + pessoaBusca.getCidade() + "', '" + pessoaBusca.getUf() + "',"
                + " '" + pessoaBusca.getTelefone() + "', '" + pessoaBusca.getCelular() + "',"
                + " '" + pessoaBusca.getUser() + "','" + date + "', '" + thisSec + "', "
                + "'" + pessoaBusca.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_inserePlanodebuscaCivil");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attPlanodebuscaOficial(Pessoal_busca pessoaBusca) {
        String insereTableSQL = "UPDATE pessoal_oficial_busca"
                + " SET cep='" + pessoaBusca.getCep() + "', logradouro='" + pessoaBusca.getLogradouro() + "', numero='" + pessoaBusca.getNumero() + "', "
                + "complemento='" + pessoaBusca.getComplemento() + "', bairro='" + pessoaBusca.getBairro() + "', "
                + "cidade='" + pessoaBusca.getCidade() + "', uf='" + pessoaBusca.getUf() + "', telefone='" + pessoaBusca.getTelefone() + "', "
                + "celular='" + pessoaBusca.getCelular() + "'"
                + " WHERE nip_oficial='" + pessoaBusca.getNip() + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attPlanodebuscaOficial");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attPlanodebuscaPraca(Pessoal_busca pessoaBusca) {
        String insereTableSQL = "UPDATE pessoal_praca_busca "
                + " SET cep='" + pessoaBusca.getCep() + "', logradouro='" + pessoaBusca.getLogradouro() + "', numero='" + pessoaBusca.getNumero() + "', "
                + "complemento='" + pessoaBusca.getComplemento() + "', bairro='" + pessoaBusca.getBairro() + "', "
                + "cidade='" + pessoaBusca.getCidade() + "', uf='" + pessoaBusca.getUf() + "', telefone='" + pessoaBusca.getTelefone() + "', "
                + "celular='" + pessoaBusca.getCelular() + "'"
                + " WHERE nip_praca='" + pessoaBusca.getNip() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attPlanodebuscaPraca");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attPlanodebuscaCivil(Pessoal_busca pessoaBusca) {
        String insereTableSQL = "UPDATE pessoal_civil_busca"
                + " SET cep='" + pessoaBusca.getCep() + "', logradouro='" + pessoaBusca.getLogradouro() + "', numero='" + pessoaBusca.getNumero() + "', "
                + "complemento='" + pessoaBusca.getComplemento() + "', bairro='" + pessoaBusca.getBairro() + "', "
                + "cidade='" + pessoaBusca.getCidade() + "', uf='" + pessoaBusca.getUf() + "', telefone='" + pessoaBusca.getTelefone() + "', "
                + "celular='" + pessoaBusca.getCelular() + "'"
                + " WHERE nip_civil='" + pessoaBusca.getNip() + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attPlanodebuscaCivil");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean attPlanodebuscaTTC(Pessoal_busca pessoaBusca) {
        String insereTableSQL = "UPDATE pessoal_ttc_busca"
                + " SET cep='" + pessoaBusca.getCep() + "', logradouro='" + pessoaBusca.getLogradouro() + "', numero='" + pessoaBusca.getNumero() + "', "
                + "complemento='" + pessoaBusca.getComplemento() + "', bairro='" + pessoaBusca.getBairro() + "', "
                + "cidade='" + pessoaBusca.getCidade() + "', uf='" + pessoaBusca.getUf() + "', telefone='" + pessoaBusca.getTelefone() + "', "
                + "celular='" + pessoaBusca.getCelular() + "'"
                + " WHERE nip_ttc='" + pessoaBusca.getNip() + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoBh30Pessoal_attPlanodebuscaTTC");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
