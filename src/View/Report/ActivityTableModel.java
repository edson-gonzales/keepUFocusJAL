package View.Report;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import Utils.FocusTimeUtils;

/**
 * Initialize the data of the Activity table and define the columns
 *
 * @author Lourdes Villca
 */
class ActivityTableModel extends AbstractTableModel {
    private final String[] columnNames = {"%", "Time", "Activity"};
    private ApplicationFocusTime applicationFocusTime;
    private FocusTimeUtils utils;
    private Object[][] data;

    /**
     * Initialize the Table with its content
     * @param startDate start date to Fill the DataSet
     * @param endDate end date to fill the DataSet
     */
    public ActivityTableModel(String startDate, String endDate) {
        utils = new FocusTimeUtils();
        fillData(startDate,endDate);
    }

    /**
     * This method fill the table with the tracked Application List
     * @param startDate start date to build the query
     * @param endDate end date to build the query
     */
    public void fillData(String startDate, String endDate) {
        applicationFocusTime = new ApplicationFocusTime();
        ArrayList<ApplicationFocusTime> appFocusTimeList = applicationFocusTime.getTrackedApplication(startDate, endDate);
        data = new Object[appFocusTimeList.size()][3];
        for (int i = 0; i < appFocusTimeList.size();i++) {
            data[i][0] = appFocusTimeList.get(i).getPercentaje();
            data[i][1] = utils.convertTime(appFocusTimeList.get(i).getTotalTime());
            data[i][2] = appFocusTimeList.get(i).getApplication().getApplicationName();

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
     * Returns the number of rows in the activity model
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
