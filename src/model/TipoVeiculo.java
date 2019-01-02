/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-04-2017
 */
public class TipoVeiculo {

    private int idTipoVeiculo;
    private String nomeTipoVeiculo;

    // Getters
    public int getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public String getNomeTipoVeiculo() {
        return nomeTipoVeiculo;
    }

    // Setters
    public void setIdTipoVeiculo(int idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public void setNomeTipoVeiculo(String nomeTipoVeiculo) {
        this.nomeTipoVeiculo = nomeTipoVeiculo;
    }

    @Override
    public String toString() {
        return nomeTipoVeiculo;
    }

}
