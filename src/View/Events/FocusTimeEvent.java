package View.Events;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.FocusTime.FocusTimeThread;
import Utils.Constants;
import View.FocusTime.FocusTime;
import View.Main;

/**
 * Manage Events from the popup Focus Time
 *
 * @author Lourdes Villca
 */
public class FocusTimeEvent implements ActionListener {
    private FocusTime focusTime;

    public FocusTimeEvent(FocusTime focusTime) {
        this.focusTime = focusTime;
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
            case Constants.TRAY_ICON:
                JOptionPane.showMessageDialog(null, "FocusTimes by PROG-102 TEAM FocusTime");
                break;
            case Constants.ABOUT:
                JOptionPane.showMessageDialog(null, "FocusTimes by PROG-102 TEAM FocusTime");
                break;
            case Constants.ADMINISTRATION:
                Main main = Main.getMain();
                break;
            case Constants.ACTIVITY_REPORT:
                Main.getMain();
                break;
            case Constants.OFFICE_TIMER:
                break;
            case Constants.START_TRACK:
                if (FocusTime.focusTimeThread == null) {
                    FocusTime.focusTimeThread = new FocusTimeThread(1, 25);
                }
                FocusTime.focusTimeThread.start();
                System.out.println("Start thread");
                break;
            case Constants.STOP_TRACK:

                FocusTime.focusTimeThread.interrupt();
                FocusTime.focusTimeThread = null;
                System.out.println("Stop thread");
                break;

            case Constants.EXIT:
                if (FocusTime.focusTimeThread != null) {
                    FocusTime.focusTimeThread.interrupt();
                }

                System.exit(0);
                break;
        }
    }
}
