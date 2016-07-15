package Model.AdminUser;

import Model.Conection.Connection;

/**
 * This class  contains the information of every user, save, update and delete a user of dbKeepUFocus.sqlite data base
 *
 * @autor: JuanaRodriguez
 */
public class User extends Model.Common.Person {

    private int userId;
    private String userName;
    private String password;
    private boolean enable;
    private Connection db;

    /**
     * Give back the Id of a user
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Modify the Id of the  user
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Give back the name of the user
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Modify the name of the user
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Give back the password of the user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modify the password of the user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * This method is a construct the object user
     */
    public User() {
        super();
        this.setUserId(0);
        this.setUserName("");
        this.setPassword("");
        this.setEnable(false);
        db = new Connection();
    }

    /**
     * This method save a user in the dbKeepUFocus.sqlite database
     *
     * @return: the sql query.
     */
    public boolean save() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into User(username,password,roleId,state) ");
        sql.append(String.format("Values('%s','%s',0,0)", this.getUserName(), this.getPassword()));
        return db.execute(sql.toString());
    }

    public boolean update() {
        System.out.printf("method will implements");
        return true;
    }

    public boolean delete() {
        System.out.printf("method will implements");
        return true;
    }
}
