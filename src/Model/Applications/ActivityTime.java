package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * The class manages activity of the data base
 *
 * @autor: JuanaRodriguez
 */
public class ActivityTime {
    private int activityId;
    private Timestamp startDate;
    private Timestamp endDate;
    private int activityTypeId;
    private int userId;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the Activity
     *
     * @return activityId, this variable is an integer value
     */
    public int getActivityId(){
        return activityId;
    }

    /**
     * The method set the Id of the Activity
     *
     * @param activityId will be set in the Activity
     */
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
    /**
     * The method return the star date of the activity
     *
     * @return startDate, this variable is a Timestamp value
     */
    public Timestamp getStartDate(){
        return startDate;
    }

    /**
     * The method set the stat date of the user
     *
     * @param startDate it should be a Timestamp date
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    /**
     * The method return the end date of the activity
     *
     * @return endDate, this variable is a Timestamp value
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * This method set the end date of the FocusTime
     *
     * @param endDate it should be a Timestamp date
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    /**
     * The method return the Id of the activity type
     *
     * @return activityTypeId, this variable is an integer value
     */
    public int getActivityTypeId(){
        return activityTypeId;
    }

    /**
     * The method set the Id of the activity type
     *
     * @param activityTypeId will be set in the Activity
     */
    public void setActivityTypeId(int activityTypeId) {
        this.activityTypeId = activityTypeId;
    }
    /**
     * The method return the user id of the activity
     *
     * @return userId, this variable is an integer value
     */
    public int getUserId(){
        return userId;
    }

    /**
     * The method set the user id of the activity
     *
     * @param userId will be set in the Activity
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * Initialize the connection to the database
     */
    public ActivityTime() {
        this.startDate = new Timestamp(0);
        this.endDate = new Timestamp(0);
        this.activityTypeId = 0;
        this.userId = 0;
        dbAccess = new DataAccess();
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @param applicationId
     * @param userId
     */
    public ActivityTime(Timestamp startDate, Timestamp endDate, int applicationId, int userId) {
        this.activityId = 0;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityTypeId = 0;
        this.userId = userId;
        dbAccess = new DataAccess();
    }
    /**
     * This method save the activity information in the database
     *
     * @return a boolean, return true if the activity was inserted in the database
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder("insert into ActivityTime (startDate, endDate, activityTypeId, userId) ");
            sql.append(String.format("values ('%s', ", this.getStartDate()));
            sql.append(String.format("'%s', ", this.getEndDate()));
            sql.append(String.format("%s, ", this.getActivityId()));
            sql.append(String.format("%s)", this.getUserId()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setActivityId(result.getInt(1));
                saved = true;
            }
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }
    /**
    * This method update the information for a given activity
    *
    * @return a boolean, return true if the activity was updated in the database
    */
    public boolean update() {
        boolean updated;
        StringBuilder sql = new StringBuilder("update ActivityTime set ");
        sql.append(String.format("startDate = '%s', ", this.getStartDate()));
        sql.append(String.format("endDate = '%s', ", this.getEndDate()));
        sql.append(String.format("activityTypeId = %s, ", this.getActivityTypeId()));
        sql.append(String.format("userId = %s ", this.getUserId()));
        sql.append(String.format("where activityId = %s", this.getActivityId()));
        updated = dbAccess.update(sql.toString());
        return updated;
    }
    /**
     * The method delete an activity and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the activity was deleted successfully
     */
    public boolean delete(){
        boolean deleted;
        StringBuilder sql = new StringBuilder("delete from ActivityTime ");
        sql.append(String.format("where activityId = %s", getActivityId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
