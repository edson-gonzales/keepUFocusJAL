package Test.Model.FocusTime;

import Model.Connections.DataAccess;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Timestamp;
import Model.FocusTime.FocusTime;

/**
 * @author Lourdes Villca
 */
public class FocusTimeTest {

    @Test
    public void verifyThatANewFocusTimeIsAdded() {
        DataAccess dataAccess = new DataAccess();
        FocusTime focusTime = new FocusTime();
        boolean result = false;
        String startDate = "2016-08-01 13:51:30.767";
        String endDate = "2016-08-01 14:18.359";
        focusTime.setStartDate(Timestamp.valueOf(startDate));
        focusTime.setEndDate(Timestamp.valueOf(endDate));
        focusTime.setApplicationId(1);
        focusTime.save();


        Assert.assertEquals("Verify Start Date of Focus Time", focusTime.getStartDate(), FocusTime.getFocusTimeById(focusTime.getFocusTimeId()).getStartDate());
        Assert.assertEquals("Verify End date of Focus Time", focusTime.getEndDate(), FocusTime.getFocusTimeById(focusTime.getFocusTimeId()).getEndDate());
        Assert.assertEquals("Verify Application Id of Focus Time", focusTime.getApplicationId(), FocusTime.getFocusTimeById(focusTime.getFocusTimeId()).getApplicationId());

    }

}
