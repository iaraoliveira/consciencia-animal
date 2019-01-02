/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-05-2017
 */
public class PorteAnimal {
    private int idPorteAnimal;
    private String nomePorteAnimal;
    
    //getters

    public int getIdPorteAnimal() {
        return idPorteAnimal;
    }

    public String getNomePorteAnimal() {
        return nomePorteAnimal;
    }
    
    //setters

    public void setIdPorteAnimal(int idPorteAnimal) {
        this.idPorteAnimal = idPorteAnimal;
    }

    public void setNomePorteAnimal(String nomePorteAnimal) {
        this.nomePorteAnimal = nomePorteAnimal;
    }
    
}
