package src.modelo;

import java.time.LocalTime;
import java.util.Date;

public class Chapa_Dependente {
    
    private int id_chapa;
    private int id_chapa_dependentes;
    private int chapa_active;
    private String nome;
    private String parentesco;
    private int idade;
    private String nip;
    private String ident;
    private Date data_cad;
    private LocalTime hora_cad;
    private String user_cad;
    private String ip_cad;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    public int getId_chapa() {
        return id_chapa;
    }

    public void setId_chapa(int id_chapa) {
        this.id_chapa = id_chapa;
    }

    public int getChapa_active() {
        return chapa_active;
    }

    public void setChapa_active(int chapa_active) {
        this.chapa_active = chapa_active;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Date getData_cad() {
        return data_cad;
    }

    public void setData_cad(Date data_cad) {
        this.data_cad = data_cad;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public LocalTime getHora_cad() {
        return hora_cad;
    }

    public void setHora_cad(LocalTime hora_cad) {
        this.hora_cad = hora_cad;
    }

    public String getUser_cad() {
        return user_cad;
    }

    public void setUser_cad(String user_cad) {
        this.user_cad = user_cad;
    }

    public String getIp_cad() {
        return ip_cad;
    }

    public void setIp_cad(String ip_cad) {
        this.ip_cad = ip_cad;
    }

    /**
     * @return the id_chapa_dependentes
     */
    public int getId_chapa_dependentes() {
        return id_chapa_dependentes;
    }

    /**
     * @param id_chapa_dependentes the id_chapa_dependentes to set
     */
    public void setId_chapa_dependentes(int id_chapa_dependentes) {
        this.id_chapa_dependentes = id_chapa_dependentes;
    }
    
}
