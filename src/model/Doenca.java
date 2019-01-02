/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-06-2017
 */
public class Doenca {
    private int idDoenca;
    private String nomeDoenca;
    private Animal animal;

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal FKAnimal) {
        this.animal = FKAnimal;
    }

    public void setsetIdDoenca(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
