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
    private UserControllers controllerUsers;
    protected User userUpdate;

    /**
     * Create a User event object
     *
     */
    public UserEvent(AddUserUI addUserUI) {
        this.addUserUI = addUserUI;
        controllerUsers = new UserControllers();
    }

    /**
     * Create a user event reference to table user
     *
     * @param tableUser where the event is executed
     */
    public UserEvent(TableUser tableUser) {
        this.tableUser = tableUser;
        controllerUsers = new UserControllers();
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
                addUserUI = new AddUserUI(false);
                addUserUI.setVisible(true);
                break;

            case Constants.SAVE_USER: // accept button to save a user
                if(addUserUI.isEdit()){
                    User user= addUserUI.getUserEdited();
                    setUserInfo(user);
                    controllerUsers.updateUser(user);
                } else {
                    User user = new User();
                    setUserInfo(user);
                    controllerUsers.saveUser(user);
                }
                addUserUI.dispose();
                refreshMainFrame();

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

                addUserUI = new AddUserUI(true);
                addUserUI.getLeftPanel().setName(user.getFirstName());
                addUserUI.getLeftPanel().setLastName(user.getLastName());
                addUserUI.getLeftPanel().setUserName(user.getUserName());
                addUserUI.getLeftPanel().setPassword(user.getPassword());
                addUserUI.getRightPanel().setRoleCbox(controllerUsers.getRoleById(user.getRoleId()));
                addUserUI.getRightPanel().setPositionCbox(controllerUsers.getPositionById(user.getPositionId()));
                addUserUI.setVisible(true);
                addUserUI.setUserEdited(user);

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
        int alertMessage = JOptionPane.showConfirmDialog(tableUser, "Do you want to delete this user?", "Delete user", JOptionPane.YES_NO_OPTION);
        if (alertMessage == JOptionPane.YES_OPTION) {
            User user = (User)tableUser.table.getModel().getValueAt(row, 0);
            user.delete();

            refreshMainFrame();

        }
    }
    /**
     * Method to refresh the content of the main frame
     *
     */
    public void refreshMainFrame() {
        Main.getMain().getContentPane().removeAll();
        SearchUserUI searchUser = new SearchUserUI();

        Main.getMain().getContentPane().add(searchUser, BorderLayout.CENTER);
        Main.getMain().setSize(Main.getMain().getWidth() + 1, Main.getMain().getHeight() + 1);
        Main.getMain().setSize(Main.getMain().getWidth() - 1, Main.getMain().getHeight() - 1);
    }

    /**
     * Set the User with the information typed in the components
     *
     * @param user object that is setting with data
     */
    public void setUserInfo(User user) {
        user.setFirstName(addUserUI.getLeftPanel().getName());
        user.setLastName(addUserUI.getLeftPanel().getLastName());
        user.setUserName(addUserUI.getLeftPanel().getUserName());
        user.setPassword(addUserUI.getLeftPanel().getPassword());
        user.setRoleId(addUserUI.getRightPanel().getRole().getRoleId());
        user.setPositionId(addUserUI.getRightPanel().getPosition().getPositionId());
    }
}
