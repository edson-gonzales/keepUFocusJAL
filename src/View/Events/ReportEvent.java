package View.Events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import View.Report.Activity;

import javax.swing.*;

/**
 * @author Lourdes Villca
 */
public class ReportEvent implements ActionListener {
    private Activity activity;
    private JFrame mainWindow;

    public ReportEvent(JFrame mainWindow, Activity activity) {
        this.mainWindow = mainWindow;
        this.activity = activity;
    }

    /**
     * This method is invoked when an action occurs
     *
     * @param e action event that gives information about the event and its source
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //activity = new Activity();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = dateFormatter.format(activity.getDatePickerFrom());
        String endDate = dateFormatter.format(activity.getDatePickerTo());

        mainWindow.getContentPane().removeAll();
        activity = new Activity(mainWindow, startDate, endDate);
        mainWindow.getContentPane().add(activity);

        refreshMainFrame();

        System.out.println(startDate);
    }

    /**
     * Method to refresh the content of the main frame
     */
    public void refreshMainFrame() {
        mainWindow.setSize(mainWindow.getWidth() + 1, mainWindow.getHeight() + 1);
        mainWindow.setSize(mainWindow.getWidth() - 1, mainWindow.getHeight() - 1);
    }
}
