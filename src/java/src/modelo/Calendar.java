/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

/**
 *
 * @author gustavo
 */
public class Calendar {
    private String ano_start;
    private String mes_start;
    private String dia_start;
    private String ano_end;
    private String mes_end;
    private String dia_end;
    private String title;
    private boolean allDay;

    /**
     * @return the ano_start
     */
    public String getAno_start() {
        return ano_start;
    }

    /**
     * @param ano_start the ano_start to set
     */
    public void setAno_start(String ano_start) {
        this.ano_start = ano_start;
    }

    /**
     * @return the mes_start
     */
    public String getMes_start() {
        return mes_start;
    }

    /**
     * @param mes_start the mes_start to set
     */
    public void setMes_start(String mes_start) {
        this.mes_start = mes_start;
    }

    /**
     * @return the dia_start
     */
    public String getDia_start() {
        return dia_start;
    }

    /**
     * @param dia_start the dia_start to set
     */
    public void setDia_start(String dia_start) {
        this.dia_start = dia_start;
    }

    /**
     * @return the ano_end
     */
    public String getAno_end() {
        return ano_end;
    }

    /**
     * @param ano_end the ano_end to set
     */
    public void setAno_end(String ano_end) {
        this.ano_end = ano_end;
    }

    /**
     * @return the mes_end
     */
    public String getMes_end() {
        return mes_end;
    }

    /**
     * @param mes_end the mes_end to set
     */
    public void setMes_end(String mes_end) {
        this.mes_end = mes_end;
    }

    /**
     * @return the dia_end
     */
    public String getDia_end() {
        return dia_end;
    }

    /**
     * @param dia_end the dia_end to set
     */
    public void setDia_end(String dia_end) {
        this.dia_end = dia_end;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the allDay
     */
    public boolean isAllDay() {
        return allDay;
    }

    /**
     * @param allDay the allDay to set
     */
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
    
    
    
    
}
