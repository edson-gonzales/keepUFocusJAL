package View.config.Application;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 * Display the chart and the information of the activity
 *
 * @author Lourdes Villca
 */
public class Application extends JPanel {
    /**
     * Init the components and define the layout for panels
     */
    public Application() {
        ApplicationTable applicationTable = new ApplicationTable();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(applicationTable);
    }
}
