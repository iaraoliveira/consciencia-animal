/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Alunos
 */
public class Utilitarios {

    public static final int NAO_FOI_POSSIVEL_INSERIR = 0;
    public static final int NAO_FOI_POSSIVEL_ALTERAR = 0;
    public static int NAO_FOI_POSSIVEL_EXCLUIR = 0;

    public static String retornarPadraoBR(String dataOcorrencia) {
        String[] numeros = dataOcorrencia.split("-");
        return numeros[2] + "/" + numeros[1] + "/" + numeros[0];
    }
    
    public static String retorarPadraoUS(String dataOcorrencia){
        String numeros[] = dataOcorrencia.split("/");
        return numeros[2] + "-" + numeros[1] + "-" + numeros[0];
    }
    
}
