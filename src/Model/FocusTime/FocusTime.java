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
            StringBuilder sql = new StringBuilder("insert into FocusTime (startDate, endDate, applicationId)");
            sql.append(String.format("values ('%s', ", this.getStartDate()));
            sql.append(String.format("'%s', ", this.getEndDate()));
            sql.append(String.format("%s)", this.getApplicationId()));

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
     * This method get all Focus time registered in the database
     *
     * @return an ArrayList with all focusTime record in the database
     */
    public static ArrayList<FocusTime> getListFocusTime() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<FocusTime> focusTimes = new ArrayList<>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from FocusTime");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                FocusTime focusTime = new FocusTime();
                focusTime.setFocusTimeId(result.getInt(1));
                focusTime.setStartDate(result.getTimestamp(2));
                focusTime.setEndDate(result.getTimestamp(3));
                focusTime.setApplicationId(result.getInt(4));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return focusTimes;
    }

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

}
