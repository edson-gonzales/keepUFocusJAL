package View.AdminUser;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Initialize the data of the table and define the Columns
 *
 * @author Lourdes Villca
 */
class UserTableModel extends AbstractTableModel {
    private final String[] columnNames = {"First Name",
            "Last Name",
            "Age",
            "Address",
            "Edit",
            "Delete"};

    ImageIcon edit = new ImageIcon(getClass().getResource("../../Resources/images/edit.jpg"));
    ImageIcon delete = new ImageIcon(getClass().getResource("../../Resources/images/delete.png"));

    private final Object[][] data = {
            {"Kathy", "Smith", 17, "Address 1", edit, delete},
            {"John", "Doe", 21, "Rowing", edit, delete},
            {"Sue", "Black", 43, "Knitting", edit, delete},
            {"Jane", "White", 24, "Speed reading", edit, delete},
            {"Joe", "Brown", 42, "Pool", edit, delete}
    };

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
