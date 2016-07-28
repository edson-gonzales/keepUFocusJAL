//package Test.Controller.Applications;
//
//import Controller.Applications.ApplicationControllers;
//import Model.Applications.Application;
//import Model.Applications.ApplicationCategory;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by AldoBalderrama on 7/25/2016.
// */
//public class ApplicationControllersTest {
//    @Test
//    public void saveOneApplicationWithApplicationControllers() {
//        Application application = new Application("Ruby Mine");
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        assertTrue(applicationControllers.saveApplication(application));
//        applicationControllers.deleteApplication(application);
//    }
//
//    @Test
//    public void updateOneApplicationWithApplicationControllers() {
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        Application otherApplication = new Application("Ruby mine");
//        applicationControllers.saveApplication(otherApplication);
//        Application application = Application.getApplicationById(otherApplication.getApplicationId());
//        application.setApplicationName("Ruby Mine Update");
//        assertTrue(applicationControllers.updateApplication(application));
//        applicationControllers.deleteApplication(application);
//    }
//
//    @Test
//    public void deleteOneApplicationWithApplicationControllers() {
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        Application otherApplication = new Application("Ruby mine");
//        applicationControllers.saveApplication(otherApplication);
//        Application application = Application.getApplicationById(otherApplication.getApplicationId());
//        assertTrue(applicationControllers.deleteApplication(application));
//    }
//
//    @Test
//    public void saveOneApplicationCategoryWithApplicationCategoryControllers() {
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        ApplicationCategory applicationCategory = new ApplicationCategory("Work");
//        assertTrue(applicationControllers.saveApplicationCategory(applicationCategory));
//        applicationControllers.deleteApplicationCategory(applicationCategory);
//    }
//
//    @Test
//    public void updateOneApplicationCategoryWithApplicationCategoryControllers() {
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        ApplicationCategory otherApplicationCategory = new ApplicationCategory("Work");
//        applicationControllers.saveApplicationCategory(otherApplicationCategory);
//        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategoryById(otherApplicationCategory.getApplicationCategoryId());
//        applicationCategory.setApplicationCategoryName("Test");
//        assertTrue(applicationControllers.updateApplicationCategory(applicationCategory));
//        applicationControllers.deleteApplicationCategory(applicationCategory);
//    }
//
//    @Test
//    public void deleteOneApplicationCategoryWithApplicationCategoryControllers() {
//        ApplicationControllers applicationControllers = new ApplicationControllers();
//        ApplicationCategory otherApplicationCategory = new ApplicationCategory("Work");
//        applicationControllers.saveApplicationCategory(otherApplicationCategory);
//        ApplicationCategory applicationCategory = ApplicationCategory.getApplicationCategoryById(otherApplicationCategory.getApplicationCategoryId());
//        assertTrue(applicationControllers.deleteApplicationCategory(applicationCategory));
//    }
//}