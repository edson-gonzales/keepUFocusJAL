package Utils;

import javax.swing.*;
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
            hourList.add(new HourUtil(i * 60, i + ":00 "));

        }
        return hourList;
    }
    public static String calculateTotalHour(int startHour,int endDate){
        int totalHour = (endDate - startHour)/60;
        return totalHour + " Hrs";

    }
    public static void convertTimeToTimeStamp(String date,String time){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = date+" "+time;
        try{
            Date datec = sdf.parse(dateInString);
            System.out.println(datec);
        }catch (Exception e){
            System.out.printf("error");
        }

    }

}
