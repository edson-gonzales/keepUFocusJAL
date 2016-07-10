import javax.swing.JFrame;
import java.awt.*;
import View.AdminUser.MenuBar;


public class Main extends JFrame{
    private MenuBar mainMenuBar;


    public Main() {

        super("KEEP U FOCUS");
        Container pane = getContentPane();

        mainMenuBar = new MenuBar(this);

        this.setJMenuBar(mainMenuBar);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 700);
        setVisible(true);

    }

    public static void main(String arg[]) {

        Main principal = new Main();
    }
}



