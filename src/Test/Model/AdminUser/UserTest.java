package Test.Model.AdminUser;

import Model.AdminUser.User;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author AldoBalderrama on 7/14/2016.
 */
public class UserTest {
    @Test
    public void getOneUserByUserIdThatIsNotNull() {
        assertNotNull(User.getUser(18));
    }
}