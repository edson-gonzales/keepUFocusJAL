package Test.Model.AdminUser;

import Model.Conection.Connection;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by AldoBalderrama on 7/18/2016.
 */
public class ConnectionTest {
    @Test
    public void isConnect() {
        Connection connection = new Connection();

        assertTrue(connection.connect());
    }
}
