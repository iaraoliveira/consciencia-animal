/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-14-2017
 */
public class TipoAnimal {
    private int idTipoAnimal;
    private String nomeTipoAnimal;
    
    //getters

    public int getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public String getNomeTipoAnimal() {
        return nomeTipoAnimal;
    }
    
    //setters

    public void setIdTipoAnimal(int idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public void setNomeTipoAnimal(String nomeTipoAnimal) {
        this.nomeTipoAnimal = nomeTipoAnimal;
    }
    
    
}
