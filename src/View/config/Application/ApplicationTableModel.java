package View.config.Application;

import javax.swing.table.AbstractTableModel;

/**
 * Initialize the data of the Application table and define the Columns
 *
 * @author Lourdes Villca
 */
class ApplicationTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Application",
            "Productive",
            "Non Productive"
    };

    private final Object[][] data = {
            {"app1", false, false},
            {"app2", false, true},
            {"app3", false, true},
            {"app4", true, false},
            {"app5", false, true}
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
     * Returns the number of rows in the application model
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
        return true;
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
