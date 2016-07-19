import Model.Common.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor Juana Rodriguez
 */
public class PersonTest {

    @Test
    public void VerifyThatANewPersonWasAdd() {
        Person person = new Person();
        person.setFirstName("Lana");
        person.setLastName("Vargas");
        person.setEnable(false);
        person.setPersonId(1);
        Assert.assertTrue(person.save());
    }

}

