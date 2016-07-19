import Model.Conection.Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor Juana Rodriguez
 */
public class ConnectionTest {
    @Test
    public void VerifyTheConnectionToTheDataBase(){
        Connection connection = new Connection();
        Assert.assertTrue(connection.connect());
    }
}

