package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.TipoVeiculoDAO;
import database.Conexao;
import model.TipoVeiculo;
import org.junit.Test;
import database.Utilitarios;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class TipoVeiculoDAOJUnitTest {
    
    @Test
    public void inserir(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
         assertEquals(1, codigoInserido);
    }
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Outro Abrigo");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
        tipoVeiculo.setIdTipoVeiculo(codigoInserido);
        
        TipoVeiculo tipoVeiculoBuscado  = new TipoVeiculoDAO().buscarTipoVeiculoPorId(codigoInserido);
        assertNotNull(tipoVeiculoBuscado);
        assertEquals(tipoVeiculo.getIdTipoVeiculo(), tipoVeiculoBuscado.getIdTipoVeiculo());
        assertEquals(tipoVeiculo.getNomeTipoVeiculo(), tipoVeiculoBuscado.getNomeTipoVeiculo());
    }
    
    @Test
    public void alterar(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo C");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
        tipoVeiculo.setIdTipoVeiculo(codigoInserido);
        
        tipoVeiculo.setNomeTipoVeiculo("Abrigo B");
        int codigoAlterado = new TipoVeiculoDAO().alterar(tipoVeiculo);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        TipoVeiculo tipoVeiculoBuscado = new TipoVeiculoDAO().buscarTipoVeiculoPorId(tipoVeiculo.getIdTipoVeiculo());
    }
    
}
