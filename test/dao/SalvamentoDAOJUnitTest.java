package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.OcorrenciaDAO;
import dao.SalvamentoDAO;
import dao.TipoVeiculoDAO;
import dao.VeiculoDAO;
import database.Conexao;
import database.Utilitarios;
import java.sql.SQLException;
import model.Ocorrencia;
import model.Salvamento;
import model.TipoVeiculo;
import model.Veiculo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class SalvamentoDAOJUnitTest {

    @Test
    public void inserir() throws SQLException {
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
        veiculo.setIdVeiculo(codigoInserido);

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("nome do local");
        ocorrencia.setDataOcorrencia("2018-05-08");
        ocorrencia.setDescricaoOcorrencia("descrição da ocorrencia");
        ocorrencia.setHoraOcorrencia("09:30");
        codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        assertEquals(1, codigoInserido);
        ocorrencia.setIdOcorrencia(codigoInserido);

        Salvamento salvamento = new Salvamento();
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setLocalSalvamento("Nome Local");
        salvamento.setDataSalvamento("2017-08-05");
        salvamento.setHoraSalvamento("09:30");
        salvamento.setJesusSalvador("Pedro");
        codigoInserido = new SalvamentoDAO().inserir(salvamento);
        salvamento.setIdSalvamento(codigoInserido);

    }

    @Test
    public void buscarPorId() {
        Conexao.truncate();
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNomeTipoVeiculo("Abrigo A");
        int codigoInserido = new TipoVeiculoDAO().inserir(tipoVeiculo);
        assertEquals(1, codigoInserido);
        tipoVeiculo.setIdTipoVeiculo(codigoInserido);

        Veiculo veiculo = new Veiculo();
        veiculo.setModeloVeiculo("Modelo2");
        veiculo.setPlacaVeiculo("Placa2");
        veiculo.setFabricanteVeiculo("Fabricante2");
        veiculo.setEstaDisponivel(true);
        veiculo.setFKTipoVeiculo(tipoVeiculo);
        codigoInserido = new VeiculoDAO().inserir(veiculo);
        assertEquals(1, codigoInserido);
        veiculo.setIdVeiculo(codigoInserido);

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("nome do local");
        ocorrencia.setDataOcorrencia("2018-05-08");
        ocorrencia.setDescricaoOcorrencia("descrição da ocorrencia");
        ocorrencia.setHoraOcorrencia("09:30");
        codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        assertEquals(1, codigoInserido);
        ocorrencia.setIdOcorrencia(codigoInserido);

        Salvamento salvamento = new Salvamento();
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setLocalSalvamento("Nome Local");
        salvamento.setDataSalvamento("2017-08-05");
        salvamento.setHoraSalvamento("09:30");
        salvamento.setJesusSalvador("Pedro");
        codigoInserido = new SalvamentoDAO().inserir(salvamento);
        assertEquals(1, codigoInserido);
        salvamento.setIdSalvamento(codigoInserido);

        Salvamento salvamentoBuscado = new SalvamentoDAO().buscarSalvamentoPorId(codigoInserido);

        assertEquals(salvamento.getFKOcorrencia().getIdOcorrencia(), salvamentoBuscado.getFKOcorrencia().getIdOcorrencia());
        assertEquals(salvamento.getFKVeiculo().getIdVeiculo(), salvamentoBuscado.getFKVeiculo().getIdVeiculo());
        assertEquals(salvamento.getIdSalvamento(), salvamentoBuscado.getIdSalvamento());
        assertEquals(salvamento.getLocalSalvamento(), salvamentoBuscado.getLocalSalvamento());
        assertEquals(salvamento.getDataSalvamento(), salvamentoBuscado.getDataSalvamento());
        assertEquals(salvamento.getHoraSalvamento(), salvamentoBuscado.getHoraSalvamento());
        assertEquals(salvamento.getJesusSalvador(), salvamentoBuscado.getJesusSalvador());

    }

    @Test
    public void alterar() {
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
        assertEquals(1, codigoInserido);
        veiculo.setIdVeiculo(codigoInserido);

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setLocalOcorrencia("nome do local");
        ocorrencia.setHoraOcorrencia("09:30");
        ocorrencia.setDescricaoOcorrencia("descrição da ocorrencia");
        ocorrencia.setDataOcorrencia("2019-05-08");
        codigoInserido = new OcorrenciaDAO().inserir(ocorrencia);
        assertEquals(1, codigoInserido);
        ocorrencia.setIdOcorrencia(codigoInserido);

        Salvamento salvamento = new Salvamento();
        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setLocalSalvamento("Nome Local");
        salvamento.setDataSalvamento("2017-08-05");
        salvamento.setHoraSalvamento("09:30");
        salvamento.setJesusSalvador("Pedro");
        codigoInserido = new SalvamentoDAO().inserir(salvamento);
        salvamento.setIdSalvamento(codigoInserido);

        salvamento.setFKOcorrencia(ocorrencia);
        salvamento.setFKVeiculo(veiculo);
        salvamento.setLocalSalvamento("Outro Local");
        salvamento.setDataSalvamento("2018-08-05");
        salvamento.setHoraSalvamento("09:35");
        salvamento.setJesusSalvador("José");
        int codigoAlterado = new SalvamentoDAO().alterar(salvamento);
         //assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, codigoAlterado);

        Salvamento salvamentoBuscado = new SalvamentoDAO().buscarSalvamentoPorId(salvamento.getIdSalvamento());
    }

}
