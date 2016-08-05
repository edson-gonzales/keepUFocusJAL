package View.AdminUser;

import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.UserAdmin.UserControllers;
import Model.Common.Position;
import Model.UserAdmin.Role;
import Utilities.SpringUtilities;
import Utils.Constants;

/**
 * Build the Left side of the User form
 *
 * @author Lourdes Villca
 */

public class RightPanelUserUI extends JPanel {
    private JLabel roleLabel;
    private JLabel possitionLabel;
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

        InitComponent.initLabel(possitionLabel, resource.getString("admin.label.possitionLabel"), this);
        UserControllers controller = new UserControllers();
        List<Position> positionList = new ArrayList<Position>();

        positionList = controller.getListPosition();
        positionCbox = InitComponent.initComboBox(positionCbox, txtSize, this);

        for(Position position: positionList){
            positionCbox.addItem(position);
        }
        InitComponent.initLabel(roleLabel, resource.getString("admin.label.roleLabel"), this);
        roleCbox = InitComponent.initComboBox(roleCbox, txtSize, this);

        List<Role> roleList = new ArrayList<Role>();
        roleList = controller.getListRole();
        for(Role role: roleList){
            roleCbox.addItem(role);
        }

        InitComponent.setSizeComponent(this, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(this, 2, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

    }

    /**
     * Returns the selected rol of the user
     *
     * @return the Role
     */
    public Role getRole() {
        return (Role)roleCbox.getSelectedItem();
    }

    /**
     * Returns the selected possition of the user
     *
     * @return the position
     */
    public Position getPosition() {
        return (Position)positionCbox.getSelectedItem();
    }

    public void setRoleCbox(int role) {
        this.roleCbox.setSelectedItem(role);
    }

    public void setPositionCbox(int position) {
        this.positionCbox.setSelectedItem(position);
    }


}
