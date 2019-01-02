package model;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-04-2017
 */
public class Abrigo {
    private int idAbrigo;
    private String nomeAbrigo, localAbrigo, responsavelAbrigo;
    private int lotacaoAbrigo;
    

    //getters
    public String getNomeAbrigo() {
        return nomeAbrigo;
    }

    public String getLocalAbrigo() {
        return localAbrigo;
    }

    public String getResponsavelAbrigo() {
        return responsavelAbrigo;
    }

    public int getIdAbrigo() {
        return idAbrigo;
    }

    public int getLotacaoAbrigo() {
        return lotacaoAbrigo;
    }

    //setters
    public void setNomeAbrigo(String nomeAbrigo) {
        this.nomeAbrigo = nomeAbrigo;
    }

    public void setLocalAbrigo(String localAbrigo) {
        this.localAbrigo = localAbrigo;
    }

    public void setResponsavelAbrigo(String responsavelAbrigo) {
        this.responsavelAbrigo = responsavelAbrigo;
    }

    public void setIdAbrigo(int idAbrigo) {
        this.idAbrigo = idAbrigo;
    }

    public void setLotacaoAbrigo(int lotacaoAbrigo) {
        this.lotacaoAbrigo = lotacaoAbrigo;
    }
    
    
}
