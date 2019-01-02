package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.PorteAnimalDAO;
import database.Conexao;
import model.PorteAnimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class PorteAnimalDAOJUnitTest {
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        PorteAnimal porteAnimal = new PorteAnimal();
        porteAnimal.setNomePorteAnimal("Médio");
        int codigoInserido = new PorteAnimalDAO().inserir(porteAnimal);
        porteAnimal.setIdPorteAnimal(codigoInserido);
        
        PorteAnimal porteBuscado  = new PorteAnimalDAO().buscarPorteAnimalPorId(codigoInserido);
        assertNotNull(porteBuscado);
        assertEquals(porteAnimal.getIdPorteAnimal(), porteBuscado.getIdPorteAnimal());
        assertEquals(porteAnimal.getNomePorteAnimal(), porteBuscado.getNomePorteAnimal());
    }
    
}
