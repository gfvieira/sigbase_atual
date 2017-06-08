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
 * @author root
 */
public class Ouvidoria_res {
    
    private String protocolo;
    private String resposta;
    private String usercad;
    private Date datacad;
    private LocalTime horacad;
    private String ipcad;

    /**
     * @return the protocolo
     */
    public String getProtocolo() {
        return protocolo;
    }

    /**
     * @param protocolo the protocolo to set
     */
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the usercad
     */
    public String getUsercad() {
        return usercad;
    }

    /**
     * @param usercad the usercad to set
     */
    public void setUsercad(String usercad) {
        this.usercad = usercad;
    }

    /**
     * @return the datacad
     */
    public Date getDatacad() {
        return datacad;
    }

    /**
     * @param datacad the datacad to set
     */
    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    /**
     * @return the horacad
     */
    public LocalTime getHoracad() {
        return horacad;
    }

    /**
     * @param horacad the horacad to set
     */
    public void setHoracad(LocalTime horacad) {
        this.horacad = horacad;
    }

    /**
     * @return the ipcad
     */
    public String getIpcad() {
        return ipcad;
    }

    /**
     * @param ipcad the ipcad to set
     */
    public void setIpcad(String ipcad) {
        this.ipcad = ipcad;
    }
    
}
