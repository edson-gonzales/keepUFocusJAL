package View.AdminUser;

import javax.swing.*;
import java.awt.*;
import View.Events.UserEvent;
import Utilities.SpringUtilities;


/**
 * Created by LuLy on 06/07/2016.
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

    private JPanel makeLeftPanel(){
        JPanel panel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);

        initLabel(nameLabel, "Name", panel);
        initTextBox(nameTxt, txtSize, panel);

        initLabel(lastNameLabel, "Last Name", panel);
        initTextBox(lastNameTxt, txtSize, panel);

        initLabel(userLabel, "User", panel);
        initTextBox(userTxt, txtSize, panel);

        initLabel(passwordLabel, "Password", panel);
        initTextBox(passwordTxt, txtSize, panel);
        initLabel(activeLabel, "Active", panel);

        activeCbox = new JCheckBox();

        panel.setMaximumSize(new Dimension(310, 50));
        panel.setPreferredSize(new Dimension(310, 50));
        panel.setMinimumSize(new Dimension(310, 50));

        panel.add(activeCbox);

        SpringUtilities.makeCompactGrid(panel,
                5, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        return panel;
    }

    private JPanel makeRightPanel()
    {
        JPanel rightPanel = new JPanel(new SpringLayout());
        Dimension txtSize = new Dimension(150, 25);
        initLabel(addressLabel, "Address", rightPanel);
        initTextBox(addressTxt, txtSize, rightPanel);

        initLabel(emailLabel, "E-mail", rightPanel);
        initTextBox(emailTxt, txtSize, rightPanel);

        initLabel(possitionLabel, "Possition", rightPanel);
        initComboBox(possitionCbox, txtSize, rightPanel);

        initLabel(roleLabel, "Role", rightPanel);
        initComboBox(roleCbox, txtSize, rightPanel);


        rightPanel.setMaximumSize(new Dimension(300, 50));
        rightPanel.setPreferredSize(new Dimension(300, 50));
        rightPanel.setMinimumSize(new Dimension(300, 50));

        SpringUtilities.makeCompactGrid(rightPanel,4,2,6,6,6,6);

        return rightPanel;
    }

    private void setSizeComponent(Component comp, Dimension txtSize) {
        comp.setMaximumSize(txtSize);
        comp.setPreferredSize(txtSize);
        comp.setMinimumSize(txtSize);
    }
    public void initLabel(JLabel jlabel, String text, JPanel panel){
        jlabel=new JLabel(text);
        panel.add(jlabel);
    }

    public void initTextBox(JTextField textField,Dimension txtSize, JPanel rightPanel){
        textField = new JTextField(20);
        setSizeComponent(textField, txtSize);
        rightPanel.add(textField);

    }
    public void initComboBox(JComboBox comboBox, Dimension cboxSize, JPanel rightPanel){
        comboBox = new JComboBox();
        setSizeComponent(comboBox, cboxSize);
        rightPanel.add(comboBox);

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
