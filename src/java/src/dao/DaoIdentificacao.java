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
import src.modelo.Identificacao_model;
import src.modelo.Indicador_model;
import src.modelo.Pedido_model;
import src.modelo.Pedido_move;
import src.modelo.ModeloGraficoItem;

public class DaoIdentificacao {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoIdentificacao() {
        connectDataBase = new ConnectDataBase();
    }

    public int totalEstacionamento() {
        String selectTableSQL = "select * from identificacao where numeroestacionamento != '0' and data_return is null;";
        int temp = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                temp = temp++;
            }
            return temp;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIdentificacao_totalEstacionamento");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public int totalCracha() {
        String selectTableSQL = "select * from identificacao where numerocracha != '0' and data_return is null;";
        int temp = 0;
        try {
            if (connectDataBase.openConection() == null) {
                return -1;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                temp = temp++;
            }
            return temp;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIdentificacao_totalCracha");
            return -1;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereCracha(Identificacao_model identificacao, int type) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String cracha = "", estacionamento = "";
        if (type == 0) {
            cracha = identificacao.getCracha();
            estacionamento = "0";
        } else {
            cracha = "0";
            estacionamento = identificacao.getEstacionamento();
        }
        String insereTableSQL = "INSERT INTO identificacao (numerocracha, numeroestacionamento, nome, nip,"
                + " cpf, empresa, destino, telefone, user_cad, data_cad, hora_cad, ip_cad) "
                + "VALUES ('" + cracha+ "', '" + estacionamento+ "', '" + identificacao.getNome() + "', "
                + "'" + identificacao.getNip() + "','" + identificacao.getCpf() + "', '" + identificacao.getEmpresa() + "', "
                + "'" + identificacao.getDestino() + "','" + identificacao.getTelefone() + "', '" + identificacao.getUsercad() + "', "
                + "'" + date + "', '" + thisSec + "', '" + identificacao.getIpcad() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIdentificacao_insereCracha");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Identificacao_model> busca(String access, String type) {
        String selectTableSQL = "";
        if (type.equals("CARD")) {
            selectTableSQL = "select * from identificacao where numerocracha != '0' and data_return is null;";
        }
        if (type.equals("PARK")) {
            selectTableSQL = "select * from identificacao where numeroestacionamento != '0' and data_return is null;";
        }
        ArrayList<Identificacao_model> lista = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Identificacao_model sateRetorno = new Identificacao_model();
                sateRetorno.setCracha(rs.getString("numerocracha"));
                sateRetorno.setEstacionamento(rs.getString("numeroestacionamento"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setCpf(rs.getString("cpf"));
                sateRetorno.setEmpresa(rs.getString("empresa"));
                sateRetorno.setDestino(rs.getString("destino"));
                sateRetorno.setTelefone(rs.getString("telefone"));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoIdentificacao_busca");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

}
