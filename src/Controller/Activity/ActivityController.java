package Controller.Activity;

import java.util.ArrayList;

import Model.Applications.ActivityTime;
import Model.Applications.ActivityType;
import Model.Applications.ActivityTypeHandler;
import View.OfficeTime.OfficeTime;


/**
 * Created by LourdesVillca on 8/8/2016.
 */
public class ActivityController {
    public ArrayList<ActivityType> getActivities(){
        return ActivityTypeHandler.getListActivityType();
    }
    public boolean saveActivity(ActivityTime activity){
        return activity.save();
    }
}

