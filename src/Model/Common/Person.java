package Model.Common;

import Model.Connections.DataAccess;

import java.sql.ResultSet;

/**
 * The class manages persons of the database
 *
 * @autor: JuanaRodriguez
 */
public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private int positionId;
    private int gender;
    private DataAccess dbAccess;

    /**
     * The method return the Id of the person
     *
     * @return personId, this variable is an integer value
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * The method set the personId of the person
     *
     * @param personId will be set in the person
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * The method return the first name of the person
     *
     * @return firstName, this variable is a string value
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * The method set the first name of the person
     *
     * @param firstName will be set in the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The method return the last name of the person
     *
     * @return lastName, this variable is a string value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The method set the last name of the person
     *
     * @param lastName will be set in the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The method return the positionId of the person
     *
     * @return positionId, this variable is an integer value
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * The method set the positionId of the person
     *
     * @param positionId will be set in the person
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * The method return the gender of the person
     *
     * @return gender, this variable is an integer value
     */
    public int getGender() {
        return gender;
    }

    /**
     * The method set the gender of the person
     *
     * @param gender will be set in the person
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * The method construct the Person object and instance the DataAccess class.
     */
    public Person() {
        this.personId = 0;
        this.firstName = "";
        this.lastName = "";
        this.gender = 0;
        this.positionId = 0;
        dbAccess = new DataAccess();
    }

    /**
     * The method insert a person in the database, catch the id from the person inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the person was inserted, this  flag return true if the
     * person was inserted correctly.
     */
    public boolean save() {
        boolean saved = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Person (firstName,lastName,gender,positionId) ");
            sql.append(String.format("Values('%s','%s',0,0)", this.getFirstName(), this.getLastName()));
            result = dbAccess.save(sql.toString());
            if (result.next()) {
                this.setPersonId(result.getInt(1));
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
     * The method updates a person and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Person set ");
        sql.append(String.format("firstName = '%s', ", getFirstName()));
        sql.append(String.format("lastName = '%s', ", getLastName()));
        sql.append(String.format("gender = '%s', ", getGender()));
        sql.append(String.format("positionId = %s ", getPositionId()));
        sql.append(String.format("where personId = %s", getPersonId()));
        updated = dbAccess.update(sql.toString());
        dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method delete a person and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Person ");
        sql.append(String.format("where PersonId = %s", getPersonId()));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }

}
