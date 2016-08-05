package Model.UserAdmin;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class UserHandler, it handles of the User class
 *
 * @autor: JuanaRodriguez
 */
public class UserHandler {
    /**
     * The method get a specific user given an Id
     *
     * @param userId the id of the user to get a specific user
     * @return the User object
     */
    public static User getUserById(int userId) {
        User user = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from User ");
            sql.append(String.format("where userId = %s;", userId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                user = new User();
                user.setUserId(result.getInt(1));
                user.setFirstName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setUserName(result.getString(4));
                user.setPassword(result.getString(5));
                user.setRoleId(result.getInt(6));
                user.setPositionId(result.getInt(7));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return user;
    }

    /**
     * The method return the user objects and set in an ArrayList
     *
     * @return users return a set users
     */
    public static ArrayList<User> getListUser() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<User> users = new ArrayList<>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from User");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                User user = new User();
                user.setUserId(result.getInt(1));
                user.setFirstName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setUserName(result.getString(4));
                user.setPassword(result.getString(5));
                user.setRoleId(result.getInt(6));
                user.setPositionId(result.getInt(7));
                users.add(user);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return users;
    }

    /**
     *
     * @param userId
     * @return
     */
    public static boolean exist(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}
