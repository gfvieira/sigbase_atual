package src.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import src.Error;
import src.modelo.Indicador_model;
import src.modelo.ModeloGraficoItem;
import src.modelo.Servidor_indicador;

public class DaoIndicadoresbh30 {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoIndicadoresbh30() {
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindAll");
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindbh34");
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindbh34Mes");
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindMes");
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindData34");
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
    
    public ArrayList<Indicador_model> buscaindOfMensal34(String mensal, String year) {
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
                + " and (atendimento = 'REDE' or atendimento = 'HARDWARE' or atendimento = 'LOTUS-SIGDEM')";
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaindOfMensal34");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindAnual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Servidor_indicador buscaOfAll() {
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when grad = '15' then 1 else 0 end) as cmg, "
                + "sum(case when grad = '14' then 1 else 0 end) as cf, "
                + "sum(case when grad = '13' then 1 else 0 end) as cc, "
                + "sum(case when grad = '12' then 1 else 0 end) as ct, "
                + "sum(case when grad = '11' then 1 else 0 end) as t1, "
                + "sum(case when grad = '10' then 1 else 0 end) as t2, "
                + "sum(case when grad = '9' then 1 else 0 end) as gm "
                + "from pessoal_oficial where afast = '0'";
                Servidor_indicador inc = new Servidor_indicador();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                inc.setTotal(rs.getInt("total"));
                inc.setCmg(rs.getInt("cmg"));
                inc.setCf(rs.getInt("cf"));
                inc.setCc(rs.getInt("cc"));
                inc.setCt(rs.getInt("ct"));
                inc.setT1(rs.getInt("t1"));
                inc.setT2(rs.getInt("t2"));
                inc.setGm(rs.getInt("gm"));
            }
            return inc;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaOfAll");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
    public Servidor_indicador buscaPrAll() {
        String selectTableSQL = "select count(*) as total, "
                + "sum(case when grad = '8' then 1 else 0 end) as so, "
                + "sum(case when grad = '7' then 1 else 0 end) as sg1, "
                + "sum(case when grad = '6' then 1 else 0 end) as sg2, "
                + "sum(case when grad = '5' then 1 else 0 end) as sg3, "
                + "sum(case when grad = '4' then 1 else 0 end) as cb, "
                + "sum(case when grad = '2' then 1 else 0 end) as mn, "
                + "sum(case when grad = '1' then 1 else 0 end) as rc "
                + "from pessoal_praca where afast = '0'";
                        Servidor_indicador inc = new Servidor_indicador();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                inc.setTotal(rs.getInt("total"));
                inc.setSo(rs.getDouble("so"));
                inc.setSg1(rs.getDouble("sg1"));
                inc.setSg2(rs.getDouble("sg2"));
                inc.setSg3(rs.getDouble("sg3"));
                inc.setCb(rs.getDouble("cb"));
                inc.setMn(rs.getDouble("mn"));
                inc.setRc(rs.getDouble("rc"));
            }
            return inc;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaPrAll");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Servidor_indicador buscaCvAll() {
        String selectTableSQL = "select count(*) as total "
                + "from pessoal_civil where afast = '0'";
                        Servidor_indicador inc = new Servidor_indicador();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                inc.setCv(rs.getDouble("total"));
            }
            return inc;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaCvAll");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Servidor_indicador buscaTtcAll() {
        String selectTableSQL = "select count(*) as total "
                + "from pessoal_ttc where afast = '0'";
                        Servidor_indicador inc = new Servidor_indicador();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                inc.setTtc(rs.getDouble("total"));
            }
            return inc;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh30_buscaTtcAll");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
