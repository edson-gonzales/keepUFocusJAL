package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class manages application of the database
 *
 * @autor: JuanaRodriguez
 */
public class Application {
    private int applicationId;
    private String applicationName;
    private int categoryId;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the application
     *
     * @return applicationId, this variable is an integer value
     */
    public int getApplicationId() {
        return applicationId;
    }

    /**
     * The method set the id of the application
     *
     * @param applicationId will be set in the application
     */
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * The method return the name of the application
     *
     * @return applicationName, this variable is an string value
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * The method set the name of the application
     *
     * @param applicationName will be set in the application
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * The method return the categoryId of the application
     *
     * @return categoryId, this variable is an integer value
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * The method set the categoryId of the application
     *
     * @param categoryId will be set in the application
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * The method build an Application object
     */
    public Application() {
        this.setApplicationId(0);
        this.setApplicationName("");
        this.setCategoryId(1);
        dbAccess = new DataAccess();
    }

    /**
     * The method insert a application in the database, catch the id from the application inserted in the "result"
     * variable
     *
     * @return the saved flag that help us to check if the application was inserted, this  flag return true if the
     * application was inserted correctly.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Application (applicationName,applicationCategoryId) ");
            sql.append(String.format("Values('%s',1)", this.getApplicationName()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setApplicationId(result.getInt(1));
                saved = true;
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }

    /**
     * The method updates an application and give back true through of updated variable if the date was modify
     * successfully using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Application set ");
        sql.append(String.format("applicationName = '%s' ,", getApplicationName()));
        sql.append(String.format("applicationCategoryId = '%s' ",this.getCategoryId()));
        sql.append(String.format("where applicationId = %s", getApplicationId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method deletes an application and give back true through of deleted variable if the date was delete
     * successfully using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Application ");
        sql.append(String.format("where applicationId = %s", getApplicationId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
