package Controller.FocusTime;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that control the active applications in which is working a user
 *
 * @author Aldo Balderrama
 */
public class FocusTimeThread extends Thread {
    private List<String> applicationNameList;
    private int seconds;

    /**
     * Gets the applications list.
     *
     * @return The application list.
     */
    public List<String> getApplicationNameList() {
        return applicationNameList;
    }

    /**
     * Build a new FocusTimeThread.
     *
     * @param seconds Indicate the time in seconds that mean how often the process is executed.
     */
    public FocusTimeThread(int seconds) {
        this.applicationNameList = new ArrayList<>();
        this.seconds = seconds * 1000;
    }

    /**
     * This method runs when the thread is thrown in the background.
     */
    public void run() {
        boolean isRun = true;
        while (isRun) {
            try {
                this.process();
                sleep(this.seconds);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (this.isInterrupted()) {
                isRun = false;
            }
        }
    }

    /**
     * This method processes the information about application activity that is running in the computer.
     */
    private void process() {
        String[] arrayName = getActiveWindowTitle().split("-");
        applicationNameList.add(arrayName[arrayName.length - 1].trim());
    }

    /***
     * Gets the name of the application that is active in the computer.
     *
     * @return the name of the active application
     */
    private static String getActiveWindowTitle() {
        HWND fgWindow = User32.INSTANCE.GetForegroundWindow();
        int titleLength = User32.INSTANCE.GetWindowTextLength(fgWindow) + 1;
        char[] title = new char[titleLength];
        User32.INSTANCE.GetWindowText(fgWindow, title, titleLength);
        return Native.toString(title);
    }
}