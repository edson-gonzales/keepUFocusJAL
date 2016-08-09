package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class manages Tracking Configuration of the database
 *
 * @autor: JuanaRodriguez
 */
public class TrackingConfiguration {
    private int trackingConfigurationId;
    private int startHour;
    private int endHour;
    private String days;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the Activity
     *
     * @return activityId, this variable is an integer value
     */
    public int getTrackingConfigurationId() {
        return trackingConfigurationId;
    }

    /**
     * The method set the Id of the Activity
     *
     * @param trackingConfigurationId will be set in the Activity
     */
    public void setTrackingConfigurationId(int trackingConfigurationId) {
        this.trackingConfigurationId = trackingConfigurationId;
    }

    /**
     * The method return the star date of the activity
     *
     * @return startDate, this variable is a Timestamp value
     */
    public int getStartHour() {
        return startHour;
    }

    /**
     * The method set the stat date of the user
     *
     * @param startHour it should be a Timestamp date
     */
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    /**
     * The method return the end date of the activity
     *
     * @return endHour, this variable is a Timestamp value
     */
    public int getEndHour() {
        return endHour;
    }

    /**
     * This method set the end date of the FocusTime
     *
     * @param endHour it should be a Timestamp date
     */
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    /**
     * The method return the user id of the activity
     *
     * @return userId, this variable is an integer value
     */
    public String getDays() {
        return days;
    }

    /**
     * The method set the user id of the activity
     *
     * @param days will be set in the Activity
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * Initialize the connection to the database
     */
    public TrackingConfiguration() {
        this.trackingConfigurationId = 0;
        this.startHour = 0;
        this.endHour = 0;
        this.days = "";
        dbAccess = new DataAccess();
    }

    /**
     * @param days
     */
    public TrackingConfiguration(String days) {
        this.startHour = 0;
        this.endHour = 0;
        this.days = "";
        dbAccess = new DataAccess();
    }

    /**
     * This method save the tracking configuration information in the database
     *
     * @return a boolean, return true if the tracking configuration was inserted in the database
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into TrackingConfiguration (startHour, endHour, days) ");
            sql.append(String.format("values (%s,%s,'%s')", this.getStartHour(), this.getEndHour(), this.getDays()));

            result = dbAccess.save(sql.toString());

            if (result.next()) {
                this.setTrackingConfigurationId(result.getInt(1));
                saved = true;
            }
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }

    /**
     * This method update the information for a given tracking configuration
     *
     * @return a boolean, return true if the tracking configuration was updated in the database
     */
    public boolean update() {
        boolean updated;
        StringBuilder sql = new StringBuilder("update TrackingConfiguration set ");
        sql.append(String.format("startHour = '%s', ", this.getStartHour()));
        sql.append(String.format("endHour = '%s', ", this.getEndHour()));
        sql.append(String.format("days = '%s' ", this.getDays()));
        sql.append(String.format("where trackingConfigurationId = %s", this.getTrackingConfigurationId()));
        System.out.println(sql);
        updated = dbAccess.update(sql.toString());

        return updated;
    }

    /**
     * The method delete an tracking configuration and give back true through of deleted variable if the date was
     * delete successfully using the method deleted from DataAccess class.
     *
     * @return deleted true if the tracking configuration was deleted successfully
     */
    public boolean delete() {
        boolean deleted;
        StringBuilder sql = new StringBuilder("delete from TrackingConfiguration ");
        sql.append(String.format("where trackingConfigurationId = %s", getTrackingConfigurationId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }

}
