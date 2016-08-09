package View.Report;

import View.Login.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.text.DecimalFormat;
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

        JFreeChart barChart = ChartFactory.createBarChart("All Activities", "Application", "Time Min", createDataset(startDate,endDate), PlotOrientation.VERTICAL, true, false, true);
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
        ArrayList<ApplicationFocusTime> appFocusTimeList = applicationFocusTime.getTrackedApplicationByCategory(startDate, endDate, Session.getUser().getUserId());
        for (ApplicationFocusTime app : appFocusTimeList){
            Double time = validateTime(app.getTotalTime());
            dataset.addValue(time, app.getApplicationCategory().getApplicationCategoryName(), app.getApplicationCategory().getApplicationCategoryName());
        }
        return dataset;
    }

    /**
     * This method convert the totaltime in minutes
     * @param time time in seconds
     * @return the time in minutes
     */
    public Double validateTime(int time){
        int value = time / 60;
        if(time/60 < 1){
            return 1.0;
        }else {
            return value*1.0;
        }

    }

}
