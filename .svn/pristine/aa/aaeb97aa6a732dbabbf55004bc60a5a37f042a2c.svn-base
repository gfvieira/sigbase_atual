package src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import src.Logger;
import src.modelo.Chapa_Dependente;
import src.modelo.Chapa_Permissionario;
import src.modelo.Chapa_Veiculo;
import src.modelo.Chapa_historico;
import src.modelo.Chapa_model;

public class DaoChapa {

    private ConnectDataBase connectDataBase = null;
    private Logger log = null;
    private Statement statement;

    public DaoChapa() {
        connectDataBase = new ConnectDataBase();
    }

    public boolean insereFila(Chapa_model chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO chapa_fila (nome, nip, grad, om, ramal, "
                + "mensagem, fila, data_cad, hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + chapa.getNome() + "', '" + chapa.getNip() + "', '" + chapa.getGrad() + "',"
                + " '" + chapa.getOm() + "', '" + chapa.getRamal() + "',"
                + " '" + chapa.getMsg() + "', '0', '" + date + "', '" + thisSec + "', '" + chapa.getUser() + "',"
                + " '" + chapa.getIp() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_insereFila");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean inserePermissionario(Chapa_Permissionario chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "INSERT INTO chapa_permissionario (chapa_active, bloco, apto, nome, nip,"
                + " grad, om, ident, cpf, estadocivil"
                + ", endereco, telefone, celular, ramal, "
                + "mensagem, data_cad, hora_cad, user_cad, ip_cad) "
                + "VALUES ('" + 1 + "', '" + chapa.getBloco() + "', '" + chapa.getApto() + "', '" + chapa.getNome() + "', '" + chapa.getNip()
                + "', '" + chapa.getGrad() + "', '" + chapa.getOm() + "','" + chapa.getIdentidade() + "', '" + chapa.getCpf() + "', '" + chapa.getEstadoCivil()
                + "', '" + chapa.getEndereco() + "', '" + chapa.getTelefone() + "', '" + chapa.getCelular() + "', '" + chapa.getRamal() + "',"
                + " '" + chapa.getMsg() + "', '" + date + "', '" + thisSec + "', '" + chapa.getUser() + "',"
                + " '" + chapa.getIp() + "');";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.execute(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_insereFila");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public ArrayList<Chapa_model> buscaFila() {
        String selectTableSQL = "SELECT * from chapa_fila where fila = 0 ORDER BY id_filachapa asc";
        ArrayList<Chapa_model> lista = new ArrayList<>();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                Chapa_model chapaRetorno = new Chapa_model();
                chapaRetorno.setId(rs.getInt("id_filachapa"));
                chapaRetorno.setNome(rs.getString("nome"));
                chapaRetorno.setNip(rs.getString("nip"));
                chapaRetorno.setMsg(rs.getString("mensagem"));
                chapaRetorno.setGrad(rs.getInt("grad"));
                chapaRetorno.setOm(rs.getInt("om"));
                chapaRetorno.setRamal(rs.getString("ramal"));
                chapaRetorno.setDatacad(rs.getDate("data_cad"));
                chapaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapaRetorno.setUser(rs.getString("user_Cad"));
                lista.add(chapaRetorno);
            }
            return lista;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaFila");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Chapa_model buscaFila(String nome) {
        String selectTableSQL = "SELECT * from chapa_fila where fila = 0 and nome = '" + nome + "'";
        Chapa_model chapa = new Chapa_model();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                chapa.setId(rs.getInt("id_filachapa"));
                chapa.setNome(rs.getString("nome"));
                chapa.setNip(rs.getString("nip"));
                chapa.setMsg(rs.getString("mensagem"));
                chapa.setGrad(rs.getInt("grad"));
                chapa.setOm(rs.getInt("om"));
                chapa.setRamal(rs.getString("ramal"));
                chapa.setDatacad(rs.getDate("data_cad"));
                chapa.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapa.setUser(rs.getString("user_Cad"));
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaFila");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
        return chapa;
    }

    public Chapa_model buscaPermissionario1(String nome) {
        String selectTableSQL = "SELECT chapa_perm.id_chapa, chapa_fila.nome, chapa_fila.nip\n"
                + "FROM chapa_fila\n"
                + "INNER JOIN chapa_perm\n"
                + "ON (chapa_perm.id_chapa=16 and chapa_fila.id_filachapa=16);";
        Chapa_model chapa = new Chapa_model();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                chapa.setId(rs.getInt("id_filachapa"));
                chapa.setNome(rs.getString("nome"));
                chapa.setNip(rs.getString("nip"));
                chapa.setMsg(rs.getString("mensagem"));
                chapa.setGrad(rs.getInt("grad"));
                chapa.setOm(rs.getInt("om"));
                chapa.setRamal(rs.getString("ramal"));
                chapa.setDatacad(rs.getDate("data_cad"));
                chapa.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapa.setUser(rs.getString("user_Cad"));
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaFila");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
        return chapa;
    }

    public ArrayList<Chapa_Permissionario> buscaPermissionario(String bloco) {
        String selectTableSQL = "SELECT * from chapa_permissionario where chapa_active = 1 and bloco = '" + bloco + "';";
        Chapa_Permissionario chapaRetorno;
        ArrayList<Chapa_Permissionario> moradoresDoBloco = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                chapaRetorno = new Chapa_Permissionario();
                chapaRetorno.setId(rs.getInt("id_chapa"));
                chapaRetorno.setApto(rs.getString("apto"));
                chapaRetorno.setBloco(rs.getString("bloco"));
                chapaRetorno.setNome(rs.getString("nome"));
                chapaRetorno.setNip(rs.getString("nip"));
                chapaRetorno.setMsg(rs.getString("mensagem"));
                chapaRetorno.setGrad(rs.getInt("grad"));
                chapaRetorno.setOm(rs.getInt("om"));
                chapaRetorno.setRamal(rs.getString("ramal"));
                chapaRetorno.setDatacad(rs.getDate("data_cad"));
                chapaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapaRetorno.setUser(rs.getString("user_Cad"));
                moradoresDoBloco.add(chapaRetorno);
            }
            return moradoresDoBloco;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaPermissionario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean deletePermissionario(Chapa_Permissionario chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE chapa_permissionario SET chapa_active = 2 where chapa_active = 1 and bloco = '" + chapa.getBloco() + "' and apto = '" + chapa.getApto() + "' and nip = '" + chapa.getNip() + "';";

        String insereTableSQL2 = "UPDATE chapa_fila SET"
                + " fila = 2, data_ret='" + date + "', hora_ret='" + thisSec + "', "
                + "user_ret='" + chapa.getUser() + "', ip_ret = '" + chapa.getIp() + "' where nip = '" + chapa.getNip() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(insereTableSQL2);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_deletePermissionario");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Chapa_model buscaMilitar(Chapa_model chapa) {
        String selectTableSQL = "SELECT * from chapa_fila where id_filachapa = '" + chapa.getId() + "'";
        Chapa_model chapaRetorno = new Chapa_model();

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                chapaRetorno.setId(rs.getInt("id_filachapa"));
                chapaRetorno.setNome(rs.getString("nome"));
                chapaRetorno.setNip(rs.getString("nip"));
                chapaRetorno.setMsg(rs.getString("mensagem"));
                chapaRetorno.setGrad(rs.getInt("grad"));
                chapaRetorno.setOm(rs.getInt("om"));
                chapaRetorno.setRamal(rs.getString("ramal"));
                chapaRetorno.setDatacad(rs.getDate("data_cad"));
                chapaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapaRetorno.setUser(rs.getString("user_Cad"));
            }
            return chapaRetorno;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaMilitar");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean updateMilitar(Chapa_model chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE chapa_fila SET nome='" + chapa.getNome() + "',"
                + " nip='" + chapa.getNip() + "', grad='" + chapa.getGrad() + "',"
                + " om='" + chapa.getOm() + "', ramal='" + chapa.getRamal() + "',"
                + " mensagem='" + chapa.getMsg() + "',"
                + " data_alt='" + date + "', hora_alt='" + thisSec + "', "
                + "user_alt='" + chapa.getUser() + "', ip_alt='" + chapa.getIp() + "' where id_filachapa = '" + chapa.getId() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_updateMilitar");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean retiraFila(Chapa_model chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE chapa_fila SET"
                + " fila ='2', data_ret='" + date + "', hora_ret='" + thisSec + "', "
                + "user_ret='" + chapa.getUser() + "', ip_ret = '" + chapa.getIp() + "' where nip = '" + chapa.getNip() + "';";
        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_retiraFila");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean buscaNip(String nip) {
        String selectTableSQL1 = "select "
                + "  case nip = '" + nip + "' then 'TRUE' else 'FALSE' end as isMorador "
                + "from chapa_permissionario "
                + "where nip = '" + nip + "';";
        Chapa_model chapaRetorno = new Chapa_model();
        try {
            if (connectDataBase.openConection() == null) {
                return false;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL1);
            while (rs.next()) {
                chapaRetorno.setNip(rs.getString("nip"));
            }
            if (chapaRetorno.getNip().equals(nip)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscanip");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }

    }

    public boolean buscaApto(String apto) {
        String selectTableSQL2 = "select "
                + "  case apto = '" + apto + "' then 'TRUE' else 'FALSE' end as isMorador "
                + "from chapa_permissionario "
                + "where apto = '" + apto + "';";
        Chapa_model chapaRetorno = new Chapa_model();
        try {
            if (connectDataBase.openConection() == null) {
                return false;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL2);
            while (rs.next()) {
                chapaRetorno.setApto(rs.getString("apto"));
            }
            if (chapaRetorno.getApto().equals(apto)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaapto");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }

    }

    public boolean buscaBloco(String bloco) {
        String selectTableSQL3 = "select "
                + "  case bloco = '" + bloco + "' then 'TRUE' else 'FALSE' end as isMorador "
                + "from chapa_permissionario "
                + "where bloco = '" + bloco + "';";
        Chapa_model chapaRetorno = new Chapa_model();
        try {
            if (connectDataBase.openConection() == null) {
                return false;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL3);
            while (rs.next()) {
                chapaRetorno.setBloco(rs.getString("bloco"));
            }
            if (chapaRetorno.getBloco().equals(bloco)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscabloco");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }

    }

    public boolean removePermissionario(Chapa_Permissionario chapa) {
        boolean removeu = false;
        String selectTableSQL3 = "update chapa_fila set fila = 1 where nip = '" + chapa.getNip() + "';";
        Chapa_model chapaRetorno = new Chapa_model();
        try {
            if (connectDataBase.openConection() == null) {
                return false;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            int rs = statement.executeUpdate(selectTableSQL3);
            removeu = true;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscabloco");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
        return removeu;
    }

    public ArrayList<String> buscaRealocarPermissionario() {
        ArrayList<String> retorno = new ArrayList<>();
        String selectTableSQL3 = "SELECT nome from chapa_fila where fila = 2 ORDER BY id_filachapa asc";
        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL3);
            while (rs.next()) {
                retorno.add(rs.getString("nome"));
            }
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscabloco");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
        return retorno;
    }

    public boolean updatePerm(String parameter) {
        boolean removeu = false;
        String selectTableSQL3 = "update chapa_fila set fila = 0 where nome = '" + parameter + "';";
        Chapa_model chapaRetorno = new Chapa_model();
        try {
            if (connectDataBase.openConection() == null) {
                return false;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            int rs = statement.executeUpdate(selectTableSQL3);
            removeu = true;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscabloco");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
        return removeu;
    }

    public Chapa_Permissionario buscaPermissionarioDoApto(String nip, String apto, String bloco, int i) {
        String selectTableSQL = "SELECT * from chapa_permissionario where chapa_active = " + i + " and bloco = '" + bloco + "' and apto = '" + apto + "' and nip ='" + nip + "';";
        Chapa_Permissionario chapaRetorno;

        try {
            if (connectDataBase.openConection() == null) {
                return null;//criar uma variavel no usauario pra condicao do banco
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            chapaRetorno = new Chapa_Permissionario();

            while (rs.next()) {
                chapaRetorno.setId(rs.getInt("id_chapa"));
                chapaRetorno.setApto(rs.getString("apto"));
                chapaRetorno.setBloco(rs.getString("bloco"));
                chapaRetorno.setNome(rs.getString("nome"));
                chapaRetorno.setNip(rs.getString("nip"));
                chapaRetorno.setMsg(rs.getString("mensagem"));
                chapaRetorno.setGrad(rs.getInt("grad"));
                chapaRetorno.setOm(rs.getInt("om"));
                chapaRetorno.setEstadoCivil(rs.getInt("estadocivil"));
                chapaRetorno.setCelular(rs.getString("celular"));
                chapaRetorno.setEndereco(rs.getString("endereco"));
                chapaRetorno.setTelefone(rs.getString("telefone"));
                chapaRetorno.setCpf(rs.getString("cpf"));
                chapaRetorno.setIdentidade(rs.getString("ident"));
                chapaRetorno.setRamal(rs.getString("ramal"));
                chapaRetorno.setDatacad(rs.getDate("data_cad"));
                chapaRetorno.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapaRetorno.setUser(rs.getString("user_Cad"));
            }
            return chapaRetorno;
        } catch (Exception e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_buscaPermissionario");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean atualizaPermissionario(Chapa_Permissionario chapa) {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        String t = new SimpleDateFormat("HH:mm:ss").format(tm);
        Date date = new Date();
        LocalTime thisSec = LocalTime.parse(t);
        String insereTableSQL = "UPDATE chapa_permissionario set chapa_active = '1' ,"
                + " bloco = '" + chapa.getBloco() + "' , apto = '" + chapa.getApto() + "' ,"
                + " nome = '" + chapa.getNome() + "' , nip = '" + chapa.getNip() + "' ,"
                + " grad = '" + chapa.getGrad() + "' , om= '" + chapa.getOm() + "' ,"
                + " ident= '" + chapa.getIdentidade() + "' , cpf= '" + chapa.getCpf() + "', "
                + "estadocivil= '" + chapa.getEstadoCivil() + "' , endereco = '" + chapa.getEndereco() + "' , "
                + "telefone = '" + chapa.getTelefone() + "' , celular= '" + chapa.getCelular() + "' ,"
                + " ramal= '" + chapa.getRamal() + "' , mensagem= '" + chapa.getMsg() + "' "
                + "where chapa_active = '1' "
                + "and bloco = '" + chapa.getBloco() + "' "
                + "and apto = '" + chapa.getApto() + "' "
                + "and nip = '" + chapa.getNip() + "';";

        String atualizaPermMov = "INSERT INTO chapa_permissionario_mov "
                + "(id_chapa, desc_mov, useralt, dataalt, horaalt, ipalt)"
                + " VALUES (" + chapa.getId() + ", 'CADASTRO PERMISSIONARIO ATUALIZADO', '" + chapa.getUser() + "', '" + date + "', '" + thisSec + "', '" + chapa.getIp() + "')";

        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(insereTableSQL);
            statement.executeUpdate(atualizaPermMov);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_insereFila");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public void cadastraVeiculo(Chapa_Veiculo veiculo, int chapa_active, int id_chapa, String user, String ip) {
        LocalTime time = LocalTime.now();
        Date date = new Date();

        String sql = "INSERT INTO chapa_veiculo("
                + "   id_chapa, chapa_active, modelo, placa, data_cad, "
                + "   hora_cad, user_cad, ip_cad)"
                + "   VALUES ('" + id_chapa + "', '" + chapa_active + "', '" + veiculo.getModelo()
                + "', '" + veiculo.getPlaca() + "', '" + date + "', "
                + "   '" + time + "', '" + user + "', '" + ip + "');";

        if (connectDataBase.openConection() != null) {
            try {
                statement = connectDataBase.openConection().createStatement();
                statement.execute(sql);
            } catch (SQLException e) {
                log = new Logger();
                log.Gravar(e.getMessage(), "DaoChapa_cadastrarVeiculo");
            }
        }

    }

    public ArrayList<Chapa_Veiculo> buscaVeiculoPermissionario(Chapa_Permissionario perm) {
        LocalTime time = LocalTime.now();
        Date date = new Date();
        ArrayList<Chapa_Veiculo> veiculos = new ArrayList<>();

        String sql = "select * from chapa_veiculo where id_chapa = '" + perm.getId() + "' and chapa_active = '" + 1 + "';";

        if (connectDataBase.openConection() != null) {
            try {
                statement = connectDataBase.openConection().createStatement();
                statement.execute(sql);
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {
                    Chapa_Veiculo v = new Chapa_Veiculo();
                    v.setId_Veiculo(rs.getInt("id_chapa_veiculo"));
                    v.setId_chapa(rs.getInt("id_chapa"));
                    v.setModelo(rs.getString("modelo"));
                    v.setPlaca(rs.getString("placa"));
                    v.setChapa_active(rs.getInt("chapa_active"));
                    v.setUser(rs.getString("user_cad"));
                    v.setDatacad(rs.getDate("data_cad"));
                    v.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                    veiculos.add(v);
                }
            } catch (SQLException e) {
                log = new Logger();
                log.Gravar(e.getMessage(), "DaoChapa_atualizarVeiculo");
            }
        }
        return veiculos;
    }

    public boolean atualizaVeiculo(Chapa_Veiculo v) {
        String attVeiculo = "UPDATE chapa_veiculo"
                + " SET modelo='" + v.getModelo() + "', placa='" + v.getPlaca() + "' "
                + " WHERE id_chapa_veiculo = '" + v.getId_Veiculo() + "';";

        try {
            if (connectDataBase.openConection() == null) {
                return false;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(attVeiculo);
            return true;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_atualizaVeiculoPerm");
            return false;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public Chapa_Permissionario verificaCadastroDeNip(String nip) {
        String consulta = "select * from chapa_permissionario where nip = '" + nip + "' and chapa_active = '1';";

        try {
            if (connectDataBase.openConection() == null) {
                return null;
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(consulta);

            Chapa_Permissionario chapa = null;
            while (rs.next()) {
                chapa = new Chapa_Permissionario();
                chapa.setId(rs.getInt("id_chapa"));
                chapa.setApto(rs.getString("apto"));
                chapa.setBloco(rs.getString("bloco"));
                chapa.setNome(rs.getString("nome"));
                chapa.setNip(rs.getString("nip"));
                chapa.setMsg(rs.getString("mensagem"));
                chapa.setGrad(rs.getInt("grad"));
                chapa.setOm(rs.getInt("om"));
                chapa.setEstadoCivil(rs.getInt("estadocivil"));
                chapa.setCelular(rs.getString("celular"));
                chapa.setEndereco(rs.getString("endereco"));
                chapa.setTelefone(rs.getString("telefone"));
                chapa.setCpf(rs.getString("cpf"));
                chapa.setIdentidade(rs.getString("ident"));
                chapa.setRamal(rs.getString("ramal"));
                chapa.setDatacad(rs.getDate("data_cad"));
                chapa.setHoracad(LocalTime.parse(rs.getString("hora_cad")));
                chapa.setUser(rs.getString("user_Cad"));
            }
            return chapa;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_atualizaVeiculoPerm");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public boolean insereDependente(Chapa_Dependente dep) {
        LocalTime time = LocalTime.now();
        Date date = new Date();

        String sql = "INSERT INTO chapa_dependentes("
                + "   id_chapa, chapa_active, nome, parentesco, "
                + "   data_cad, nip, ident, hora_cad, user_cad, ip_cad, idade)"
                + "   VALUES ('" + dep.getId_chapa() + "', '" + dep.getChapa_active() + "',"
                + " '" + dep.getNome() + "',  '" + dep.getParentesco() + "', '" + date + "',"
                + " '" + dep.getNip() + "', '" + dep.getIdent() + "', '" + time + "',"
                + "   '" + dep.getUser_cad() + "', '" + dep.getIp_cad() + "', '" + dep.getIdade() + "');";

        if (connectDataBase.openConection() != null) {
            try {
                statement = connectDataBase.openConection().createStatement();
                statement.execute(sql);
                return true;
            } catch (SQLException e) {
                log = new Logger();
                log.Gravar(e.getMessage(), "DaoChapa_atualizarVeiculo");
                return false;
            }
        }
        return false;

    }

    public ArrayList<Chapa_Dependente> buscaDependentesPermissionario(Chapa_Permissionario perm) {
        String consulta = "select * from chapa_dependentes where id_chapa = '" + perm.getId() + "' and chapa_active = '1';";
        ArrayList<Chapa_Dependente> dependentes = new ArrayList<>();
        try {
            if (connectDataBase.openConection() == null) {
                return null;
            }
            statement = connectDataBase.openConection().createStatement();
            ResultSet rs = statement.executeQuery(consulta);

            Chapa_Permissionario chapa = null;
            while (rs.next()) {
                Chapa_Dependente dep = new Chapa_Dependente();
                dep.setId_chapa_dependentes(rs.getInt("id_chapa_dependentes"));
                dep.setId_chapa(perm.getId());
                dep.setChapa_active(rs.getInt("chapa_active"));
                dep.setData_cad(rs.getDate("data_cad"));
                dep.setHora_cad(rs.getTime("hora_cad").toLocalTime());
                dep.setId_chapa(rs.getInt("id_chapa"));
                dep.setIdade(rs.getInt("idade"));
                dep.setIdent(rs.getString("ident"));
                dep.setIp_cad(rs.getString("ip_cad"));
                dep.setNip(rs.getString("nip"));
                dep.setNome(rs.getString("nome"));
                dep.setParentesco(rs.getString("parentesco"));
                dep.setUser_cad(rs.getString("user_cad"));
                dependentes.add(dep);
            }
            return dependentes;
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_BuscaDependentes");
            return null;
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public void deletaVeiculo(String id_Veiculo, String modelo, String placa) {
        String attVeiculo = "UPDATE chapa_veiculo"
                + " SET chapa_active='" + 0 + "'"
                + " WHERE id_chapa_veiculo = '" + id_Veiculo + "';";

        try {
            if (connectDataBase.openConection() == null) {
                return;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(attVeiculo);
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_atualizaVeiculoPerm");
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public void atualizaDependente(Chapa_Dependente dep) {
        LocalTime time = LocalTime.now();
        Date date = new Date();

        String sqlAtt = "UPDATE chapa_dependentes"
                + "   SET id_chapa='" + dep.getId_chapa() + "', nome='" + dep.getNome() + "',"
                + "   parentesco='" + dep.getParentesco() + "', "
                + "   nip='" + dep.getNip() + "', ident='" + dep.getIdent() + "', "
                + "   idade='" + dep.getIdade() + "'"
                + " WHERE id_chapa_dependentes = '" + dep.getId_chapa_dependentes() + "';";

        try {
            if (connectDataBase.openConection() == null) {
                return;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(sqlAtt);
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_atualizaVeiculoPerm");
        } finally {
            connectDataBase.closeConnection();
        }
    }

    public void deletaDependente(int id_dep) {
        String attVeiculo = "UPDATE chapa_dependentes"
                + " SET chapa_active ='" + 0 + "'"
                + " WHERE id_chapa_dependentes = '" + id_dep + "';";

        try {
            if (connectDataBase.openConection() == null) {
                return;
            }
            statement = connectDataBase.openConection().createStatement();
            statement.executeUpdate(attVeiculo);
        } catch (SQLException e) {
            log = new Logger();
            log.Gravar(e.getMessage(), "DaoChapa_atualizaDependentePerm");
        } finally {
            connectDataBase.closeConnection();
        }
    }

    //==========================================================================
    //Historico de Cadastro do Chapa
    //==========================================================================    
    public boolean insertHistoricoChapa(Chapa_historico hist) {
        LocalTime time = LocalTime.now();
        Date date = new Date();

        String sql = "INSERT INTO chapa_historico("+"id_chapa, nip, inicio_moradia, fim_moradia, useralt, "
                + " dataalt, horaalt, ipalt)"
                + " VALUES (" + hist.getId_chapa() + ", \'" + hist.getNip() + "\', \'" + hist.getInicio_moradia() + "\', " + hist.getFim_moradia() + ", \'" + hist.getUseralt() + "\', \'"
                + date + "\', \'" + time + "\', \'" + hist.getIp_cad() + "\');";

        if (connectDataBase.openConection()!=null) {
            try {
                statement = connectDataBase.openConection().createStatement();
                statement.execute(sql);
                return true;
            } catch (SQLException e) {
                log = new Logger();
                log.Gravar(e.getMessage(), "DaoChapa_insertHistoricoChapa()");
                return false;
            }
        }

        return false;
    }

    public void updateHistoricoChapa(Chapa_Permissionario chapa) {
        
    }

    public Chapa_historico selectHistoricoChapa(String nip) {
        return null;
    }

    public boolean deleteHistoricoChapa(String nip) {
        return true;
    }

}
