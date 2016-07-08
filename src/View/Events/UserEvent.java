package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.UserAdmin.ControllerUsers;
import View.AdminUser.AddUserUI;

/**
 * Created by LuLy on 07/07/2016.
 */
public class UserEvent implements ActionListener{
    private ControllerUsers userController;

    private AddUserUI addUserUI;
    public UserEvent(AddUserUI addUserUI){
        this.addUserUI = addUserUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // send this information to the controller
        /*addUserUI.getName();
        addUserUI.getLastName();
        addUserUI.getUserName();
        addUserUI.getPassword();
        addUserUI.getAddress();
        addUserUI.getEmail();
        addUserUI.getRole();
        addUserUI.getPossition();
        userController.addUserUI();*/
    }
}
