package View.Events;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.UserAdmin.UserControllers;
import View.FocusTime.FocusTime;
import Utils.Constants;
import View.Login.Login;
import View.Login.Session;

/**
 * Created by Administrator on 8/4/2016.
 */
public class LoginEvent implements ActionListener {
    private JFrame loginWindow;

    public LoginEvent(JFrame loginWindow) {
        this.loginWindow = loginWindow;

    }

    /**
     * This method is invoked when an action occurs inside the Login page
     *
     * @param e action event that gives information about the event and its source
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case Constants.LOGIN:
                UserControllers controller = new UserControllers();
                if (controller.userExist(((Login) loginWindow).getUserTxt(), ((Login) loginWindow).getPasswordTxt()) != null) {
                    System.out.println("usuario existe");
                    Session.setUser(controller.userExist(((Login) loginWindow).getUserTxt(), ((Login) loginWindow).getPasswordTxt()));
                    FocusTime focusTime = new FocusTime();
                    loginWindow.dispose();

                } else {
                    ((Login) loginWindow).showMessage();
                    System.out.println("no existe");
                }

                break;
            case Constants.CANCEL:
                loginWindow.dispose();
                break;
        }

    }
}
