package src.modelo;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author oficina
 */
public class Pedido_model {

    private String os;
    private String post;
    private String nome;
    private String nip;
    private String ramal;
    private String setor;
    private String atendimento;
    private String equipamento;
    private String solicitacao;
    private String descricao;
    private String obs;
    private String status;
    private int priori;
    private int pob;
    private int feedback;
    private String move;
    private Date dataevento;
    private LocalTime horaevento;
    private LocalTime horafim;
    private Date datacad;
    private LocalTime horacad;
    private int qnt;
    private String ip;

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
     * @return the ramal
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * @param ramal the ramal to set
     */
    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the atendimento
     */
    public String getAtendimento() {
        return atendimento;
    }

    /**
     * @param atendimento the atendimento to set
     */
    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    /**
     * @return the equipamento
     */
    public String getEquipamento() {
        return equipamento;
    }

    /**
     * @param equipamento the equipamento to set
     */
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * @return the solicitacao
     */
    public String getSolicitacao() {
        return solicitacao;
    }

    /**
     * @param solicitacao the solicitacao to set
     */
    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the datacad
     */
    public String getDatacad() {
        return datacad.toString();
    }

    /**
     * @param datacad the datacad to set
     */
    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }

    /**
     * @return the move
     */
    public String getMove() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(String move) {
        this.move = move;
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
     * @return the feedback
     */
    public int getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    /**
     * @return the priori
     */
    public int getPriori() {
        return priori;
    }

    /**
     * @param priori the priori to set
     */
    public void setPriori(int priori) {
        this.priori = priori;
    }

    /**
     * @return the dataevento
     */
    public Date getDataevento() {
        return dataevento;
    }

    /**
     * @param dataevento the dataevento to set
     */
    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }

    /**
     * @return the horaevento
     */
    public LocalTime getHoraevento() {
        return horaevento;
    }

    /**
     * @param horaevento the horaevento to set
     */
    public void setHoraevento(LocalTime horaevento) {
        this.horaevento = horaevento;
    }

    /**
     * @return the pob
     */
    public int getPob() {
        return pob;
    }

    /**
     * @param pob the pob to set
     */
    public void setPob(int pob) {
        this.pob = pob;
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

    /**
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return the horafim
     */
    public LocalTime getHorafim() {
        return horafim;
    }

    /**
     * @param horafim the horafim to set
     */
    public void setHorafim(LocalTime horafim) {
        this.horafim = horafim;
    }

}
