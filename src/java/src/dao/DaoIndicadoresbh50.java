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

public class DaoIndicadoresbh50 {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoIndicadoresbh50() {
        connectDataBase = new ConnectDataBase();
    }

    public ArrayList<Indicador_model> buscaindAll50() {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 "
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindAll50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<ModeloGraficoItem> buscaindbh50() {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 "
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindbh50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<ModeloGraficoItem> buscaindbh50Mes() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between '01/" + d + "' and '" + d1 + "'"
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindbh50Mes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindMes50() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String d = new SimpleDateFormat("MM/yyyy").format(tm);
        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tm);
        String selectTableSQL = "select atendimento, "
                + "count(*) AS total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) AS finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) AS andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) AS iniciado "
                + "from oficinabh50 where data_cad between '01/" + d + "' and '" + d1 + "'"
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindMes50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindData50(Date data_ini, Date data_fim) {
        String selectTableSQL = "select atendimento, "
                + "count(*) as total, "
                + "sum(case when status = 'AGUARDANDO ENCARREGADO' then 1 else 0 end) as encarregado, "
                + "sum(case when status = 'FINALIZADO' then 1 else 0 end) as finalizado, "
                + "sum(case when status = 'EM ANDAMENTO' then 1 else 0 end) as andamento, "
                + "sum(case when status = 'NÃO INICIADO' then 1 else 0 end) as iniciado "
                + "from oficinabh50 where data_cad between '" + data_ini + "' and '" + data_fim + "'"
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
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindData50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindMensal50(String mensal, String year) {
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
                + "from oficinabh50 where data_cad between " + between
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
                lista.add(inc);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIndicadoresbh50_buscaindMensal50");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Indicador_model> buscaindAnual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
