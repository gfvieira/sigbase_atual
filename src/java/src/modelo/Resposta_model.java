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
public class Resposta_model {
    
    private String pergunta;
    private double respSim;
    private double respNa;
    private double total;
    private String dep;

    /**
     * @return the respSim
     */
    public double getRespSim() {
        return respSim;
    }

    /**
     * @param respSim the respSim to set
     */
    public void setRespSim(double respSim) {
        this.respSim = respSim;
    }

    /**
     * @return the respNa
     */
    public double getRespNa() {
        return respNa;
    }

    /**
     * @param respNa the respNa to set
     */
    public void setRespNa(double respNa) {
        this.respNa = respNa;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the dep
     */
    public String getDep() {
        return dep;
    }

    /**
     * @param dep the dep to set
     */
    public void setDep(String dep) {
        this.dep = dep;
    }

    /**
     * @return the pergunta
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * @param pergunta the pergunta to set
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

}
