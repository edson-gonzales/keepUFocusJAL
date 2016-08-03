package Test.Model.Application;

import Model.Applications.Application;
import Model.Applications.ApplicationHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class ApplicationTest {
    @Test
    public void VerifyThatANewApplicationIsAdd() {
        Application application = new Application();
        application.setApplicationName("Chrome");
        application.setCategoryId(1);
        application.save();
        Assert.assertEquals(application.getApplicationName(), ApplicationHandler.getApplicationById(application.getApplicationId()).getApplicationName());
        application.delete();
    }

    @Test
    public void VerifyThatAnApplicationIsUpdated() {
        Application application = new Application();
        application.setApplicationName("Crome");
        application.setCategoryId(1);
        application.save();
        Application otherApplication = ApplicationHandler.getApplicationById(application.getApplicationId());
        otherApplication.setApplicationName("Chrome");
        otherApplication.update();
        Assert.assertEquals(otherApplication.getApplicationName(), ApplicationHandler.getApplicationById(application.getApplicationId()).getApplicationName());
        application.delete();
    }

    @Test
    public void VerifyIfAnApplicationIsDeleted() {
        Application application = new Application();
        application.setApplicationName("Chrome");
        application.setCategoryId(1);
        application.save();
        application.delete();
        Assert.assertNull(ApplicationHandler.getApplicationById(application.getApplicationId()));
    }

    @Test
    public void VerifyIfAnApplicationExist() {
        Application application = new Application();
        application.setApplicationName("Excel");
        application.setCategoryId(1);
        application.save();
        Assert.assertTrue(ApplicationHandler.exist("Excel"));
        application.delete();
    }
}
