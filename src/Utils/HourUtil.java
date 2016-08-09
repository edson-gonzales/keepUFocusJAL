package Utils;

/**
 * Class to manage the hours
 *
 * @author Lourdes Villca
 */
public class HourUtil {
    private int timeMinutes;
    private String timeString;

    public HourUtil(int timeMinutes, String timeString) {
        this.timeString = timeString;
        this.timeMinutes = timeMinutes;
    }

    /**
     * This method get the time in minutes
     *
     * @return the time in minutes
     */
    public int getTimeMinutes() {
        return timeMinutes;
    }

    /**
     * This method set the time in minutes
     *
     * @param timeMinutes time in minutes
     */
    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    /**
     * This method get the time in string format e.g. "7:00"
     *
     * @return the time in string format
     */
    public String getTimeString() {
        return timeString;
    }

    /**
     * This method set the time in String format
     *
     * @param timeString time in string format
     */
    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    /**
     * This method set the String representation of the Hour Util
     *
     * @return the String
     */
    @Override
    public String toString() {
        return timeString;
    }

    /**
     * Compare the Hour Utils
     *
     * @param other the object to be compared
     * @return true if the objects are equals
     */
    @Override
    public boolean equals(Object other) {
        HourUtil otherHour = (HourUtil) other;

        return otherHour != null && otherHour.toString().equals(this.timeString);
    }
}
