package Test.Controller.Applications;

import Controller.Applications.ApplicationControllers;
import Model.Applications.Application;
import Model.Applications.ApplicationCategory;
import Model.Applications.ApplicationCategoryHandler;
import Model.Applications.ApplicationHandler;
import Model.Connections.DataAccess;

import org.junit.Test;

import java.sql.ResultSet;

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
        applicationControllers.deleteApplication(application);
    }

    @Test
    public void updateOneApplicationWithApplicationControllers() {
        ApplicationControllers applicationControllers = new ApplicationControllers();
        Application otherApplication = new Application("Ruby mine");
        applicationControllers.saveApplication(otherApplication);
        Application application = ApplicationHandler.getApplicationById(otherApplication.getApplicationId());
        application.setApplicationName("Ruby Mine Update");
        assertTrue(applicationControllers.updateApplication(application));
        applicationControllers.deleteApplication(application);
    }

    @Test
    public void deleteOneApplicationWithApplicationControllers() {
        ApplicationControllers applicationControllers = new ApplicationControllers();
        Application otherApplication = new Application("Ruby mine");
        applicationControllers.saveApplication(otherApplication);
        Application application = ApplicationHandler.getApplicationById(otherApplication.getApplicationId());
        assertTrue(applicationControllers.deleteApplication(application));
    }

    @Test
    public void saveOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationControllers applicationControllers = new ApplicationControllers();
        ApplicationCategory applicationCategory = new ApplicationCategory("Work");
        assertTrue(applicationControllers.saveApplicationCategory(applicationCategory));
        applicationControllers.deleteApplicationCategory(applicationCategory);
    }

    @Test
    public void updateOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationControllers applicationControllers = new ApplicationControllers();
        ApplicationCategory otherApplicationCategory = new ApplicationCategory("Work");
        applicationControllers.saveApplicationCategory(otherApplicationCategory);
        ApplicationCategory applicationCategory = ApplicationCategoryHandler.getApplicationCategoryById(otherApplicationCategory.getApplicationCategoryId());
        applicationCategory.setApplicationCategoryName("Test");
        assertTrue(applicationControllers.updateApplicationCategory(applicationCategory));
        applicationControllers.deleteApplicationCategory(applicationCategory);
    }

    @Test
    public void deleteOneApplicationCategoryWithApplicationCategoryControllers() {
        ApplicationControllers applicationControllers = new ApplicationControllers();
        ApplicationCategory otherApplicationCategory = new ApplicationCategory("Work");
        applicationControllers.saveApplicationCategory(otherApplicationCategory);
        ApplicationCategory applicationCategory = ApplicationCategoryHandler.getApplicationCategoryById(otherApplicationCategory.getApplicationCategoryId());
        assertTrue(applicationControllers.deleteApplicationCategory(applicationCategory));
    }

    @Test
    public void verifyGetListApplicationWithApplicationCategoryControllers() {
        DataAccess dataAccess = new DataAccess();
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Count(*) as Count ");
        sql.append("FROM Application");
        ResultSet resultSet = dataAccess.select(sql.toString());
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            dataAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        ApplicationControllers applicationControllers = new ApplicationControllers();
        assertTrue(applicationControllers.getListApplication().size() == count);
    }
}