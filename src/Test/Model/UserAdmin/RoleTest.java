package Test.Model.UserAdmin;

import Model.UserAdmin.Role;
import Model.UserAdmin.RoleHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class RoleTest {

    @Test
    public void VerifyThatANewRoleWasAdd() {
        Role role = new Role();
        role.setRoleName("User");
        role.save();
        Assert.assertEquals(role.getRoleName(), RoleHandler.getRoleById(role.getRoleId()).getRoleName());
        role.delete();
    }

    @Test
    public void VerifyThatARoleWasUpdated() {
        Role role = new Role();
        role.setRoleName("User");
        role.save();
        Role otherRole = RoleHandler.getRoleById(role.getRoleId());
        otherRole.setRoleName("User");
        otherRole.update();
        Assert.assertEquals(otherRole.getRoleName(), RoleHandler.getRoleById(role.getRoleId()).getRoleName());
        role.delete();
    }

    @Test
    public void VerifyThatARoleWasDeleted() {
        Role role = new Role();
        role.setRoleName("Admini");
        role.save();
        role.delete();
        Assert.assertNull(RoleHandler.getRoleById(role.getRoleId()));
    }
}
