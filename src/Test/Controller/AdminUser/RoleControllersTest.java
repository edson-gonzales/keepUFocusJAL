package Test.Controller.AdminUser;

import static org.junit.Assert.*;

import org.junit.Test;
import Model.AdminUser.Role;
import Controller.AdminUser.RoleControllers;

/**
 * Created by ALDO on 16/7/2016.
 */
public class RoleControllersTest {
    @Test
    public void saveOneRoleWithRoleControllers() {
        Role role = new Role("User");

        RoleControllers roleControllers = new RoleControllers();

        assertTrue(roleControllers.saveRole(role));
    }

    @Test
    public void updateOneRoleWithRoleControllers() {
        Role role = Role.getRole(1);
        role.setRolName("User-update");

        RoleControllers roleControllers = new RoleControllers();

        assertTrue(roleControllers.updateRole(role));
    }

    @Test
    public void deleteOneRoleWithRoleControllers() {
        Role role = Role.getRole(1);

        RoleControllers roleControllers = new RoleControllers();

        assertTrue(roleControllers.deleteRole(role));
    }
}