package Test.Model.FocusTime;

import org.junit.Assert;
import org.junit.Test;
import java.sql.Timestamp;
import Model.FocusTime.FocusTime;
import Model.Connections.DataAccess;
import Model.FocusTime.FocusTimeHandler;

import static java.sql.Timestamp.*;

/**
 * @author Lourdes Villca
 */
public class FocusTimeTest {

    @Test
    public void verifyThatANewFocusTimeIsAdded() {
        DataAccess dataAccess = new DataAccess();
        FocusTime focusTime = new FocusTime();
        String startDate = "2016-08-01 12:45:30.767";
        String endDate = "2016-08-01 13:00:45.359";
        focusTime.setStartDate(Timestamp.valueOf(startDate));
        focusTime.setEndDate(Timestamp.valueOf(endDate));
        focusTime.setApplicationId(3);
        focusTime.save();


        Assert.assertEquals("Verify Start Date of Focus Time", focusTime.getStartDate(), FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId()).getStartDate());
        Assert.assertEquals("Verify End date of Focus Time", focusTime.getEndDate(), FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId()).getEndDate());
        Assert.assertEquals("Verify Application Id of Focus Time", focusTime.getApplicationId(), FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId()).getApplicationId());

    }
    @Test
    public void verifyThatAFocusTimeIsUpdated(){
        DataAccess dataAccess = new DataAccess();
        FocusTime focusTime = new FocusTime();
        String startDate = "2016-08-01 12:45:30.767";
        String endDate = "2016-08-01 13:00:45.359";
        focusTime.setStartDate(Timestamp.valueOf(startDate));
        focusTime.setEndDate(Timestamp.valueOf(endDate));
        focusTime.setApplicationId(3);
        focusTime.save();
        FocusTime otherFocusTime = FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId());
        otherFocusTime.setEndDate(Timestamp.valueOf("2016-08-01 14:00:45.359"));
        otherFocusTime.update(focusTime.getFocusTimeId());
        Assert.assertEquals(otherFocusTime.getEndDate(), FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId()).getEndDate());

    }
    @Test
    public void verifyGetFocusTimeById(){
        DataAccess dataAccess = new DataAccess();
        FocusTime focusTime = new FocusTime();
        String startDate = "2016-08-02 12:45:30.767";
        String endDate = "2016-08-02 13:00:45.359";
        focusTime.setStartDate(Timestamp.valueOf(startDate));
        focusTime.setEndDate(Timestamp.valueOf(endDate));
        focusTime.setApplicationId(3);
        focusTime.save();
        Assert.assertNotNull(FocusTimeHandler.getFocusTimeById(focusTime.getFocusTimeId()));
    }


}
