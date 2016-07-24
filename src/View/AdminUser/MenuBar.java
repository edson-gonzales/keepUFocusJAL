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

    private ResourceBundle resource;

    /**
     * Create the menu Items into the MenuBar and add action to the menu Item
     *
     * @param mainWindow Main menu that content the menu bar
     */
    public MenuBar(final JFrame mainWindow) {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);

        menuAdministration = new JMenu(resource.getString("menu.label.administration"));
        menuConfiguration = new JMenu(resource.getString("menu.label.configuration"));
        menuReports = new JMenu(resource.getString("menu.label.reports"));

        itemUser = new JMenuItem(resource.getString("menuItem.label.user"));
        itemApplication = new JMenuItem(resource.getString("menuItem.label.application"));
        itemFocusTime = new JMenuItem(resource.getString("menuItem.label.focusTime"));

        this.add(menuAdministration);
        this.add(menuConfiguration);
        this.add(menuReports);

        menuAdministration.add(itemUser);

        menuConfiguration.add(itemApplication);
        menuConfiguration.add(itemFocusTime);

        itemUser.setActionCommand("1");
        itemFocusTime.setActionCommand("2");
        itemApplication.setActionCommand("3");

        MenuEvents menuEvents = new MenuEvents(mainWindow);

        itemUser.addActionListener(menuEvents);
        itemApplication.addActionListener(menuEvents);
        itemFocusTime.addActionListener(menuEvents);

    }
}
