import Model.Common.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 7/13/2016.
 */
public class PersonTest {

    public PersonTest(){
    }

    @Test
    public void VerifyThatANewPersonWasAdd (){
        Person person = new Person();
        person.setFirstName("Lana");
        person.setLastName("Vargas");
        person.setEnable(false);
        person.setPersonId(1);
        Assert.assertTrue(person.save());
    }

}

