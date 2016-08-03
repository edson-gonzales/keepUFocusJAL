package View.Report;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import View.Report.ApplicationFocusTime;

/**
 * Initialize the data of the Activity table and define the columns
 *
 * @author Lourdes Villca
 */
class ActivityTableModel extends AbstractTableModel {
    private final String[] columnNames = {"%", "Time", "Activity"};
    private ApplicationFocusTime applicationFocusTime;
    private Object [][] data;

    /**
     * Initialize the Table with its content
     */
    public ActivityTableModel() {

        fillData();
    }

    /**
     * This method fill the table with the tracked Application List
     */
    public void fillData(){
        applicationFocusTime = new ApplicationFocusTime();
        ArrayList<ApplicationFocusTime> appFocusTimeList = applicationFocusTime.getTrackedApplication("2016-08-02", "2016-08-02");
        data = new Object[appFocusTimeList.size()][3];
        int i = 0;
        for(ApplicationFocusTime app: appFocusTimeList){
           data[i][0] = app.getApplication().getApplicationId();
           data[i][1]= app.getTotalTime();
           data[i][2]= app.getApplication().getApplicationName();
           i++;
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
