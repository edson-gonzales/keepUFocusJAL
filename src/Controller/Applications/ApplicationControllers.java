package Controller.Applications;

import Model.Applications.Application;
import Model.Applications.ApplicationCategory;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class ApplicationControllers {
    //Methods

    /**
     * Save an Application object.
     *
     * @param application Save Application in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean saveApplication(Application application) {
        return application.save();
    }

    /**
     * Update an Application object.
     *
     * @param application update Application in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updateApplication(Application application) {
        return application.update();
    }

    /**
     * Delete an Application object.
     *
     * @param application delete Application in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean deleteApplication(Application application) {
        return application.delete();
    }

    /**
     * Save an ApplicationCategory object.
     *
     * @param applicationCategory Save ApplicationCategory in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean saveApplicationCategory(ApplicationCategory applicationCategory) {
        return applicationCategory.save();
    }

    /**
     * Update an ApplicationCategory object.
     *
     * @param applicationCategory update ApplicationCategory in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updateApplicationCategory(ApplicationCategory applicationCategory) {
        return applicationCategory.update();
    }

    /**
     * Delete an ApplicationCategory object.
     *
     * @param applicationCategory delete ApplicationCategory in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean deleteApplicationCategory(ApplicationCategory applicationCategory) {
        return applicationCategory.delete();
    }
}
