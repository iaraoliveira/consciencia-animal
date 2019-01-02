package graficos;

import database.Conexao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

/**
 *
 * @author Alunos
 */
public class GraficoPizza {
    
    public GraficoPizza() {
        PieChart graficoPizza = new PieChartBuilder().width(800).height(600).build();
        graficoPizza.setTitle("Graficos Felizes");
        Color[] sliceColors = new Color[]{
            new Color(0, 97, 142),
            new Color(142, 0, 0),
            new Color(0, 142, 80)};
        graficoPizza.getStyler().setSeriesColors(sliceColors);
        String sql = "SELECT COUNT(idSalvamento) as quantidade, localSalvamento, MONTH(dataSalvamento) FROM salvamento \n"
                + "WHERE MONTH(dataSalvamento)  = 5"
                + "\nGROUP BY localSalvamento, MONTH(dataSalvamento) ";
        try {
            Statement s = Conexao.conectar().createStatement();
            s.execute(sql);
            ResultSet re = s.getResultSet();
            int total = 0;
            while (re.next()) {
                total += re.getInt("quantidade");
            }
            
            re.beforeFirst();
            while (re.next()) {
                int quantidade = re.getInt("quantidade");
                float percentual = (re.getInt("quantidade") * 100) / total;
                graficoPizza.addSeries(re.getString("localSalvamento"), percentual);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GraficoPizza.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jFrame = new SwingWrapper<PieChart>(graficoPizza).displayChart();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(820, 620);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - jFrame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - jFrame.getHeight()) / 2);
        jFrame.setLocation(x, y-20);
        
    }
    
}
