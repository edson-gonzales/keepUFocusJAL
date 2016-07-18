package Test.Controller.Common;

import Controller.Common.PositionControllers;
import Model.Common.Position;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ALDO on 16/7/2016.
 */
public class PositionControllersTest {
    @Test
    public void saveOnePositionWithPositionControllers() {
        Position position = new Position();

        position.setPositionName("Development");
        position.setEnable(true);

        PositionControllers positionControllers = new PositionControllers();

        assertTrue(positionControllers.savePosition(position));
    }

    @Test
    public void updateOnePositionWithPositionControllers() {
        Position position = Position.getPosition(1);
        position.setPositionName("Test");

        PositionControllers positionControllers = new PositionControllers();

        assertTrue(positionControllers.updatePosition(position));
    }

    @Test
    public void deleteOneUserWithUserControllers() {
        Position position = Position.getPosition(1);

        PositionControllers positionControllers = new PositionControllers();
        assertTrue(positionControllers.deletePosition(position));
    }
}
