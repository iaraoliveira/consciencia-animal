package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AbrigoDAO;
import database.Conexao;
import database.Utilitarios;
import model.Abrigo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-11-2017
 */
public class AbrigoDAOJUnitTest {
    
    @Test
    public void inserir(){
        Conexao.truncate();
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Teste Abrigo");
        abrigo.setLocalAbrigo("Escola Agricola");
        abrigo.setLotacaoAbrigo(50);
        abrigo.setResponsavelAbrigo("Letícia");
        int codigoInserido = new AbrigoDAO().inserir(abrigo);
         assertEquals(1, codigoInserido);
    }
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Outro Abrigo");
        abrigo.setLocalAbrigo("Centro");
        abrigo.setLotacaoAbrigo(100);
        abrigo.setResponsavelAbrigo("José");
        int codigoInserido = new AbrigoDAO().inserir(abrigo);
        abrigo.setIdAbrigo(codigoInserido);
        
        Abrigo abrigoBuscado  = new AbrigoDAO().buscarAbrigoPorId(codigoInserido);
        
        assertEquals(abrigo.getIdAbrigo(), abrigoBuscado.getIdAbrigo());
        assertEquals(abrigo.getNomeAbrigo(), abrigoBuscado.getNomeAbrigo());
        assertEquals(abrigo.getLocalAbrigo(), abrigoBuscado.getLocalAbrigo());
        assertEquals(abrigo.getLotacaoAbrigo(), abrigoBuscado.getLotacaoAbrigo());
        assertEquals(abrigo.getResponsavelAbrigo(), abrigoBuscado.getResponsavelAbrigo());
    }
    
    @Test
    public void alterar(){
        Conexao.truncate();
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Mais um Teste");
        abrigo.setLocalAbrigo("Centro");
        abrigo.setLotacaoAbrigo(80);
        abrigo.setResponsavelAbrigo("Maria");
        int codigoInserido = new AbrigoDAO().inserir(abrigo);
        abrigo.setIdAbrigo(codigoInserido);
        
        abrigo.setNomeAbrigo("Mais um Teste 2");
        abrigo.setLocalAbrigo("Velha");
        abrigo.setLotacaoAbrigo(100);
        abrigo.setResponsavelAbrigo("Letícia");
        int codigoAlterado = new AbrigoDAO().alterar(abrigo);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        Abrigo abrigoBuscado = new AbrigoDAO().buscarAbrigoPorId(abrigo.getIdAbrigo());
    }
    
    @Test
    public void excluir(){
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Teste Abrigo");
        abrigo.setLocalAbrigo("Escola Agricola");
        abrigo.setLotacaoAbrigo(50);
        abrigo.setResponsavelAbrigo("Letícia");
      
        AbrigoDAO dao = new AbrigoDAO();
        dao.truncate();
        int codigo = dao.inserir(abrigo);
        dao.excluir(codigo);

        Abrigo carroBuscado = dao.buscarAbrigoPorId(codigo);
        assertNull(carroBuscado);
    }
    
}
