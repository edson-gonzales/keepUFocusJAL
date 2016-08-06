package View.AdminUser;

import Model.UserAdmin.User;
import Utils.Constants;
import View.Events.UserEvent;
import View.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * UI to Add User, Form with the fields of user
 *
 * @author Lourdes Villca
 */

public class AddUserUI extends JDialog {
    private JButton acceptBtn;
    private JButton cancelBtn;
    private UserEvent userEvent;
    private LeftPanelUserUI leftPanel;
    private RightPanelUserUI rightPanel;
    private ResourceBundle resource;
    private JPanel bottomPanel;
    private boolean isEdit;
    private User userEdited;

    /**
     * Init the components and define a layout for panels
     *
     * @param isEdit A boolean to define if the User is to be edited or not
     */
    public AddUserUI(boolean isEdit) {
        super((JFrame) Main.getMain());
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);

        this.isEdit = isEdit;
        leftPanel = new LeftPanelUserUI();
        rightPanel = new RightPanelUserUI();

        this.setLayout(new BorderLayout());
        bottomPanel = buildBottomPanel();
        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.setSize(700, 250);

        setLocationRelativeTo((JFrame) Main.getMain());
    }

    /**
     * Method to build the bottom side of the panel
     *
     * @return the panel with the buttons accept and cancel
     */

    public JPanel buildBottomPanel() {
        JPanel bottomPanel = new JPanel();
        acceptBtn = InitComponent.initButton(acceptBtn, resource.getString("common.label.acceptButton"), bottomPanel);
        cancelBtn = InitComponent.initButton(cancelBtn, resource.getString("common.label.cancelButton"), bottomPanel);

        userEvent = new UserEvent(this);

        acceptBtn.setActionCommand(Constants.SAVE_USER);
        cancelBtn.setActionCommand(Constants.CANCEL_USER);

        acceptBtn.addActionListener(userEvent);

        cancelBtn.addActionListener(userEvent);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        bottomPanel.add(acceptBtn);
        bottomPanel.add(cancelBtn);
        return bottomPanel;
    }

    /**
     * Method that return the left panel
     *
     * @return the left panel
     */
    public LeftPanelUserUI getLeftPanel() {
        return this.leftPanel;
    }

    /**
     * Method that return the right panel
     *
     * @return the right panel
     */
    public RightPanelUserUI getRightPanel() {
        return this.rightPanel;
    }

    /**
     * This method verify if the displayed Dialog is to update or delete the User
     *
     * @return if the dialog is to update this return true
     */
    public boolean isEdit(){ return this.isEdit; }

    /**
     * This Method set the User to be edited
     * @param user to be edited
     */
    public void setUserEdited(User user){
        this.userEdited = user;
    }

    /**
     * This method return the selected user to be edited
     *
     * @return the user edited
     */
    public User getUserEdited(){
        return this.userEdited;
    }
}
