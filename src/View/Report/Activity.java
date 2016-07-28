package View.Report;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;


/**
 * Display the chart and the information of the activity
 *
 * @author Lourdes Villca
 */
public class Activity extends JPanel {
    private JLabel periodTime;

    /**
     * Init the components and define the layout for panels
     */
    public Activity() {
        periodTime = new JLabel("Test activity");

        TableActivity tableActivity = new TableActivity();
        BarChart chart = new BarChart();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(periodTime);
        this.add(chart);
        this.add(tableActivity);

    }

}
