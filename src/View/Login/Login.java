package View.Login;

import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ResourceBundle;
import Utils.Constants;
import Utils.FocusTimeUtils;
import View.AdminUser.InitComponent;
import View.Events.LoginEvent;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;

/**
 * Login page where the user put their credentials to access to the system
 *
 * @author Lourdes Villca
 */
public class Login extends JFrame {
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel errorMessage;
    private JTextField userTxt;
    private JPasswordField passwordTxt;
    private JButton loginButton;
    private JButton cancelButton;
    private ResourceBundle resource;

    /**
     * Initialize the login page
     */
    public Login(){
        super(" KEEP Up FOCUS");
        ImageIcon icon = new ImageIcon(getClass().getResource("../../Resources/images/iconKUF.png"));
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        setIconImage(icon.getImage());
        Container pane = getContentPane();
        pane.add(buildComponents());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 170);
        FocusTimeUtils.centerWindow(this);

        setVisible(true);
    }

    /**
     * Method that build the components that is displayed in the loggin page
     *
     * @return the panel with the components
     */
    public JPanel buildComponents(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        errorMessage = new JLabel("The User name or password are not correct");
        errorMessage.setForeground(Color.red);
        errorMessage.setVisible(false);

        userLabel = new JLabel(resource.getString("login.label.user"));
        userTxt = InitComponent.initTextBox(userTxt, new Dimension(50, 25), loginPanel);
        passwordLabel = new JLabel(resource.getString("login.label.password"));

        passwordTxt = new JPasswordField();
        loginButton = InitComponent.initButton(loginButton, resource.getString("login.button.login"), loginPanel);
        cancelButton = InitComponent.initButton(cancelButton, resource.getString("login.button.cancel"), loginPanel);

        setPositionOfComponents();

        loginButton.setActionCommand(Constants.LOGIN);
        loginButton.addActionListener(new LoginEvent(this));
        loginPanel.add(errorMessage);
        loginPanel.add(userLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTxt);
        cancelButton.setActionCommand(Constants.CANCEL);

        cancelButton.addActionListener(new LoginEvent(this));
        return loginPanel;
    }

    /**
     * Method that set the positions of the components
     */
    public void setPositionOfComponents(){
        errorMessage.setBounds(10,0,250,25);
        userLabel.setBounds(10, 25, 80, 25);
        userTxt.setBounds(100, 25, 160, 25);
        passwordLabel.setBounds(10, 55, 80, 25);
        passwordTxt.setBounds(100, 55, 160, 25);
        loginButton.setBounds(50, 95, 80, 25);
        cancelButton.setBounds(140, 95, 80, 25);
    }

    /**
     * Method that get the Text into the Login field
     *
     * @return the typed user name
     */
    public String getUserTxt() {
        return userTxt.getText();
    }

    /**
     * Method that get the password
     *
     * @return the typed password
     */
    public String getPasswordTxt() {
        return passwordTxt.getText();
    }

    /**
     * Method that display the error message when the credentials of the user are wrong
     */
    public void showMessage(){
        this.errorMessage.setVisible(true);
    }

    public static void main(String arg[]) {
        try
        {
            System.setProperty("user.home","src/Resources/skins");
            UIManager.setLookAndFeel(new SkinLookAndFeel());
        } catch(Exception e){}

        Login login = new Login();
    }
}
