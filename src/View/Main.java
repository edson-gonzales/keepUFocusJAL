package View;

import View.AdminUser.MenuBar;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.ImageIcon;

/**
 * Main class to create the window
 *
 * @author Lourdes Villca
 */
public class Main extends JFrame {
    private MenuBar mainMenuBar;
    private static Main main;

    /**
     * Initialize the Window, and the menu bar
     */
    private Main() {
        super(" KEEP Up FOCUS");
        Container pane = getContentPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("../Resources/images/iconKUF.png"));
        setIconImage(icon.getImage());
        mainMenuBar = new MenuBar(this);
        this.setJMenuBar(mainMenuBar);

        setSize(800, 700);
        setVisible(true);
    }

    public static void reset(){
        main = new Main();
    }

    public static Main getMain() {
        if (main == null) {
            main = new Main();
        }

        return main;
    }

}