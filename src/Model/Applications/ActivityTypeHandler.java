package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 8/2/2016.
 */
public class ActivityTypeHandler {

    /**
     * The method get a specific activityType given an Id
     *
     * @param activityTypeId the id of the activityType to get a specific activityType
     * @return the ActivityType object
     */
    public static ActivityType getActivityTypeById(int activityTypeId) {
        ActivityType activityType = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from ActivityType ");
            sql.append(String.format("where activityTypeId = %s;", activityTypeId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                activityType = new ActivityType();
                activityType.setActivityTypeId(result.getInt(1));
                activityType.setActivityTypeName(result.getString(2));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return activityType;
    }
    /**
     * This method returns data of ActivityType and puts in an array
     *
     * @return activityTypes return a set of activityTypes
     */
    public static ArrayList<ActivityType> getListActivityType() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<ActivityType> activityTypes = new ArrayList<ActivityType>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from ActivityType");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                ActivityType activityType = new ActivityType();
                activityType.setActivityTypeId(result.getInt(1));
                activityType.setActivityTypeName(result.getString(2));
                activityTypes.add(activityType);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return activityTypes;
    }
}
