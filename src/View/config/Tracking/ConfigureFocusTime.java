package View.config.Tracking;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import Utils.Constants;
import Utils.FocusTimeUtils;
import Utils.HourUtil;
import View.AdminUser.InitComponent;
import View.Events.ConfigureFocusTimeEvent;


/**
 * Configure the days and hours to be tracked
 *
 * @author Lourdes Villca
 */
public class ConfigureFocusTime extends JPanel {
    private JLabel daysToSelectTitleLabel;
    private JLabel sundayLabel;
    private JLabel mondayLabel;
    private JLabel tuesdayLabel;
    private JLabel wednesdayLabel;
    private JLabel thursdayLabel;
    private JLabel fridayLabel;
    private JLabel startHourLabel;
    private JLabel endHourLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel totalHour;
    private JCheckBox sundayCheckBox;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JCheckBox[] weekDays;
    private JLabel hoursToBeMonitoredLabel;
    private JComboBox startHoursBox;
    private JComboBox endHoursBox;
    private JButton saveButton;
    private JPanel daysPanel;
    private JPanel hoursPanel;
    private ArrayList<HourUtil> hourUtils;
    private ResourceBundle resource;
    private HashMap<String, JCheckBox> daysWeek;

    /**
     * Init the components and define the Layout for panels
     */
    public ConfigureFocusTime() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buildDaysPanel());
        this.add(buildHoursPanel());
        buildSaveButton();
    }

    /**
     * Method that build the Section to select the days to be tracked
     *
     * @return the Panel with the days to be selected
     */
    public JPanel buildDaysPanel() {
        JPanel daysPanel = new JPanel();
        daysPanel.setLayout(new BoxLayout(daysPanel, BoxLayout.X_AXIS));
        sundayCheckBox = InitComponent.initCheckBox(sundayCheckBox, resource.getString("config.label.sunday"), daysPanel);
        mondayCheckBox = InitComponent.initCheckBox(mondayCheckBox, resource.getString("config.label.monday"), daysPanel);
        tuesdayCheckBox = InitComponent.initCheckBox(tuesdayCheckBox, resource.getString("config.label.tuesday"), daysPanel);
        wednesdayCheckBox = InitComponent.initCheckBox(wednesdayCheckBox, resource.getString("config.label.wednesday"), daysPanel);
        thursdayCheckBox = InitComponent.initCheckBox(thursdayCheckBox, resource.getString("config.label.thursday"), daysPanel);
        fridayCheckBox = InitComponent.initCheckBox(fridayCheckBox, resource.getString("config.label.friday"), daysPanel);
        saturdayCheckBox = InitComponent.initCheckBox(saturdayCheckBox, resource.getString("config.label.saturday"), daysPanel);
        daysWeek = new HashMap<>();
        daysWeek.put("Sun", sundayCheckBox);
        daysWeek.put("Mon", mondayCheckBox);
        daysWeek.put("Tues", tuesdayCheckBox);
        daysWeek.put("Wed", wednesdayCheckBox);
        daysWeek.put("Thu", thursdayCheckBox);
        daysWeek.put("Fri", fridayCheckBox);
        daysWeek.put("Sat", saturdayCheckBox);

        daysPanel.setBorder(BorderFactory.createTitledBorder(resource.getString("config.label.daysTitle")));
        setDimension(daysPanel);

        return daysPanel;
    }

    /**
     * Method that build the hours section to be selected
     *
     * @return the Panel with the ComboBox to select the hours
     */
    public JPanel buildHoursPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(resource.getString("config.label.hoursTitle")));
        InitComponent.initLabel(fromLabel, resource.getString("config.label.from"), panel);
        startHoursBox = InitComponent.initComboBox(startHoursBox, new Dimension(100, 25), panel);
        InitComponent.initLabel(toLabel, resource.getString("config.label.To"), panel);
        endHoursBox = InitComponent.initComboBox(endHoursBox, new Dimension(100, 25), panel);
        totalHour = new JLabel("");
        hourUtils = FocusTimeUtils.hoursList();

        for (int i = 0; i < hourUtils.size(); i++) {
            startHoursBox.addItem(hourUtils.get(i));
            endHoursBox.addItem(hourUtils.get(i));
        }

        endHoursBox.setActionCommand(Constants.CALCULATE_HOUR);
        endHoursBox.addActionListener(new ConfigureFocusTimeEvent(this));
        panel.add(totalHour);
        setDimension(panel);
        return panel;
    }

    /**
     * Method that build the save button
     */
    public void buildSaveButton() {
        saveButton = InitComponent.initButton(saveButton, resource.getString("config.button.save"), this);
        saveButton.setActionCommand(Constants.SAVE_CONFIG);
        saveButton.addActionListener(new ConfigureFocusTimeEvent(this));
    }

    /**
     * Method that build the total Hours according the start and end date
     */
    public void buildTotalHours() {
        int start = ((HourUtil) startHoursBox.getSelectedItem()).getTimeMinutes();
        int end = ((HourUtil) endHoursBox.getSelectedItem()).getTimeMinutes();
        totalHour.setText(FocusTimeUtils.calculateTotalHour(start, end));

    }

    /**
     * Method that set the Dimension of the panels
     *
     * @param panel to be setting with a dimension
     */
    public void setDimension(JPanel panel) {
        panel.setPreferredSize(new Dimension(350, 150));
        panel.setMaximumSize(new Dimension(350, 150));
        panel.setMinimumSize(new Dimension(350, 150));
    }

    /**
     * Method that get the days with the selected days
     *
     * @return the String Days separated with "-"
     */
    public String selectedCheckBoxes() {
        String res = "";

        for (JCheckBox check : daysWeek.values()) {
            if (check.isSelected()) {
                res += check.getText() + "-";
            }
        }

        return res.substring(0, res.length() - 1);
    }

    /**
     * Method that get the selected end hour
     *
     * @return
     */
    public HourUtil getEndHoursBox() {
        return (HourUtil) endHoursBox.getSelectedItem();
    }

    /**
     * Method that get the selected start hour
     *
     * @return
     */
    public HourUtil getStartHoursBox() {
        return (HourUtil) startHoursBox.getSelectedItem();
    }

    /**
     * Method that set the end hour with the selected data
     *
     * @param endHoursBox end hour to be selected
     */
    public void setEndHoursBox(HourUtil endHoursBox) {
        this.endHoursBox.setSelectedItem(endHoursBox);
    }

    /**
     * Method that set the start hour with the selected data
     *
     * @param startHoursBox start hour to be selected
     */
    public void setStartHoursBox(HourUtil startHoursBox) {
        this.startHoursBox.setSelectedItem(startHoursBox);
    }

    /**
     * Method that split a String in base a parameter in this case "-"
     *
     * @param weekDaysString the string to be split
     */
    public void setWeekDays(String weekDaysString) {
        StringTokenizer tokenizer = new StringTokenizer(weekDaysString, "-");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            JCheckBox check = daysWeek.get(token);
            check.setSelected(true);
        }
    }

    /**
     * This method returns the List of Hours
     *
     * @return the Array List of Hours
     */
    public ArrayList<HourUtil> getHourUtils() {
        return hourUtils;
    }
}
