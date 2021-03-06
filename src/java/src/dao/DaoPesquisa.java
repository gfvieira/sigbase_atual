package src.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import src.Error;
import src.modelo.pesquisa.Pergunta_model;
import src.modelo.pesquisa.Pesquisa_model;
import src.modelo.Resposta_model;
import src.modelo.pesquisa.Pesquisa_habilidade;
import src.modelo.pesquisa.Pesquisa_nota;
import src.modelo.pesquisa.Pesquisa_sexo;

public class DaoPesquisa {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoPesquisa() {
        connectDataBase = new ConnectDataBase();
    }

    public Pergunta_model buscaLastquestion() {
        String selectTableSQL = "SELECT * FROM pergunta WHERE id_pergunta = (SELECT MAX(id_pergunta) FROM pergunta);";
        Pergunta_model perguntaRetorno = null;
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                perguntaRetorno = new Pergunta_model();
                perguntaRetorno.setPergunta1(rs.getString("Pergunta1"));
                perguntaRetorno.setPergunta2(rs.getString("Pergunta2"));
                perguntaRetorno.setPergunta3(rs.getString("Pergunta3"));
                perguntaRetorno.setUsercad(rs.getString("user_cad"));
                perguntaRetorno.setDatacad(rs.getDate("data_cad"));
                perguntaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
            }
            return perguntaRetorno;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaLastquestion");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereQuestion(Pergunta_model pesquisa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pergunta (pergunta1, pergunta2, pergunta3, data_cad, hora_cad, user_cad) "
                + "VALUES ('" + pesquisa.getPergunta1() + "', '" + pesquisa.getPergunta2() + "', '" + pesquisa.getPergunta3() + "',"
                + "'" + date + "', '" + thisSec + "', '" + pesquisa.getUsercad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_insereQuestion");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pergunta_model> buscaSate() {
        String selectTableSQL = "SELECT * from pergunta;";
        ArrayList<Pergunta_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pergunta_model perguntaRetorno = new Pergunta_model();
                perguntaRetorno.setPergunta1(rs.getString("pergunta1"));
                perguntaRetorno.setPergunta2(rs.getString("pergunta2"));
                perguntaRetorno.setPergunta3(rs.getString("pergunta3"));
                perguntaRetorno.setUsercad(rs.getString("user_cad"));
                perguntaRetorno.setDatacad(rs.getDate("data_cad"));
                lista.add(perguntaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaSate");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int total1() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String selectTableSQL = "select count(*) as total from resultado where data_cad between '01/" + d + "' and '07/" + d + "';";
        int total = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_total1");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int total2() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String selectTableSQL = "select count(*) as total from resultado where data_cad between '08/" + d + "' and '14/" + d + "';";
        int total = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_total2");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int total3() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String selectTableSQL = "select count(*) as total from resultado where data_cad between '15/" + d + "' and '21/" + d + "';";
        int total = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_total3");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int total4() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String dd = "";
        switch (d) {
            case "02/2016":
                dd = "28";
                break;
            case "01/2016":
            case "03/2016":
            case "05/2016":
            case "07/2016":
            case "08/2016":
            case "10/2016":
            case "12/2016":
                dd = "31";
                break;
            default:
                dd = "30";
                break;
        }
        String selectTableSQL = "select count(*) as total from resultado where data_cad between '22/" + d + "' and '" + dd + "/" + d + "';";
        int total = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_total4");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model diario(String date, int i) {
        String pergunta = "";
        switch (i) {
            case 1:
                pergunta = "pergunta1";
                break;
            case 2:
                pergunta = "pergunta2";
                break;
            case 3:
                pergunta = "pergunta3";
                break;
            default:
                break;
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when " + pergunta + " = '1' then 1 else 0 end) as resp1, "
                + "sum(case when " + pergunta + " = '2' then 1 else 0 end) as resp2, "
                + "sum(case when " + pergunta + " = '3' then 1 else 0 end) as resp3, "
                + "sum(case when " + pergunta + " = '4' then 1 else 0 end) as resp4, "
                + "sum(case when " + pergunta + " = '5' then 1 else 0 end) as resp5 "
                + "from resultado where data_cad = '" + date + "'";
        Resposta_model lista = new Resposta_model();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                lista.setTotal(rs.getInt("total"));
//                lista.setResp1(rs.getInt("resp1"));
//                lista.setResp2(rs.getInt("resp2"));
//                lista.setResp3(rs.getInt("resp3"));
//                lista.setResp4(rs.getInt("resp4"));
//                lista.setResp5(rs.getInt("resp5"));
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_diario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model semana(String semana, String mes, int i) {
        String pergunta = "", inicio = "", termino = "";
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("yyyy").format(tm);
        switch (i) {
            case 1:
                pergunta = "pergunta1";
                break;
            case 2:
                pergunta = "pergunta2";
                break;
            case 3:
                pergunta = "pergunta3";
                break;
            default:
                break;
        }
        if (semana.equals("01")) {
            inicio = "01";
            termino = "07";
        } else if (semana.equals("02")) {
            inicio = "08";
            termino = "14";
        } else if (semana.equals("03")) {
            inicio = "15";
            termino = "21";
        } else if (semana.equals("04") && mes.equals("01")
                || mes.equals("03")
                || mes.equals("05")
                || mes.equals("07")
                || mes.equals("08")
                || mes.equals("10")
                || mes.equals("12")) {
            inicio = "22";
            termino = "31";
        } else if (semana.equals("04") && mes.equals("02")) {
            inicio = "22";
            termino = "28";
        } else {
            inicio = "22";
            termino = "30";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when " + pergunta + " = '1' then 1 else 0 end) as resp1, "
                + "sum(case when " + pergunta + " = '2' then 1 else 0 end) as resp2, "
                + "sum(case when " + pergunta + " = '3' then 1 else 0 end) as resp3, "
                + "sum(case when " + pergunta + " = '4' then 1 else 0 end) as resp4, "
                + "sum(case when " + pergunta + " = '5' then 1 else 0 end) as resp5 "
                + "from resultado where data_cad between '" + inicio + "/" + mes + "/" + d + "' and '" + termino + "/" + mes + "/" + d + "'";
        Resposta_model lista = new Resposta_model();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                lista.setTotal(rs.getInt("total"));
//                lista.setResp1(rs.getInt("resp1"));
//                lista.setResp2(rs.getInt("resp2"));
//                lista.setResp3(rs.getInt("resp3"));
//                lista.setResp4(rs.getInt("resp4"));
//                lista.setResp5(rs.getInt("resp5"));
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_semana");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int buscaLast() {
        String selectTableSQL = "SELECT id_premiomais FROM pesquisa_premiomais WHERE id_premiomais = (SELECT MAX(id_premiomais) FROM pesquisa_premiomais);";
        int temp = -1;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                temp = rs.getInt("id_premiomais");
            }
            //statement.close();
            return temp;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaLast");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int buscaUltimo() {
        String selectTableSQL = "SELECT id_clima_org FROM pesquisa_clima_org "
                + "WHERE id_clima_org = (SELECT MAX(id_clima_org) FROM pesquisa_clima_org);";
        int temp = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return 0;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                temp = rs.getInt("id_clima_org");
            }
            //statement.close();
            return temp;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaUltimo");
            return 0;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePesquisaClimaOrg(Pesquisa_model pesquisa) {
        PreparedStatement prep;
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pesquisa_clima_org("
                + "            setor, graduacao, sexo, tempodetrab, perg1, perg2, "
                + "            perg3, perg4, perg5, perg6, perg7, perg8, perg9, perg10, perg11, "
                + "            perg12, perg13, perg14, perg15, perg16, perg17, perg18, perg19, "
                + "            perg20, perg21, perg22, perg23, perg24, perg25, perg26, perg27, "
                + "            perg28, perg29, perg30, perg31, perg32, perg33, perg34, perg35, "
                + "            perg36, perg37, perg38, perg39, perg40, perg41, perg42, perg43, "
                + "            perg44, perg45, perg46, perg47, perg48, perg49, perg50, perg51, "
                + "            perg52, perg53, perg54, perg55, perg56, perg57, perg58, perg59, "
                + "            perg60, perg61, perg62, perg63, perg64, perg65, perg66, perg67, "
                + "            perg68, perg69, perg70, perg71, perg72, perg73, perg74, perg75, "
                + "            perg76, perg77, perg78, perg79, perg80, perg81, perg82, perg83, "
                + "            perg84, perg85, perg86, perg87, perg88, perg89, perg90, perg91, "
                + "            perg92, perg93, perg94, perg95, perg96, perg97, perg98, perg99, "
                + "            perg100, perg101, perg102, perg103, perg104, select108, disc109, "
                + "            select110, disc111, disc112, disc113, protocolo, data_cad, hora_cad, "
                + "            ip_cad)"
                + "    VALUES (?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?, "
                + "            ?, ?, ?, ?, ?, ?, ?, ?,"
                + "            ?, ?, ?, ?, ?, ?, ?,"
                + "            ?, ?, ?, ?, ?, ?, ?,"
                + "            '" + pesquisa.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            prep = connectDataBase.openConection().prepareStatement(insereTableSQL);
            prep.setString(1, pesquisa.getSetor());
            prep.setInt(2, pesquisa.getGraduacao());
            prep.setInt(3, pesquisa.getSexo());
            prep.setInt(4, pesquisa.getTempoDeTrab());
            for (int i = 5; i <= 108; i++) {
                prep.setInt(i, pesquisa.getPerguntas().get("perg" + (i - 4)));
            }

            prep.setInt(109, pesquisa.getSelect108());
            prep.setString(110, pesquisa.getDisc109());
            prep.setInt(111, pesquisa.getSelect110());
            prep.setString(112, pesquisa.getDisc111());
            prep.setString(113, pesquisa.getDisc112());
            prep.setString(114, pesquisa.getDisc113());
            prep.setString(115, pesquisa.getProtocolo());
            java.sql.Date data = new java.sql.Date(date.getTime());
            prep.setDate(116, data);
            java.sql.Time time = new java.sql.Time(thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
            prep.setTime(117, time);
            prep.execute();
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_inserePesquisa");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePesquisa(Pesquisa_model pesquisa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO pesquisa_premiomais (dep, perg1, perg2, perg3, perg4, perg5, perg6, "
                + "protocolo, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + pesquisa.getSetor() + "', '" + pesquisa.getPerg1() + "',"
                + " '" + pesquisa.getPerg2() + "', '" + pesquisa.getPerg3() + "', '" + pesquisa.getPerg4() + "',"
                + " '" + pesquisa.getPerg5() + "', '" + pesquisa.getPerg6() + "', '" + pesquisa.getProtocolo() + "',"
                + " '" + date + "', '" + thisSec + "', '" + pesquisa.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_inserePesquisa");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model BuscaPremiomais(String dep) {
        Resposta_model lista = new Resposta_model();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when perg1 = '1' then 1 else 0 end) as p1s, "
                + "sum(case when perg2 = '1' then 1 else 0 end) as p2s, "
                + "sum(case when perg3 = '1' then 1 else 0 end) as p3s, "
                + "sum(case when perg4 = '1' then 1 else 0 end) as p4s, "
                + "sum(case when perg5 = '1' then 1 else 0 end) as p5s, "
                + "sum(case when perg6 = '1' then 1 else 0 end) as p6s "
                + "from pesquisa_premiomais "
                + "where dep = '" + dep + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
//                lista.setResp1(rs.getDouble("p1s"));
//                lista.setResp2(rs.getDouble("p2s"));
//                lista.setResp3(rs.getDouble("p3s"));
//                lista.setResp4(rs.getDouble("p4s"));
//                lista.setResp5(rs.getDouble("p5s"));
//                lista.setResp6(rs.getDouble("p6s"));
                lista.setTotal(rs.getDouble("total"));
                lista.setDep(dep);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model BuscaClimaOrg(String dep, int i) {
        Resposta_model lista = new Resposta_model();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when perg" + i + " = '1' then 1 else 0 end) as p" + i + "s, "
                + "sum(case when perg" + i + " = '2' then 1 else 0 end) as p" + i + "na "
                + "from pesquisa_clima_org where setor = '" + dep + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                lista.setRespSim(rs.getDouble("p" + i + "s"));
                lista.setRespNa(rs.getDouble("p" + i + "na"));
                lista.setTotal(rs.getDouble("total"));
                lista.setDep(dep);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model BuscaClimaOrgAll(int i) {
        Resposta_model lista = new Resposta_model();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when perg" + i + " = '1' then 1 else 0 end) as p" + i + "s, "
                + "sum(case when perg" + i + " = '2' then 1 else 0 end) as p" + i + "na "
                + "from pesquisa_clima_org";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                lista.setRespSim(rs.getDouble("p" + i + "s"));
                lista.setRespNa(rs.getDouble("p" + i + "na"));
                lista.setTotal(rs.getDouble("total"));
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Resposta_model BuscaClimaOrgNa(String dep) {
        Resposta_model lista = new Resposta_model();
        String selectTableSQL = "select count(*) as total, ";
        for (int i = 1; i <= 103; i++) {
            if (i == 1) {
                selectTableSQL = selectTableSQL + "sum(case when perg" + i + " = '2' then 1 else 0 end) as p" + i + "s";
            } else {
                selectTableSQL = selectTableSQL + ", sum(case when perg" + i + " = '2' then 1 else 0 end) as p" + i + "s";
            }
        }
        selectTableSQL = selectTableSQL + " from pesquisa_clima_org "
                + "where setor = '" + dep + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
//                lista.setResp1(rs.getDouble("p1s"));
//                lista.setResp2(rs.getDouble("p2s"));
//                lista.setResp3(rs.getDouble("p3s"));
//                lista.setResp4(rs.getDouble("p4s"));
//                lista.setResp5(rs.getDouble("p5s"));
//                lista.setResp6(rs.getDouble("p6s"));
                lista.setTotal(rs.getDouble("total"));
                lista.setDep(dep);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Pesquisa_model> BuscaPremiomaisProtocolo(String dep) {
        ArrayList<Pesquisa_model> lista = new ArrayList<>();
        String selectTableSQL = "select protocolo "
                + "from pesquisa_premiomais "
                + "where dep = '" + dep + "'";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Pesquisa_model listaTemp = new Pesquisa_model();
                listaTemp.setProtocolo(rs.getString("protocolo"));
                listaTemp.setSetor(dep);
                lista.add(listaTemp);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomaisProtocolo");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<String> buscaPerguntas(int tipo) {
        ArrayList<String> perguntas = new ArrayList<>();
        String selectTableSQL = "select * "
                + "from pesquisa_perguntas "
                + "where tipo_de_pesquisa = '" + tipo + "' ORDER BY id_perguntas asc;";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                perguntas.add(rs.getString("pergunta"));
            }
            return perguntas;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaPerguntas");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public String buscaPerg(int tipo) {
        String perguntas = "";
        String selectTableSQL = "select pergunta "
                + "from pesquisa_perguntas "
                + "where id_perguntas = '" + tipo + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                perguntas = rs.getString("pergunta");
            }
            return perguntas;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaPerguntas");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public String buscaPerguntas(int tipo, int pergunta) {
        String perg = "";
        String selectTableSQL = "select * "
                + "from pesquisa_perguntas "
                + "where tipo_de_pesquisa = '" + tipo + "' and id_perguntas = '" + pergunta + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                perg = rs.getString("pergunta");
            }
            return perg;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_buscaPerguntas");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pesquisa_sexo BuscaSexo() {
        Pesquisa_sexo sexo = new Pesquisa_sexo();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when sexo = '1' then 1 else 0 end) as mas, "
                + "sum(case when sexo = '2' then 1 else 0 end) as fem "
                + "from pesquisa_clima_org;";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                sexo.setTotal(rs.getDouble("total"));
                sexo.setMasc(rs.getDouble("mas"));
                sexo.setFem(rs.getDouble("fem"));
            }
            return sexo;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pesquisa_nota BuscaNota() {

        Pesquisa_nota nota = new Pesquisa_nota();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when select108 = '1' then 1 else 0 end) as nota1, "
                + "sum(case when select108 = '2' then 1 else 0 end) as nota2, "
                + "sum(case when select108 = '3' then 1 else 0 end) as nota3, "
                + "sum(case when select108 = '4' then 1 else 0 end) as nota4, "
                + "sum(case when select108 = '5' then 1 else 0 end) as nota5, "
                + "sum(case when select108 = '6' then 1 else 0 end) as nota6, "
                + "sum(case when select108 = '7' then 1 else 0 end) as nota7, "
                + "sum(case when select108 = '8' then 1 else 0 end) as nota8, "
                + "sum(case when select108 = '9' then 1 else 0 end) as nota9, "
                + "sum(case when select108 = '10' then 1 else 0 end) as nota10 "
                + "from pesquisa_clima_org;";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                nota.setTotal(rs.getDouble("total"));
                nota.setN1(rs.getDouble("nota1"));
                nota.setN2(rs.getDouble("nota2"));
                nota.setN3(rs.getDouble("nota3"));
                nota.setN4(rs.getDouble("nota4"));
                nota.setN5(rs.getDouble("nota5"));
                nota.setN6(rs.getDouble("nota6"));
                nota.setN7(rs.getDouble("nota7"));
                nota.setN8(rs.getDouble("nota8"));
                nota.setN9(rs.getDouble("nota9"));
                nota.setN10(rs.getDouble("nota10"));
            }
            return nota;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Pesquisa_habilidade BuscaHabi() {

        Pesquisa_habilidade hab = new Pesquisa_habilidade();
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when select110 = '1' then 1 else 0 end) as hab1, "
                + "sum(case when select110 = '2' then 1 else 0 end) as hab2, "
                + "sum(case when select110 = '3' then 1 else 0 end) as hab3, "
                + "sum(case when select110 = '4' then 1 else 0 end) as hab4, "
                + "sum(case when select110 = '5' then 1 else 0 end) as hab5, "
                + "sum(case when select110 = '6' then 1 else 0 end) as hab6 "
                + "from pesquisa_clima_org;";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                hab.setTotal(rs.getDouble("total"));
                hab.setN1(rs.getDouble("hab1"));
                hab.setN2(rs.getDouble("hab2"));
                hab.setN3(rs.getDouble("hab3"));
                hab.setN4(rs.getDouble("hab4"));
                hab.setN5(rs.getDouble("hab5"));
                hab.setN6(rs.getDouble("hab6"));
            }
            return hab;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoPesquisa_BuscaPremiomais");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
