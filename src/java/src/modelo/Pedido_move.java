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
 * @author oficina
 */
public class Pedido_move {

    private int id;
    private String os;
    private String descricao_move;
    private String of;
    private Date datacadmov;
    private LocalTime horacadmov;
    private String ip;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the descricao_move
     */
    public String getDescricao_move() {
        return descricao_move;
    }

    /**
     * @param descricao_move the descricao_move to set
     */
    public void setDescricao_move(String descricao_move) {
        this.descricao_move = descricao_move;
    }

    /**
     * @return the of
     */
    public String getOf() {
        return of;
    }

    /**
     * @param of the of to set
     */
    public void setOf(String of) {
        this.of = of;
    }

    /**
     * @return the datacadmov
     */
    public Date getDatacadmov() {
        return datacadmov;
    }

    /**
     * @param datacadmov the datacadmov to set
     */
    public void setDatacadmov(Date datacadmov) {
        this.datacadmov = datacadmov;
    }

    /**
     * @return the horacadmov
     */
    public LocalTime getHoracadmov() {
        return horacadmov;
    }

    /**
     * @param horacadmov the horacadmov to set
     */
    public void setHoracadmov(LocalTime horacadmov) {
        this.horacadmov = horacadmov;
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

}
