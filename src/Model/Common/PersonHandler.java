package Model.Common;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class PersonHandler, it handles of the Person class
 *
 * @autor: JuanaRodriguez
 */
public class PersonHandler {
    /**
     * The method get a specific person given an Id
     *
     * @param personId the id of the person to get a specific person
     * @return the Person object
     */
    public static Person getPersonById(int personId) {
        Person person = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from Person ");
            sql.append(String.format("where personId = %s;", personId));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                person = new Person();
                person.setPersonId(result.getInt(1));
                person.setFirstName(result.getString(2));
                person.setLastName(result.getString(3));
                person.setGender(result.getInt(4));
                person.setPositionId(result.getInt(5));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return person;
    }

    /**
     * The method return the person objects and set in an ArrayList
     *
     * @return persons return a set persons
     */
    public static ArrayList<Person> getListPerson() {
        DataAccess dbAccess = new DataAccess();
        ArrayList<Person> persons = new ArrayList<Person>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from Person");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                Person person = new Person();
                person.setPersonId(result.getInt(1));
                person.setFirstName(result.getString(2));
                person.setLastName(result.getString(3));
                person.setGender(result.getInt(4));
                person.setPositionId(result.getInt(5));
                persons.add(person);
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return persons;
    }
}
