package Model.TrakingConfig;

import Model.Applications.TrackingConfiguration;
import Model.Connections.DataAccess;
import Model.FocusTime.FocusTime;

import java.sql.ResultSet;

/**
 *@author Lourdes Villca.
 */
public class TrackingConfigurationHandler {

    public static TrackingConfiguration getTrackingConfiguration(){

        DataAccess dbAccess = new DataAccess();
        TrackingConfiguration trackingConfiguration = null;

        StringBuilder sql = new StringBuilder("Select * from TrackingConfiguration");
        ResultSet resultSet = dbAccess.select(sql.toString());

        try {
            while (resultSet.next()) {
                trackingConfiguration = new TrackingConfiguration();
                trackingConfiguration.setTrackingConfigurationId(resultSet.getInt(1));
                trackingConfiguration.setStartHour(resultSet.getInt(2));
                trackingConfiguration.setEndHour(resultSet.getInt(3));
                trackingConfiguration.setDays(resultSet.getString(4));
            }
            resultSet.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return trackingConfiguration;
    }

}
