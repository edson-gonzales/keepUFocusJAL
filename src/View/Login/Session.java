package View.Login;

import Controller.UserAdmin.UserControllers;
import Model.UserAdmin.User;

/**
 * Save the User in the session
 *
 * @auhtor Lourdes Villca
 */
public class Session {
    private static User user;

    public Session() {

    }

    /**
     * Return the user that is in the session
     *
     * @return the user
     */
    public static User getUser() {
        return user;
    }

    /**
     * Set the user into the session
     *
     * @param theUser user to keep in the session
     */
    public static void setUser(User theUser) {
        user = theUser;
    }

    public static boolean isAdmin() {
        UserControllers controller = new UserControllers();
        return controller.isAdmin(user.getRoleId());
    }
}
