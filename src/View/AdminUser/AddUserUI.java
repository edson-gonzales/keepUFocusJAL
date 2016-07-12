package View.AdminUser;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.Component;

import Utilities.SpringUtilities;
import View.Events.UserEvent;

/**
 * UI to Add User, Form with the fields of user
 * @author: Lourdes Villca
 */

public class AddUserUI extends JPanel {
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel activeLabel;
    private JLabel addressLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JLabel possitionLabel;
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JTextField userTxt;
    private JTextField passwordTxt;
    private JCheckBox activeCbox;
    private JTextField addressTxt;
    private JTextField emailTxt;
    private JComboBox roleCbox;
    private JComboBox possitionCbox;
    private JButton acceptBtn;
    private JButton cancelBtn;
    private UserEvent userEvent;
    private JPanel leftPanel;
    private JPanel rightPanel;

    public AddUserUI(){

        leftPanel = makeLeftPanel();
        rightPanel = makeRightPanel();
        acceptBtn = new JButton("Accept");
        cancelBtn = new JButton("Cancel");
        this.setLayout(new BorderLayout());

        acceptBtn.addActionListener(new UserEvent(this));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        bottomPanel.add(acceptBtn);
        bottomPanel.add(cancelBtn);

        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.PAGE_END);

        this.setBorder(BorderFactory.createTitledBorder("Add New User"));
    }
    /**
     * Method to build the left panel with the corresponding data
     * @return return a panel with all their components
     */
    private JPanel makeLeftPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(nameLabel, "Name", panel);
        InitComponent.initTextBox(nameTxt, txtSize, panel);

        InitComponent.initLabel(lastNameLabel, "Last Name", panel);
        InitComponent.initTextBox(lastNameTxt, txtSize, panel);

        InitComponent.initLabel(userLabel, "User", panel);
        InitComponent.initTextBox(userTxt, txtSize, panel);

        InitComponent.initLabel(passwordLabel, "Password", panel);
        InitComponent.initTextBox(passwordTxt, txtSize, panel);
        InitComponent.initLabel(activeLabel, "Active", panel);

        activeCbox = new JCheckBox();
        panel.add(activeCbox);

        InitComponent.setSizeComponent(panel, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6); /* rows, cols, initX, initY, xPad, yPad*/

        return panel;
    }
    /**
     * Method to build the right panel with the corresponding data
     * @return return a panel with all their components
     */
    private JPanel makeRightPanel()
    {
        JPanel rightPanel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);
        InitComponent.initLabel(addressLabel, "Address", rightPanel);
        InitComponent.initTextBox(addressTxt, txtSize, rightPanel);

        InitComponent.initLabel(emailLabel, "E-mail", rightPanel);
        InitComponent.initTextBox(emailTxt, txtSize, rightPanel);

        InitComponent.initLabel(possitionLabel, "Possition", rightPanel);
        InitComponent.initComboBox(possitionCbox, txtSize, rightPanel);

        InitComponent.initLabel(roleLabel, "Role", rightPanel);
        InitComponent.initComboBox(roleCbox, txtSize, rightPanel);

        InitComponent.setSizeComponent(rightPanel, new Dimension(310, 50));
        SpringUtilities.makeCompactGrid(rightPanel,4,2,6,6,6,6); /* rows, cols, initX, initY, xPad, yPad*/

        return rightPanel;
    }

    public String getName(){
        return nameTxt.getText();
    }
    public String getLastName(){
        return lastNameTxt.getText();
    }
    public String getUserName(){
        return userTxt.getText();
    }
    public String getPassword(){
        return passwordTxt.getText();
    }
    public boolean getStatus(){ return activeCbox.isSelected();}
    public String getAddress(){
        return addressTxt.getText();
    }
    public String getEmail(){
        return emailTxt.getText();
    }
    public String getRole(){
        return roleCbox.getSelectedItem().toString();
    }
    public String getPossition(){
        return possitionCbox.getSelectedItem().toString();
    }

}
