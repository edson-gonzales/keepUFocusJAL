package Controller.TrakingConfig;

import Model.Applications.TrackingConfiguration;
import Model.TrakingConfig.TrackingConfigurationHandler;

/**
 * @author Lourdes Villca
 */
public class TrackingConfigController {
    /**
     * Update an Traking Configuration.
     *
     * @param trackingConfig update focus time tracking  in the data base.
     * @return Return boolean value (True = Success;False = Error).
     */
    public boolean updateApplication(TrackingConfiguration trackingConfig) {
        return trackingConfig.update();
    }

    /**
     * Get tracking configuration given an id.
     *
     * @return Return boolean value (True = Success;False = Error).
     */
    public TrackingConfiguration getTrackingConfiguration() {
        return TrackingConfigurationHandler.getTrackingConfiguration();

    }
}
