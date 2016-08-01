package Test.Model.Application;

import Model.Applications.Application;
import Model.Applications.ApplicationCategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @autor: JuanaRodriguez
 */
public class ApplicationCategoryTest {
    @Test
    public void VerifyThatANewApplicationCategoryIsAdd(){
        ApplicationCategory applicationCategory = new ApplicationCategory();
        applicationCategory.setApplicationCategoryName("Meeting");
        applicationCategory.save();
        Assert.assertEquals(applicationCategory.getApplicationCategoryName(), ApplicationCategory.getApplicationCategoryById(applicationCategory.getApplicationCategoryId()).getApplicationCategoryName());
        applicationCategory.delete();
    }

    @Test
    public void VerifyThatAnApplicationIsUpdated(){
        ApplicationCategory applicationCategory = new ApplicationCategory();
        applicationCategory.setApplicationCategoryName("Lunchh");
        applicationCategory.save();
        ApplicationCategory otherApplicationCategory = ApplicationCategory.getApplicationCategoryById(applicationCategory.getApplicationCategoryId());
        otherApplicationCategory.setApplicationCategoryName("Lunch");
        otherApplicationCategory.update();
        Assert.assertEquals(otherApplicationCategory.getApplicationCategoryName(), ApplicationCategory.getApplicationCategoryById(applicationCategory.getApplicationCategoryId()).getApplicationCategoryName());
        applicationCategory.delete();
    }
    @Test
    public void VerifyThatAnApplicationCategoryIsDeleted(){
        ApplicationCategory applicationCategory = new ApplicationCategory();
        applicationCategory.setApplicationCategoryName("Lunchhh");
        applicationCategory.save();
        Assert.assertNotNull(ApplicationCategory.getApplicationCategoryById(applicationCategory.getApplicationCategoryId()));
        applicationCategory.delete();
    }
}