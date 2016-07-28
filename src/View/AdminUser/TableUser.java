package View.AdminUser;

import View.Events.UserEvent;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 * This class show the users list
 *
 * @author Lourdes Villca
 */
public class TableUser extends JPanel {
    public JTable table;

    /**
     * Initialize the table that contain the user list
     */
    public TableUser() {
        super(new GridLayout(1, 0));

        final JPanel panel = this;
        table = new JTable(new UserTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        table.addMouseListener(new UserEvent(this));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

}