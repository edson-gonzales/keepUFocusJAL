package View.Report;

import javax.swing.table.AbstractTableModel;

/**
 * Initialize the data of the Activity table and define the columns
 *
 * @author Lourdes Villca
 */
class ActivityTableModel extends AbstractTableModel {
    private final String[] columnNames ={"%","Time", "Activity"};
    private final Object [][] data = {
            {"50%", "1h 30 m","Idea"},
            {"10%", "30 m","Facebook"},
            {"5%", "1h 30 m","Java2s.com"}
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
