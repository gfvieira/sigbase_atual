package src.modelo;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Chapa_Veiculo {

    private int id_chapa;

    
    private int id_Veiculo;
    private int chapa_active;
    private String modelo;
    private String placa;
    private String user;
    private String ip;
    private Date datacad;
    private LocalTime horacad;
    
    
    public int getId_Veiculo() {
        return id_Veiculo;
    }

    public void setId_Veiculo(int id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }

    public int getId_chapa() {
        return id_chapa;
    }

    public void setId_chapa(int id_chapa) {
        this.id_chapa = id_chapa;
    }

    public int getChapa_active() {
        return chapa_active;
    }

    public void setChapa_active(int chapa_active) {
        this.chapa_active = chapa_active;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDatacad() {
        return datacad;
    }

    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    public LocalTime getHoracad() {
        return horacad;
    }

    public void setHoracad(LocalTime horacad) {
        this.horacad = horacad;
    }
    
    
}
