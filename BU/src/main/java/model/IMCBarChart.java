package model;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class IMCBarChart extends JFrame {

    public IMCBarChart(String title) {
        super(title);

        // Crear un dataset para el gráfico de barras
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Datos de ejemplo: (nombre de la persona, peso en kg, altura en metros)
        String[] nombres = {"Persona 1", "Persona 2", "Persona 3", "Persona 4", "Persona 5"};
        double[][] datos = {
                {60, 1.7}, {70, 1.8}, {80, 1.75}, {90, 1.85}, {100, 1.9}
        };

        // Calcular IMC y agregar datos al dataset
        for (int i = 0; i < nombres.length; i++) {
            double peso = datos[i][0];
            double altura = datos[i][1];
            double imc = peso / (altura * altura); // Fórmula IMC
            dataset.addValue(imc, "IMC", nombres[i]); // Agrega el IMC al dataset con nombre como categoría
        }

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "Gráfico de IMC",               // Título del gráfico
                "Persona",                      // Etiqueta del eje X
                "IMC",                          // Etiqueta del eje Y
                dataset,                        // Dataset que contiene los datos
                PlotOrientation.VERTICAL,       // Orientación del gráfico
                true,                           // Incluir leyenda
                true,                           // Incluir herramientas de gráficos
                false                           // Incluir URL de gráficos
        );

        // Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        IMCBarChart chart = new IMCBarChart("Gráfico de IMC");
        chart.pack();
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}