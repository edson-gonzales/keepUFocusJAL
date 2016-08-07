package View.config.Application;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import java.util.ResourceBundle;

import Utils.Constants;
import View.AdminUser.InitComponent;
import View.Events.ApplicationEvent;
import Model.Applications.Application;
import View.Main;

/**
 * This class contain the form to update application
 *
 * @author Lourdes Villca
 */
public class ApplicationForm extends JDialog {

    private JLabel applicationNameLabel;
    private JLabel productiveLabel;
    private JLabel nonProductivelabel;
    private JRadioButton productiveRadio;
    private JRadioButton nonProductiveRadio;
    private JButton acceptButton;
    private JButton cancelButton;
    private ResourceBundle resource;
    private Application application;

    /**
     * Initialize the Dialog with its components
     */
    public ApplicationForm() {
        super((JFrame) Main.getMain());
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.add(buildPanel());
        this.setTitle("Update Application");
        this.setSize(400, 200);
        this.setVisible(true);
        setLocationRelativeTo((JFrame) Main.getMain());
    }

    /**
     * Build the content of the dialog to select if an Application is productive or not
     *
     * @return the built panel
     */
    public JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        applicationNameLabel = new JLabel("");
        productiveLabel = new JLabel(resource.getString("application.label.productive"));
        productiveRadio = new JRadioButton();
        nonProductivelabel = new JLabel(resource.getString("application.label.noProductive"));
        nonProductiveRadio = new JRadioButton();
        acceptButton = InitComponent.initButton(acceptButton, resource.getString("common.label.acceptButton"), panel);
        cancelButton = InitComponent.initButton(cancelButton, resource.getString("common.label.cancelButton"), panel);
        setPositionOfComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(productiveRadio);
        group.add(nonProductiveRadio);

        panel.add(applicationNameLabel);
        panel.add(productiveLabel);
        panel.add(productiveRadio);
        panel.add(nonProductivelabel);
        panel.add(nonProductiveRadio);
        addEventsToButtons();
        return panel;
    }

    /**
     * Set the position for each components in the dialog
     */
    public void setPositionOfComponents() {
        applicationNameLabel.setBounds(30, 20, 330, 30);
        productiveLabel.setBounds(20, 50, 120, 30);
        productiveRadio.setBounds(120, 50, 80, 30);
        nonProductivelabel.setBounds(20, 80, 120, 30);
        nonProductiveRadio.setBounds(120, 80, 80, 30);
        acceptButton.setBounds(100, 120, 80, 30);
        cancelButton.setBounds(200, 120, 80, 30);
    }

    /**
     * Add events to each buttons, accept and cancel button
     */
    public void addEventsToButtons() {
        acceptButton.setActionCommand(Constants.UPDATE_APP);
        cancelButton.setActionCommand(Constants.CANCEL_APP);
        acceptButton.addActionListener(new ApplicationEvent(this));
        cancelButton.addActionListener(new ApplicationEvent(this));
    }

    /**
     * Set the text label of the application name with data from the database
     *
     * @param applicationNameLabel application name
     */
    public void setApplicationNameLabel(String applicationNameLabel) {
        this.applicationNameLabel.setText(applicationNameLabel);
    }

    /**
     * Check the radio Button if the category of the application is non productive
     *
     * @param nonProductiveRadio selected radio button
     */
    public void setNonProductiveRadio(boolean nonProductiveRadio) {
        this.nonProductiveRadio.setSelected(nonProductiveRadio);
    }

    /**
     * Check the radio Button if the category of the application is productive
     *
     * @param productiveRadio selected radio button
     */
    public void setProductiveRadio(boolean productiveRadio) {
        this.productiveRadio.setSelected(productiveRadio);
    }

    /**
     * Get the Radio button for productive option
     *
     * @return the productive radio button
     */

    public JRadioButton getProductiveRadio() {
        return productiveRadio;
    }

    /**
     * Get the Radio button for non productive application
     *
     * @return the non productive radio button
     */

    public JRadioButton getNonProductiveRadio() {
        return nonProductiveRadio;
    }

    /**
     * Set the application info from the database
     *
     * @param application it is the application to be updated
     */
    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * Get the Application object to be updated
     *
     * @return the Application
     */
    public Application getApplication() {
        return application;
    }
}
