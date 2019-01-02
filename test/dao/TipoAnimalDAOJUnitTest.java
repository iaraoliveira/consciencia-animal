/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import database.Utilitarios;
import model.TipoAnimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class TipoAnimalDAOJUnitTest {
    
    @Test
    public void inserir(){
        Conexao.truncate();
        TipoAnimal tipoAnimal = new TipoAnimal();
        tipoAnimal.setNomeTipoAnimal("Grande");
        int codigoInserido = new TipoAnimalDAO().inserir(tipoAnimal);
        
    }
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        TipoAnimal tipoAnimal = new TipoAnimal();
        tipoAnimal.setNomeTipoAnimal("Grande");
        int codigoInserido = new TipoAnimalDAO().inserir(tipoAnimal);
        tipoAnimal.setIdTipoAnimal(codigoInserido);
        
        TipoAnimal tipoAnimalBuscado  = new TipoAnimalDAO().buscarTipoAnimalPorId(codigoInserido);
        
        assertEquals(tipoAnimal.getIdTipoAnimal(), tipoAnimalBuscado.getIdTipoAnimal());
        assertEquals(tipoAnimal.getNomeTipoAnimal(), tipoAnimalBuscado.getNomeTipoAnimal());
    }
    
    @Test
    public void alterar(){
        Conexao.truncate();
        TipoAnimal tipoAnimal = new TipoAnimal();
        tipoAnimal.setNomeTipoAnimal("Grande");
        int codigoInserido = new TipoAnimalDAO().inserir(tipoAnimal);
        tipoAnimal.setIdTipoAnimal(codigoInserido);
        
        tipoAnimal.setNomeTipoAnimal("Médio");

        int codigoAlterado = new TipoAnimalDAO().alterar(tipoAnimal);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        TipoAnimal tipoAnimalBuscado = new TipoAnimalDAO().buscarTipoAnimalPorId(tipoAnimal.getIdTipoAnimal());
    }
    
}
