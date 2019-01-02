package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author 
 */
public class Conexao {

    private static Connection conexao;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost/consciencia_animal";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        try {
            Properties propriedades = new Properties();
            propriedades.setProperty("user", USUARIO);
            propriedades.setProperty("password", SENHA);

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(HOST, propriedades);
            return conexao;
        } catch (SQLException | ClassNotFoundException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            return null;
        }
    }

    public static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
    }

    public static void truncate() {
        conectar();
        if (conexao!=null) {
            String sql = "";
            sql += "TRUNCATE TABLE abrigo";
            sql += "TRUNCATE TABLE tipo_veiculo";
            sql += "TRUNCATE TABLE veiculo";
            sql += "TRUNCATE TABLE ocorrencia";
            sql += "TRUNCATE TABLE salvamento";
            sql += "TRUNCATE TABLE porte_animal";
            sql += "TRUNCATE TABLE animal";

            
            try{
                Statement st = conexao.createStatement();              
                st.addBatch("SET FOREIGN_KEY_CHECKS = 0;");
                st.addBatch("TRUNCATE TABLE abrigo;");
                st.addBatch("TRUNCATE TABLE tipo_veiculo;");
                st.addBatch("TRUNCATE TABLE veiculo;");
                st.addBatch("TRUNCATE TABLE ocorrencia;");
                st.addBatch("TRUNCATE TABLE salvamento;");
                st.addBatch("TRUNCATE TABLE porte_animal;");
                st.addBatch("TRUNCATE TABLE animal;");
                st.addBatch("SET FOREIGN_KEY_CHECKS = 1;");
                st.executeBatch();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                desconectar();
            }
        }
    }

}
