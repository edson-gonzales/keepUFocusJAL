package Controller.Common;

import Model.Common.Position;

/**
 * Control the interaction between the view and the model layer
 * Created by ALDO on 16/7/2016.
 */
public class PositionControllers {
    //Methods

    /**
     * Save an position object.
     *
     * @param position Save position in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean savePosition(Position position) {
        return position.save();
    }

    /**
     * Update an position object.
     *
     * @param position update position in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updatePosition(Position position) {
        return position.update();
    }

    /**
     * Delete an position object.
     *
     * @param position delete position in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean deletePosition(Position position) {
        return position.delete();
    }
}
