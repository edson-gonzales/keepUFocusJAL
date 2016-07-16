package Test.Controller.UserAdmin;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.AdminUser.UserControllers;
import Model.AdminUser.User;


/**
 * @author AldoBalderrama on 7/13/2016.
 */
public class ControllerUserTest {
    @Test
    public void saveOneUserWithUserControllers() {
        User user = new User();

        user.setFirstName("Miguel Aldo");
        user.setLastName("Balderrama Vaca");
        user.setPositionId(1);
        user.setUserName("mabalderramav");
        user.setPassword("1234");
        user.setEnable(true);

        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.saveUser(user));
    }

    @Test
    public void updateOneUserWithUserControllers() {
        User user = User.getUser(15);
        user.setUserName("omBalderrama");

        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.updateUser(user));
    }

    @Test
    public void deleteOneUserWithUserControllers() {
        User user = User.getUser(15);

        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.deleteUser(user));
    }
}