package Model.Common;

/**
 * Created by AldoBalderrama on 7/5/2016.
 */
public class Person {
    //Attribute
    private int personId;
    private String firstName;
    private String lastName;
    private int positionId;

    //Property

    /**
     * Get personId for an person object.
     *
     * @return Return userId of person Object.
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Set personId for an parson object.
     *
     * @param personId The personId to be store.
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * Get firstName for an person object.
     *
     * @return Return firstName of person Object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set firstName for an parson object.
     *
     * @param firstName The firstName to be store.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get lastName for an person object.
     *
     * @return Return lastName of person Object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set lastName for an parson object.
     *
     * @param lastName The lastName to be store.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get positionId for an person object.
     *
     * @return Return positionId of person Object.
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Set positionId for an parson object.
     *
     * @param positionId The positionId to be store.
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    //Constructor

    /**
     * Build a new UserControllersTest.
     */
    public Person() {
        this.personId = 0;
        this.firstName = "";
        this.lastName = "";
        this.positionId = 0;
    }

    /**
     * Build a new person with required params.
     *
     * @param firstName First name the user.Required fields.
     * @param lastName  Last name the user.Required fields.
     */
    public Person(String firstName, String lastName) {
        this.personId = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionId = 1;
    }
}
