package View.config.Application;

import Controller.Applications.ApplicationControllers;
import Controller.UserAdmin.UserControllers;
import Model.Applications.Application;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Initialize the data of the Application table and define the Columns
 *
 * @author Lourdes Villca
 */
class ApplicationTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Application",
            "Productive",
            "Non Productive",
            "edit"
    };
    private Object[][] data;
    private ImageIcon edit;

    public ApplicationTableModel() {
        edit = new ImageIcon(getClass().getResource("../../../Resources/images/edit.jpg"));
        setApplicationData();
    }

    /**
     * Initialize the Application List with data from the database
     */
    public void setApplicationData(){
        List<Application> appList = new ArrayList<Application>();
        ApplicationControllers controller = new ApplicationControllers();
        appList = controller.getListApplication();
        data = new Object[appList.size()][5];

        for (int i = 0; i < appList.size(); i++) {
            data[i][0] = appList.get(i);
            data[i][1] = appList.get(i).getCategoryId() == 2;
            data[i][2] = appList.get(i).getCategoryId() == 3;
            data[i][3] = edit;
        }
    }
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
