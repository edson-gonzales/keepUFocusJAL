package View.Events;

import Controller.TrakingConfig.TrackingConfigController;
import Model.Applications.TrackingConfiguration;
import Utils.Constants;
import View.config.Tracking.ConfigureFocusTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Lourdes Villca
 */
public class ConfigureFocusTimeEvent implements ActionListener{
    private ConfigureFocusTime confFocusTime;

    public ConfigureFocusTimeEvent(ConfigureFocusTime confFocusTime){
        this.confFocusTime = confFocusTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case Constants.CALCULATE_HOUR:
                confFocusTime.buildTotalHours();
                break;
            case Constants.SAVE_CONFIG:
                TrackingConfigController controller = new TrackingConfigController();
                TrackingConfiguration trackConfig = controller.getTrackingConfiguration();
                if(trackConfig!=null){
                    trackConfig.setTrackingConfigurationId(trackConfig.getTrackingConfigurationId());
                    trackConfig.setDays(confFocusTime.selectedCheckBoxes());
                    trackConfig.setStartHour(confFocusTime.getStartHoursBox().getTimeMinutes());
                    trackConfig.setEndHour(confFocusTime.getEndHoursBox().getTimeMinutes());
                    trackConfig.setDays(confFocusTime.selectedCheckBoxes());
                    trackConfig.update();

                }else{
                    trackConfig = new TrackingConfiguration();
                    trackConfig.setDays(confFocusTime.selectedCheckBoxes());
                    trackConfig.setStartHour(confFocusTime.getStartHoursBox().getTimeMinutes());
                    trackConfig.setEndHour(confFocusTime.getEndHoursBox().getTimeMinutes());
                    trackConfig.save();
                }

                break;
        }
    }
}
