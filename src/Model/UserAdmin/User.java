package Model.UserAdmin;

import Model.Common.Person;
import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class manages user of the data base
 *
 * @autor: JuanaRodriguez
 */
public class User extends Person {
    private int userId;
    private String userName;
    private String password;
    private int roleId;
    private int personId;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the user
     *
     * @return userId, this variable is an integer value
     */
    public int getUserId() {
        return userId;
    }

    /**
     * The method set the id of the user
     *
     * @param userId will be set in the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * The method return the userName of the user.
     *
     * @return userName, this variable is a string value
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The method set the username of the user
     *
     * @param userName will be set in the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * The method return the password of the user.
     *
     * @return password, this variable is a string value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * The method set the password of the user.
     *
     * @param password, will be set in the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The method return the Id of the user
     *
     * @return userId, this variable is an integer value
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * The method set the roleId of the user
     *
     * @param roleId will be set in the user
     */
    public void setRoleId(int roleId) {
        this.userId = roleId;
    }

    /**
     * The method return the personId of the user
     *
     * @return personId, this variable is an integer value
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * The method set the personId of the user
     *
     * @param personId will be set in the user
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * The method build the Role object and instance the DataAccess class.
     */
    public User() {
        super();
        this.userId = 0;
        this.userName = "";
        this.password = "";
        this.roleId = 0;
        this.personId = 0;
        dbAccess = new DataAccess();
    }

    /**
     * The method build the Role object and instance the DataAccess class.
     *
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     */
    public User(String firstName, String lastName, String userName, String password) {
        super();
        this.userId = 0;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.userName = userName;
        this.password = password;
        this.roleId = 0;
        this.personId = 0;
        dbAccess = new DataAccess();
    }

    /**
     * The method insert a user in the database, catch the id from the user inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the user was inserted, this  flag return true if the
     * user was inserted correctly and false if it wasn't inserted.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into User (login,password,roleId,personId) ");
            sql.append(String.format("Values('%s','%s',0,0)", this.getUserName(), this.getPassword()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setUserId(result.getInt(1));
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
     * The method updates a user and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update User set ");
        sql.append(String.format("login = '%s', ", getUserName()));
        sql.append(String.format("password = '%s', ", getPassword()));
        sql.append(String.format("roleId = '%s', ", getRoleId()));
        sql.append(String.format("personId = '%s' ", getPersonId()));
        sql.append(String.format("where userId = %s", getUserId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method delete a user and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from User ");
        sql.append(String.format("where userId = %s", getUserId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
