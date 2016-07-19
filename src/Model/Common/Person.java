package Model.Common;

import Model.Conection.Connection;
/**
 * This class save, update and delete a person for the dbKeepUFocus.sqlite database
 * @autor: JuanaRodriguez
 */
public class Person {

    private int personId;
    private String firstName;
    private String lastName;
    private boolean enable;
    private Position position;
    private Connection db;

    /**
     * Give back the id from person
     * @return personId
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Modify the id from person
     * @param personId
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * Give back the first name of the person
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modify the first name of person
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Give back the last name of the person
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Modify the last name of person
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean isEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * Give back the position of the person
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Modify the position of the person
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * This method construct the object Person
     */
    public Person()
    {
        this.setPersonId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setEnable(false);
        this.setPosition(new Position());
        db = new Connection();
    }

    /**
     * This method save a person in the dbKeepUFocus.sqlite database
     * @return the sql query.
     */
    public boolean save()
    {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into Person(firstName,lastName,gender,positionId) ");
        sql.append(String.format("Values('%s','%s',0,1)", this.getFirstName(), this.getLastName()));
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
