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
import src.modelo.FolhanItem;
import src.modelo.FolhanOm;
import src.modelo.Usuario;

public class DaoFolhaN {

    private ConnectDataBaseFolhaN connectDataBasefolhan = null;
    private Statement statement;
    private Error log = null;

    public DaoFolhaN() {
        connectDataBasefolhan = new ConnectDataBaseFolhaN();
    }

    public ArrayList<FolhanItem> buscaOM() {//trocar para a view correta vw_carregaom onde busca todas as om cadastradas
        String selectTableSQL = "select sigla from vw_folhan_equip where sigla != 'MBAIXA' group by sigla;";
        ArrayList<FolhanItem> lista = new ArrayList<>();
        try {
            if (connectDataBasefolhan.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBasefolhan.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                FolhanItem folhaRetorno = new FolhanItem();
                folhaRetorno.setSiglaOm(rs.getString("sigla"));;
                lista.add(folhaRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoFolhaN_buscaOM");
            return null;
        } finally {
            connectDataBasefolhan.closeConnection();
        }
    }

    public ArrayList<FolhanItem> folhan_equip(String om, int tipo) {
        String selectTableSQL = "";
        switch (tipo) {
            case 1:
                selectTableSQL = "select * from vw_folhan_equipamento where sigla = '" + om + "' and nomemovimentacao != 'Empréstimo' ;";
                break;
            case 2:
                selectTableSQL = "select * from vw_folhan_equipagem where sigla = '" + om + "' and nomemovimentacao != 'Empréstimo';";
                break;
            case 3:
                selectTableSQL = "select * from vw_folhan_equip where sigla = '" + om + "' and nomemovimentacao = 'Empréstimo';";
                break;
        }

        ArrayList<FolhanItem> lista = new ArrayList<>();
        try {
            if (connectDataBasefolhan.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBasefolhan.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                FolhanItem folhaRetorno = new FolhanItem();
                folhaRetorno.setNumeroIdentificacao(rs.getString("numeroidentificacao"));
                folhaRetorno.setNomeMovimentacao(rs.getString("nomemovimentacao"));
                folhaRetorno.setNomeFantasia(rs.getString("nomefantasia"));
                folhaRetorno.setAnoGM(rs.getString("anogm"));
                folhaRetorno.setCategoria(rs.getString("nomecategoriaitem"));
                folhaRetorno.setNomeItem(rs.getString("nomeitem"));
                folhaRetorno.setClassificacao(rs.getString("classificacao"));
                folhaRetorno.setQnt(rs.getInt("quantidade"));
                folhaRetorno.setVlUnitario(rs.getDouble("valorunitario"));
                folhaRetorno.setNomeOm(rs.getString("nomeom"));
                lista.add(folhaRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoFolhaN_buscaOM");
            return null;
        } finally {
            connectDataBasefolhan.closeConnection();
        }
    }

    public ArrayList<FolhanItem> folhan_equip(int tipo) {
        String selectTableSQL = "";
        switch (tipo) {
            case 1:
                selectTableSQL = "select * from vw_folhan_equipamento where nomemovimentacao != 'Empréstimo' order by sigla;";
                break;
            case 2:
                selectTableSQL = "select * from vw_folhan_equipagem where nomemovimentacao != 'Empréstimo' order by sigla;";
                break;
            case 3:
                selectTableSQL = "select * from vw_folhan_equip where nomemovimentacao = 'Empréstimo' order by sigla;";
                break;
        }
        ArrayList<FolhanItem> lista = new ArrayList<>();
        try {
            if (connectDataBasefolhan.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBasefolhan.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                FolhanItem folhaRetorno = new FolhanItem();
                folhaRetorno.setNumeroIdentificacao(rs.getString("numeroidentificacao"));
                folhaRetorno.setNomeMovimentacao(rs.getString("nomemovimentacao"));
                folhaRetorno.setAnoGM(rs.getString("anogm"));
                folhaRetorno.setCategoria(rs.getString("nomecategoriaitem"));
                folhaRetorno.setNomeItem(rs.getString("nomeitem"));
                folhaRetorno.setClassificacao(rs.getString("classificacao"));
                folhaRetorno.setQnt(rs.getInt("quantidade"));
                folhaRetorno.setVlUnitario(rs.getDouble("valorunitario"));
                folhaRetorno.setNomeOm(rs.getString("nomeom"));
                lista.add(folhaRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoFolhaN_buscaOM");
            return null;
        } finally {
            connectDataBasefolhan.closeConnection();
        }
    }

    public ArrayList<FolhanOm> folhan_om() {
        String selectTableSQL = "select * from vw_carregaom order by sigla";
        ArrayList<FolhanOm> lista = new ArrayList<>();
        try {
            if (connectDataBasefolhan.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBasefolhan.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                FolhanOm folhaRetorno = new FolhanOm();
                folhaRetorno.setCodigoNaval(rs.getString("codigonaval"));
                folhaRetorno.setIndicativoNaval(rs.getString("indicativonaval"));
                folhaRetorno.setNomeOm(rs.getString("nomeom"));
                folhaRetorno.setSiglaOm(rs.getString("sigla"));
                folhaRetorno.setTipoOm(rs.getString("tipoom"));
                lista.add(folhaRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoFolhaN_buscaOM");
            return null;
        } finally {
            connectDataBasefolhan.closeConnection();
        }
    }

    public ArrayList<FolhanOm> folhan_om(String om) {
        String selectTableSQL = "select * from vw_carregaom where tipoom = '" + om + "' order by sigla";
        ArrayList<FolhanOm> lista = new ArrayList<>();
        try {
            if (connectDataBasefolhan.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBasefolhan.openConection().createStatement();
            //statement = dbConnection.createStatement();       
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                FolhanOm folhaRetorno = new FolhanOm();
                folhaRetorno.setCodigoNaval(rs.getString("codigonaval"));
                folhaRetorno.setIndicativoNaval(rs.getString("indicativonaval"));
                folhaRetorno.setNomeOm(rs.getString("nomeom"));
                folhaRetorno.setSiglaOm(rs.getString("sigla"));
                folhaRetorno.setTipoOm(rs.getString("tipoom"));
                lista.add(folhaRetorno);
            }
            return lista;
        } catch (SQLException e) {
            log = new Error();
            log.Gravar(e.getMessage(), "DaoFolhaN_buscaOM");
            return null;
        } finally {
            connectDataBasefolhan.closeConnection();
        }
    }
}
