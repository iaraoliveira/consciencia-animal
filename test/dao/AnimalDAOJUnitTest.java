package dao;


import dao.AbrigoDAO;
import dao.AnimalDAO;
import database.Conexao;
import database.Utilitarios;
import java.sql.Date;
import java.sql.SQLException;
import model.Abrigo;
import model.Animal;
import model.Doenca;
import model.Ocorrencia;
import model.PorteAnimal;
import model.Salvamento;
import model.TipoVeiculo;
import model.Veiculo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-11-2017
 */
public class AnimalDAOJUnitTest {
   
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
        abrigo.setIdAbrigo(codigoInserido);
        
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataOcorrencia("11/09/2017");
        ocorrencia.setDescricaoOcorrencia("gfaldakufdh");
        ocorrencia.setLocalOcorrencia("idk");
        
        Salvamento salvamento  = new Salvamento();
        salvamento.setDataSalvamento("11/09/2017");
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setJesusSalvador("Jesus");
        salvamento.setLocalSalvamento("idk");
        
        PorteAnimal porte = new PorteAnimal();
        porte.setNomePorteAnimal("médio");
             
        Animal animal = new Animal();
        animal.setFKSalvamento(salvamento);
        animal.setFKAbrigo(abrigo);
        animal.setFKPorteAnimal(porte);
        animal.setNomeAnimal("Animal teste");
        animal.setSexoAnimal("M");
        animal.setIdadeAnimal(5);
        animal.setRacaAnimal("Raça Teste");
        animal.setPesoAnimal(15.0f);
        animal.setEhCastrado(true);
        animal.setEstaSaudavel(true);
        
        assertEquals(1, codigoInserido);
    
    }

    @Test
    public void buscarPorId() throws SQLException{
        Conexao.truncate();
        
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Teste Abrigo");
        abrigo.setLocalAbrigo("Escola Agricola");
        abrigo.setLotacaoAbrigo(50);
        abrigo.setResponsavelAbrigo("Letícia");
        int codigoInserido = new AbrigoDAO().inserir(abrigo);
        assertEquals(1, codigoInserido);
        abrigo.setIdAbrigo(codigoInserido);
        
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
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
        
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataOcorrencia("11/09/2017");
        ocorrencia.setDescricaoOcorrencia("gfaldakufdh");
        ocorrencia.setLocalOcorrencia("idk");
        codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        assertEquals(1, codigoInserido);
        ocorrencia.setIdOcorrencia(codigoInserido);
        
        Salvamento salvamento  = new Salvamento();
        salvamento.setDataSalvamento("11/09/2017");
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setJesusSalvador("Jesus");
        salvamento.setLocalSalvamento("idk");
        codigoInserido = new SalvamentoDAO().inserir(salvamento);
        assertEquals(1, codigoInserido);
        salvamento.setIdSalvamento(codigoInserido);
        
        PorteAnimal porte = new PorteAnimal();
        porte.setNomePorteAnimal("médio");
        codigoInserido = new PorteAnimalDAO().inserir(porte);
        assertEquals(1, codigoInserido);
        porte.setIdPorteAnimal(codigoInserido);
        
        Animal animal = new Animal();
        animal.setNomeAnimal("Lulu");
        animal.setEhCastrado(true);
        animal.setEstaSaudavel(true);
        animal.setFKAbrigo(abrigo);
        animal.setFKPorteAnimal(porte);
        animal.setFKSalvamento(salvamento);
        animal.setIdadeAnimal(5);
        animal.setPesoAnimal(15.0f);
        animal.setRacaAnimal("Capivara");
        animal.setSexoAnimal("M");
        codigoInserido = new AnimalDAO().inserir(animal);
        assertEquals(1, codigoInserido);
        animal.setIdAnimal(codigoInserido);
        
        Animal animalBuscado  = new AnimalDAO().buscarAnimalPorId(codigoInserido);
        //assertNotNull(animalBuscado);
        assertEquals(animal.getIdAnimal(), animalBuscado.getIdAnimal());
        assertEquals(animal.getNomeAnimal(), animalBuscado.getNomeAnimal());
        assertEquals(animal.isEhCastrado(), animalBuscado.isEhCastrado());
        assertEquals(animal.isEstaSaudavel(), animalBuscado.isEstaSaudavel());
        assertEquals(animal.getFKAbrigo().getIdAbrigo(), animalBuscado.getFKAbrigo().getIdAbrigo());
        assertEquals(animal.getFKPorteAnimal().getIdPorteAnimal(), animalBuscado.getFKPorteAnimal().getIdPorteAnimal());
        assertEquals(animal.getFKSalvamento().getIdSalvamento(), animalBuscado.getFKSalvamento().getIdSalvamento());
        assertEquals(animal.getIdadeAnimal(), animalBuscado.getIdadeAnimal());
        assertEquals(animal.getPesoAnimal(), animalBuscado.getPesoAnimal());
        assertEquals(animal.getRacaAnimal(), animalBuscado.getRacaAnimal());
        assertEquals(animal.getSexoAnimal(), animalBuscado.getSexoAnimal());
        
    }
    
     @Test
     public void alterar() throws SQLException{
        Conexao.truncate();
        
        Abrigo abrigo = new Abrigo();
        abrigo.setNomeAbrigo("Teste Abrigo");
        abrigo.setLocalAbrigo("Escola Agricola");
        abrigo.setLotacaoAbrigo(50);
        abrigo.setResponsavelAbrigo("Letícia");
        int codigoInserido = new AbrigoDAO().inserir(abrigo);
        assertEquals(1, codigoInserido);
        abrigo.setIdAbrigo(codigoInserido);
        
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
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
        
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataOcorrencia("11/09/2017");
        ocorrencia.setDescricaoOcorrencia("gfaldakufdh");
        ocorrencia.setLocalOcorrencia("idk");
        codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        assertEquals(1, codigoInserido);
        ocorrencia.setIdOcorrencia(codigoInserido);
        
        Salvamento salvamento  = new Salvamento();
        salvamento.setDataSalvamento("11/09/2017");
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setJesusSalvador("Jesus");
        salvamento.setLocalSalvamento("idk");
        codigoInserido = new SalvamentoDAO().inserir(salvamento);
        assertEquals(1, codigoInserido);
        salvamento.setIdSalvamento(codigoInserido);
        
        PorteAnimal porte = new PorteAnimal();
        porte.setNomePorteAnimal("médio");
        codigoInserido = new PorteAnimalDAO().inserir(porte);
         assertEquals(1, codigoInserido);
        porte.setIdPorteAnimal(codigoInserido);
        
        Animal animal = new Animal();
        animal.setNomeAnimal("Animal teste");
        animal.setEhCastrado(true);
        animal.setEstaSaudavel(true);
        animal.setFKAbrigo(abrigo);
        animal.setFKPorteAnimal(porte);
        animal.setFKSalvamento(salvamento);
        animal.setIdadeAnimal(5);
        animal.setPesoAnimal(15.0f);
        animal.setRacaAnimal("Raça Teste");
        animal.setSexoAnimal("M");
        codigoInserido = new AnimalDAO().inserir(animal);
        animal.setIdAnimal(codigoInserido);
        
        animal.setNomeAnimal("Dumbo");
        animal.setEhCastrado(false);
        animal.setEstaSaudavel(false);
        animal.setFKAbrigo(abrigo);
        animal.setFKPorteAnimal(porte);
        animal.setFKSalvamento(salvamento);
        animal.setIdadeAnimal(7);
        animal.setPesoAnimal(50.0f);
        animal.setRacaAnimal("bebê elefante");
        animal.setSexoAnimal("F");
        int codigoAlterado = new AnimalDAO().alterar(animal);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        Animal animalBuscado = new AnimalDAO().buscarAnimalPorId(animal.getIdAnimal());
    }
}
    
    
