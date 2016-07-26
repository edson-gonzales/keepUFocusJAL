package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controller.UserAdmin.ControllerUsers;
import View.AdminUser.AddUserUI;
import Model.AdminUser.User;
import View.AdminUser.LeftPanelUserUI;
import View.AdminUser.TableUser;

import javax.swing.*;

/**
 * Class to manage user events
 *
 * @author Lourdes Villca
 */
public class UserEvent implements ActionListener, MouseListener {
    private ControllerUsers userController;
    private AddUserUI addUserUI;
    private TableUser tableUser;

    /**
     * Create a User event object
     * @param addUserUI view form where the action happens
     */
    public UserEvent(AddUserUI addUserUI) {
        this.addUserUI = addUserUI;
    }

    /**
     * Create a user event reference to table user
     * @param tableUser where the event is executed
     */
    public UserEvent(TableUser tableUser) {
        this.tableUser = tableUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        switch(action){
            case 1://search a user
                break;
            case 2://open a form to create a new user
                updateDialog();
                break;

            case 3: // accept button to save a user

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

                ControllerUsers controllerUsers = new ControllerUsers();
                controllerUsers.saveUser(user);
                break;

            case 4:
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int row = tableUser.table.rowAtPoint(evt.getPoint());
        int column = tableUser.table.columnAtPoint(evt.getPoint());
        System.out.println(column);
        switch (column){
            case 4:
                updateDialog();
                break;
            case 5:
                deleteDialog(row);
                break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Dialog to display the User form
     */
    public void updateDialog(){
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
