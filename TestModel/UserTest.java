

import Model.AdminUser.User;
import Model.Conection.Connection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.DriverManager;

/**
 * @autor Juana Rodriguez
 */
public class UserTest {

    @Test
    public void VerifyANewUserWasAdd() {

        User user = new User();
        user.setUserName("Employee4285");
        user.setPassword("abc123");
        user.setEnable(false);
        Assert.assertTrue(user.save());

    }
}

