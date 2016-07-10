package View.AdminUser;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LuLy on 06/07/2016.
 */
public class MenuBar extends JMenuBar {
    private JMenu menu;
    private JMenuItem menuContent;

    public MenuBar(final JFrame mainWindow)
    {
        menu = new JMenu("Administration");
        this.add(menu);
        menuContent = new JMenuItem("New User");
        menu.add(menuContent);
        menuContent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                AddUserUI addNewUser = new AddUserUI();
                mainWindow.getContentPane().add(addNewUser, BorderLayout.CENTER);
                mainWindow.setSize(mainWindow.getWidth()+1,mainWindow.getHeight()+1);
                mainWindow.setSize(mainWindow.getWidth()-1,mainWindow.getHeight()-1);

            }
        });
    }

}
