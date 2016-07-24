package View.Events;

import View.AdminUser.AddUserUI;
import View.AdminUser.SearchUserUI;
import sun.tools.jar.Main;

import javax.swing.*;
import java.awt.*;
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
            case 2: // Application config
            case 3: // Focus time configuration

        }

    }
}
