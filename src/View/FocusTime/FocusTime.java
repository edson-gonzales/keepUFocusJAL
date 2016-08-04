package View.FocusTime;

import Controller.FocusTime.FocusTimeThread;
import Utils.Utility;
import View.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AldoBalderrama on 8/3/2016.
 */
public class FocusTime {
    static FocusTimeThread focusTimeThread;

    public FocusTime() {
        focusTimeThread = new FocusTimeThread(1,25);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(Utility.createImage("../../Resources/images/bulb.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Focus Time");
        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem optionItem = new MenuItem("Option");
        MenuItem startFocusTimeItem = new MenuItem("Start");
        MenuItem stopFocusTimeItem = new MenuItem("Stop");
        MenuItem exitItem = new MenuItem("Exit");

        //Add components to popup menu
        popup.add(aboutItem);
        popup.add(optionItem);
        popup.addSeparator();
        popup.add(startFocusTimeItem);
        popup.add(stopFocusTimeItem);
        popup.addSeparator();
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "FocusTimes by PROG-102 TEAM FocusTime");
            }
        });
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "FocusTimes by PROG-102 TEAM FocusTime");
            }
        });
        optionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.main(new String[]{});
            }
        });
        startFocusTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (focusTimeThread == null) {
                    focusTimeThread = new FocusTimeThread(1,25);
                }
                focusTimeThread.start();
                System.out.println("Start thread");
            }
        });
        stopFocusTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                focusTimeThread.interrupt();
                focusTimeThread = null;
                System.out.println("Stop thread");
            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (focusTimeThread != null) {
                    focusTimeThread.interrupt();
                }
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
}
