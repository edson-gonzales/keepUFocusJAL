package Model.FocusTime;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import Model.Connections.DataAccess;

/**
 * Manage Focus Time in the database
 *
 * @author Lourdes Villca
 */
public class FocusTime {
    private Timestamp startDate;
    private Timestamp endDate;
    private int focusTimeId;
    private int applicationId;
    private int userId;
    private DataAccess dbAccess;

    /**
     * Initialize the connection to the database
     */
    public FocusTime() {
        dbAccess = new DataAccess();

    }

    /**
     * This method save the Focus time information in the database
     *
     * @return a boolean, return true if the focus time was inserted in the database
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder("insert into FocusTime (startDate, endDate, applicationId, userId)");
            sql.append(String.format("values ('%s', ", this.getStartDate()));
            sql.append(String.format("'%s', ", this.getEndDate()));
            sql.append(String.format("%s, ", this.getApplicationId()));
            sql.append(String.format("%s)", this.getUserId()));

            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setFocusTimeId(result.getInt(1));
                saved = true;
            }
            dbAccess.closeConnection();

        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }

    /**
     * This method update the information for a given Focus Time
     *
     * @param focusTimeId the Id of the Focus Time to be updated
     * @return a boolean, return true if the focus time was updated in the database
     */
    public boolean update(int focusTimeId) {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update FocusTime set ");
        sql.append(String.format("startDate = '%s', ", this.getStartDate()));
        sql.append(String.format("endDate = '%s', ", this.getEndDate()));
        sql.append(String.format("applicationId = %s, ", this.getApplicationId()));
        sql.append(String.format("userId = %s ", this.getUserId()));
        sql.append(String.format("where focusTimeId = %s", focusTimeId));
        updated = dbAccess.update(sql.toString());
        return updated;

    }

    /**
     * This method returns the start date of the FocusTime
     *
     * @return the Start Date
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * This method set the start date of the FocusTime
     *
     * @param startDate it should be a Timestamp date
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the end date of the FocusTime
     *
     * @return the end date
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
     * This method returns the FocusTime Id
     *
     * @return the Id of the FocusTime
     */
    public int getFocusTimeId() {
        return focusTimeId;
    }

    /**
     * This method set the id of the FocusTime
     *
     * @param focusTimeId the id of the FocusTime
     */
    public void setFocusTimeId(int focusTimeId) {
        this.focusTimeId = focusTimeId;
    }

    /**
     * This method returns the id of the Application
     *
     * @return the Application Id
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     * This method set the application id of the Focus Time
     *
     * @param applicationId the id of the application id
     */
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * This method returns the User Id associated with the Focus Time
     *
     * @return the User Id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * This method set the User Id related with a Focus Time
     *
     * @param userId the User Id that correspond to a Focus Time
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
