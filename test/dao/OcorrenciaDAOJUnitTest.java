package dao;


import dao.OcorrenciaDAO;
import database.Conexao;
import database.Utilitarios;
import java.sql.Date;
import model.Ocorrencia;
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
 * @author Alunos
 */
public class OcorrenciaDAOJUnitTest {
    
    @Test
    public void inserir(){
        Conexao.truncate();
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("nome do local");
        ocorrencia.setHoraOcorrencia("09:35");
        ocorrencia.setDescricaoOcorrencia("descrição da ocorrencia");
        ocorrencia.setDataOcorrencia("2017-08-05");
        int codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
         assertEquals(1, codigoInserido);
    }
    
    @Test
    public void buscarPorId(){
        Conexao.truncate();
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("idk");
        ocorrencia.setHoraOcorrencia("09:30");
        ocorrencia.setDescricaoOcorrencia("bvdskhahfa");
        ocorrencia.setDataOcorrencia("2017-05-08");
        int codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        ocorrencia.setIdOcorrencia(codigoInserido);
        
        Ocorrencia ocorrenciaBuscada  = new OcorrenciaDAO().buscarOcorrenciaPorId(codigoInserido);
        assertNotNull(ocorrenciaBuscada);
        assertEquals(ocorrencia.getLocalOcorrencia(),    ocorrenciaBuscada.getLocalOcorrencia());
        assertEquals(ocorrencia.getIdOcorrencia(),    ocorrenciaBuscada.getIdOcorrencia());
        assertEquals(ocorrencia.getDescricaoOcorrencia(),   ocorrenciaBuscada.getDescricaoOcorrencia());
        assertEquals(ocorrencia.getHoraOcorrencia(),    ocorrenciaBuscada.getHoraOcorrencia());
        assertEquals(ocorrencia.getDataOcorrencia(),     ocorrenciaBuscada.getDataOcorrencia());
    }
    
    @Test
    public void alterar(){
        Conexao.truncate();
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("idk");
        ocorrencia.setDataOcorrencia("2017-08-05");
        ocorrencia.setHoraOcorrencia("08:30");
        ocorrencia.setDescricaoOcorrencia("njdskhvc");
        int codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        ocorrencia.setIdOcorrencia(codigoInserido);
        
        ocorrencia.setLocalOcorrencia("idk");
        ocorrencia.setDataOcorrencia("2018-08-05");
        ocorrencia.setHoraOcorrencia("09:30");
        ocorrencia.setDescricaoOcorrencia("bvdshfasçlfj");
        int codigoAlterado = new OcorrenciaDAO().alterar(ocorrencia);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);
        
        Ocorrencia ocorrenciaBuscada = new OcorrenciaDAO().buscarOcorrenciaPorId(ocorrencia.getIdOcorrencia());
    }
    
}
