import Model.Common.Role;
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
        Assert.assertEquals(role.getRoleName(), Role.getRoleById(role.getRoleId()).getRoleName());
    }

    @Test
    public void VerifyThatARoleWasUpdated() {
        Role role = new Role();
        role.setRoleName("s");
        role.save();
        Role otherRole = Role.getRoleById(role.getRoleId());
        otherRole.setRoleName("Administrator");
        otherRole.update();
        Assert.assertEquals(otherRole.getRoleName(), Role.getRoleById(role.getRoleId()).getRoleName());
        role.delete();
    }

    @Test
    public void VerifyThatARoleWasDeleted() {
        Role role = new Role();
        role.setRoleName("Administrator");
        role.save();
        role.delete();
        Assert.assertNull(Role.getRoleById(role.getRoleId()));
    }
}
