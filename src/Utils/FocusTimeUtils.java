package Utils;

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

}
