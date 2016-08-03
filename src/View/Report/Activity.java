package View.Report;

import Model.Connections.Connection;
import Model.Connections.DataAccess;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


/**
 * Display the chart and the information of the activity
 *
 * @author Lourdes Villca
 */
public class Activity extends JPanel {
    private JLabel periodTime;

    /**
     * Init the components and define the layout for panels
     */
    public Activity() {
        periodTime = new JLabel("Test activity");

        TableActivity tableActivity = new TableActivity();
        BarChart chart = new BarChart();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(periodTime);
        this.add(chart);
        this.add(tableActivity);

    }

    /**
     * Method that calculate the total time expressed in seconds and convert it in Hours, Minutes and Seconds
     *
     * @param totalTime expressed in seconds
     * @return a String with the time expressed in Hours, Minutes and Seconds
     */
    public String convertTime(int totalTime){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String result = "";
        if(totalTime > 3600){
            hours = totalTime/3600;
            totalTime = totalTime % 3600;
            result += hours;
        }

        if(totalTime > 60){
            minutes = totalTime/60;
            seconds = totalTime%60;
            result += minutes;
        }
        else{
            seconds = totalTime;
            result += seconds;
        }

         return result;
    }

}
