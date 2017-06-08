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
public class Indicador_model_anual {
    
    private double total;
    private double totalAberto;
    private double totalFechado;
    private String mes;
    private String ano;
    private String oficina;

    /**
     * @return the totalAberto
     */
    public double getTotalAberto() {
        return totalAberto;
    }

    /**
     * @param totalAberto the totalAberto to set
     */
    public void setTotalAberto(double totalAberto) {
        this.totalAberto = totalAberto;
    }

    /**
     * @return the totalFechado
     */
    public double getTotalFechado() {
        return totalFechado;
    }

    /**
     * @param totalFechado the totalFechado to set
     */
    public void setTotalFechado(double totalFechado) {
        this.totalFechado = totalFechado;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the oficina
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
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
    
}
