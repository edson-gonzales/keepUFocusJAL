package View.OfficeTime;

import javax.swing.*;
import java.awt.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Controller.Activity.ActivityController;
import Model.Applications.ActivityType;
import Utils.Constants;
import Utils.FocusTimeUtils;
import Utils.HourUtil;
import View.AdminUser.InitComponent;
import View.Events.OfficeTimeEvent;
import java.util.ResourceBundle;

/**
 * Form to register the office time
 *
 * @auhtor Lourdes Villca
 */
public class OfficeTime extends JDialog {
    private JLabel fromHour;
    private JLabel toHour;
    private JLabel activity;

    private JComboBox fromHourCbx;
    private JComboBox toHourCbx;
    private JComboBox activitycbx;
    private ArrayList<HourUtil> hourUtils;
    private JButton acceptButton;
    private JButton cancelButton;
    private ResourceBundle resource;

    /**
     * Initialize the components
     */
    public OfficeTime() {
        ImageIcon icon = new ImageIcon(getClass().getResource("../../Resources/images/iconKUF.png"));
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        setIconImage(icon.getImage());
        this.setTitle("Register activity");
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.add(buildPanel());
        this.setSize(400, 200);
        this.setVisible(true);
        FocusTimeUtils.centerWindow(this);

    }

    /**
     * This method builds the main panel
     *
     * @return the built panel
     */
    public JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        fromHour = new JLabel("From");
        toHour = new JLabel("To");
        fromHourCbx = InitComponent.initComboBox(fromHourCbx, new Dimension(100, 25), panel);
        toHourCbx = InitComponent.initComboBox(toHourCbx, new Dimension(100, 25), panel);
        activity = new JLabel("Activity");
        activitycbx = InitComponent.initComboBox(activitycbx, new Dimension(100, 25), panel);
        acceptButton = InitComponent.initButton(acceptButton, resource.getString("common.label.acceptButton"), panel);
        cancelButton = InitComponent.initButton(cancelButton, resource.getString("common.label.cancelButton"), panel);
        acceptButton.setActionCommand(Constants.SAVE_OFFICETIME);
        cancelButton.setActionCommand(Constants.CANCEL_OFFICETIME);

        acceptButton.addActionListener(new OfficeTimeEvent(this));
        cancelButton.addActionListener(new OfficeTimeEvent(this));

        setPositionComponents();
        setDataComboBox();
        addContentToPanel(panel);
        return panel;
    }

    /**
     * This method set the possition of the components
     */
    public void setPositionComponents() {
        fromHour.setBounds(10, 10, 50, 25);
        fromHourCbx.setBounds(60, 10, 100, 25);
        toHour.setBounds(180, 10, 50, 25);
        toHourCbx.setBounds(210, 10, 100, 25);
        activity.setBounds(10, 55, 80, 25);
        activitycbx.setBounds(100, 55, 150, 25);
        acceptButton.setBounds(70, 110, 100, 25);
        cancelButton.setBounds(180, 110, 100, 25);
    }

    /**
     * This method adds the components to the panel
     *
     * @param panel
     */
    public void addContentToPanel(JPanel panel) {
        panel.add(fromHour);
        panel.add(toHour);
        panel.add(activity);
    }

    /**
     * This method set the data(Hours) into the ComboBox
     */
    public void setDataComboBox() {
        ActivityController controller = new ActivityController();
        ArrayList<ActivityType> activityType = controller.getActivities();
        for (ActivityType actiType : activityType) {
            activitycbx.addItem(actiType);
        }
        hourUtils = FocusTimeUtils.hoursList();
        for (HourUtil hour : hourUtils) {
            fromHourCbx.addItem(hour);
            toHourCbx.addItem(hour);

        }

    }

    /**
     * This method get the current date to save the activity in the current date
     *
     * @return the current date
     */
    public String getCurrentDate() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateString = formatter.format(new Date());
        return dateString;
    }

    /**
     * Get the selected time from the "From" comboBox
     *
     * @return the selected date
     */
    public java.sql.Timestamp getFromHourCbx() {
        String fromHour = fromHourCbx.getSelectedItem().toString();
        java.sql.Timestamp dateTime = FocusTimeUtils.convertTimeToTimeStamp(getCurrentDate(), fromHour);
        return dateTime;
    }

    /**
     * Get the selected time from the "To" ComboBox
     *
     * @return the selected comboBox
     */
    public java.sql.Timestamp getToHourCbx() {
        String toHour = toHourCbx.getSelectedItem().toString();
        java.sql.Timestamp dateTime = FocusTimeUtils.convertTimeToTimeStamp(getCurrentDate(), toHour);
        return dateTime;
    }

    /**
     * Get the selected activity from the comboBox
     *
     * @return the selected activity
     */
    public ActivityType getActivitycbx() {
        return (ActivityType) activitycbx.getSelectedItem();
    }

}
