package View.Events;

import View.AdminUser.AddUserUI;
import View.AdminUser.SearchUserUI;
import View.config.ConfigureFocusTime;
import sun.tools.jar.Main;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manage Events for Menu Bar options
 * @author Lourdes Villca
 */
public class MenuEvents implements ActionListener {
    private JFrame mainWindow;

    public MenuEvents(JFrame mainWindow){
        this.mainWindow = mainWindow;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int action = Integer.parseInt(e.getActionCommand());
        switch(action) {
            case 1: // User menu
                SearchUserUI searchUser = new SearchUserUI();
                mainWindow.getContentPane().add(searchUser, BorderLayout.CENTER);
                mainWindow.setSize(mainWindow.getWidth() + 1, mainWindow.getHeight() + 1);
                mainWindow.setSize(mainWindow.getWidth() - 1, mainWindow.getHeight() - 1);
                break;
            case 2: // Focus time configuration
                System.out.println("Focus config");
                ConfigureFocusTime configFocusTime = new ConfigureFocusTime();
                mainWindow.getContentPane().add(configFocusTime, BorderLayout.CENTER);
                mainWindow.setSize(mainWindow.getWidth() + 1, mainWindow.getHeight() + 1);
                mainWindow.setSize(mainWindow.getWidth() - 1, mainWindow.getHeight() - 1);

                break;
            case 3: // Application config
                System.out.println("Aplication config");
                break;

        }

    }
}
