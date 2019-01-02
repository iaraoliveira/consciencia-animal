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
import model.Ocorrencia;
import model.Salvamento;
import model.Veiculo;

/**
 *
 * @author Filipe Gabriel Tobias, Iara Oliveira, Vinicius Donschen e Talita
 * Victoria | Date=09-04-2017
 */
public class AbrigoDAO {

    public int inserir(Abrigo abrigo) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO abrigo(nomeAbrigo, localAbrigo, responsavelAbrigo, lotacaoAbrigo)";
        sql += "\nVALUE(?, ?, ?, ?)";

        try {
            /**
             * Classe utilizada para criar o sql substituindo as interrogações
             * RETURN_GENERATED_KEYS -> Utilizado para informar para o
             * PreparedStatement que dever ser retornado o id gerado pelo Banco
             * de Dados
             */
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // substituir as Interrogações
            ps.setString(1, abrigo.getNomeAbrigo());
            ps.setString(2, abrigo.getLocalAbrigo());
            ps.setString(3, abrigo.getResponsavelAbrigo());
            ps.setInt(4, abrigo.getLotacaoAbrigo());
            // Executa o comando no Banco de Dados
            ps.execute();

            /**
             * Classe Utilizada para trabalhar com as informações que o Banco de
             * Dados Retorna
             */
            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                codigoInserido = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao Inserir o Abrigo", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoInserido;
    }

    public int alterar(Abrigo abrigo) {
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE abrigo SET";
        sql += "\nnomeAbrigo = ?,";
        sql += "\nlocalAbrigo = ?,";
        sql += "\nresponsavelAbrigo = ?,";
        sql += "\nlotacaoAbrigo = ?";
        sql += "\nWHERE idAbrigo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, abrigo.getNomeAbrigo());
            ps.setString(2, abrigo.getLocalAbrigo());
            ps.setString(3, abrigo.getResponsavelAbrigo());
            ps.setInt(4, abrigo.getLotacaoAbrigo());
            ps.setInt(5, abrigo.getIdAbrigo());
            codigoAlterado = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Alterar AbrigoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlterado;
    }

    public int excluir(int id) {
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM abrigo WHERE idAbrigo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codigoExcluido = ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir AbrigoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return codigoExcluido;
    }

    public void truncate() {
        String sql = "TRUNCATE abrigo";
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

    public ArrayList<Abrigo> retornarListaAbrigo() {
        ArrayList<Abrigo> abrigos = new ArrayList<>();
        String sql = "SELECT idAbrigo, nomeAbrigo, localAbrigo, responsavelAbrigo, lotacaoAbrigo"
                + "\nFROM abrigo";

        try {
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Abrigo a = new Abrigo();
                a.setIdAbrigo(rs.getInt("idAbrigo"));
                a.setNomeAbrigo(rs.getString("nomeAbrigo"));
                a.setLocalAbrigo(rs.getString("localAbrigo"));
                a.setResponsavelAbrigo(rs.getString("responsavelAbrigo"));
                a.setLotacaoAbrigo(rs.getInt("lotacaoAbrigo"));
                abrigos.add(a);

            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar AbrigoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return abrigos;
    }

    public Abrigo buscarAbrigoPorId(int codigo) {
        Abrigo abrigo = null;
        String sql = "SELECT nomeAbrigo, localAbrigo, responsavelAbrigo, lotacaoAbrigo FROM abrigo";
        sql += "\nWHERE idAbrigo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultado = ps.getResultSet();
            if (resultado.next()) {
                abrigo = new Abrigo();
                abrigo.setIdAbrigo(codigo);
                abrigo.setNomeAbrigo(resultado.getString("nomeAbrigo"));
                abrigo.setLocalAbrigo(resultado.getString("localAbrigo"));
                abrigo.setResponsavelAbrigo(resultado.getString("responsavelAbrigo"));
                abrigo.setLotacaoAbrigo(resultado.getInt("lotacaoAbrigo"));
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Não foi Possível retornar abrigo da AbrigoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }

        return abrigo;
    }
    
    public ArrayList<Abrigo> pesquisarAbrigo(String nomeColuna, String pesquisa) {
        ArrayList<Abrigo> abrigos = new ArrayList<>();
        String sql = "SELECT idAbrigo, nomeAbrigo, localAbrigo, responsavelAbrigo, lotacaoAbrigo"
                + "\nFROM abrigo ";
        switch (nomeColuna) {
            case "Código":
                sql += "\nWHERE idAbrigo LIKE ?";
                break;
            case "Nome":
                sql += "\nWHERE nomeAbrigo LIKE ?";
                break;
            case "Bairro":
                sql += "\nWHERE localAbrigo LIKE ?";
                break;
            case "Responsável":
                sql += "\nWHERE responsavelAbrigo LIKE ?";
                break;
        }
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Abrigo a;
                a = new Abrigo();
                
                a.setIdAbrigo(rs.getInt("idAbrigo"));
                a.setNomeAbrigo(rs.getString("nomeAbrigo"));
                a.setLocalAbrigo(rs.getString("localAbrigo"));
                a.setResponsavelAbrigo(rs.getString("responsavelAbrigo"));
                a.setLotacaoAbrigo(rs.getInt("lotacaoAbrigo"));

                
                abrigos.add(a);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Erro ao Retornar AbrigoDAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return abrigos;
    }

    

}
