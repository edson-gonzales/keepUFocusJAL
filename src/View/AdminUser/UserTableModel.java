package View.AdminUser;

import javax.swing.ImageIcon;
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

    /**
     * Returns the number of columns in the model
     *
     * @return number of columns
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the number of rows in the user model
     *
     * @return the number of rows
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * This method returns the name of the column given a columnIndex.
     *
     * @param col column Index
     * @return the name of the column
     */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * This method returns the value for the cell given a columnIndex and rowIndex.
     *
     * @param row row index
     * @param col column index
     * @return the value for the given cell
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     * This method returns the most specific superclass for all the cell values in the column.
     *
     * @param col Column
     * @return the most specific superclass
     */
    @Override
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    /**
     * This method returns false and this mean that a cell is not editable
     *
     * @param row row index
     * @param col column index
     * @return a boolean that mean a Cell is not editable
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    /**
     * Sets the value in the cell at columnIndex and rowIndex to aValue.
     *
     * @param value data to be put into the table
     * @param row   row index
     * @param col   column index
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
