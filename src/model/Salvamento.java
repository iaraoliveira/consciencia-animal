package model;

import java.sql.Date;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-05-2017
 */
public class Salvamento {
    
    private int idSalvamento;
    private Veiculo FKVeiculo;
    private Ocorrencia FKOcorrencia;
    private String dataSalvamento;
    private String horaSalvamento;
    private String localSalvamento;
    private String jesusSalvador;
    
    // Getters

    public int getIdSalvamento() {
        return idSalvamento;
    }

    public Veiculo getFKVeiculo() {
        return FKVeiculo;
    }

    public Ocorrencia getFKOcorrencia() {
        return FKOcorrencia;
    }

    public String getDataSalvamento() {
        return dataSalvamento;
    }

    public String getHoraSalvamento() {
        return horaSalvamento;
    }

    public String getLocalSalvamento() {
        return localSalvamento;
    }

    public String getJesusSalvador() {
        return jesusSalvador;
    }
    
    // Setter

    public void setIdSalvamento(int idSalvamento) {
        this.idSalvamento = idSalvamento;
    }

    public void setFKVeiculo(Veiculo FKVeiculo) {
        this.FKVeiculo = FKVeiculo;
    }

    public void setFKOcorrencia(Ocorrencia FKOcorrencia) {
        this.FKOcorrencia = FKOcorrencia;
    }

    public void setDataSalvamento(String dataSalvamento) {
        this.dataSalvamento = dataSalvamento;
    }

    public void setHoraSalvamento(String horaSalvamento) {
        this.horaSalvamento = horaSalvamento;
    }

    public void setLocalSalvamento(String localSalvamento) {
        this.localSalvamento = localSalvamento;
    }

    public void setJesusSalvador(String jesusSalvador) {
        this.jesusSalvador = jesusSalvador;
    }

    
    
            
}
