/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=10-04-2017
 */
public class Animal {
    private int idAnimal, idadeAnimal;
    private PorteAnimal FKPorteAnimal;
    private Salvamento FKSalvamento;
    private Abrigo FKAbrigo;
    private String nomeAnimal, racaAnimal ;
    private String sexoAnimal;
    private float pesoAnimal;
    private boolean ehCastrado, estaSaudavel;
    private Doenca FKDoenca;
    
    //getters
    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public PorteAnimal getFKPorteAnimal() {
        return FKPorteAnimal;
    }

    public Salvamento getFKSalvamento() {
        return FKSalvamento;
    }

    public Abrigo getFKAbrigo() {
        return FKAbrigo;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getRacaAnimal() {
        return racaAnimal;
    }

    public String getSexoAnimal() {
        return sexoAnimal;
    }

    public float getPesoAnimal() {
        return pesoAnimal;
    }

    public boolean isEhCastrado() {
        return ehCastrado;
    }

    public boolean isEstaSaudavel() {
        return estaSaudavel;
    }

    public Doenca getFKDoenca() {
        return FKDoenca;
    }
    
    //setters

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public void setFKPorteAnimal(PorteAnimal FKPorteAnimal) {
        this.FKPorteAnimal = FKPorteAnimal;
    }

    public void setFKSalvamento(Salvamento FkSalvamento) {
        this.FKSalvamento = FKSalvamento;
    }

    public void setFKAbrigo(Abrigo FkAbrigo) {
        this.FKAbrigo = FKAbrigo;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public void setSexoAnimal(String sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public void setPesoAnimal(float pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public void setEhCastrado(boolean ehCastrado) {
        this.ehCastrado = ehCastrado;
    }

    public void setEstaSaudavel(boolean estaSaudavel) {
        this.estaSaudavel = estaSaudavel;
    }

    public void setFKDoenca(Doenca FKDoenca) {
        this.FKDoenca = FKDoenca;
    }
    
            
}
