package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.TipoVeiculoDAO;
import dao.VeiculoDAO;
import database.Conexao;
import database.Utilitarios;
import model.TipoVeiculo;
import model.Veiculo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class VeiculoDAOJUnitTest {
    
    @Test
    public void inserir(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
         assertEquals(1, codigoInserido);
        tipoVeiculo.setIdTipoVeiculo(codigoInserido);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModeloVeiculo("Modelo");
        veiculo.setPlacaVeiculo("Placa");
        veiculo.setFabricanteVeiculo("Fabricante");
        veiculo.setEstaDisponivel(true);
        veiculo.setFKTipoVeiculo(tipoVeiculo);
        codigoInserido = new VeiculoDAO().inserir(veiculo);
         assertEquals(1, codigoInserido);
    }
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
         assertEquals(1, codigoInserido);
         tipoVeiculo.setIdTipoVeiculo(codigoInserido);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModeloVeiculo("Modelo 2");
        veiculo.setPlacaVeiculo("Placa 2");
        veiculo.setFabricanteVeiculo("Fabricante 2");
        veiculo.setEstaDisponivel(true);
        veiculo.setFKTipoVeiculo(tipoVeiculo);
        codigoInserido = new VeiculoDAO().inserir(veiculo);
        assertEquals(1, codigoInserido);
        veiculo.setIdVeiculo(codigoInserido);
        
        Veiculo veiculoBuscado  = new VeiculoDAO().buscarVeiculoPorId(codigoInserido);
        //assertNotNull(veiculoBuscado);
        assertEquals(veiculo.getIdVeiculo(), veiculoBuscado.getIdVeiculo());
        assertEquals(veiculo.getModeloVeiculo(), veiculoBuscado.getModeloVeiculo());
        assertEquals(veiculo.getPlacaVeiculo(), veiculoBuscado.getPlacaVeiculo());
        assertEquals(veiculo.getFabricanteVeiculo(), veiculoBuscado.getFabricanteVeiculo());
        assertEquals(veiculo.isEstaDisponivel(), veiculoBuscado.isEstaDisponivel());
        assertEquals(veiculo.getFKTipoVeiculo().getIdTipoVeiculo(), veiculoBuscado.getFKTipoVeiculo().getIdTipoVeiculo());
    }
    
    @Test
    public void alterar(){
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
         assertEquals(1, codigoInserido);
        tipoVeiculo.setIdTipoVeiculo(codigoInserido);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModeloVeiculo("Modelo 1");
        veiculo.setPlacaVeiculo("Placa 1");
        veiculo.setFabricanteVeiculo("Fabricante 1");
        veiculo.setEstaDisponivel(true);
        veiculo.setFKTipoVeiculo(tipoVeiculo);
        codigoInserido = new VeiculoDAO().inserir(veiculo);
        veiculo.setIdVeiculo(codigoInserido);
        
        veiculo.setModeloVeiculo("Modelo 2");
        veiculo.setPlacaVeiculo("Placa 2");
        veiculo.setFabricanteVeiculo("Fabricante 2");
        veiculo.setEstaDisponivel(false);
        veiculo.setFKTipoVeiculo(tipoVeiculo);
        int codigoAlterado = new VeiculoDAO().alterar(veiculo);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        Veiculo veiculoBuscado = new VeiculoDAO().buscarVeiculoPorId(veiculo.getIdVeiculo());
    }
    
}
