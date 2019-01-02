/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-04-2017
 */
public class Ocorrencia {
    private int idOcorrencia;
    private String descricaoOcorrencia;
    private String dataOcorrencia;
    private String localOcorrencia;
    private String horaOcorrencia;
    
    // Getters
    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public String getDescricaoOcorrencia() {
        return descricaoOcorrencia;
    }

    public String getDataOcorrencia() {
        return dataOcorrencia;
    }

    public String getLocalOcorrencia() {
        return localOcorrencia;
    }

    public String getHoraOcorrencia() {
        return horaOcorrencia;
    }
    
    
    // Setters
    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public void setDescricaoOcorrencia(String descricaoOcorrencia) {
        this.descricaoOcorrencia = descricaoOcorrencia;
    }

    public void setDataOcorrencia(String dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public void setLocalOcorrencia(String localOcorrencia) {
        this.localOcorrencia = localOcorrencia;
    }

    public void setHoraOcorrencia(String horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }
    
}
