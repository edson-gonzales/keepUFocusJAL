package Test.Model.Common;

import Model.Common.Position;
import Model.Common.PositionHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class PositionTest {
    @Test
    public  void VerifyANewPositionIsSaved (){
        Position position = new Position();
        position.setPositionName("Lead");
        position.save();
        Assert.assertEquals(position.getPositionName(), PositionHandler.getPositionById(position.getPositionId()).getPositionName());
        position.delete();
    }
    @Test
    public void VerifyThatAPositionIsUpdated() {
        Position position = new Position();
        position.setPositionName("Leade");
        position.save();
        Position otherPosition = PositionHandler.getPositionById(position.getPositionId());
        otherPosition.setPositionName("Lead");
        otherPosition.update();
        Assert.assertEquals(otherPosition.getPositionName(), PositionHandler.getPositionById(position.getPositionId()).getPositionName());
        position.delete();
    }

    @Test
    public void VerifyThatAPositionIsDeleted() {
        Position position = new Position();
        position.setPositionName("Lead");
        position.save();
        position.delete();
        Assert.assertNull(PositionHandler.getPositionById(position.getPositionId()));
    }
}
