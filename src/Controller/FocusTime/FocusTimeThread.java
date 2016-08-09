package Controller.FocusTime;

import Model.Applications.Application;
import Model.Applications.ApplicationHandler;
import Model.FocusTime.FocusTime;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Class that control the active applications in which is working a user
 *
 * @author Aldo Balderrama
 */
public class FocusTimeThread extends Thread {
    private List<String> applicationNameList;
    private FocusTime previousFocusTime;
    private Application previousApplication;
    private int seconds;
    private int userId;
    private boolean isRun;

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
    public FocusTimeThread(int seconds, int userId) {
        this.applicationNameList = new ArrayList<>();
        this.seconds = seconds * 1000;
        this.previousFocusTime = null;
        this.previousApplication = null;
        this.userId = userId;
        this.isRun = false;
    }

    /**
     * This method runs when the thread is thrown in the background.
     */
    public void run() {
        this.isRun = true;
        while (isRun) {
            try {
                this.process();
                sleep(this.seconds);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                this.isRun = false;
                this.process();
            }
        }
    }

    /**
     * This method processes the information about application activity that is running in the computer.
     */
    private void process() {
        String applicationName = getApplicationName();
        System.out.println(applicationName);
        Date date = new Date();
        Application application = this.getApplication(applicationName);
        long starTime = date.getTime();
        long endTime = 0;
        if (this.previousFocusTime == null) {
            this.previousFocusTime = this.getFocusTime(new Timestamp(starTime), new Timestamp(endTime), application.getApplicationId(), this.userId);
            this.previousApplication = application;
        } else if (!this.previousApplication.getApplicationName().equals(application.getApplicationName())) {
            System.out.println(this.previousApplication.getApplicationName());
            endTime = starTime;
            this.previousFocusTime.setEndDate(new Timestamp(endTime));
            this.previousFocusTime.update();
            endTime = 0;
            this.previousFocusTime = this.getFocusTime(new Timestamp(starTime), new Timestamp(endTime), application.getApplicationId(), this.userId);
            this.previousApplication = application;
        } else if (!this.isRun) {
            endTime = starTime;
            this.previousFocusTime.setEndDate(new Timestamp(endTime));
            this.previousFocusTime.update();
        }
        this.applicationNameList.add(applicationName);
    }

    /**
     * Gets the name of the application that is active in the computer.
     *
     * @return the name of the active application.
     */
    private String getApplicationName() {
        String name = getActiveWindowTitle();
        String[] arrayName = name.split("-");
        if (arrayName.length > 1) {
            return arrayName[arrayName.length - 1].trim() + "-" + arrayName[0].trim();
        } else {
            return arrayName[arrayName.length - 1].trim();
        }
    }

    /**
     * Gets object Application.
     *
     * @param startTime     initial start time.
     * @param endTime       end time.
     * @param applicationId id the application.
     * @param userId        id the user.
     * @return Gets object Application.
     */
    private FocusTime getFocusTime(Timestamp startTime, Timestamp endTime, int applicationId, int userId) {
        FocusTime focusTime = new FocusTime(startTime, endTime, applicationId, userId);
        focusTime.save();
        return focusTime;
    }

    /**
     * Gets object Application.
     *
     * @param applicationName To find the application name.
     * @return Gets object Application.
     */
    private Application getApplication(String applicationName) {
        Application application;
        if (ApplicationHandler.exist(applicationName)) {
            application = ApplicationHandler.getApplicationByName(applicationName);
        } else {
            application = new Application(applicationName);
            application.save();
        }
        return application;
    }

    /***
     * Gets the name of the application that is active in the computer.
     *
     * @return the name of the active application.
     */
    private String getActiveWindowTitle() {
        HWND fgWindow = User32.INSTANCE.GetForegroundWindow();
        int titleLength = User32.INSTANCE.GetWindowTextLength(fgWindow) + 1;
        char[] title = new char[titleLength];
        User32.INSTANCE.GetWindowText(fgWindow, title, titleLength);
        return Native.toString(title);
    }
}