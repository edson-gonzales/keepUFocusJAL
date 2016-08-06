package View.Login;

import Utils.Constants;
import View.AdminUser.InitComponent;
import View.Events.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Lourdes Villca
 */
public class Login extends JFrame {
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTxt;
    private JTextField passwordTxt;
    private JButton loginButton;
    private JButton cancelButton;
    private ResourceBundle resource;

    public Login(){
        super("KEEP U FOCUS");
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        Container pane = getContentPane();
        pane.add(buildComponents());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 150);
        setVisible(true);
    }
    public JPanel buildComponents(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        userLabel = new JLabel(resource.getString("login.label.user"));
        userTxt = InitComponent.initTextBox(userTxt,new Dimension(50,25),loginPanel);
        passwordLabel = new JLabel(resource.getString("login.label.password"));

        passwordTxt = InitComponent.initTextBox(passwordTxt, new Dimension(50, 25), loginPanel);
        loginButton = InitComponent.initButton(loginButton, resource.getString("login.button.login"), loginPanel);
        cancelButton = InitComponent.initButton(cancelButton, resource.getString("login.button.cancel"), loginPanel);
        LoginEvent loginEvent = new LoginEvent(this);

        loginButton.setActionCommand(Constants.LOGIN);
        loginButton.addActionListener(loginEvent);

        loginPanel.add(userLabel);
        userLabel.setBounds(10, 10, 80, 25);
        userTxt.setBounds(100, 10, 160, 25);
        loginPanel.add(passwordLabel);
        passwordLabel.setBounds(10, 40, 80, 25);
        passwordTxt.setBounds(100, 40, 160, 25);
        loginButton.setBounds(50, 80, 80, 25);
        cancelButton.setBounds(140, 80, 80, 25);

        cancelButton.setActionCommand(Constants.CANCEL);

        cancelButton.addActionListener(loginEvent);
        return loginPanel;
    }
    public static void main(String arg[]) {
        Login login = new Login();
    }
}
