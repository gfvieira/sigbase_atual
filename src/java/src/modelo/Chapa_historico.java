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
 * @author telematica
 */
public class Chapa_historico {
    
    private int id_chapa_hist;
    private int id_chapa;
    private String nip;
    private Date inicio_moradia;
    private Date fim_moradia;
    private String useralt;
    private Date dataalt;
    private LocalTime horaalt;
    private String ip_cad;

    /**
     * @return the id_chapa_hist
     */
    public int getId_chapa_hist() {
        return id_chapa_hist;
    }

    /**
     * @param id_chapa_hist the id_chapa_hist to set
     */
    public void setId_chapa_hist(int id_chapa_hist) {
        this.id_chapa_hist = id_chapa_hist;
    }

    /**
     * @return the id_chapa
     */
    public int getId_chapa() {
        return id_chapa;
    }

    /**
     * @param id_chapa the id_chapa to set
     */
    public void setId_chapa(int id_chapa) {
        this.id_chapa = id_chapa;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return the inicio_moradia
     */
    public Date getInicio_moradia() {
        return inicio_moradia;
    }

    /**
     * @param inicio_moradia the inicio_moradia to set
     */
    public void setInicio_moradia(Date inicio_moradia) {
        this.inicio_moradia = inicio_moradia;
    }

    /**
     * @return the fim_moradia
     */
    public Date getFim_moradia() {
        return fim_moradia;
    }

    /**
     * @param fim_moradia the fim_moradia to set
     */
    public void setFim_moradia(Date fim_moradia) {
        this.fim_moradia = fim_moradia;
    }

    /**
     * @return the useralt
     */
    public String getUseralt() {
        return useralt;
    }

    /**
     * @param useralt the useralt to set
     */
    public void setUseralt(String useralt) {
        this.useralt = useralt;
    }

    /**
     * @return the dataalt
     */
    public Date getDataalt() {
        return dataalt;
    }

    /**
     * @param dataalt the dataalt to set
     */
    public void setDataalt(Date dataalt) {
        this.dataalt = dataalt;
    }

    /**
     * @return the horaalt
     */
    public LocalTime getHoraalt() {
        return horaalt;
    }

    /**
     * @param horaalt the horaalt to set
     */
    public void setHoraalt(LocalTime horaalt) {
        this.horaalt = horaalt;
    }

    /**
     * @return the ip_cad
     */
    public String getIp_cad() {
        return ip_cad;
    }

    /**
     * @param ip_cad the ip_cad to set
     */
    public void setIp_cad(String ip_cad) {
        this.ip_cad = ip_cad;
    }
}
