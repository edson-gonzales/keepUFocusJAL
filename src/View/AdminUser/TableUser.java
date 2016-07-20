package View.AdminUser;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 * This class show the users list
 *
 * @author Lourdes Villca
 */
public class TableUser extends JPanel {

    public TableUser() {
        super(new GridLayout(1, 0));

        final JPanel panel = this;
        final JTable table = new JTable(new UserTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());

                if (col == 4) {
                    JDialog editUser = new JDialog();
                    editUser.setSize(700, 400);
                    AddUserUI userForm = new AddUserUI();
                    editUser.add(userForm);
                    editUser.setVisible(true);

                } else if (col == 5) {
                    int res = JOptionPane.showConfirmDialog(panel, "Do you want to delete this user?");

                    if(res == JOptionPane.YES_OPTION) {
                        System.out.println("delete row: " + row);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

}