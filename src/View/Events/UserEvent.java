package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.UserAdmin.ControllerUsers;
import View.AdminUser.AddUserUI;
import Model.AdminUser.User;

/**
 * Class to manage user events
 *
 * @author: Lourdes Villca
 */
public class UserEvent implements ActionListener {
    private ControllerUsers userController;
    private AddUserUI addUserUI;

    /**
     * Create a User event object
     * @param addUserUI view form where the action happens
     */
    public UserEvent(AddUserUI addUserUI) {
        this.addUserUI = addUserUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // send this information to the controller
        User user = new User();
        user.setFirstName(addUserUI.getName());
        user.setLastName(addUserUI.getLastName());
        user.setUserName(addUserUI.getUserName());
        user.setPassword(addUserUI.getPassword());
        user.setEnable(addUserUI.getStatus());
        user.setAddress(addUserUI.getAddress());
        user.setEmail(addUserUI.getEmail());
        user.setRole(addUserUI.getRole());
        user.setPossition(addUserUI.getPossition());

        ControllerUsers controllerUsers = new ControllerUsers();
        controllerUsers.saveUser(user);
    }
}
