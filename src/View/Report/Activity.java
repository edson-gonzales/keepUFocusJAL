package View.Report;

import View.Events.ReportEvent;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.util.*;

import Utils.Constants;
import View.AdminUser.InitComponent;

/**
 * Display the chart and the information of the activity
 *
 * @author Lourdes Villca
 */
public class Activity extends JPanel {
    private JLabel periodTime;
    private JLabel fromDate;
    private JLabel toDate;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePickerFrom;
    private JDatePickerImpl datePickerTo;
    private JButton generate;
    private TableActivity tableActivity;
    private BarChart chart;
    private ResourceBundle resource;
    private ReportEvent reportEvent;
    private JFrame mainWindow;

    /**
     * Init the components and define the layout for panels
     */
    public Activity(JFrame mainWindow, String startDate, String endDate) {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);

        tableActivity = new TableActivity(startDate, endDate);
        chart = new BarChart(startDate, endDate);

        this.mainWindow = mainWindow;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(addDatePickerPanel());
        this.add(chart);
        this.add(tableActivity);
    }

    /**
     * This method build the panel where is the DatePicker
     *
     * @return the panel with the DatePicker
     */
    public JPanel addDatePickerPanel() {
        JPanel panel = new JPanel();

        InitComponent.initLabel(fromDate, resource.getString("report.label.from"), panel);
        generate = InitComponent.initButton(generate, resource.getString("report.label.generateButton"), panel);

        datePickerFrom = buildDatePicker();
        datePickerTo = buildDatePicker();

        reportEvent = new ReportEvent(mainWindow, this);
        generate.addActionListener(reportEvent);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(datePickerFrom);
        InitComponent.initLabel(toDate, resource.getString("report.label.to"), panel);
        panel.add(datePickerTo);
        panel.add(generate);

        return panel;
    }

    /**
     * This method build the DatePicker component
     *
     * @return the built DatePicker
     */
    public JDatePickerImpl buildDatePicker() {
        model = new UtilDateModel();
        JDatePickerImpl datePicker;
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setMaximumSize(new Dimension(250, 30));
        model.setSelected(true);
        return datePicker;
    }

    /**
     * This method return the selected date
     *
     * @return The from date selected from the DatePicker
     */
    public Date getDatePickerFrom() {
        return (Date) datePickerFrom.getModel().getValue();
    }

    /**
     * This method set the selected Date
     *
     * @param datePickerFrom the selected date from the DatePicker
     */
    public void setDatePickerFrom(JDatePickerImpl datePickerFrom) {
        this.datePickerFrom = datePickerFrom;
    }

    /**
     * This method return the selected date from TO DatePicker
     *
     * @return the selected DatePicker
     */
    public Date getDatePickerTo() {
        return (Date) datePickerTo.getModel().getValue();
    }

    /**
     * This method set the selected date from the TO DatePicker
     *
     * @param datePickerTo the selected DatePicker
     */
    public void setDatePickerTo(JDatePickerImpl datePickerTo) {
        this.datePickerTo = datePickerTo;
    }
}
