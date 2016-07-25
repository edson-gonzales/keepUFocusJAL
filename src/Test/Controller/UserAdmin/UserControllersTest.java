package Test.Controller.UserAdmin;

import Controller.UserAdmin.UserControllers;
import Model.Common.Position;
import Model.UserAdmin.Role;
import Model.UserAdmin.User;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class UserControllersTest {
    /**
     *
     */
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

    @Test
    public void getListUserWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListUser().size() > 0);
    }

    @Test
    public void saveOneRoleWithUserControllers() {
        Role role = new Role("User");
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.saveRole(role));
    }

    @Test
    public void updateOneRoleWithUserControllers() {
        Role role = Role.getRole(1);
        role.setRolName("User-update");
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.updateRole(role));
    }

    @Test
    public void deleteOneRoleWithUserControllers() {
        Role role = Role.getRole(1);
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.deleteRole(role));
    }

    @Test
    public void getListRoleWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListRole().size() > 0);
    }

    @Test
    public void saveOnePositionWithUserControllers() {
        Random r = new Random();
        Position position = new Position();
        position.setPositionName("Development-" + r.nextInt(100));
        position.setEnable(true);
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.savePosition(position));
    }

    @Test
    public void updateOnePositionWithUserControllers() {
        Random r = new Random();
        Position position = Position.getPosition(1);
        position.setPositionName("Test-" + r.nextInt(100));
        UserControllers userControllers = new UserControllers();

        assertTrue(userControllers.updatePosition(position));
    }

    @Test
    public void deleteOnePositionWithUserControllers() {

        Random r = new Random();
        Position position = new Position();
        position.setPositionName("Development-" + r.nextInt(100));
        position.setEnable(true);
        UserControllers userControllers = new UserControllers();
        userControllers.savePosition(position);
        assertTrue(userControllers.deletePosition(position));
    }

    @Test
    public void getListPositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListPosition().size() > 0);
    }
}
