package Controller.Applications;

import Model.Applications.Application;

/**
 * Control the interaction between the view and the model layer
 * Created by ALDO on 16/7/2016.
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
}
