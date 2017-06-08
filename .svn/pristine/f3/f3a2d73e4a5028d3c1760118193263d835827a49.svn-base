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
import src.modelo.Indicador_bh10_model;
import src.modelo.Indicador_model;
import src.modelo.ModeloGraficoItem;

public class DaoIndicadores {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoIndicadores() {
        connectDataBase = new ConnectDataBase();
    }

    public ArrayList<Indicador_model> buscaindAll() {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 "
                + "group by atendimento";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina(rs.getString("atendimento"));
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindAll");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<ModeloGraficoItem> buscaindbh34() {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 "
                + "group by atendimento";
        ArrayList<ModeloGraficoItem> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                for (int t = 0; t < 3; t++) {
                    ModeloGraficoItem inc = new ModeloGraficoItem();
                    inc.setOficina(rs.getString("atendimento"));
                    if (t == 2) {
                        inc.setQuantidade(rs.getInt("finalizado"));
                        inc.setTipo("Finalizado");
                    }
                    if (t == 1) {
                        inc.setQuantidade(rs.getInt("andamento"));
                        inc.setTipo("Em Andamento");
                    }
                    if (t == 0) {
                        inc.setQuantidade(rs.getInt("iniciado"));
                        inc.setTipo("Não Iniciado");
                    }
                    lista.add(inc);
                }
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindbh34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<ModeloGraficoItem> buscaindbh34Mes() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between '01/" + d + "' and '" + d1 + "'"
                + "group by atendimento";
        ArrayList<ModeloGraficoItem> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                for (int t = 0; t < 3; t++) {
                    ModeloGraficoItem inc = new ModeloGraficoItem();
                    inc.setOficina(rs.getString("atendimento"));
                    if (t == 2) {
                        inc.setQuantidade(rs.getInt("finalizado"));
                        inc.setTipo("Finalizado");
                    }
                    if (t == 1) {
                        inc.setQuantidade(rs.getInt("andamento"));
                        inc.setTipo("Em Andamento");
                    }
                    if (t == 0) {
                        inc.setQuantidade(rs.getInt("iniciado"));
                        inc.setTipo("Não Iniciado");
                    }
                    lista.add(inc);
                }
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindbh34Mes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindMes() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select atendimento, "
                + "count(*) AS total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) AS finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) AS andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) AS iniciado "
                + "from oficinabh34 where data_cad between '01/" + d + "' and '" + d1 + "'"
                + "group by atendimento";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina(rs.getString("atendimento"));
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindMes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindData34(Date data_ini, Date data_fim) {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between '" + data_ini + "' and '" + data_fim + "'"
                + "group by atendimento";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina(rs.getString("atendimento"));
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindData34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindMensal34(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between " + between
                + " group by atendimento";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina(rs.getString("atendimento"));
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindAnual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int totalMensal(String between) {
        String selectTableSQL = "select count(*) as total "
                + "from oficinabh34 where data_cad between " + between //dentre as data de finalização
                + " and (atendimento = 'REDE' or atendimento = 'HARDWARE' or atendimento = 'LOTUS-SIGDEM')";
        int inc = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return 0;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                inc = rs.getInt("total");
            }
            return inc;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfMensal34");
            return 0;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindOfMensal34(String mensal, String year) {
        String between;
        switch (mensal) {
            case "2":
                between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
                break;
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
                break;
            default:
                between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
                break;
        }
//        String selectTableSQL = "select count(*) as total, "
//                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
//                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, " //buscar so os finalizados
//                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
//                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
//                + "from oficinabh34 where data_cad between " + between //dentre as data de finalização
//                + " and (atendimento = 'REDE' or atendimento = 'HARDWARE' or atendimento = 'LOTUS-SIGDEM')";
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when a.status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when a.status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when a.status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when a.status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 a, oficinabh34_status b where a.os_bh34 = b.os"
                + " and a.data_cad between " + between
                + " and b.data_fin between " + between
                + " and (atendimento = 'REDE' or atendimento = 'HARDWARE' or atendimento = 'LOTUS-SIGDEM') ";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("OFICINA");
                inc.setTotal(totalMensal(between));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindSomMensal34(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between " + between
                + " and atendimento = 'SOM'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("SOM");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindSomMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindTelMensal34(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between " + between
                + " and atendimento = 'TELEFONIA'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("TELEFONIA");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindTelMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindFonoMensal34(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh34 where data_cad between " + between
                + " and atendimento = 'FONOCLAMA'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("FONOCLAMA");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindFonoMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //============================================================================================================
    public ArrayList<Indicador_model> buscaindOfElMensal50(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between " + between
                + " and atendimento = 'ELETRICA'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("ELETRICA");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfElMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindOfMoMensal50(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between " + between
                + " and atendimento = 'REFRIGERACAO'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("REFRIGERACAO");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfMoMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindOfMtMensal50(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between " + between
                + " and atendimento = 'METALURGIA'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("METALURGIA");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfMtMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindOfCpMensal50(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between " + between
                + " and atendimento = 'CARPINTARIA'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("CARPINTARIA");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfCpMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindOfVtMensal50(String mensal, String year) {
        String between = "";
        if (mensal.equals("2")) {
            between = "'01/" + mensal + "/" + year + "' and '28/" + mensal + "/" + year + "'";
        } else if (mensal.equals("1")
                || mensal.equals("3")
                || mensal.equals("5")
                || mensal.equals("7")
                || mensal.equals("8")
                || mensal.equals("10")
                || mensal.equals("12")) {
            between = "'01/" + mensal + "/" + year + "' and '31/" + mensal + "/" + year + "'";
        } else {
            between = "'01/" + mensal + "/" + year + "' and '30/" + mensal + "/" + year + "'";
        }
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between " + between
                + " and atendimento = 'GARAGEM'";
        ArrayList<Indicador_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Indicador_model inc = new Indicador_model();
                inc.setOficina("GARAGEM");
                inc.setTotal(rs.getInt("total"));
                inc.setAguadando_enc(rs.getInt("encarregado"));
                inc.setNao_iniciado(rs.getInt("iniciado"));
                inc.setEm_andamento(rs.getInt("andamento"));
                inc.setFinalizado(rs.getInt("finalizado"));
                inc.setMes(mensal);
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadores_buscaindOfVtMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
