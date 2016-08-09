package View.Report;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Applications.Application;
import Model.Applications.ApplicationCategory;
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
    private ApplicationCategory applicationCategory;
    private DataAccess dbAccess;
    private int totalTime;
    private double percentaje;

    public ApplicationFocusTime() {
        dbAccess = new DataAccess();
    }

    /**
     * This method gets the tracked applications, grouping by Application id and with the corresponding total time for each one
     *
     * @param startDate start date of the focus time
     * @param endDate   end date of the focus time
     * @return the ArrayList of ApplicationFocusTime
     */
    public ArrayList<ApplicationFocusTime> getTrackedApplication(String startDate, String endDate, int userId) {
        System.out.println(userId);
        ArrayList<ApplicationFocusTime> appFocusTime = new ArrayList<>();
        ApplicationFocusTime applicationFocusTime = null;
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("select res. *, (res.total * 100 / (select sum(Cast (((JulianDay(Datetime(ft.endDate)) - JulianDay(Datetime(ft.startDate))) * 24*60*60) as double)) from FocusTime as ft ");
        sql.append(String.format("where  Date(ft.startDate) between '%s' and ", startDate));
        sql.append(String.format("'%s' and ", endDate));
        sql.append(String.format("Date(ft.endDate) between '%s' and  ", startDate));
        sql.append(String.format("'%s')) as percentage ", endDate));
        sql.append("from ( select ap.*, ft.*, ac.applicationCategoryName, sum(Cast (((JulianDay(Datetime(ft.endDate)) - JulianDay(Datetime(ft.startDate))) * 24*60*60) as integer)) as total ");
        sql.append("from Application as ap, FocusTime as ft, ApplicationCategory as ac ");
        sql.append("where ap.applicationId = ft.applicationId and ap.applicationCategoryId = ac.applicationCategoryId and ");
        sql.append(String.format("Date(ft.startDate) between '%s' and ", startDate));
        sql.append(String.format("'%s' and ", endDate));
        sql.append(String.format("Date(ft.endDate) between '%s' and ", startDate));
        sql.append(String.format("'%s' and userId = %s ", endDate,userId));
        sql.append("group by ft.applicationId) as res group by res.applicationId");
        System.out.println(sql);
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                applicationFocusTime = new ApplicationFocusTime();
                applicationCategory = new ApplicationCategory();
                focusTime = new FocusTime();
                application = new Application();
                application.setApplicationId(result.getInt(1));
                application.setApplicationName(result.getString(2));
                application.setCategoryId(result.getInt(3));
                focusTime.setFocusTimeId(result.getInt(4));
                focusTime.setStartDate(result.getTimestamp(5));
                focusTime.setEndDate(result.getTimestamp(6));
                focusTime.setApplicationId(result.getInt(7));
                focusTime.setUserId(result.getInt(8));
                applicationCategory.setApplicationCategoryName(result.getString(9));
                applicationFocusTime.setTotalTime(result.getInt(10));
                applicationFocusTime.setPercentaje(result.getDouble(11));
                applicationFocusTime.setApplication(application);
                applicationFocusTime.setFocusTime(focusTime);
                applicationFocusTime.setApplicationCategory(applicationCategory);
                appFocusTime.add(applicationFocusTime);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return appFocusTime;
    }

    /**
     * This method returns FocusTime of the application tracked
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
    public void setTotalTime(int time) {
        this.totalTime = time;
    }

    /**
     * This method return the Total time in seconds that an Application was active
     *
     * @return the total time in seconds
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * This method returns the total in Porcentaje for applications
     *
     * @return the percentaje of applications
     */
    public double getPercentaje() {
        return percentaje;
    }

    /**
     * This method set the calculate percentage for each application
     *
     * @param percentaje the calculated percentage
     */
    public void setPercentaje(double percentaje) {
        this.percentaje = percentaje;
    }

    /**
     * This method returns the application category
     *
     * @return the category of the application
     */
    public ApplicationCategory getApplicationCategory() {
        return applicationCategory;
    }

    /**
     * This method set the application category
     *
     * @param applicationCategory the application category that is obtained from the query
     */
    public void setApplicationCategory(ApplicationCategory applicationCategory) {
        this.applicationCategory = applicationCategory;
    }
}
