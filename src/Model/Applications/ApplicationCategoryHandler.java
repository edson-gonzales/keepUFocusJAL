package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class ApplicationCategoryHandler, it handles of the ApplicationCategory class
 *
 * @autor: JuanaRodriguez
 */
public class ApplicationCategoryHandler {
    /**
     * The method get a specific ApplicationCategory given an Id
     *
     * @param applicationCategoryId the id of the ApplicationCategory to get a specific ApplicationCategory
     * @return the ApplicationCategory object
     */
    public static ApplicationCategory getApplicationCategoryById(int applicationCategoryId) {
        ApplicationCategory applicationCategory = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from ApplicationCategory ");
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

    /**
     * The method return the application category objects and set in an ArrayList
     *
     * @return applicationCategories return a set applicationCategories
     */
    public static ArrayList<ApplicationCategory> getListApplicationCategory() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<ApplicationCategory> applicationCategories = new ArrayList<ApplicationCategory>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from ApplicationCategory");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                ApplicationCategory applicationCategory = new ApplicationCategory();
                applicationCategory.setApplicationCategoryId(result.getInt(1));
                applicationCategory.setApplicationCategoryName(result.getString(2));
                applicationCategories.add(applicationCategory);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return applicationCategories;
    }
}
