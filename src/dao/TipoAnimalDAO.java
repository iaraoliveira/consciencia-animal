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
import model.TipoAnimal;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita Victoria | Date=09-14-2017
 */
public class TipoAnimalDAO {
    
    public int inserir(TipoAnimal tipo) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO tipo_animal (nomeTipoAnimal)";
        sql += "\nVALUE(?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, tipo.getNomeTipoAnimal());
            ps.execute();

            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao Inserir o tipo do animal", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoInserido;
    }

     public int alterar(TipoAnimal tipo) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE tipo_animal SET";
        sql += "\nnomeTipoAnimal = ?";
        sql += "\nWHERE idTipoAnimal  = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, tipo.getNomeTipoAnimal());
            ps.setInt(2, tipo.getIdTipoAnimal());
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
        String sql = "DELETE FROM tipo_animal WHERE idTipoAnimal  = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir TipoAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }
     
     public void truncate() {
        String sql = "TRUNCATE tipo_animal";
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
     
     public ArrayList<TipoAnimal> retornarListaTipoAnimal() {
        ArrayList<TipoAnimal> tiposAnimais = new ArrayList<>();
        String sql = "SELECT idTipoAnimal, nomeTipoAnimal"
                + "\nFROM tipo_animal";
         try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TipoAnimal tipo = new TipoAnimal();
                tipo.setIdTipoAnimal(rs.getInt("idTipoAnimal"));
                tipo.setNomeTipoAnimal(rs.getString("nomeTipoAnimal"));
                tiposAnimais.add(tipo);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao retornar tipo do animal", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return tiposAnimais;
    }
     
     public TipoAnimal buscarTipoAnimalPorId(int codigo) {
        TipoAnimal tipoAnimal = null;
        String sql = "SELECT nomeTipoAnimal FROM tipo_animal";
        sql += "\nWHERE idTipoAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                tipoAnimal = new TipoAnimal();
                tipoAnimal.setIdTipoAnimal(codigo);
                tipoAnimal.setNomeTipoAnimal(resultado.getString("nomeTipoAnimal"));
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi possível retornar tipo do animal de TipoAnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return tipoAnimal;
    }

}


