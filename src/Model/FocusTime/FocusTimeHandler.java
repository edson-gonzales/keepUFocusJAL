package Model.FocusTime;

import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Connections.DataAccess;
import Model.FocusTime.FocusTime;

/**
 * @author Lourdes Villca
 */
public class FocusTimeHandler {

    /**
     * This method select a specific focus time given a Id
     *
     * @param focusTimeId the id from the Focus Time
     * @return the FocusTime object
     */
    public static FocusTime getFocusTimeById(int focusTimeId) {
        DataAccess dbAccess = new DataAccess();
        FocusTime focusTime = null;

        StringBuilder sql = new StringBuilder("Select * from FocusTime where ");
        sql.append(String.format("FocusTimeId = %s", focusTimeId));
        ResultSet resultSet = dbAccess.select(sql.toString());

        try {
            while (resultSet.next()) {
                focusTime = new FocusTime();
                focusTime.setFocusTimeId(resultSet.getInt(1));
                focusTime.setStartDate(resultSet.getTimestamp(2));
                focusTime.setEndDate(resultSet.getTimestamp(3));
                focusTime.setApplicationId(resultSet.getInt(4));

            }
            resultSet.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return focusTime;
    }
}
