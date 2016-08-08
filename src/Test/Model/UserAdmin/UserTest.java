package Test.Model.UserAdmin;

import Model.UserAdmin.User;
import Model.UserAdmin.UserHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class UserTest {
    @Test
    public void VerifyIfANewUserIsAdd() {
        User user = new User();
        user.setFirstName("Aldo");
        user.setLastName("Balderrama");
        user.setUserName("admin");
        user.setPassword("admin");
        user.setRoleId(1);
        user.setPositionId(1);
        user.save();
        Assert.assertEquals(user.getUserName(), UserHandler.getUserById(user.getUserId()).getUserName());
        user.delete();
    }

    @Test
    public void VerifyThatAnUserIsUpdated() {
        User user = new User();
        user.setFirstName("Lourdes");
        user.setLastName("Villca");
        user.setUserName("user");
        user.setPassword("user");
        user.setRoleId(2);
        user.setPositionId(2);
        user.save();
        User otherUser = UserHandler.getUserById(user.getUserId());
        otherUser.setFirstName("Lourdes");
        otherUser.update();
        Assert.assertEquals(otherUser.getUserName(), UserHandler.getUserById(user.getUserId()).getUserName());
        user.delete();
    }

    @Test
    public void VerifyThatAnUserIsDeleted() {
        User user = new User();
        user.setFirstName("Juana");
        user.setLastName("Rodriguez");
        user.setUserName("user");
        user.setPassword("user");
        user.setRoleId(2);
        user.setPositionId(1);
        user.save();
        user.delete();
        Assert.assertNull(UserHandler.getUserById(user.getUserId()));
    }
}
