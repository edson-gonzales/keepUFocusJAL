package View.Events;

import Controller.Applications.ApplicationControllers;
import Model.Applications.Application;
import Utils.Constants;
import View.Main;
import View.config.Application.ApplicationForm;
import View.config.Application.ApplicationTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class to manage Application events
 *
 * @author Lourdes Villca
 */
public class ApplicationEvent extends MouseAdapter implements ActionListener {
    private ApplicationTable appTable;
    private ApplicationForm applicationForm;

    public ApplicationEvent(ApplicationTable appTable) {
        this.appTable = appTable;
    }

    public ApplicationEvent(ApplicationForm applicationForm) {
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
            case Constants.UPDATE_APPLICATION: //update icon
                Application application = (Application) appTable.applicationTable.getModel().getValueAt(row, 0);
                setApplicationInfo(application);

                break;

        }

    }

    /**
     * This method is invoked when an action occurs inside the Application view
     *
     * @param evt action event that gives information about the event and its source
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        String action = evt.getActionCommand();
        switch (action) {
            case Constants.UPDATE_APP:
                getUpdateApplicationForm();
                applicationForm.dispose();
                refreshMainFrame();
                break;
            case Constants.CANCEL_APP:
                applicationForm.dispose();
                break;
        }
    }

    /**
     * Set the Application with the information selected in the component, Check if an application is productive or not
     *
     * @param application object that is setting with data
     */
    public void setApplicationInfo(Application application) {
        applicationForm = new ApplicationForm();
        ApplicationControllers controller = new ApplicationControllers();
        applicationForm.setApplicationNameLabel(controller.getApplicationById(application.getApplicationId()).getApplicationName());
        applicationForm.setProductiveRadio(controller.getApplicationById(application.getApplicationId()).getCategoryId() == Constants.PRODUCTIVE_APP);
        applicationForm.setNonProductiveRadio(controller.getApplicationById(application.getApplicationId()).getCategoryId() == Constants.NONPRODUCTIVE_APP);
        applicationForm.setApplication(application);
    }

    /**
     * Update the Application info, it set the Application category (Productive or Non Productive)
     */
    public void getUpdateApplicationForm() {
        Application application = applicationForm.getApplication();
        ApplicationControllers controller = new ApplicationControllers();
        application.setApplicationId(applicationForm.getApplication().getApplicationId());
        application.setCategoryId(Constants.NOCATEGORY_APP);
        if (applicationForm.getProductiveRadio().isSelected()) {
            application.setCategoryId(Constants.PRODUCTIVE_APP);
        } else if (applicationForm.getNonProductiveRadio().isSelected()) {
            application.setCategoryId(Constants.NONPRODUCTIVE_APP);

        }

        controller.updateApplication(application);
    }

    /**
     * Method to refresh the content of the Application Table
     */
    public void refreshMainFrame() {
        Main.getMain().getContentPane().removeAll();
        ApplicationTable application = new ApplicationTable();

        Main.getMain().getContentPane().add(application, BorderLayout.CENTER);
        Main.getMain().setSize(Main.getMain().getWidth() + 1, Main.getMain().getHeight() + 1);
        Main.getMain().setSize(Main.getMain().getWidth() - 1, Main.getMain().getHeight() - 1);
    }

}
