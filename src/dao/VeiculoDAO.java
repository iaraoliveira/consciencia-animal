/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TipoVeiculo;
import model.Veiculo;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-05-2017
 */
public class VeiculoDAO {

    public int inserir(Veiculo veiculo) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO veiculo(modeloVeiculo, placaVeiculo, fabricanteVeiculo, estaDisponivel, FKTipoVeiculo)";
        sql += "\nVALUE(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, veiculo.getModeloVeiculo());
            ps.setString(2, veiculo.getPlacaVeiculo());
            ps.setString(3, veiculo.getFabricanteVeiculo());
            ps.setBoolean(4, veiculo.isEstaDisponivel());
            ps.setInt(5, veiculo.getFKTipoVeiculo().getIdTipoVeiculo());
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

    public int alterar(Veiculo veiculo) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE veiculo SET";
        sql += "\nmodeloVeiculo = ?,";
        sql += "\nplacaVeiculo = ?,";
        sql += "\nfabricanteVeiculo = ?,";
        sql += "\nestaDisponivel = ?,";
        sql += "\nFKTipoVeiculo = ?";
        sql += "\nWHERE idVeiculo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, veiculo.getModeloVeiculo());
            ps.setString(2, veiculo.getPlacaVeiculo());
            ps.setString(3, veiculo.getFabricanteVeiculo());
            ps.setBoolean(4, veiculo.isEstaDisponivel());
            ps.setInt(5, veiculo.getFKTipoVeiculo().getIdTipoVeiculo());
            ps.setInt(6, veiculo.getIdVeiculo());
            codigoAlterado = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar VeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlterado;
    }

    public boolean excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM veiculo WHERE idVeiculo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
            if (buscarVeiculoPorId(id) == null) {
                return true;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir VeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return false;
    }

    public void truncate() {
        String sql = "TRUNCATE veiculo";
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

    public ArrayList<Veiculo> retornarListaVeiculo() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT idVeiculo, modeloVeiculo, placaVeiculo, fabricanteVeiculo, estaDisponivel, FKTipoVeiculo"
                + "\nFROM veiculo";

        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setIdVeiculo(rs.getInt("idVeiculo"));
                v.setModeloVeiculo(rs.getString("modeloVeiculo"));
                v.setPlacaVeiculo(rs.getString("placaVeiculo"));
                v.setFabricanteVeiculo(rs.getString("fabricanteVeiculo"));
                v.setEstaDisponivel(rs.getBoolean("estaDisponivel"));
                int codigoTipoVeiculo = rs.getInt("FKTipoVeiculo");
                TipoVeiculo tipoVeiculo = new TipoVeiculoDAO().buscarTipoVeiculoPorId(codigoTipoVeiculo);
                v.setFKTipoVeiculo(tipoVeiculo);
                veiculos.add(v);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar VeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return veiculos;
    }
    
    public ArrayList<Veiculo> pesquisarVeiculo(String nomeColuna, String pesquisa, boolean disponibilidade) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT idVeiculo, FKTipoVeiculo, modeloVeiculo, placaVeiculo, fabricanteVeiculo, estaDisponivel"
                + "\nFROM veiculo ";
        switch (nomeColuna) {
            case "Código":
                sql += "\nWHERE idVeiculo LIKE ?";
                break;
            case "Modelo":
                sql += "\nWHERE modeloVeiculo LIKE ?";
                break;
            case "Placa":
                sql += "\nWHERE placaVeiculo LIKE ?";
                break;
            case "Fabricante":
                sql += "\nWHERE fabricanteVeiculo LIKE ?";
                break;
                
        }
        sql += " AND estaDisponivel = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ps.setBoolean(2, disponibilidade);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setIdVeiculo(rs.getInt("idVeiculo"));
                
                int codigoTipoVeiculo = rs.getInt("FKTipoVeiculo");
                TipoVeiculo tipoVeiculo = new TipoVeiculoDAO().buscarTipoVeiculoPorId(codigoTipoVeiculo);
                v.setFKTipoVeiculo(tipoVeiculo);
                
                v.setModeloVeiculo(rs.getString("modeloVeiculo"));
                v.setPlacaVeiculo(rs.getString("placaVeiculo"));
                v.setFabricanteVeiculo(rs.getString("fabricanteVeiculo"));
                v.setEstaDisponivel(rs.getBoolean("estaDisponivel"));
                veiculos.add(v);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar VeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return veiculos;
    }


    public Veiculo buscarVeiculoPorId(int codigo) {
        Veiculo veiculo = null;
        String sql = "SELECT idVeiculo, modeloVeiculo, placaVeiculo, fabricanteVeiculo, estaDisponivel, FKTipoVeiculo FROM veiculo";
        sql += "\nWHERE idVeiculo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setModeloVeiculo(rs.getString("modeloVeiculo"));
                veiculo.setPlacaVeiculo(rs.getString("placaVeiculo"));
                veiculo.setFabricanteVeiculo(rs.getString("fabricanteVeiculo"));
                veiculo.setEstaDisponivel(rs.getBoolean("estaDisponivel"));
                veiculo.setFKTipoVeiculo(new TipoVeiculoDAO().buscarTipoVeiculoPorId(rs.getInt("FKTipoVeiculo")));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar Veiculo do VeiculoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return veiculo;
    }
}
