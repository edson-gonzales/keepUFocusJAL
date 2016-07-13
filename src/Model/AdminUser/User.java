package Model.AdminUser;

import Model.Common.Position;
import Model.Conection.Connection;

/**
 * Created by AldoBalderrama on 7/5/2016.
 */
public class User extends Model.Common.Person
{
    //Attribute
    private int userId;
    private String userName;
    private String password;
    private boolean enable;
    private Connection db;

    //Property
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    //Constructor
    public User()
    {
        super();
        this.setUserId(0);
        this.setUserName("");
        this.setPassword("");
        this.setEnable(false);
        this.setPersonId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setEnable(false);
        this.setPosition(new Position());
        db = new Connection();
    }

    //Methods
    public boolean save()
    {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into Person(firstName,lastName,gender,positionId) ");
        sql.append(String.format("Values('%s','%s',0,1)",this.getFirstName(),this.getLastName()));
        return db.execute(sql.toString());
    }
    public boolean update()
    {
        System.out.printf("method will implements");
        return true;
    }
    public boolean delete()
    {
        System.out.printf("method will implements");
        return true;
    }
}
