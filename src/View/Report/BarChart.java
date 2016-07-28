package View.Report;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
 * Class to draw the chart for activities
 *
 * @author Lourdes Villca
 */
public class BarChart extends JPanel {

    public BarChart() {

        JFreeChart barChart = ChartFactory.createBarChart("All Activities", "Application", "Time", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        this.add(chartPanel);
    }

    /**
     * Define the values to generate the chart
     *
     * @return the dataset with the information of the activities
     */
    private CategoryDataset createDataset() {
        //application list
        final String fiat = "productivo";
        final String audi = "no productivo";
        final String ford = "IntelliJ";
        final String speed = "Facebook";
        final String millage = "Postman";
        final String userrating = "Ruby";
        final String safety = "safety";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, fiat, speed);
        dataset.addValue(3.0, fiat, userrating);
        dataset.addValue(5.0, fiat, millage);
        dataset.addValue(5.0, fiat, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, millage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, millage);
        dataset.addValue(6.0, ford, safety);

        return dataset;
    }
}
