package Model.Common;

/**
 * Created by AldoBalderrama on 7/5/2016.
 */
public class Person {
    //Attribute
    private int personId;
    private String firstName;
    private String lastName;
    private boolean enable;
    private Position position;

    //Property
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean isEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    //Constructor
    public Person()
    {
        this.setPersonId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setEnable(false);
        this.setPosition(new Position());
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
