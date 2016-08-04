package Model.UserAdmin;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class RoleHandler, it handles of the Role class
 *
 * @autor: JuanaRodriguez
 */
public class RoleHandler {
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
     * The method return the role objects and set in an ArrayList
     *
     * @return roles return a set roles
     */
    public static ArrayList<Role> getListRole() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<Role> roles = new ArrayList<Role>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from Role");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                Role role = new Role();
                role.setRoleId(result.getInt(1));
                role.setRoleName(result.getString(2));
                roles.add(role);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return roles;
    }
}
