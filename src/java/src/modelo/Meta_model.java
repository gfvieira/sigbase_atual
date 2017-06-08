/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

/**
 *
 * @author root
 */
public class Meta_model {
    private int id;
    private String meta;
    private int tipo;
    private int ano;
    private int concluido;
    private int setor;
    private String user;
    private int userDiv;
    private String ipCad;

    /**
     * @return the meta
     */
    public String getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(String meta) {
        this.meta = meta;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the setor
     */
    public int getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(int setor) {
        this.setor = setor;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the userDiv
     */
    public int getUserDiv() {
        return userDiv;
    }

    /**
     * @param userDiv the userDiv to set
     */
    public void setUserDiv(int userDiv) {
        this.userDiv = userDiv;
    }

    /**
     * @return the concluido
     */
    public int getConcluido() {
        return concluido;
    }

    /**
     * @param concluido the concluido to set
     */
    public void setConcluido(int concluido) {
        this.concluido = concluido;
    }

    /**
     * @return the ipCad
     */
    public String getIpCad() {
        return ipCad;
    }

    /**
     * @param ipCad the ipCad to set
     */
    public void setIpCad(String ipCad) {
        this.ipCad = ipCad;
    }

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
    
    
}
