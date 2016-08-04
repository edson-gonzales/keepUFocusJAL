package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class ApplicationHandler, it handles of the Application class
 *
 * @autor: JuanaRodriguez
 */
public class ApplicationHandler {
    /**
     * The method get a specific application given an Id
     *
     * @param applicationId the id of the application to get a specific application
     * @return the Application object
     */
    public static Application getApplicationById(int applicationId) {
        Application application = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from Application ");
            sql.append(String.format("where applicationId = %s;", applicationId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                application = new Application();
                application.setApplicationId(result.getInt(1));
                application.setApplicationName(result.getString(2));
                application.setCategoryId(result.getInt(3));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return application;
    }

    /**
     * The method get a specific application given the name of the application
     *
     * @param applicationName the name of the application to get a specific application
     * @return the Application object
     */
    public static Application getApplicationByName(String applicationName) {
        Application application = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from Application ");
            sql.append(String.format("where applicationName = '%s';", applicationName));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                application = new Application();
                application.setApplicationId(result.getInt(1));
                application.setApplicationName(result.getString(2));
                application.setCategoryId(result.getInt(3));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return application;
    }

    /**
     * Given the name's application, the method return if this exist or not
     *
     * @param applicationName the name of the application to verify if exist or not in the database
     * @return exist return true if the name's application exist and return false if this doesn't exist
     */
    public static boolean exist(String applicationName) {
        boolean exist = false;
        Application application = getApplicationByName(applicationName);
        if (application != null) {
            exist = true;
        }
        return exist;
    }

    /**
     * The method return the application objects and set in an ArrayList
     *
     * @return applications return a set applications
     */
    public static ArrayList<Application> getListApplication() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<Application> applications = new ArrayList<Application>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from Application");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                Application application = new Application();
                application.setApplicationId(result.getInt(1));
                application.setApplicationName(result.getString(2));
                application.setCategoryId(result.getInt(1));
                applications.add(application);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return applications;
    }

}
