package Test.Controller.Applications;

import static org.junit.Assert.*;

import org.junit.Test;
import Model.Applications.Application;
import Controller.Applications.ApplicationControllers;

/**
 * Created by ALDO on 16/7/2016.
 */
public class ApplicationControllersTest {
    @Test
    public void saveOneApplicationWithApplicationControllers()
    {
        Application application = new Application("Ruby Mine");

        ApplicationControllers applicationControllers = new ApplicationControllers();

        assertTrue(applicationControllers.saveApplication(application));
    }
    @Test
    public void updateOneApplicationWithApplicationControllers()
    {
        Application application = Application.getApplication(1);
        application.setApplicationName("Ruby Mine Test");

        ApplicationControllers applicationControllers = new ApplicationControllers();

        assertTrue(applicationControllers.updateApplication(application));
    }
    @Test
    public void deleteOneApplicationWithApplicationControllers()
    {
        Application applicationCategory = Application.getApplication(1);

        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.deleteApplication(applicationCategory));
    }

}
