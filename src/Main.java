//import java.sql.Connection;
import Controller.UserAdmin.ControllerUsers;
import Model.AdminUser.User;

/**
 * Created by Administrator on 7/6/2016.
 */
public class Main {

    public static void main(String [] args)
    {
        //New User
        User user = new User();
        user.setFirstName("Juana");
        user.setLastName("rodriguez");
        //Use controller
        ControllerUsers controllerUsers = new ControllerUsers();
        if(controllerUsers.saveUser(user))
        {
            System.out.println("Save good");
        }
        else
        {
            System.out.println("Error");
        }
    }
}
