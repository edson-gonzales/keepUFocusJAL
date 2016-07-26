package View.AdminUser;

import Utils.Constants;
import View.Events.MenuEvents;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

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
     *
     */
    public void buildMenuAdmin() {
        menuAdministration = new JMenu(resource.getString("menu.label.administration"));
        itemUser = new JMenuItem(resource.getString("menuItem.label.user"));


        menuAdministration.add(itemUser);
        itemUser.setActionCommand("1");
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

        itemFocusTime.setActionCommand("2");
        itemApplication.setActionCommand("3");

        itemFocusTime.addActionListener(menuEvents);
        itemApplication.addActionListener(menuEvents);

        this.add(menuConfiguration);
    }

    /**
     * Build the Report Menu
     */
    public void buildMenuReport() {
        menuReports = new JMenu(resource.getString("menu.label.reports"));
        this.add(menuReports);
    }
}
