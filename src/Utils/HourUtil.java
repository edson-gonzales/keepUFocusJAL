package Utils;

/**
 * @author Lourdes Villca
 */
public class HourUtil {
    private int timeMinutes;
    private String timeString;

    public HourUtil(int timeMinutes, String timeString) {
        this.timeString = timeString;
        this.timeMinutes = timeMinutes;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    @Override
    public String toString() {
        return timeString;
    }
}
