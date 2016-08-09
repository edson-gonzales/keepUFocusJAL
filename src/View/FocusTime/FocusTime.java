package View.FocusTime;

import java.awt.PopupMenu;
import java.awt.MenuItem;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.AWTException;
import View.Events.FocusTimeEvent;
import Controller.FocusTime.FocusTimeThread;
import Utils.Constants;
import Utils.Utility;
import View.Login.Session;
/**
 * This class build the Popup menu
 *
 * Created by AldoBalderrama on 8/3/2016.
 */
public class FocusTime extends PopupMenu {
    public static FocusTimeThread focusTimeThread;
    private SystemTray tray;
    private MenuItem aboutItem;
    private MenuItem configuration;
    private MenuItem officeTimer;
    private MenuItem report;
    private MenuItem startFocusTimeItem;
    private MenuItem stopFocusTimeItem;
    private MenuItem exitItem;

    /**
     * Method that initialize the components
     */
    public FocusTime() {
        focusTimeThread = new FocusTimeThread(1, Session.getUser().getUserId());
        tray = SystemTray.getSystemTray();
        createAndShowGUI();
        buildTrayIcon();
        buildItemAbout();
        buildItemConfiguration();
        buildItemOfficeTimer();
        buildItemReport();
        buildItemsManageTracker();
        buildExitItem();
        focusTimeThread.start();
    }

    /**
     * Method that create and Show the GUI
     */
    public static void createAndShowGUI() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
    }

    /**
     * Method that build the Tray icon that is displayed in the Task bar
     */
    public void buildTrayIcon() {
        TrayIcon trayIcon = new TrayIcon(Utility.createImage("../../Resources/images/iconKUF.png", "tray icon"));
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Focus Time");
        trayIcon.setPopupMenu(this);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        trayIcon.setActionCommand(Constants.TRAY_ICON);
        trayIcon.addActionListener(new FocusTimeEvent(this));

    }

    /**
     * Method That build the Item About
     */
    public void buildItemAbout() {
        aboutItem = new MenuItem("About KeepUFocus");
        this.add(aboutItem);
        aboutItem.setActionCommand(Constants.ABOUT);
        aboutItem.addActionListener(new FocusTimeEvent(this));
        this.addSeparator();
    }

    /**
     * Method that build the Item Configuration that only is enable for user administrator
     */
    public void buildItemConfiguration() {
        if(Session.isAdmin()){
            configuration = new MenuItem("Configuration");
            configuration.setActionCommand(Constants.ADMINISTRATION);
            configuration.addActionListener(new FocusTimeEvent(this));
            this.add(configuration);
        }

    }

    /**
     * Method that build the Item Office timer, where the user can register their activities
     */
    public void buildItemOfficeTimer(){
        if(!Session.isAdmin()){
            officeTimer = new MenuItem("Office Timer");
            officeTimer.setActionCommand(Constants.OFFICE_TIMER);
            officeTimer.addActionListener(new FocusTimeEvent(this));
            this.add(officeTimer);
        }

    }

    /**
     * Method that build the Item Report where the user can track their used application
     */
    public void buildItemReport(){
        report = new MenuItem("Report");
        report.setActionCommand(Constants.ACTIVITY_REPORT);
        report.addActionListener(new FocusTimeEvent(this));
        this.add(report);
    }

    /**
     * Method that build the Item to start and stop the Application Tracking
     */
    public void buildItemsManageTracker() {
        startFocusTimeItem = new MenuItem("Restart");
        stopFocusTimeItem = new MenuItem("Stop");
        startFocusTimeItem.setActionCommand(Constants.RESTART_TRACK);
        stopFocusTimeItem.setActionCommand(Constants.STOP_TRACK);
        startFocusTimeItem.addActionListener(new FocusTimeEvent(this));
        stopFocusTimeItem.addActionListener(new FocusTimeEvent(this));
        this.add(startFocusTimeItem);
        this.add(stopFocusTimeItem);
    }

    /**
     * Method that Build the exit from the system
     */
    public void buildExitItem() {
        this.addSeparator();
        exitItem = new MenuItem("Exit");
        exitItem.setActionCommand(Constants.EXIT);
        exitItem.addActionListener(new FocusTimeEvent(this));
        this.add(exitItem);
    }


}
