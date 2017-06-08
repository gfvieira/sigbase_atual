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
public class FolhanItem {

    private String numeroIdentificacao;
    private String nomeMovimentacao;
    private String nomeFantasia;
    private String nomeItem;
    private String categoria;
    private String classificacao;
    private String nomeOm;
    private String siglaOm;
    private String anoGM;
    private double vlUnitario;
    private int qnt;

    /**
     * @return the nomeItem
     */
    public String getNomeItem() {
        return nomeItem;
    }

    /**
     * @param nomeItem the nomeItem to set
     */
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nomeOm
     */
    public String getNomeOm() {
        return nomeOm;
    }

    /**
     * @param nomeOm the nomeOm to set
     */
    public void setNomeOm(String nomeOm) {
        this.nomeOm = nomeOm;
    }

    /**
     * @return the anoGM
     */
    public String getAnoGM() {
        return anoGM;
    }

    /**
     * @param anoGM the anoGM to set
     */
    public void setAnoGM(String anoGM) {
        this.anoGM = anoGM;
    }

    /**
     * @return the siglaOm
     */
    public String getSiglaOm() {
        return siglaOm;
    }

    /**
     * @param siglaOm the siglaOm to set
     */
    public void setSiglaOm(String siglaOm) {
        this.siglaOm = siglaOm;
    }

    /**
     * @return the classificacao
     */
    public String getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the vlUnitario
     */
    public double getVlUnitario() {
        return vlUnitario;
    }

    /**
     * @param vlUnitario the vlUnitario to set
     */
    public void setVlUnitario(double vlUnitario) {
        this.vlUnitario = vlUnitario;
    }

    /**
     * @return the qnt
     */
    public int getQnt() {
        return qnt;
    }

    /**
     * @param qnt the qnt to set
     */
    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    /**
     * @return the numeroIdentificacao
     */
    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    /**
     * @param numeroIdentificacao the numeroIdentificacao to set
     */
    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    /**
     * @return the nomeMovimentacao
     */
    public String getNomeMovimentacao() {
        return nomeMovimentacao;
    }

    /**
     * @param nomeMovimentacao the nomeMovimentacao to set
     */
    public void setNomeMovimentacao(String nomeMovimentacao) {
        this.nomeMovimentacao = nomeMovimentacao;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
