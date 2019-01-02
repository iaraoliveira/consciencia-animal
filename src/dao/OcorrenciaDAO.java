/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Abrigo;
import model.Ocorrencia;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-04-2017
 */
public class OcorrenciaDAO {

    public int inserir(Ocorrencia ocorrencia) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO ocorrencia (descricaoOcorrencia, dataOcorrencia, localOcorrencia, horaOcorrencia )";
        sql += "\nVALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, ocorrencia.getDescricaoOcorrencia());
            ps.setString(2, ocorrencia.getDataOcorrencia());
            ps.setString(3, ocorrencia.getLocalOcorrencia());
            ps.setString(4, ocorrencia.getHoraOcorrencia());
            ps.execute();

            ResultSet resultado = ps.getGeneratedKeys();
            while (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        } finally {
            Conexao.desconectar();
        }
        return codigoInserido;
    }

    public int alterar(Ocorrencia ocorrencia) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE ocorrencia SET";
        sql += "\ndescricaoOcorrencia= ?,";
        sql += "\ndataOcorrencia= ?,";
        sql += "\nlocalOcorrencia= ?,";
        sql += "\nhoraOcorrencia= ?";
        sql += "\nWHERE idOcorrencia = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, ocorrencia.getDescricaoOcorrencia());
            ps.setString(2, ocorrencia.getDataOcorrencia());
            ps.setString(3, ocorrencia.getLocalOcorrencia());
            ps.setString(4, ocorrencia.getHoraOcorrencia());
            ps.setInt(5, ocorrencia.getIdOcorrencia());

            codigoAlterado = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar OcorrenciaDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        

        return codigoAlterado;
    }
    

    public int excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM ocorrencia WHERE idOcorrencia = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir ocorrenciaDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
            
        }

        return codigoExcluido;
    }
    

    public void truncate() {
        String sql = "TRUNCATE ocorrencia";
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

    public ArrayList<Ocorrencia> retornarListaOcorrencia() {
        ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
        String sql = "SELECT idOcorrencia, descricaoOcorrencia, dataOcorrencia, localOcorrencia, horaOcorrencia"
                + "\nFROM ocorrencia";
        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                Ocorrencia o = new Ocorrencia();
                o.setIdOcorrencia(rs.getInt("idOcorrencia"));
                o.setDescricaoOcorrencia(rs.getString("descricaoOcorrencia"));
                o.setDataOcorrencia(rs.getString("dataOcorrencia"));
                o.setLocalOcorrencia(rs.getString("localOcorrencia"));
                o.setHoraOcorrencia(rs.getString("horaOcorrencia"));
                ocorrencias.add(o);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar OcorrenciaDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return ocorrencias;
    }

    public ArrayList<Ocorrencia> pesquisarOcorrencia(String nomeColuna, String pesquisa) {
        ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
        String sql = "SELECT idOcorrencia, descricaoOcorrencia, dataOcorrencia, localOcorrencia, horaOcorrencia"
                + "\nFROM ocorrencia ";
        switch (nomeColuna) {
            case "Código":
                sql += "\nWHERE idOcorrencia LIKE ?";
                break;
            case "Data":
                sql += "\nWHERE dataOcorrencia LIKE ?";
                break;
            case "Hora":
                sql += "\nWHERE horaOcorrencia LIKE ?";
                break;
            case "Local":
                sql += "\nWHERE localOcorrencia LIKE ?";
                break;
            case "Descrição":
                sql += "\nWHERE descricaoOcorrencia LIKE ?";
                break;

        }
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setIdOcorrencia(rs.getInt("idOcorrencia"));
                o.setDescricaoOcorrencia(rs.getString("descricaoOcorrencia"));
                o.setDataOcorrencia(rs.getString("dataOcorrencia"));
                o.setLocalOcorrencia(rs.getString("localOcorrencia"));
                o.setHoraOcorrencia(rs.getString("horaOcorrencia"));
                ocorrencias.add(o);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar OcorrenciaDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return ocorrencias;
    }

    public Ocorrencia buscarOcorrenciaPorId(int codigo) {
        Ocorrencia ocorrencia = null;
        String sql = "SELECT descricaoOcorrencia, dataOcorrencia, localOcorrencia, horaOcorrencia FROM ocorrencia";
        sql += "\nWHERE idOcorrencia = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                ocorrencia = new Ocorrencia();
                ocorrencia.setIdOcorrencia(codigo);
                ocorrencia.setDescricaoOcorrencia(resultado.getString("descricaoOcorrencia"));
                ocorrencia.setDataOcorrencia(resultado.getString("dataOcorrencia"));
                ocorrencia.setLocalOcorrencia(resultado.getString("localOcorrencia"));
                ocorrencia.setHoraOcorrencia(resultado.getString("horaOcorrencia"));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar ocorrencia da OcorrenciaDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        

        return ocorrencia;
    }
}
