package View.Report;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Class to draw the chart for activities
 *
 * @author Lourdes Villca
 */
public class BarChart extends JPanel {
    private ApplicationFocusTime applicationFocusTime;

    /**
     * Initialize the components for build the BarChart
     * @param startDate Start date to make the query
     * @param endDate end date to make the query
     */
    public BarChart(String startDate, String endDate) {

        JFreeChart barChart = ChartFactory.createBarChart("All Activities", "Application", "Time", createDataset(startDate,endDate), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        this.add(chartPanel);
    }

    /**
     * Define the values to generate the chart
     *
     * @return the dataset with the information of the activities
     */
    private CategoryDataset createDataset(String startDate, String endDate) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        applicationFocusTime = new ApplicationFocusTime();
        ArrayList<ApplicationFocusTime> appFocusTimeList = applicationFocusTime.getTrackedApplication(startDate, endDate);
        for (ApplicationFocusTime app : appFocusTimeList){
            dataset.addValue(app.getTotalTime()/3600,app.getApplicationCategory().getApplicationCategoryName(),app.getApplication().getApplicationName());
        }
        return dataset;
    }

}
