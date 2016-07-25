package Test.Controller.Applications;

import Model.Applications.Application;
import Model.Applications.ApplicationCategory;
import Controller.Applications.ApplicationControllers;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
/**
 * Created by AldoBalderrama on 7/25/2016.
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

    @Test
    public void saveOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationCategory applicationCategory = new ApplicationCategory("Work");
        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.saveApplicationCategory(applicationCategory));
    }

    @Test
    public void updateOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategory(1);
        applicationCategory.setApplicationCategoryName("Test");
        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.updateApplicationCategory(applicationCategory));
    }

    @Test
    public void deleteOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategory(1);
        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.deleteApplicationCategory(applicationCategory));
    }
}
