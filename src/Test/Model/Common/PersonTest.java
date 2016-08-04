package Test.Model.Common;

import Model.Common.Person;
import Model.Common.PersonHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class PersonTest {
    @Test
    public void VerifyIfAPersonIsAdd() {
        Person person = new Person();
        person.setFirstName("Pedro");
        person.setLastName("Suarez");
        person.setGender(1);
        person.setPositionId(1);
        person.save();
        Assert.assertEquals(person.getFirstName(), PersonHandler.getPersonById(person.getPersonId()).getFirstName());
        person.delete();
    }

    @Test
    public void VerifyIfAPersonIsUpdated() {
        Person person = new Person();
        person.setFirstName("Pedo");
        person.setLastName("Suarez");
        person.setGender(1);
        person.setPositionId(1);
        person.save();
        Person otherPerson = PersonHandler.getPersonById(person.getPersonId());
        otherPerson.setFirstName("Pedro");
        otherPerson.update();
        Assert.assertEquals(otherPerson.getFirstName(), PersonHandler.getPersonById(person.getPersonId()).getFirstName());
        person.delete();
    }

    @Test
    public void VerifyIfAnPersonIsDeleted() {
        Person person = new Person();
        person.setFirstName("Pedro");
        person.setLastName("Suarez");
        person.setGender(1);
        person.setPositionId(1);
        person.save();
        person.delete();

    }
}
