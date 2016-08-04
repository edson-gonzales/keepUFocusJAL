package View.Report;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class display the Activity List
 *
 * @author Lourdes Villca
 */
public class TableActivity extends JPanel {
    public JTable tableActivity;

    /**
     * Initialize the table that contain the Activity list
     *
     * @param startDate start date to build the table
     * @param endDate   end date to build the table
     */
    public TableActivity(String startDate, String endDate) {
        super(new GridLayout(1, 0));

        tableActivity = new JTable(new ActivityTableModel(startDate, endDate));
        tableActivity.setPreferredScrollableViewportSize(new Dimension(800, 70));
        tableActivity.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tableActivity);
        add(scrollPane);
    }

}
