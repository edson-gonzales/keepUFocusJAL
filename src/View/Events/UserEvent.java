package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.UserAdmin.ControllerUsers;
import View.AdminUser.AddUserUI;
import Model.AdminUser.User;

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

<<<<<<< HEAD
        //send this information to the controller
        User user = new User();
        user.setFirstName(addUserUI.getName());
        user.setLastName(addUserUI.getLastName());
        user.setUserName(addUserUI.getUserName());
        user.setPassword(addUserUI.getPassword());
        user.setEnable(addUserUI.getStatus());
        addUserUI.getAddress();
        addUserUI.getEmail();
        addUserUI.getRole();
        addUserUI.getPossition();

        ControllerUsers controllerUsers = new ControllerUsers();
        controllerUsers.saveUser(user);

=======
        ArrayList<String> user = new ArrayList<String>();
        user.add(addUserUI.getName());
        user.add(addUserUI.getLastName());
        user.add(addUserUI.getUserName());
        user.add(addUserUI.getPassword());
        user.add(addUserUI.getAddress());
        user.add(addUserUI.getEmail());
        user.add(addUserUI.getRole());
        user.add(addUserUI.getPossition());
        userController.save(user);
>>>>>>> 43ee1ea31b76bc812cce2f4b79abee9e55e41fdf
    }
}
