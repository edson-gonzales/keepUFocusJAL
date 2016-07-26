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
        role.setRoleName("Administrator2");
        role.save();
        Role recoverRole = new Role();
        recoverRole.getRoleById(role.getRoleId());
        Assert.assertEquals("Administrator2", recoverRole.getRoleName());
        //Assert.assertNotNull(role.getRoleById(role.getRoleId()));

    }

    @Test
    public void VerifyThatARoleWasUpdated() {
        Role role = new Role();
        role.setRoleName("Gerent Edited1");
        role.update(1);
        Assert.assertEquals("Gerent Edited1", role.getRoleName());
    }

    @Test
    public void VerifyThatARoleWasDeleted() {
        Role role = new Role();
        role.delete(2);
    }
}
