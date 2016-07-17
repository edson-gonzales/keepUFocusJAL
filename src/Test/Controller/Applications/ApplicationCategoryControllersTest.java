package Test.Controller.Applications;

import static org.junit.Assert.*;

import org.junit.Test;
import Model.Applications.ApplicationCategory;
import Controller.Applications.ApplicationCategoryControllers;

/**
 * Created by ALDO on 16/7/2016.
 */
public class ApplicationCategoryControllersTest {
    @Test
    public void saveOneApplicationCategoryWithApplicationCategoryControllers()
    {
        ApplicationCategory applicationCategory = new ApplicationCategory("Work");

        ApplicationCategoryControllers applicationCategoryControllers = new ApplicationCategoryControllers();

        assertTrue(applicationCategoryControllers.saveApplicationCategory(applicationCategory));
    }
    @Test
    public void updateOneApplicationCategoryWithApplicationCategoryControllers()
    {
        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategory(1);
        applicationCategory.setApplicationCategoryName("Test");

        ApplicationCategoryControllers applicationCategoryControllers = new ApplicationCategoryControllers();

        assertTrue(applicationCategoryControllers.updateApplicationCategory(applicationCategory));
    }
    @Test
    public void deleteOneApplicationCategoryWithApplicationCategoryControllers()
    {
        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategory(1);

        ApplicationCategoryControllers applicationCategoryControllers = new ApplicationCategoryControllers();
        assertTrue(applicationCategoryControllers.deleteApplicationCategory(applicationCategory));
    }
}
