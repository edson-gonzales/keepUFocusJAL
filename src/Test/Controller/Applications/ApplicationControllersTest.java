package Test.Controller.Applications;

import Controller.Applications.ApplicationControllers;
import Model.Applications.Application;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ALDO on 16/7/2016.
 */
public class ApplicationControllersTest {
    @Test
    public void saveOneApplicationWithApplicationControllers() {
        Application application = new Application("Ruby Mine");

        ApplicationControllers applicationControllers = new ApplicationControllers();

        assertTrue(applicationControllers.saveApplication(application));
    }

    @Test
    public void updateOneApplicationWithApplicationControllers() {
        Application application = Application.getApplication(1);
        application.setApplicationName("Ruby Mine Test");

        ApplicationControllers applicationControllers = new ApplicationControllers();

        assertTrue(applicationControllers.updateApplication(application));
    }

    @Test
    public void deleteOneApplicationWithApplicationControllers() {
        Application applicationCategory = Application.getApplication(1);

        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.deleteApplication(applicationCategory));
    }

}
