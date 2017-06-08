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

public class DaoFatura {

    private ConnectDataBase connectDataBase = null;
    private Error log = null;
    private Statement statement;

    public DaoFatura() {
        connectDataBase = new ConnectDataBase();
    }

    public ArrayList<Pedido_model> buscaSate() {
        String selectTableSQL = "";
        selectTableSQL = "SELECT * from sate WHERE faturado = '0';";
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
                sateRetorno.setOs(rs.getString("os"));
                sateRetorno.setNome(rs.getString("nome"));
                sateRetorno.setNip(rs.getString("nip"));
                sateRetorno.setRamal(rs.getString("ramal"));
                sateRetorno.setSetor(rs.getString("setor"));
                sateRetorno.setAtendimento(rs.getString("atendimento"));
                sateRetorno.setEquipamento(rs.getString("equipamento"));
                sateRetorno.setSolicitacao(rs.getString("solicitacao"));
                sateRetorno.setDescricao(rs.getString("descricao"));
                lista.add(sateRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Error();
            log.Gravar(e.getMessage());
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }
}
