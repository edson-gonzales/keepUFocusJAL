package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class ApplicationCategory {
    private int applicationCategoryId;
    private String applicationCategoryName;
    private DataAccess dbAccess;

    public int getApplicationCategoryId() {
        return applicationCategoryId;
    }

    public void setApplicationCategoryId(int applicationCategoryId) {
        this.applicationCategoryId = applicationCategoryId;
    }

    public String getApplicationCategoryName() {
        return applicationCategoryName;
    }

    public void setApplicationCategoryName(String applicationCategoryName) {
        this.applicationCategoryName = applicationCategoryName;
    }

    public ApplicationCategory() {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = "";
    }

    public ApplicationCategory(String applicationCategoryName) {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = applicationCategoryName;
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

    public static ApplicationCategory getApplicationCategory(int applicationCategoryId) {
        ApplicationCategory applicationCategory = new ApplicationCategory("Work");
        return applicationCategory;
    }

    public static ApplicationCategory getApplicationCategoryById(int applicationCategoryId) {
        ApplicationCategory applicationCategory = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from ApplicationCategory");
            sql.append(String.format("where applicationCategoryId = %s;", applicationCategoryId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                applicationCategory = new ApplicationCategory();
                applicationCategory.setApplicationCategoryId(result.getInt(1));
                applicationCategory.setApplicationCategoryName(result.getString(2));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return applicationCategory;
    }
}
