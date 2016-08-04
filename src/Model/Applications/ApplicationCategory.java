package Model.Applications;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class manages ApplicationCategory of the database
 *
 * @autor: JuanaRodriguez
 */
public class ApplicationCategory {
    private int applicationCategoryId;
    private String applicationCategoryName;
    private DataAccess dbAccess;

    /**
     * The method return the Id's Application Category
     *
     * @return applicationCategoryId, this variable is string value
     */
    public int getApplicationCategoryId() {
        return applicationCategoryId;
    }

    /**
     * The method set the Id in the Application Category
     *
     * @param applicationCategoryId will be set in the ApplicationCategory
     */
    public void setApplicationCategoryId(int applicationCategoryId) {
        this.applicationCategoryId = applicationCategoryId;
    }

    /**
     * The method return the name's Application Category
     *
     * @return applicationCategoryName, this variable is string value
     */
    public String getApplicationCategoryName() {
        return applicationCategoryName;
    }

    /**
     * The method set the name the Application Category
     *
     * @param applicationCategoryName will be set in the ApplicationCategory
     */
    public void setApplicationCategoryName(String applicationCategoryName) {
        this.applicationCategoryName = applicationCategoryName;
    }

    /**
     * The method build an ApplicationCategory object
     */
    public ApplicationCategory() {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = "";
        dbAccess = new DataAccess();
    }

    /**
     *
     * @param applicationCategoryName
     */
    public ApplicationCategory(String applicationCategoryName) {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = applicationCategoryName;
        dbAccess = new DataAccess();
    }

    /**
     * The method insert an applicationCategory in the database, catch the id from the applicationCategory inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the applicationCategory was inserted, this  flag return true if the
     * applicationCategory was inserted correctly.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ApplicationCategory (applicationCategoryName)");
            sql.append(String.format("Values('%s')", this.getApplicationCategoryName()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setApplicationCategoryId(result.getInt(1));
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
     * The method updates an applicationCategory and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update ApplicationCategory set ");
        sql.append(String.format("applicationCategoryName = '%s' ", getApplicationCategoryName()));
        sql.append(String.format("where applicationCategoryId = %s", getApplicationCategoryId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method deletes an applicationCategory and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from ApplicationCategory ");
        sql.append(String.format("where applicationCategoryId = %s", getApplicationCategoryId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
