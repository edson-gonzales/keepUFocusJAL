package Utils;

import javax.swing.JFrame;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Helper for differents operations that help to Convert time,
 *
 * @author Lourdes Villca
 */
public class FocusTimeUtils {

    public FocusTimeUtils() {

    }

    /**
     * Method that calculate the total time expressed in seconds and convert it in Hours, Minutes and Seconds
     *
     * @param totalTime expressed in seconds
     * @return a String with the time expressed in Hours, Minutes and Seconds
     */
    public String convertTime(int totalTime) {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String result = " ";
        if (totalTime >= 3600) {
            hours = totalTime / 3600;
            totalTime = totalTime % 3600;
            result += hours + "h ";
        }

        if (totalTime >= 60) {
            minutes = totalTime / 60;
            seconds = totalTime % 60;
            result += minutes + "m ";
        } else {
            seconds = totalTime;
            result += seconds + "s";
        }

        return result;
    }

    /**
     * Method that have the Hours to be selected, it start at 6:00 AM to 22:00 PM
     *
     * @return the hash map with the list of hours
     */
    public static ArrayList<HourUtil> hoursList() {
        int startHour = 6;
        int endHour = 22;
        ArrayList<HourUtil> hourList = new ArrayList<>();
        for (int i = 6; i <= endHour; i++) {
            hourList.add(new HourUtil(i * 60, i + ":00"));

        }
        return hourList;
    }

    /**
     * This method calculate the Total hour given an start and end hour
     *
     * @param startHour start hour
     * @param endDate   end hour
     * @return the total hour in String format
     */
    public static String calculateTotalHour(int startHour, int endDate) {
        int totalHour = (endDate - startHour) / 60;
        return "   "+totalHour + " Hrs";

    }

    /**
     * This method  that convert a String Date in a Timestamp
     *
     * @param date string date to be converted
     * @param time string date to be converted
     * @return the Timestamp of the given Date and time
     */
    public static java.sql.Timestamp convertTimeToTimeStamp(String date, String time) {
        java.sql.Timestamp timeStamp = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateInString = date + " " + time+":00";
            Date dateParse = sdf.parse(dateInString);
            timeStamp = new java.sql.Timestamp(dateParse.getTime());



        } catch (Exception e) {
            System.out.println(e);

        }

        return timeStamp;
    }

    /**
     * Method that get the position of the component related to the center of the screen
     *
     * @param component to be centered
     * @return the point
     */
    public static Point getCenteredPos(Component component) {
        Point res = new Point();

        if (component != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension compSize = component.getSize();

            res.move((screenSize.width / 2 - compSize.width / 2), (screenSize.height / 2 - compSize.height / 2));
        }

        return res;
    }

    /**
     * This method center the main window in the screen
     *
     * @param window to be center
     */
    public static void centerWindow(Window window) {
        if (window != null) {
            Point point = getCenteredPos(window);
            window.setLocation(point);
        }
    }
}
