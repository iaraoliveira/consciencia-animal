run a project in intelijj/*
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
import model.Abrigo;
import model.Animal;
import model.Doenca;
import model.PorteAnimal;
import model.Salvamento;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-06-2017
 */
public class AnimalDAO {

    public int inserir(Animal animal) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO animal(FKSalvamento, FKAbrigo, FKPorteAnimal, nomeAnimal, sexoAnimal, idadeAnimal, racaAnimal, pesoAnimal, ehCastrado, estaSaudavel)";
        sql += "\nVALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            
            ps.setInt(1, animal.getFKSalvamento().getIdSalvamento());
            ps.setInt(2, animal.getFKAbrigo().getIdAbrigo());
            ps.setInt(3, animal.getFKPorteAnimal().getIdPorteAnimal());
            ps.setString(4, animal.getNomeAnimal());
            ps.setString(5, animal.getSexoAnimal());
            ps.setInt(6, animal.getIdadeAnimal());
            ps.setString(7, animal.getRacaAnimal());
            ps.setFloat(8, animal.getPesoAnimal());
            ps.setBoolean(9, animal.isEhCastrado());
            ps.setBoolean(10, animal.isEstaSaudavel());
            ps.execute();

            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao Inserir o Animal", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return codigoInserido;
    }

    public int alterar(Animal animal){
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE animal SET";
        sql += "\nFKSalvamento = ?,";
        sql += "\nFKAbrigo = ?,";
        sql += "\nFKPorteAnimal = ?,";
        sql += "\nnomeAnimal = ?,";
        sql += "\nsexoAnimal = ?,";
        sql += "\nidadeAnimal = ?,";
        sql += "\nracaAnimal = ?,";
        sql += "\npesoAnimal = ?,";
        sql += "\nehCastrado = ?,";
        sql += "\nestaSaudavel = ?";
        sql += "\nWHERE idAnimal = ?";
        
        try{
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, animal.getFKSalvamento().getIdSalvamento());
            ps.setInt(2, animal.getFKAbrigo().getIdAbrigo());
            ps.setInt(3, animal.getFKPorteAnimal().getIdPorteAnimal());
            ps.setString(4, animal.getNomeAnimal());
            ps.setString(5, animal.getSexoAnimal());
            ps.setInt(6, animal.getIdadeAnimal());
            ps.setString(7, animal.getRacaAnimal());
            ps.setFloat(8, animal.getPesoAnimal());
            ps.setBoolean(9, animal.isEhCastrado());
            ps.setBoolean(10, animal.isEstaSaudavel());
            ps.setInt(11, animal.getIdAnimal());
            
            codigoAlterado = ps.executeUpdate();
        } catch( SQLException sqle){
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar AnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        
        return codigoAlterado;
    }
    
    
    public int excluir(int id){
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM animal WHERE idAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir animalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }

    public void truncate() {
        String sql = "TRUNCATE animal";
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

    public ArrayList<Animal> retornarListaAnimal() {
        ArrayList<Animal> animais = new ArrayList<>();
        String sql = "SELECT idAnimal, FKSalvamento, FKAbrigo, FKPorteAnimal, nomeAnimal, pesoAnimal, racaAnimal, sexoAnimal, ehCastrado, estaSaudavel"
                + "\nFROM animal";

        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("idAnimal"));

                a.setIdAnimal(rs.getInt("idAnimal"));
                int codigoSalvamento = rs.getInt("FKSalvamento");
                Salvamento salvamento = new SalvamentoDAO().buscarSalvamentoPorId(codigoSalvamento);
                a.setFKSalvamento(salvamento);

                int codigoAbrigo = rs.getInt("FKAbrigo");
                Abrigo abrigo = new AbrigoDAO().buscarAbrigoPorId(codigoAbrigo);
                a.setFKAbrigo(abrigo);

                int codigoPorteAnimal = rs.getInt("FKPorteAnimal");
                PorteAnimal porteAnimal = new PorteAnimalDAO().buscarPorteAnimalPorId(codigoPorteAnimal);
                a.setFKPorteAnimal(porteAnimal);

                a.setNomeAnimal(rs.getString("nomeAnimal"));
                a.setPesoAnimal(rs.getInt("pesoAnimal"));
                a.setRacaAnimal(rs.getString("racaAnimal"));
                a.setSexoAnimal(rs.getString("sexoAnimal"));
                a.setEhCastrado(rs.getBoolean("ehCastrado"));
                a.setEstaSaudavel(rs.getBoolean("estaSaudavel"));

                animais.add(a);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar AnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return animais;
    }

    public Animal buscarAnimalPorId(int codigo) {
        Animal animal = null;
        String sql = "SELECT FKSalvamento, FKAbrigo, FKPorteAnimal, nomeAnimal, sexoAnimal, pesoAnimal, idadeAnimal, porteAnimal, estaSaudavel, ehCastrado, racaAnimal FROM animal";
        sql += "\nWHERE idAnimal = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                animal = new Animal();
                animal.setIdAnimal(codigo);
                animal.setFKSalvamento(new SalvamentoDAO().buscarSalvamentoPorId(resultado.getInt("FKSalvamento")));
                animal.setFKAbrigo(new AbrigoDAO().buscarAbrigoPorId(resultado.getInt("FKAbrigo")));
                animal.setFKPorteAnimal(new PorteAnimalDAO().buscarPorteAnimalPorId(resultado.getInt("FKPorteAnimal")));
                animal.setNomeAnimal(resultado.getString("nomeAnimal"));
                animal.setSexoAnimal(resultado.getString("sexoAnimal"));
                animal.setPesoAnimal(resultado.getInt("pesoAnimal"));
                animal.setIdadeAnimal(resultado.getInt("idadeAnimal"));
                animal.setEstaSaudavel(resultado.getBoolean("estaSaudavel"));
                animal.setEhCastrado(resultado.getBoolean("ehCastrado"));
                animal.setRacaAnimal(resultado.getString("racaAnimal"));
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar animal do AnimalDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return animal;
    }

}
