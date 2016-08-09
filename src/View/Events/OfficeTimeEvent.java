package View.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Activity.ActivityController;
import Model.Applications.ActivityTime;
import Utils.Constants;
import View.Login.Session;
import View.OfficeTime.OfficeTime;


/**
 * Manage events from Office Time
 *
 * @auhtor Lourdes Villca
 */
public class OfficeTimeEvent implements ActionListener {
    private OfficeTime officeTime;

    public OfficeTimeEvent(OfficeTime officeTime) {
        this.officeTime = officeTime;
    }

    /**
     * This method is invoked when an action occurs in the Office Time Form, when the user register a Office Time
     *
     * @param e mouse event that gives information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case Constants.SAVE_OFFICETIME:
                ActivityTime activity = new ActivityTime();
                ActivityController controller = new ActivityController();
                activity.setStartDate(officeTime.getFromHourCbx());
                activity.setEndDate(officeTime.getToHourCbx());
                activity.setActivityTypeId(officeTime.getActivitycbx().getActivityTypeId());
                activity.setUserId(Session.getUser().getUserId());
                controller.saveActivity(activity);
                officeTime.dispose();
                break;
            case Constants.CANCEL_OFFICETIME:
                officeTime.dispose();
                break;
        }
    }
}
