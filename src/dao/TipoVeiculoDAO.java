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
import model.TipoVeiculo;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-05-2017
 */
public class TipoVeiculoDAO {

    public int inserir(TipoVeiculo tipo) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO tipo_veiculo (nomeTipoVeiculo)";
        sql += "\nVALUE(?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, tipo.getNomeTipoVeiculo());
            ps.execute();

            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao Inserir o tipo do veículo", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoInserido;
    }

    public int alterar(TipoVeiculo tipo) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE tipo_veiculo SET";
        sql += "\nnomeTipoVeiculo = ?";
        sql += "\nWHERE idTipoVeiculo  = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, tipo.getNomeTipoVeiculo());
            ps.setInt(2, tipo.getIdTipoVeiculo());
            codigoAlterado = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar TipoVeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlterado;
    }

    public int excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM tipo_veiculo WHERE idTipoVeiculo  = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir TipoVeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }

    public void truncate() {
        String sql = "TRUNCATE tipo_veiculo";
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

    public ArrayList<TipoVeiculo> retornarListaTipoVeiculo() {
        ArrayList<TipoVeiculo> tiposVeiculos = new ArrayList<>();
        String sql = "SELECT idTipoVeiculo, nomeTipoVeiculo"
                + "\nFROM tipo_veiculo";

        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TipoVeiculo tipo = new TipoVeiculo();
                tipo.setIdTipoVeiculo(rs.getInt("idTipoVeiculo"));
                tipo.setNomeTipoVeiculo(rs.getString("nomeTipoVeiculo"));
                tiposVeiculos.add(tipo);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao retornar tipo do veículo", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return tiposVeiculos;
    }

    public TipoVeiculo buscarTipoVeiculoPorId(int codigo) {
        TipoVeiculo tipoVeiculo = null;
        String sql = "SELECT nomeTipoVeiculo FROM tipo_veiculo";
        sql += "\nWHERE idTipoVeiculo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                tipoVeiculo = new TipoVeiculo();
                tipoVeiculo.setIdTipoVeiculo(codigo);
                tipoVeiculo.setNomeTipoVeiculo(resultado.getString("nomeTipoVeiculo"));
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar tipo do veículo de TipoVeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return tipoVeiculo;
    }
    
    public ArrayList<TipoVeiculo> pesquisarTipoVeiculo(String nomeColuna, String pesquisa) {
        ArrayList<TipoVeiculo> tipoVeiculos = new ArrayList<>();
        String sql = "SELECT idTipoVeiculo, nomeTipoVeiculo"
                + "\nFROM tipo_veiculo ";
        switch (nomeColuna) {
            case "Código":
                sql += "\nWHERE idTipoVeiculo LIKE ?";
                break;
            case "Tipo Veículo":
                sql += "\nWHERE nomeTipoVeiculo LIKE ?";
                break;
            

        }
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                TipoVeiculo tv = new TipoVeiculo();
                tv.setIdTipoVeiculo(rs.getInt("idTipoVeiculo"));
                tv.setNomeTipoVeiculo(rs.getString("nomeTipoVeiculo"));
                tipoVeiculos.add(tv);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar TipoVeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return tipoVeiculos;
    }

}