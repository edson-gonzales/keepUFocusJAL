package View.Events;

import Controller.TrakingConfig.TrackingConfigController;
import Model.Applications.TrackingConfiguration;
import Utils.Constants;
import Utils.HourUtil;
import View.AdminUser.SearchUserUI;
import View.Report.Activity;
import View.config.Application.Application;
import View.config.Tracking.ConfigureFocusTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Manage Events for Menu Bar options
 *
 * @author Lourdes Villca
 */
public class MenuEvents implements ActionListener {
    private JFrame mainWindow;

    public MenuEvents(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * This method is invoked when an action occurs
     *
     * @param e action event that gives information about the event and its source
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case Constants.USER_LIST: // User menu
                mainWindow.getContentPane().removeAll();
                SearchUserUI searchUser = new SearchUserUI();
                refreshMainFrame(searchUser);
                break;

            case Constants.FOCUS_TIME_CONFIG: // Focus time configuration
                mainWindow.getContentPane().removeAll();
                ConfigureFocusTime configureFocusTime = fillFocusTimeConfig();
                refreshMainFrame(configureFocusTime);
                break;

            case Constants.APP_CONFIG: // Application config
                mainWindow.getContentPane().removeAll();
                Application app = new Application();
                refreshMainFrame(app);
                break;

            case Constants.ACTIVITY_REPORT: // Activity report
                mainWindow.getContentPane().removeAll();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = dateFormatter.format(new Date());
                Activity activity = new Activity(mainWindow, currentDate, currentDate);
                refreshMainFrame(activity);
                break;
        }
    }

    /**
     * Method to refresh the content of the main frame
     *
     * @param panel to be added into the main frame
     */
    public void refreshMainFrame(JPanel panel) {
        mainWindow.getContentPane().add(panel, BorderLayout.CENTER);
        mainWindow.setSize(mainWindow.getWidth() + 1, mainWindow.getHeight() + 1);
        mainWindow.setSize(mainWindow.getWidth() - 1, mainWindow.getHeight() - 1);
    }

    /**
     * Method to fill the tracking configuration form, the fields are setting with the saved information
     *
     * @return the tracking configuration
     */
    public ConfigureFocusTime fillFocusTimeConfig(){
        TrackingConfigController controller = new TrackingConfigController();
        TrackingConfiguration trackConfig = controller.getTrackingConfiguration();
        ConfigureFocusTime configFocusTime = new ConfigureFocusTime();

        if (trackConfig != null){
            configFocusTime.setStartHoursBox(new HourUtil(trackConfig.getStartHour(), trackConfig.getStartHour()/60 + ":00"));
            configFocusTime.setEndHoursBox(new HourUtil(trackConfig.getEndHour(), trackConfig.getEndHour()/60 + ":00"));
            configFocusTime.setWeekDays(trackConfig.getDays());
        }

        return configFocusTime;
    }
}