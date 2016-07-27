package Model.Common;

import Model.Conection.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @autor: JuanaRodriguez
 */
public class Role {
    private int roleId;
    private String roleName;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the role
     *
     * @return roleId, this variable is a integer value
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * The method set the id of the role
     *
     * @param roleId will be set in the role
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * The method return the name of the role
     *
     * @return roleName, this variable is string value
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * The method set the name of the role
     *
     * @param roleName will be set in the role
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * The method construct the Role object and instance the DataAccess class.
     */
    public Role() {
        this.setRoleId(0);
        this.setRoleName("");
        dbAccess = new DataAccess();
    }

    /**
     * The method insert a role in the database, catch the id from the role inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the role was inserted, this  flag return true if the
     * role was inserted correctly.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Role (roleName) ");
            sql.append(String.format("Values('%s')", this.getRoleName()));
            result = dbAccess.save(sql.toString());

            if (result.next()) {
                this.setRoleId(result.getInt(1));
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
     * The method get a specific role given an Id
     *
     * @param roleId the id of the role to get a specific role
     * @return the Role object
     */
    public static Role getRoleById(int roleId) {
        Role role = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from Role ");
            sql.append(String.format("where roleId = %s;", roleId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                role = new Role();
                role.setRoleId(result.getInt(1));
                role.setRoleName(result.getString(2));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return role;
    }

    /**
     * The method updates a role and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Role set ");
        sql.append(String.format("roleName = '%s' ", getRoleName()));
        sql.append(String.format("where roleId = %s", getRoleId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method deletes a role and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.     *
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Role ");
        sql.append(String.format("where roleId = %s", getRoleId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
