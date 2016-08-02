package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class Application {
    private int applicationId;
    private String applicationName;
    private int applicationCategoryId;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getApplicationCategoryId() {
        return applicationCategoryId;
    }

    public void setApplicationCategoryId(int applicationCategoryId) {
        this.applicationCategoryId = applicationCategoryId;
    }

    public Application() {
        this.applicationId = 0;
        this.applicationName = "";
        this.applicationCategoryId = 0;
    }

    public Application(String applicationName) {
        this.applicationId = 0;
        this.applicationName = applicationName;
        this.applicationCategoryId = 0;
    }

    public boolean save() {
        System.out.printf("method will implements");
        return true;
    }

    public boolean update() {
        System.out.printf("method will implements");
        return true;
    }

    public boolean delete() {
        System.out.printf("method will implements");
        return true;
    }

    public static Application getApplication(int applicationId) {
        Application application = new Application("Ruby Mine");
        return application;
    }

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
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return application;
    }
}
