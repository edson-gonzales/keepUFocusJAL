package View.Report;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Model.Applications.Application;
import Model.Connections.DataAccess;
import Model.FocusTime.FocusTime;

/**
 * Class to get the tracked Application from the database
 *
 * @author Lourdes Villca
 */
public class ApplicationFocusTime {
    private FocusTime focusTime;
    private Application application;
    private DataAccess dbAccess;
    private int totalTime;

    public ApplicationFocusTime(){
        dbAccess = new DataAccess();
    }

    /**
     * This method gets the tracked applications, grouping by Application id and with the corresponding total time for each one
     * @param startDate start date of the focus time
     * @param endDate end date of the focus time
     * @return the ArrayList of ApplicationFocusTime
     */
    public ArrayList<ApplicationFocusTime> getTrackedApplication(String startDate, String endDate){
        ArrayList<ApplicationFocusTime> appFocusTime = new ArrayList<>();
        ApplicationFocusTime applicationFocusTime = null;
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("select ap.*, ft.*, sum(Cast (((JulianDay(Datetime(ft.endDate)) - JulianDay(Datetime(ft.startDate))) * 24*60) as integer)) as total ");
        sql.append("from Application as ap, FocusTime as ft ");
        sql.append("where ap.applicationId = ft.applicationId and ");
        sql.append(String.format("ft.startDate like '%s%%' and ", startDate));
        sql.append(String.format("ft.endDate like '%s%%' ", endDate));
        sql.append("group by ft.applicationId");

        try{
            result = dbAccess.select(sql.toString());
            while(result.next()){
                applicationFocusTime = new ApplicationFocusTime();
                focusTime = new FocusTime();
                application = new Application();
                application.setApplicationId(result.getInt(1));
                application.setApplicationName(result.getString(2));
                focusTime.setFocusTimeId(result.getInt(3));
                focusTime.setStartDate(result.getTimestamp(4));
                focusTime.setEndDate(result.getTimestamp(5));
                focusTime.setApplicationId(result.getInt(6));
                focusTime.setUserId(result.getInt(7));
                applicationFocusTime.setTotalTime(result.getInt(8));
                applicationFocusTime.setApplication(application);
                applicationFocusTime.setFocusTime(focusTime);
                appFocusTime.add(applicationFocusTime);
            }
            result.close();
            dbAccess.closeConnection();
        }
        catch (Exception e){
            System.err.println("SQLException: " + e.getMessage());
        }
        return appFocusTime;
    }

    /**
     *  This method returns FocusTime of the application tracked
     *
     * @return the Focus Time
     */
    public FocusTime getFocusTime() {
        return focusTime;
    }

    /**
     * This method set the FocusTime of the Tracked Application
     *
     * @param focusTime it is the Focus Time
     */
    public void setFocusTime(FocusTime focusTime) {
        this.focusTime = focusTime;
    }

    /**
     * This method return the tracked Application
     *
     * @return the Application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * This method set the Application that is tracked
     *
     * @param application it is the Application
     */
    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * This method set the Total time in seconds that an Application was active
     *
     * @param time it is the total time in seconds
     */
    public void setTotalTime(int time){
        this.totalTime = time;
    }

    /**
     * This method return the Total time in seconds that an Application was active
     *
     * @return the total time in seconds
     */
    public int getTotalTime(){
       return totalTime;
    }
}
