package Test.Controller.UserAdmin;

import Controller.UserAdmin.UserControllers;
import Model.Common.Position;
import Model.Common.PositionHandler;
import Model.Connections.DataAccess;
import Model.UserAdmin.Role;
import Model.UserAdmin.RoleHandler;
import Model.UserAdmin.User;
import Model.UserAdmin.UserHandler;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
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
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.saveUser(user));
        userControllers.deleteUser(user);
    }

    @Test
    public void updateOneUserWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        User otherUser = new User("Aldo", "Balderrama", "mabalderramav", "1234");
        userControllers.saveUser(otherUser);
        User user = UserHandler.getUserById(otherUser.getUserId());
        user.setUserName("omBalderrama");
        assertTrue(userControllers.updateUser(user));
        userControllers.deleteUser(user);
    }

    @Test
    public void deleteOneUserWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        User otherUser = new User("Aldo", "Balderrama", "mabalderramav", "1234");
        userControllers.saveUser(otherUser);
        User user = UserHandler.getUserById(otherUser.getUserId());
        assertTrue(userControllers.deleteUser(user));
    }

    @Test
    public void getListUserWithUserControllers() {
        DataAccess dataAccess = new DataAccess();
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Count(*) as Count ");
        sql.append("FROM User");
        ResultSet resultSet = dataAccess.select(sql.toString());
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            dataAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        UserControllers userControllers = new UserControllers();
        int countUsers = userControllers.getListUser().size();
        assertTrue(countUsers == count);
    }

    @Test
    public void verifyIfUserExistWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        User user = new User("Aldo", "Balderrama", "mabalderramav", "1234");
        userControllers.saveUser(user);
        assertTrue(userControllers.userExist(user.getUserId()));
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
        Role role = RoleHandler.getRoleById(otherRole.getRoleId());
        role.setRoleName("User-update");
        assertTrue(userControllers.updateRole(role));
        userControllers.deleteRole(role);
    }

    @Test
    public void deleteOneRoleWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Role otherRole = new Role("User");
        userControllers.saveRole(otherRole);
        Role role = RoleHandler.getRoleById(otherRole.getRoleId());
        assertTrue(userControllers.deleteRole(role));
    }

    @Test
    public void getListRoleWithUserControllers() {
        DataAccess dataAccess = new DataAccess();
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Count(*) as Count ");
        sql.append("FROM Role");
        ResultSet resultSet = dataAccess.select(sql.toString());
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            dataAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListRole().size() == count);
    }

    @Test
    public void verifyGetRoleByIdWithUserControllers() {
        Role role = new Role("User");
        UserControllers userControllers = new UserControllers();
        role.save();
        assertNotNull(userControllers.getRoleById(role.getRoleId()));
        userControllers.deleteRole(role);
    }

    @Test
    public void saveOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position position = new Position();
        position.setPositionName("Development");
        assertTrue(userControllers.savePosition(position));
        userControllers.deletePosition(position);
    }

    @Test
    public void updateOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position otherPosition = new Position("Development");
        userControllers.savePosition(otherPosition);
        Position position = PositionHandler.getPositionById(otherPosition.getPositionId());
        position.setPositionName("Development-update");
        assertTrue(userControllers.updatePosition(position));
        userControllers.deletePosition(position);
    }

    @Test
    public void deleteOnePositionWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position otherPosition = new Position("Development");
        userControllers.savePosition(otherPosition);
        Position position = PositionHandler.getPositionById(otherPosition.getPositionId());
        assertTrue(userControllers.deletePosition(position));
    }

    @Test
    public void getListPositionWithUserControllers() {
        DataAccess dataAccess = new DataAccess();
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Count(*) as Count ");
        sql.append("FROM Position");
        ResultSet resultSet = dataAccess.select(sql.toString());
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            dataAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        UserControllers userControllers = new UserControllers();
        assertTrue(userControllers.getListPosition().size() == count);
    }

    @Test
    public void verifyGetPositionByIdWithUserControllers() {
        UserControllers userControllers = new UserControllers();
        Position position = new Position();
        position.setPositionName("Development");
        position.save();
        assertNotNull(userControllers.getPositionById(position.getPositionId()));
        position.delete();
    }
}