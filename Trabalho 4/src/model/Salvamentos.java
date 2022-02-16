/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joeda
 */
public class Salvamentos{
    private int id; // id dia
    private int heroi; // id heroi
    private int qtSalvamento; // quantidade de salvamentos que o heroi x realizou em y dia
    
    public Salvamentos() {
    }

    public Salvamentos(int id, int heroi, int qtSalvamento) {
        this.id = id;
        this.heroi = heroi;
        this.qtSalvamento = qtSalvamento;
    }
    
    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getHeroi() + "\n";
        resposta += this.getQtSalvamento() + "\n";
        return resposta;
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
     * @return the heroi
     */
    public int getHeroi() {
        return heroi;
    }

    /**
     * @param heroi the heroi to set
     */
    public void setHeroi(int heroi) {
        this.heroi = heroi;
    }

    /**
     * @return the qtSalvamento
     */
    public int getQtSalvamento() {
        return qtSalvamento;
    }

    /**
     * @param qtSalvamento the qtSalvamento to set
     */
    public void setQtSalvamento(int qtSalvamento) {
        this.qtSalvamento = qtSalvamento;
    }

 
    
}
