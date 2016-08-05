package View.AdminUser;

import javax.swing.*;
import java.awt.Dimension;

import Utilities.SpringUtilities;

import java.util.ResourceBundle;

import Utils.Constants;


/**
 * Build the right side of the User Form
 *
 * @author Lourdes Villca
 */
public class LeftPanelUserUI extends JPanel {
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JTextField userTxt;
    private JPasswordField passwordTxt;
    private ResourceBundle resource;

    /**
     * Init the component and define a layout for the panel
     */
    public LeftPanelUserUI() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.setLayout(new SpringLayout());
        buildLeftPanel();
    }

    /**
     * Method to build the left panel with the corresponding data
     *
     * @return a panel with all their components
     */
    private void buildLeftPanel() {
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(nameLabel, resource.getString("admin.label.name"), this);
        nameTxt = InitComponent.initTextBox(nameTxt, txtSize, this);

        InitComponent.initLabel(lastNameLabel, resource.getString("admin.label.LastName"), this);
        lastNameTxt = InitComponent.initTextBox(lastNameTxt, txtSize, this);

        InitComponent.initLabel(userLabel, resource.getString("admin.label.userName"), this);
        userTxt = InitComponent.initTextBox(userTxt, txtSize, this);

        InitComponent.initLabel(passwordLabel, resource.getString("admin.label.passwordLabel"), this);
        passwordTxt = InitComponent.initJPasswordField(passwordTxt, txtSize, this);

        InitComponent.setSizeComponent(this, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(this, 4, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

    }

    /**
     * Returns the first name of the user
     *
     * @return the Name
     */
    public String getName() {
        return nameTxt.getText();
    }

    /**
     * Returns the Last name of the user
     *
     * @return the Last Name
     */
    public String getLastName() {
        return lastNameTxt.getText();
    }

    /**
     * Returns the user name of the user
     *
     * @return the user name
     */
    public String getUserName() {
        return userTxt.getText();
    }

    /**
     * Returns the password of the user
     *
     * @return the password
     */
    public String getPassword() {
        return passwordTxt.getText();
    }
    public void setName(String userFirstName){
       this.nameTxt.setText(userFirstName);
    }
    public void setLastName(String lastName){
        this.lastNameTxt.setText(lastName);
    }
    public void setUserName(String userName){
        this.userTxt.setText(userName);
    }
    public void setPassword(String password){
        this.passwordTxt.setText(password);
    }


}