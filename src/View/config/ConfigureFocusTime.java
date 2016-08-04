package View.config;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;

import Utils.Constants;
import View.AdminUser.InitComponent;


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
    private JCheckBox sundayCheckBox;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JLabel hoursToBeMonitoredLabel;
    private JComboBox startHoursBox;
    private JComboBox endHoursBox;
    private JButton saveButton;
    private JPanel daysPanel;
    private JPanel hoursPanel;
    private ResourceBundle resource;

    /**
     * Init the components and define the Layout for panels
     */
    public ConfigureFocusTime() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        daysPanel = buildDaysPanel();
        hoursPanel = buildHoursPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(daysPanel);
        this.add(hoursPanel);
        saveButton = InitComponent.initButton(saveButton, resource.getString("config.button.save"), this);

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
        daysPanel.setBorder(BorderFactory.createTitledBorder(resource.getString("config.label.daysTitle")));
        daysPanel.setPreferredSize(new Dimension(350, 150));
        daysPanel.setMaximumSize(new Dimension(350, 150));
        daysPanel.setMinimumSize(new Dimension(350, 150));
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
        startHoursBox = InitComponent.initComboBox(startHoursBox, new Dimension(150, 25), panel);
        startHoursBox.addItem("8am");
        startHoursBox.addItem("9am");
        InitComponent.initLabel(toLabel, resource.getString("config.label.To"), panel);
        endHoursBox = InitComponent.initComboBox(endHoursBox, new Dimension(150, 25), panel);
        panel.setPreferredSize(new Dimension(350, 150));
        panel.setMaximumSize(new Dimension(350, 150));
        panel.setMinimumSize(new Dimension(350, 150));
        endHoursBox.addItem("10am");
        endHoursBox.addItem("12am");

        return panel;

    }

}
