package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class ActivityTimeHandler, it handles of the Activity Time class
 *
 * @autor: JuanaRodriguez
 */
public class ActivityTimeHandler {
    /**
     * The method get a specific activity given an Id
     *
     * @param activityTimeId the id of the activity time to get a specific activity time
     * @return the ActivityTime object
     */
    public static ActivityTime getActivityTimeById(int activityTimeId) {
        ActivityTime activityTime = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from ActivityTime ");
            sql.append(String.format("where activityId = %s;", activityTimeId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                activityTime = new ActivityTime();
                activityTime.setActivityId(result.getInt(1));
                activityTime.setStartDate(result.getTimestamp(2));
                activityTime.setEndDate(result.getTimestamp(3));
                activityTime.setActivityTypeId(result.getInt(4));
                activityTime.setUserId(result.getInt(5));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return activityTime;
    }
}
