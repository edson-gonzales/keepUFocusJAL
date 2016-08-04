package View.config.Application;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;


/**
 * This class display the Application List
 *
 * @author Lourdes Villca
 */
public class ApplicationTable extends JPanel {
    public JTable applicationTable;

    /**
     * Initialize the table that contain the Application list
     */
    public ApplicationTable() {
        super(new GridLayout(1, 0));

        applicationTable = new JTable(new ApplicationTableModel());
        applicationTable.setPreferredScrollableViewportSize(new Dimension(800, 70));
        applicationTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(applicationTable);
        add(scrollPane);
    }

}

