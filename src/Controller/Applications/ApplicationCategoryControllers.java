package Controller.Applications;

import Model.Applications.ApplicationCategory;

/**
 * Control the interaction between the view and the model layer
 * Created by ALDO on 16/7/2016.
 */
public class ApplicationCategoryControllers {
    //Methods

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
