package Test.Controller.UserAdmin;

import Controller.UserAdmin.UserControllers;
import Model.Common.Position;
import Model.UserAdmin.Role;
import Model.UserAdmin.User;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class UserControllersTest {
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
        userControllers.deleteUser(user);
    }

    @Test
    public void updateOneUserWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        User otherUser = new User("Aldo", "Balderrama", "mabalderramav", "1234");
        userControllers.saveUser(otherUser);
        User user = User.getUserById(otherUser.getUserId());
        user.setUserName("omBalderrama");
        assertTrue(userControllers.updateUser(user));
        userControllers.deleteUser(user);
    }

    @Test
    public void deleteOneUserWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        User otherUser = new User("Aldo", "Balderrama", "mabalderramav", "1234");
        userControllers.saveUser(otherUser);
        User user = User.getUserById(otherUser.getUserId());
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
        userControllers.deleteRole(role);
    }

    @Test
    public void updateOneRoleWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Role otherRole = new Role("User");
        userControllers.saveRole(otherRole);
        Role role = Role.getRoleById(otherRole.getRoleId());
        role.setRolName("User-update");
        assertTrue(userControllers.updateRole(role));
        userControllers.deleteRole(role);
    }

    @Test
    public void deleteOneRoleWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Role otherRole = new Role("User");
        userControllers.saveRole(otherRole);
        Role role = Role.getRoleById(otherRole.getRoleId());
        assertTrue(userControllers.deleteRole(role));
    }

    @Test
    public void getListRoleWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListRole().size() > 0);
    }

    @Test
    public void saveOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position position = new Position();
        position.setPositionName("Development");
        position.setEnable(true);
        assertTrue(userControllers.savePosition(position));
        userControllers.deletePosition(position);
    }

    @Test
    public void updateOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position otherPosition = new Position("Development",true);
        userControllers.savePosition(otherPosition);
        Position position = Position.getPositionById(otherPosition.getPositionId());
        position.setPositionName("Development-update");
        assertTrue(userControllers.updatePosition(position));
        userControllers.deletePosition(position);
    }

    @Test
    public void deleteOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position otherPosition = new Position("Development",true);
        userControllers.savePosition(otherPosition);
        Position position = Position.getPositionById(otherPosition.getPositionId());
        assertTrue(userControllers.deletePosition(position));
    }

    @Test
    public void getListPositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListPosition().size() > 0);
    }
}
