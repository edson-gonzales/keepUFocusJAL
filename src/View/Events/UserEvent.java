package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    }
}
