/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-04-2017
 */
public class Veiculo {
    private int idVeiculo;
    private String modeloVeiculo, placaVeiculo, fabricanteVeiculo;
    private boolean estaDisponivel;
    private TipoVeiculo FKTipoVeiculo;
    
    // Getters

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getFabricanteVeiculo() {
        return fabricanteVeiculo;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public TipoVeiculo getFKTipoVeiculo() {
        return FKTipoVeiculo;
    }
    
    // Setters

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setFabricanteVeiculo(String fabricanteVeiculo) {
        this.fabricanteVeiculo = fabricanteVeiculo;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }

    public void setFKTipoVeiculo(TipoVeiculo FKTipoVeiculo) {
        this.FKTipoVeiculo = FKTipoVeiculo;
    }

    @Override
    public String toString() {
        return placaVeiculo;
    }
    
    
    
}
