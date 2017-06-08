package src.modelo;

import java.io.Serializable;
import java.util.ArrayList;
 
public class ModeloGraficoItem implements Serializable {
 
    private String oficina;
    private String tipo;
    private int quantidade;
 
    public ModeloGraficoItem() {
    }
 
    public ModeloGraficoItem(String mes, String produto, int quantidade) {
        this.oficina = mes;
        this.tipo = produto;
        this.quantidade = quantidade;
    }
 
    public String getOficina() {
        return oficina;
    }
 
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    public int getQuantidade() {
        return quantidade;
    }
 
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}