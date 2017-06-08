package src.modelo;

import java.time.LocalTime;
import java.util.Date;

public class Ouvidoria_model {
    
    private int id;
    private String protocolo;
    private String nome;
    private String email;
    private String contato;
    private String mensagem;
    private int situacao;
    private String situacaoName;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
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

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    /**
     * @return the situacaoName
     */
    public String getSituacaoName() {
        return situacaoName;
    }

    /**
     * @param situacaoName the situacaoName to set
     */
    public void setSituacaoName(String situacaoName) {
        this.situacaoName = situacaoName;
    }
    
}
