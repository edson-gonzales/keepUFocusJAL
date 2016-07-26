package Model.Common;

import Model.Conection.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @autor: JuanaRodriguez
 */
public class Role {
    private int roleId;
    private String roleName;
    private DataAccess dbAccess;

    /**
     * Give back a role
     *
     * @return roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Modify the id from the role
     *
     * @param roleId
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Give back a role
     *
     * @return roleId
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Modify the id from the role
     *
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method construct the object Role
     */
    public Role() {
        this.setRoleId(0);
        this.setRoleName("");
        dbAccess = new DataAccess();
    }

    /**
     * This method insert a role in the database, catch the id from the role inserted in the "result" variable and
     * have the "saved" flag that help us to check if the role was inserted
     *
     * @return saved
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
            } else {
                throw new SQLException("There is an error, It was not possible to insert the Role");
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return saved;
    }

    /**
     * This method find a specific role through of its Id
     *
     * @param roleId
     * @return the object role
     */
    public Role getRoleById(int roleId) {
        Role role = null;
        ResultSet result = null;
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
     * This method updates a role and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @param roleId
     * @return updated
     */
    public boolean update(int roleId) {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Role set ");
        sql.append(String.format("roleName = '%s' ", this.getRoleName()));
        sql.append(String.format("where roleId = %s", roleId));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * This method deletes a role and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @param roleId
     * @return deleted
     */
    public boolean delete(int roleId) {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Role ");
        sql.append(String.format("where roleId = %s", roleId));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }


}
