import Model.Common.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor Juana Rodriguez
 */
public class PositionTest {
    @Test
    public void VerifyANewPositionrWasAdd (){
        Position position = new Position();
        position.setPositionName("Employee");
        Assert.assertTrue(position.save());
    }
}
