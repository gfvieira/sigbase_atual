/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Logon extends Usuario{
    
    private String id_session;
    private String ip;
     private Date data;
    private LocalTime hora;

    /**
     * @return the id_session
     */
    public String getId_session() {
        return id_session;
    }

    /**
     * @param id_session the id_session to set
     */
    public void setId_session(String id_session) {
        this.id_session = id_session;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
}
