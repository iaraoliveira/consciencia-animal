package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Ocorrencia;
import model.Salvamento;
import model.Veiculo;

/**
 *
 * @author Alunos Talita victoria, Felipe Tobias, Vinicius Donschen e Iara de
 * oliveira. 05/09/2017.
 */
public class SalvamentoDAO {

    public int inserir(Salvamento salvamento) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO salvamento(FKVeiculo, FKOcorrencia, dataSalvamento, horaSalvamento, localSalvamento, jesusSalvador)";
        sql += "\nVALUE(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, salvamento.getFKVeiculo().getIdVeiculo());
            ps.setInt(2, salvamento.getFKOcorrencia().getIdOcorrencia());
            ps.setString(3, salvamento.getDataSalvamento());
            ps.setString(4, salvamento.getHoraSalvamento());
            ps.setString(5, salvamento.getLocalSalvamento());
            ps.setString(6, salvamento.getJesusSalvador());
            ps.execute();
            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return codigoInserido;
    }

    public int alterar(Salvamento salvamento) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE salvamento SET";
        sql += "\nFKVeiculo = ?,";
        sql += "\nFKOcorrencia= ?,";
        sql += "\ndataSalvamento  = ?,";
        sql += "\nhoraSalvamento  = ?,";
        sql += "\nlocalSalvamento = ?,";
        sql += "\njesusSalvador = ?";
        sql += "\nWHERE idSalvamento = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, salvamento.getFKVeiculo().getIdVeiculo());
            ps.setInt(2, salvamento.getFKOcorrencia().getIdOcorrencia());
            ps.setString(3, salvamento.getDataSalvamento());
            ps.setString(4, salvamento.getHoraSalvamento());
            ps.setString(5, salvamento.getLocalSalvamento());
            ps.setString(6, salvamento.getJesusSalvador());
            ps.setInt(7, salvamento.getIdSalvamento());
            codigoAlterado = ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar SalvamentoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlterado;
    }

    public int excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM salvamento WHERE idSalvamento = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir SalvamentoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }

    public void truncate() {
        String sql = "TRUNCATE salvamento";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        } finally {
            Conexao.desconectar();
        }
    }

    public Salvamento buscarSalvamentoPorId(int codigo) {
        Salvamento salvamento = null;
        String sql = "SELECT idSalvamento ,FKVeiculo, FKOcorrencia, horaSalvamento, dataSalvamento, localSalvamento, jesusSalvador FROM salvamento";
        sql += "\nWHERE idSalvamento = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                salvamento = new Salvamento();
                salvamento.setIdSalvamento(codigo);
                salvamento.setFKVeiculo(new VeiculoDAO().buscarVeiculoPorId(rs.getInt("FKVeiculo")));
                salvamento.setFKOcorrencia(new OcorrenciaDAO().buscarOcorrenciaPorId(rs.getInt("FKOcorrencia")));
                salvamento.setHoraSalvamento(rs.getString("horaSalvamento"));
                salvamento.setDataSalvamento(rs.getString("dataSalvamento"));
                salvamento.setLocalSalvamento(rs.getString("localSalvamento"));
                salvamento.setJesusSalvador(rs.getString("jesusSalvador"));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar Salvamento de SalvamentoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return salvamento;
    }

    public ArrayList<Salvamento> retornarListaSalvamento() {
        ArrayList<Salvamento> salvamento = new ArrayList<>();
        String sql = "SELECT idSalvamento, FKVeiculo, FKOcorrencia, dataSalvamento, horaSalvamento, localSalvamento, jesusSalvador"
                + "\nFROM salvamento";

        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Salvamento s = new Salvamento();
                s.setIdSalvamento(rs.getInt("idSalvamento"));
                
                int codigoVeiculo = rs.getInt("FKVeiculo");
                Veiculo veiculo = new VeiculoDAO().buscarVeiculoPorId(codigoVeiculo);
                s.setFKVeiculo(veiculo);

                int codigoOcorrencias = rs.getInt("FKOcorrencia");
                Ocorrencia ocorrencias = new OcorrenciaDAO().buscarOcorrenciaPorId(codigoOcorrencias);
                s.setFKOcorrencia(ocorrencias);

                s.setDataSalvamento(rs.getString("dataSalvamento"));
                s.setHoraSalvamento(rs.getString("horaSalvamento"));
                s.setLocalSalvamento(rs.getString("localSalvamento"));
                s.setJesusSalvador(rs.getString("jesusSalvador"));
                salvamento.add(s);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar SalvamentoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return salvamento;
    }
    
    public ArrayList<Salvamento> pesquisarSalvamento(String nomeColuna, String pesquisa) {
        ArrayList<Salvamento> salvamentos = new ArrayList<>();
        String sql = "SELECT idSalvamento, FKVeiculo, FKOcorrencia, dataSalvamento, horaSalvamento, localSalvamento, jesusSalvador"
                + "\nFROM salvamento sl"
                + "\nJOIN veiculo ve ON (sl.FKVeiculo = ve.idVeiculo)";
        switch (nomeColuna) {
            case "Código":
                sql += "\nWHERE idSalvamento LIKE ?";
                break;
            case "Veiculo Utilizado":
                sql += "\nWHERE ve.placaVeiculo LIKE ?";
                break;
            case "Cod. Ocorrencia":
                sql += "\nWHERE FKOcorrencia LIKE ?";
                break;
            case "Data":
                sql += "\nWHERE dataSalvamento LIKE ?";
                break;
            case "Hora":
                sql += "\nWHERE horaSalvamento LIKE ?";
                break;
            case "Local":
                sql += "\nWHERE localSalvamento LIKE ?";
                break;
            case "Salvador":
                sql += "\nWHERE jesusSalvador LIKE ?";
                break;    

        }
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Salvamento s;
                s = new Salvamento();
                
                s.setIdSalvamento(rs.getInt("idSalvamento"));
                
                int codigoVeiculo = rs.getInt("FKVeiculo");
                Veiculo veiculo = new VeiculoDAO().buscarVeiculoPorId(codigoVeiculo);
                s.setFKVeiculo(veiculo);
                
                int codigoOcorrencias = rs.getInt("FKOcorrencia");
                Ocorrencia ocorrencias = new OcorrenciaDAO().buscarOcorrenciaPorId(codigoOcorrencias);
                s.setFKOcorrencia(ocorrencias);
                
                s.setDataSalvamento(rs.getString("dataSalvamento"));
                s.setHoraSalvamento(rs.getString("horaSalvamento"));
                s.setLocalSalvamento(rs.getString("localSalvamento"));
                s.setJesusSalvador(rs.getString("jesusSalvador"));

                
                salvamentos.add(s);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar SalvamentoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return salvamentos;
    }

    
}

