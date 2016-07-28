package View.Events;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import View.AdminUser.AddUserUI;
import Model.UserAdmin.User;
import View.AdminUser.TableUser;
import Controller.UserAdmin.UserControllers;
import Utils.Constants;


/**
 * Class to manage user events
 *
 * @author Lourdes Villca
 */
public class UserEvent extends MouseAdapter implements ActionListener {
    private UserControllers userController;
    private AddUserUI addUserUI;
    private TableUser tableUser;

    /**
     * Create a User event object
     *
     * @param addUserUI view form where the action happens
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
                updateDialog();
                break;

            case Constants.SAVE_USER: // accept button to save a user

                // send this information to the controller
                User user = new User();
                user.setFirstName(addUserUI.getLeftPanel().getName());
                user.setLastName(addUserUI.getLeftPanel().getLastName());
                user.setUserName(addUserUI.getLeftPanel().getUserName());
                user.setPassword(addUserUI.getLeftPanel().getPassword());
                user.setEnable(addUserUI.getLeftPanel().getStatus());
                user.setAddress(addUserUI.getRightPanel().getAddress());
                user.setEmail(addUserUI.getRightPanel().getEmail());
                user.setRole(addUserUI.getRightPanel().getRole());
                user.setPossition(addUserUI.getRightPanel().getPosition());

                UserControllers controllerUsers = new UserControllers();
                controllerUsers.saveUser(user);
                break;

            case Constants.CANCEL_USER: // Cancel save user
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
                updateDialog();
                break;
            case Constants.DELETE_USER: //Delete User
                deleteDialog(row);
                break;
        }

    }

    /**
     * Dialog to display the User form
     */
    public void updateDialog() {
        JDialog userForm = new JDialog();
        userForm.setSize(700, 400);

        AddUserUI user = new AddUserUI();

        userForm.add(user);
        userForm.setVisible(true);
    }

    /**
     * Display alert message to confirm to delete a User
     *
     * @param row selected row to be deleted
     */
    public void deleteDialog(int row) {
        int alertMessage = JOptionPane.showConfirmDialog(tableUser, "Do you want to delete this user?");
        if (alertMessage == JOptionPane.YES_OPTION) {
            System.out.println("delete row: " + row);
        }
    }
}
