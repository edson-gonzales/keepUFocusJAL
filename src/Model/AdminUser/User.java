package Model.AdminUser;

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
    }

    //Methods
    public boolean save()
    {
        System.out.printf("method will implements");
        return true;
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
