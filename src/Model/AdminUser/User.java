package Model.AdminUser;

import Model.Conection.Connection;

/**
 * Class user to save user information on data base.
 *
 * @author Aldo Balderrama on 7/5/2016.
 */
public class User extends Model.Common.Person {
    //Attribute
    private int userId;
    private String userName;
    private String password;
    private boolean enable;
    private Connection db;

    //Property

    /**
     * Get userId for an user object.
     *
     * @return Return userId of user Object.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set userId for an user object.
     *
     * @param userId The userId to be store.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get userName of user object.
     *
     * @return Return userName of user Object.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName for an user object.
     *
     * @param userName The userName to be store.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get password of user object.
     *
     * @return Return password of user Object.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password for an user object.
     *
     * @param password The password to be store.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get enable of user object.
     *
     * @return Return enable of user Object.
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * Set enable for an user object.
     *
     * @param enable The enable to be store.
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    //Constructor

    /**
     * Build a new UserControllersTest with required params.
     *
     * @param firstName First name the user.Required fields.
     * @param lastName  Last name the user.Required fields.
     * @param userName  UserControllersTest name the user.Required fields.
     * @param password  Password the user.Required fields.
     */
    public User(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName);
        this.userId = 0;
        this.userName = userName;
        this.password = password;
        this.enable = false;
        this.setPersonId(0);
        this.setPositionId(1);
        db = new Connection();
    }

    /**
     * Build a new UserControllersTest.
     */
    public User() {
        super();
        this.userId = 0;
        this.userName = "";
        this.password = "";
        this.enable = false;
        this.setPersonId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setPositionId(0);
        db = new Connection();
    }

    //Methods

    /**
     * Save user Information in the data base.
     *
     * @return Return boolean value (True = Susses;False = Error).
     */
    public boolean save() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Update the user information in the data base.
     *
     * @return Return a boolean value (True = Success;False = Error).
     */
    public boolean update() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Deleted an existing user in the data base.
     *
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean delete() {
        System.out.printf("method will implements");
        return true;
    }

    /**
     * Get an existing user in the data base.
     *
     * @param userId ID for search in the data base.
     * @return Exits an UserControllersTest.
     */
    public static User getUser(int userId) {
        User user = new User("Oscar Martin", "Balderrama Vaca", "oBalderrama", "1234");
        user.setUserId(userId);

        return user;
    }
}
