package View.AdminUser;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;

import Utilities.SpringUtilities;
import Utils.Constants;

/**
 * Build the Left side of the User form
 *
 * @author Lourdes Villca
 */

public class RightPanelUserUI extends JPanel {
    private JLabel addressLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JLabel possitionLabel;
    private JTextField addressTxt;
    private JTextField emailTxt;
    private JComboBox roleCbox;
    private JComboBox positionCbox;
    private ResourceBundle resource;

    /**
     * Init the components and define a layout the panel
     */
    public RightPanelUserUI() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        this.setLayout(new SpringLayout());
        buildRightPanel();
    }

    /**
     * Method to build the right panel with the corresponding data
     *
     * @return return a panel with all their components
     */
    private void buildRightPanel() {
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(addressLabel, resource.getString("admin.label.addressLabel"), this);
        addressTxt = InitComponent.initTextBox(addressTxt, txtSize, this);

        InitComponent.initLabel(emailLabel, resource.getString("admin.label.emailLabel"), this);
        emailTxt = InitComponent.initTextBox(emailTxt, txtSize, this);

        InitComponent.initLabel(possitionLabel, resource.getString("admin.label.possitionLabel"), this);
        positionCbox = InitComponent.initComboBox(positionCbox, txtSize, this);

        InitComponent.initLabel(roleLabel, resource.getString("admin.label.roleLabel"), this);
        roleCbox = InitComponent.initComboBox(roleCbox, txtSize, this);

        InitComponent.setSizeComponent(this, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(this, 4, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

    }

    /**
     * Returns the address of the user
     *
     * @return the address
     */
    public String getAddress() {
        return addressTxt.getText();
    }

    /**
     * Returns the email of the user
     *
     * @return the E-mail
     */
    public String getEmail() {
        return emailTxt.getText();
    }

    /**
     * Returns the selected rol of the user
     *
     * @return the Role
     */
    public String getRole() {
        return roleCbox.getSelectedItem().toString();
    }

    /**
     * Returns the selected possition of the user
     *
     * @return the position
     */
    public String getPosition() {
        return positionCbox.getSelectedItem().toString();
    }
}
