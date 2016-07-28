package View.AdminUser;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import java.util.ResourceBundle;
import Utils.Constants;
import View.Events.MenuEvents;

/**
 * Class to build the main menu
 *
 * @author Lourdes Villca
 */
public class MenuBar extends JMenuBar {
    private JMenu menuAdministration;
    private JMenu menuConfiguration;
    private JMenu menuReports;
    private JMenuItem itemUser;
    private JMenuItem itemApplication;
    private JMenuItem itemFocusTime;
    private JMenuItem itemActivityReport;
    private MenuEvents menuEvents;

    private ResourceBundle resource;

    /**
     * Create the menu Items into the MenuBar and add action to the menu Item
     *
     * @param mainWindow Main menu that content the menu bar
     */
    public MenuBar(final JFrame mainWindow) {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        menuEvents = new MenuEvents(mainWindow);
        buildMenuAdmin();
        buildMenuConfiguration();
        buildMenuReport();

    }

    /**
     * Build the Menu Administration
     */
    public void buildMenuAdmin() {
        menuAdministration = new JMenu(resource.getString("menu.label.administration"));
        itemUser = new JMenuItem(resource.getString("menuItem.label.user"));

        menuAdministration.add(itemUser);
        itemUser.setActionCommand(Constants.USER_LIST);
        itemUser.addActionListener(menuEvents);

        this.add(menuAdministration);
    }

    /**
     * Build the Configuration menu
     */
    public void buildMenuConfiguration() {
        menuConfiguration = new JMenu(resource.getString("menu.label.configuration"));
        itemApplication = new JMenuItem(resource.getString("menuItem.label.application"));
        itemFocusTime = new JMenuItem(resource.getString("menuItem.label.focusTime"));

        menuConfiguration.add(itemApplication);
        menuConfiguration.add(itemFocusTime);

        itemFocusTime.setActionCommand(Constants.FOCUS_TIME_CONFIG);
        itemApplication.setActionCommand(Constants.APP_CONFIG);

        itemFocusTime.addActionListener(menuEvents);
        itemApplication.addActionListener(menuEvents);

        this.add(menuConfiguration);
    }

    /**
     * Build the Report Menu
     */
    public void buildMenuReport() {
        menuReports = new JMenu(resource.getString("menu.label.reports"));
        itemActivityReport = new JMenuItem(resource.getString("menu.label.activityReport"));

        itemActivityReport.setActionCommand(Constants.ACTIVITY_REPORT);

        itemActivityReport.addActionListener(menuEvents);
        menuReports.add(itemActivityReport);
        this.add(menuReports);
    }
}
