package View;

import View.AdminUser.MenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * View.Main class to create the window
 *
 * @author Lourdes Villca
 */
public class Main extends JFrame {
    private MenuBar mainMenuBar;

    /**
     * Initialize the Window, and the menu bar
     */
    public Main() {
        super("KEEP U FOCUS");
        Container pane = getContentPane();

        mainMenuBar = new MenuBar(this);
        this.setJMenuBar(mainMenuBar);

        setSize(800, 700);
        setVisible(true);
    }

    /**
     * Create the principal class
     *
     * @param arg arguments
     */
    public static void main(String arg[]) {
        Main principal = new Main();
    }
}