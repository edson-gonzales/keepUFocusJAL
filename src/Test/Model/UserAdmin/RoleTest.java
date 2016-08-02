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
        role.setRoleName("Administrator");
        role.save();
        Assert.assertEquals(role.getRoleName(), RoleHandler.getRoleById(role.getRoleId()).getRoleName());
        role.delete();
    }

    @Test
    public void VerifyThatARoleWasUpdated() {
        Role role = new Role();
        role.setRoleName("Administrato");
        role.save();
        Role otherRole = RoleHandler.getRoleById(role.getRoleId());
        otherRole.setRoleName("Administrator");
        otherRole.update();
        Assert.assertEquals(otherRole.getRoleName(), RoleHandler.getRoleById(role.getRoleId()).getRoleName());
        role.delete();
    }

    @Test
    public void VerifyThatARoleWasDeleted() {
        Role role = new Role();
        role.setRoleName("Administrator");
        role.save();
        role.delete();
        Assert.assertNull(RoleHandler.getRoleById(role.getRoleId()));
    }
    @Test
    public void VerifyGetARoleById(){
        Role role = new Role();
        role.setRoleName("Administrator");
        role.setRoleName("Employee");
        role.save();
        //verificamos utilizando getListRole que los dos anteriores roles estan en la bd
    }
}
