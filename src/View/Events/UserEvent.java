package View.Events;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import View.AdminUser.AddUserUI;
import Model.UserAdmin.User;
import View.AdminUser.SearchUserUI;
import View.AdminUser.TableUser;
import Controller.UserAdmin.UserControllers;
import Utils.Constants;
import View.Main;

/**
 * Class to manage user events
 *
 * @author Lourdes Villca
 */
public class UserEvent extends MouseAdapter implements ActionListener {
    private AddUserUI addUserUI;
    private TableUser tableUser;

    /**
     * Create a User event object
     *
     */
    public UserEvent(AddUserUI addUserUI) {
        this.addUserUI = addUserUI;
    }

    /**
     * Create a user event reference to table user
     *
     * @param tableUser where the event is executed
     */
    public UserEvent(TableUser tableUser) {
        this.tableUser = tableUser;
    }

    /**
     * This method is invoked when an action occurs inside the User administration view
     *
     * @param e action event that gives information about the event and its source
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {

            case Constants.USER_LIST://search a user
                break;
            case Constants.CREATE_USER://open a form to create a new user
                addUserUI = new AddUserUI();
                addUserUI.setVisible(true);
                break;

            case Constants.SAVE_USER: // accept button to save a user

                // send this information to the controller
                User user = new User();
                user.setFirstName(addUserUI.getLeftPanel().getName());
                user.setLastName(addUserUI.getLeftPanel().getLastName());
                user.setUserName(addUserUI.getLeftPanel().getUserName());
                user.setPassword(addUserUI.getLeftPanel().getPassword());
                user.setRoleId(addUserUI.getRightPanel().getRole().getRoleId());
                user.setPositionId(addUserUI.getRightPanel().getPosition().getPositionId());

                UserControllers controllerUsers = new UserControllers();
                controllerUsers.saveUser(user);
                addUserUI.dispose();

                break;

            case Constants.CANCEL_USER: // Cancel save user
                addUserUI.dispose();
                break;
        }

    }

    /**
     * This method is invoked when an action occurs in the User Table, when the update and delete icon is clicked
     *
     * @param evt mouse event that gives information about the event.
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        int row = tableUser.table.rowAtPoint(evt.getPoint());
        int column = tableUser.table.columnAtPoint(evt.getPoint());

        switch (column) {
            case Constants.UPDATE_USER: //Update User
                User user = (User)tableUser.table.getModel().getValueAt(row, 0);
                addUserUI = new AddUserUI();
                addUserUI.getLeftPanel().setName(user.getFirstName());
                addUserUI.getLeftPanel().setLastName(user.getLastName());
                addUserUI.getLeftPanel().setUserName(user.getUserName());
                addUserUI.getLeftPanel().setPassword(user.getPassword());
                //addUserUI.getRightPanel().setRoleCbox(user.getRoleId());
                //addUserUI.getRightPanel().setPositionCbox(user.getPositionId());


                addUserUI.setVisible(true);
                break;
            case Constants.DELETE_USER: //Delete User
                deleteDialog(row);
                break;
        }

    }

    /**
     * Display alert message to confirm to delete a User
     *
     * @param row selected row to be deleted
     */
    public void deleteDialog(int row) {
        int alertMessage = JOptionPane.showConfirmDialog(tableUser, "Do you want to delete this user?");
        if (alertMessage == JOptionPane.YES_OPTION) {
            User user = (User)tableUser.table.getModel().getValueAt(row, 0);
            user.delete();
            Main.getMain().getContentPane().removeAll();
            SearchUserUI searchUser = new SearchUserUI();
            refreshMainFrame(searchUser);
            System.out.println("delete row: " + row);
        }
    }
    /**
     * Method to refresh the content of the main frame
     *
     * @param panel to be added into the main frame
     */
    public void refreshMainFrame(JPanel panel) {

        Main.getMain().getContentPane().add(panel, BorderLayout.CENTER);
        Main.getMain().setSize(Main.getMain().getWidth() + 1, Main.getMain().getHeight() + 1);
        Main.getMain().setSize(Main.getMain().getWidth() - 1, Main.getMain().getHeight() - 1);
    }
}
