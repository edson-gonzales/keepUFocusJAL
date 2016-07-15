

import Model.AdminUser.User;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 7/13/2016.
 */
public class UserTest {

    public UserTest(){}
    @Test
    public void VerifyANewUserWasAdd (){

        User user = new User();
        user.setUserName("Employee123");
        user.setPassword("abc123");
        user.setEnable(false);
        Assert.assertTrue(user.save());

    }
}

