package View.Events;

import Controller.Applications.ApplicationControllers;
import Controller.UserAdmin.UserControllers;
import Model.Applications.Application;
import Model.UserAdmin.User;
import Utils.Constants;
import View.AdminUser.AddUserUI;
import View.config.Application.ApplicationForm;
import View.config.Application.ApplicationTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by LuLy on 05/08/2016.
 */
public class ApplicationEvent extends MouseAdapter implements ActionListener{
    private ApplicationTable appTable;
    private ApplicationForm applicationForm;

    public ApplicationEvent(ApplicationTable appTable){
        this.appTable = appTable;
    }
    public ApplicationEvent(ApplicationForm applicationForm){
        this.applicationForm = applicationForm;
    }
    /**
     * This method is invoked when an action occurs in the Application Table, when the update icon is clicked
     *
     * @param e mouse event that gives information about the event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = appTable.applicationTable.rowAtPoint(e.getPoint());
        int column = appTable.applicationTable.columnAtPoint(e.getPoint());

        switch (column) {
            case Constants.UPDATE_APPLICATION: //Update Application
                applicationForm = new ApplicationForm();
                Application application = new Application();
                ApplicationControllers controller = new ApplicationControllers();
                applicationForm.setApplicationNameLabel(controller.getApplicationById(application.getApplicationId()).getApplicationName());
                //applicationForm.setProductiveRadio(controller.getApplicationById());
                //applicationForm.setNonProductiveRadio();
                break;

        }

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String action = evt.getActionCommand();
        switch (action){
            case Constants.UPDATE_APP:

                break;
            case Constants.CANCEL_APP:
                applicationForm.dispose();
                break;
        }
    }
}
