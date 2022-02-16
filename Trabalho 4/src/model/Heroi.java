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
public class Heroi{
    private int id;
    private String nome;
    private double forcageral; 
    
    public Heroi() {
    }

    public Heroi(int id, String nome, double forcageral) {
        this.id = id;
        this.nome = nome;
        this.forcageral = forcageral;
    }
    
    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getNome() + "\n";
        resposta += this.getForcaGeral() + "\n";
        return resposta;
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
     * @return the forca
     */
    public double getForcaGeral() {
        return forcageral;
    }


    public void setForca(int forcageral) {
        this.forcageral = forcageral;
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
