package View.config.Application;

import Utils.Constants;
import View.AdminUser.InitComponent;
import View.Events.ApplicationEvent;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.Dimension;
import java.util.ResourceBundle;

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

    /**
     *
     */
    public ApplicationForm() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.add(buildPanel());
        this.setTitle("Update Application");
        this.setSize(300, 200);
        this.setVisible(true);
    }

    /**
     *
     * @return
     */
    public JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        applicationNameLabel = new JLabel("Nombre app");
        productiveLabel = new JLabel(resource.getString("application.label.productive"));
        productiveRadio = new JRadioButton();
        nonProductivelabel = new JLabel(resource.getString("application.label.noProductive"));
        nonProductiveRadio = new JRadioButton();
        acceptButton = InitComponent.initButton(acceptButton, resource.getString("common.label.acceptButton"), panel);
        cancelButton = InitComponent.initButton(cancelButton, resource.getString("common.label.cancelButton"), panel);
        applicationNameLabel.setBounds(30,20,80,30);
        productiveLabel.setBounds(10, 50, 120, 30);
        productiveRadio.setBounds(100,50,80,30);
        nonProductivelabel.setBounds(10, 80, 120, 30);
        nonProductiveRadio.setBounds(100,80,80,30);
        acceptButton.setBounds(10,120,80,30);
        cancelButton.setBounds(101,120,80,30);

        ButtonGroup group = new ButtonGroup();
        group.add(productiveRadio);
        group.add(nonProductiveRadio);
        panel.add(applicationNameLabel);
        panel.add(productiveLabel);
        panel.add(productiveRadio);
        panel.add(nonProductivelabel);
        panel.add(nonProductiveRadio);
        acceptButton.setActionCommand(Constants.UPDATE_APP);
        cancelButton.setActionCommand(Constants.CANCEL_APP);

        acceptButton.addActionListener(new ApplicationEvent(this));
        cancelButton.addActionListener(new ApplicationEvent(this));

        return panel;
    }

    public void setApplicationNameLabel(String applicationNameLabel) {
        this.applicationNameLabel.setText(applicationNameLabel);
    }
    public void setNonProductiveRadio(boolean nonProductiveRadio) {
        this.nonProductiveRadio.setSelected(nonProductiveRadio);
    }

    public void setProductiveRadio(boolean productiveRadio) {
        this.productiveRadio.setSelected(productiveRadio);
    }
}
