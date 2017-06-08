package src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.modelo.Chapa_Apendice;

/**
 *
 * @author telematica
 */
public class DaoApendiceChapa {

    private ConnectDataBase connection;
    private Statement statement;

    public DaoApendiceChapa() {
        connection = new ConnectDataBase();
    }

    public void insereApendiceChapa(Chapa_Apendice ap) {
        LocalTime hora = LocalTime.now();
        String insert = "INSERT INTO chapa_apendice_arq("
                + " id_chapa, chapa_active, nip, arq1, arq2, arq3, arq4, arq5, arq6,"
                + " hora_cad, user_cad, ip_cad)"
                + " VALUES ('" + ap.getId_chapa() + "', '1','" + ap.getNip() + "', '" + ap.getArq1() + "', "
                + " '" + ap.getArq2() + "', '" + ap.getArq3() + "', '" + ap.getArq4() + "', '" + ap.getArq5() + "', "
                + " '" + ap.getArq6() + "', "
                + " '" + hora + "', '" + ap.getUser_cad() + "', '" + ap.getIp_cad() + "');";

        try {
            if (connection.openConection() == null) {
                return;
            }
            statement = connection.openConection().createStatement();

            int okay = statement.executeUpdate(insert);

        } catch (SQLException ex) {
            Logger.getLogger(DaoApendiceChapa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletaApendiceChapa(int nip) {
        LocalTime hora = LocalTime.now();
        String delete = "update chapa_apendice_arq set chapa_active = 0 where nip = '" + nip + "';";

        try {
            if (connection.openConection() == null) {
                return;
            }
            statement = connection.openConection().createStatement();

            int okay = statement.executeUpdate(delete);

        } catch (SQLException ex) {
            Logger.getLogger(DaoApendiceChapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean attApendiceChapa(String nip, int numArq, String novoCaminho) {
        LocalTime hora = LocalTime.now();
        String att = "update chapa_apendice_arq set arq" + numArq + " = '" + novoCaminho + "' where nip = '" + nip + "';";

        try {
            if (connection.openConection() == null) {
                return false;
            }
            statement = connection.openConection().createStatement();

            int okay = statement.executeUpdate(att);

            if (okay != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoApendiceChapa.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Chapa_Apendice buscaApendiceChapa(String nip) {
        Chapa_Apendice ap = new Chapa_Apendice();

        String consulta = "SELECT *"
                + "  FROM chapa_apendice_arq"
                + " WHERE nip = '" + nip + "' and chapa_active = 1;";

        try {
            if (connection.openConection() == null) {
                return null;
            }
            statement = connection.openConection().createStatement();
            ResultSet resp = statement.executeQuery(consulta);

            if (!resp.next()) {
                return null;
            } else {
                do {
                    ap.setArq1(resp.getString("arq1"));
                    ap.setArq2(resp.getString("arq2"));
                    ap.setArq3(resp.getString("arq3"));
                    ap.setArq4(resp.getString("arq4"));
                    ap.setArq5(resp.getString("arq5"));
                    ap.setArq6(resp.getString("arq6"));
                    ap.setHora_cad(resp.getString("hora_cad"));
                    ap.setId_chapa(Integer.parseInt(resp.getString("id_chapa")));
                    ap.setIp_cad(resp.getString("ip_cad"));
                    ap.setNip(nip);
                    ap.setUser_cad(resp.getString("user_cad"));
                } while (resp.next());
            }

            return ap;
        } catch (SQLException ex) {
            Logger.getLogger(DaoApendiceChapa.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
