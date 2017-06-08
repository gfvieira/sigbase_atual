/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo.pesquisa;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Pergunta_model {
    
    private String pergunta1;
    private String pergunta2;
    private String pergunta3;
    private String usercad;
    private Date datacad;
    private LocalTime horacad;

    /**
     * @return the pergunta1
     */
    public String getPergunta1() {
        return pergunta1;
    }

    /**
     * @param pergunta1 the pergunta1 to set
     */
    public void setPergunta1(String pergunta1) {
        this.pergunta1 = pergunta1;
    }

    /**
     * @return the pergunta2
     */
    public String getPergunta2() {
        return pergunta2;
    }

    /**
     * @param pergunta2 the pergunta2 to set
     */
    public void setPergunta2(String pergunta2) {
        this.pergunta2 = pergunta2;
    }

    /**
     * @return the pergunta3
     */
    public String getPergunta3() {
        return pergunta3;
    }

    /**
     * @param pergunta3 the pergunta3 to set
     */
    public void setPergunta3(String pergunta3) {
        this.pergunta3 = pergunta3;
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
    
}
