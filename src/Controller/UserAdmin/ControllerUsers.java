package Controller.UserAdmin;


import Model.AdminUser.User;
import java.util.List;

/**
 * Created by AldoBalderrama on 7/7/2016.
 */
public class ControllerUsers {
    //Attribute
    private User user;
    //Property
    //Constructor
    public ControllerUsers()
    {
        this.user = new User();
    }
    //Methods
    public void addUser(User user)
    {
        this.user = user;
    }
    public boolean save()
    {
        return this.user.save();
    }
}