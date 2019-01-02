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
import model.PorteAnimal;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-06-2017
 */
public class PorteAnimalDAO {

    public int inserir(PorteAnimal porte) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO porte_animal(nomePorteAnimal)";
        sql += "\nVALUE(?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, porte.getNomePorteAnimal());
            ps.execute();
            ResultSet resultado = ps.getGeneratedKeys();

            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao inserir o porte do animal", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoInserido;
    }

    public int alterar(PorteAnimal porte) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE porte_animal SET";
        sql += "\nnomePorteAnimal = ?,";
        sql += "\nWHERE idPorteAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, porte.getNomePorteAnimal());
            ps.setInt(2, porte.getIdPorteAnimal());
            codigoAlterado = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar PorteAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlterado;
    }

    public int excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM porte_animal WHERE idPorteAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao excluir PorteAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }

    public void truncate() {
        String sql = "TRUNCATE porte_animal";
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

    public ArrayList<PorteAnimal> retornarListaPorteAnimal() {
        ArrayList<PorteAnimal> portes = new ArrayList<>();
        String sql = "SELECT idPorteAnimal. nomePorteAnimal"
                + "\nFROM porte_animal";
        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                PorteAnimal p = new PorteAnimal();
                p.setIdPorteAnimal(rs.getInt("idPorteAnimal"));
                p.setNomePorteAnimal(rs.getString("nomePorteAnimal"));
                portes.add(p);
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar PorteAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return portes;
    }

    public PorteAnimal buscarPorteAnimalPorId(int codigo) {
        PorteAnimal porte = null;
        String sql = "SELECT nomePorteAnimal FROM porte_animal";
        sql += "\nWHERE idPorteAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                porte = new PorteAnimal();
                porte.setIdPorteAnimal(codigo);
                porte.setNomePorteAnimal(resultado.getString("nomePorteAnimal"));

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar porte do PorteAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return porte;

    }
}
