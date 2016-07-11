package Controller.UserAdmin;

import Model.AdminUser.User;

/**
 * Created by AldoBalderrama on 7/7/2016.
 */
public class ControllerUsers
{
    //Methods
    public boolean saveUser(User user)
    {
        return user.save();
    }
}