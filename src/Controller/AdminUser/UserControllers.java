package Controller.AdminUser;

import Model.AdminUser.User;

/**
 * Control the interaction between the view and the model layer
 * Created by AldoBalderrama on 7/7/2016.
 */
public class UserControllers {
    //Methods

    /**
     * Save an user object.
     *
     * @param user Save user in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean saveUser(User user) {
        return user.save();
    }

    /**
     * Update an user object.~
     *
     * @param user update user in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updateUser(User user) {
        return user.update();
    }

    /**
     * Delete an user object.
     *
     * @param user delete user in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean deleteUser(User user) {
        return user.delete();
    }
}