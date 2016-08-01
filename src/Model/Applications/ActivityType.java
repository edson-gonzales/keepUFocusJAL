package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class manages Activity Type of the database
 *
 * @autor: JuanaRodriguez
 */
public class ActivityType {


    private int activityTypeId;
    private String activityTypeName;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the activityType
     *
     * @return activityTypeId, this variable is a integer value
     */
    public int getActivityTypeId() {
        return activityTypeId;
    }

    /**
     * The method set the id of the activityType
     *
     * @param activityTypeId will be set in the activityType
     */
    public void setActivityTypeId(int activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    /**
     * The method return the name of the activityType
     *
     * @return activityTypeName, this variable is string value
     */
    public String getActivityTypeName() {
        return activityTypeName;
    }

    /**
     * The method set the name of the activityType
     *
     * @param activityTypeName will be set in the activityType
     */
    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    /**
     * The method construct the ActivityType object and instance the DataAccess class.
     */
    public ActivityType() {
        this.setActivityTypeId(0);
        this.setActivityTypeName("");
        dbAccess = new DataAccess();
    }

    /**
     * The method insert a activityType in the database, catch the id from the activityType inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the activityType was inserted, this  flag return true if the
     * activityType was inserted correctly.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ActivityType (activityTypeName) ");
            sql.append(String.format("Values('%s')", this.getActivityTypeName()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setActivityTypeId(result.getInt(1));
                saved = true;
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }

    /**
     * The method updates a activityType and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update ActivityType set ");
        sql.append(String.format("activityTypeName = '%s' ", getActivityTypeName()));
        sql.append(String.format("where activityTypeId = %s", getActivityTypeId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method deletes a activityType and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from ActivityType ");
        sql.append(String.format("where activityTypeId = %s", getActivityTypeId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
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
}
