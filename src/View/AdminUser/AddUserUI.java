package View.AdminUser;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.util.ResourceBundle;

import Utilities.SpringUtilities;
import Utils.Constants;
import View.Events.UserEvent;

/**
 * UI to Add User, Form with the fields of user
 *
 * @author Lourdes Villca
 */

public class AddUserUI extends JPanel {
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel activeLabel;
    private JLabel addressLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JLabel possitionLabel;
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JTextField userTxt;
    private JTextField passwordTxt;
    private JCheckBox activeCbox;
    private JTextField addressTxt;
    private JTextField emailTxt;
    private JComboBox roleCbox;
    private JComboBox possitionCbox;
    private JButton acceptBtn;
    private JButton cancelBtn;
    private UserEvent userEvent;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private ResourceBundle resource;

    /**
     * Init the components and define a layout for panels
     */
    public AddUserUI() {

        resource = resource.getBundle(Constants.APLICATION_RESOURCES);

        leftPanel = buildLeftPanel();
        rightPanel = buildRightPanel();
        acceptBtn = new JButton(resource.getString("common.label.acceptButton"));
        cancelBtn = new JButton(resource.getString("common.label.cancelButton"));
        this.setLayout(new BorderLayout());

        acceptBtn.addActionListener(new UserEvent(this));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        bottomPanel.add(acceptBtn);
        bottomPanel.add(cancelBtn);

        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.PAGE_END);

        this.setBorder(BorderFactory.createTitledBorder("Add New User"));
    }

    /**
     * Method to build the left panel with the corresponding data
     *
     * @return return a panel with all their components
     */
    private JPanel buildLeftPanel() {
        JPanel panel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(nameLabel, resource.getString("admin.label.name"), panel);
        InitComponent.initTextBox(nameTxt, txtSize, panel);

        InitComponent.initLabel(lastNameLabel, resource.getString("admin.label.LastName"), panel);
        InitComponent.initTextBox(lastNameTxt, txtSize, panel);

        InitComponent.initLabel(userLabel, resource.getString("admin.label.userName"), panel);
        InitComponent.initTextBox(userTxt, txtSize, panel);

        InitComponent.initLabel(passwordLabel, resource.getString("admin.label.passwordLabel"), panel);
        InitComponent.initTextBox(passwordTxt, txtSize, panel);
        InitComponent.initLabel(activeLabel, resource.getString("admin.label.activeLabel"), panel);

        activeCbox = new JCheckBox();
        panel.add(activeCbox);

        InitComponent.setSizeComponent(panel, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

        return panel;
    }

    /**
     * Method to build the right panel with the corresponding data
     *
     * @return return a panel with all their components
     */
    private JPanel buildRightPanel() {
        JPanel rightPanel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(addressLabel, resource.getString("admin.label.addressLabel"), rightPanel);
        InitComponent.initTextBox(addressTxt, txtSize, rightPanel);

        InitComponent.initLabel(emailLabel, resource.getString("admin.label.emailLabel"), rightPanel);
        InitComponent.initTextBox(emailTxt, txtSize, rightPanel);

        InitComponent.initLabel(possitionLabel, resource.getString("admin.label.possitionLabel"), rightPanel);
        InitComponent.initComboBox(possitionCbox, txtSize, rightPanel);

        InitComponent.initLabel(roleLabel, resource.getString("admin.label.roleLabel"), rightPanel);
        InitComponent.initComboBox(roleCbox, txtSize, rightPanel);

        InitComponent.setSizeComponent(rightPanel, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(rightPanel, 4, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

        return rightPanel;
    }

    /**
     * Returns the first name of the user
     * @return the Name
     */
    public String getName() {
        return nameTxt.getText();
    }

    /**
     * Returns the Last name of the user
     * @return the Last Name
     */
    public String getLastName() {
        return lastNameTxt.getText();
    }

    /**
     * Returns the user name of the user
     * @return the user name
     */
    public String getUserName() {
        return userTxt.getText();
    }

    /**
     * Returns the password of the user
     * @return the password
     */
    public String getPassword() {
        return passwordTxt.getText();
    }

    /**
     * Returns true if the checkbox is selected otherwise false
     * @return the selected status
     */
    public boolean getStatus() {
        return activeCbox.isSelected();
    }

    /**
     * Returns the address of the user
     * @return the address
     */
    public String getAddress() {
        return addressTxt.getText();
    }

    /**
     * Returns the email of the user
     * @return the E-mail
     */
    public String getEmail() {
        return emailTxt.getText();
    }

    /**
     * Returns the selected rol of the user
     * @return the Role
     */
    public String getRole() {
        return roleCbox.getSelectedItem().toString();
    }

    /**
     * Returns the selected possition of the user
     * @return the possition
     */
    public String getPossition() {
        return possitionCbox.getSelectedItem().toString();
    }
}
