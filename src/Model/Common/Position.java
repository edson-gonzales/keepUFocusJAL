package Model.Common;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class manages the position of the database
 *
 * @autor: JuanaRodriguez
 */

public class Position {
    private int positionId;
    private String positionName;
    private DataAccess dbAccess;


    /**
     * The method return the Id of the position
     *
     * @return positionId, this variable is an integer value
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * The method set the id of the position
     *
     * @param positionId will be set in the position
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * The method return the Name of the position
     *
     * @return positionName, this variable is a string value
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * The method set the name of the position
     *
     * @param positionName will be set in the position
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * The method build a Position object
     */
    public Position() {
        this.setPositionId(0);
        this.setPositionName("");
        this.dbAccess = new DataAccess();
    }

    /**
     * The method build a Position object
     * @param positionName
     */
    public Position(String positionName) {
        this.setPositionId(0);
        this.setPositionName(positionName);
        this.dbAccess = new DataAccess();
    }

    /**
     * The method insert a position in the database, catch the id from the position inserted in the "result" variable
     *
     * @return the saved flag that help us to check if the position was inserted, this  flag return true if the
     * position was inserted and false if the position wasn't inserted.
     */
    public boolean save() {
        boolean res = false;
        ResultSet result = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Position (positionName) ");
            sql.append(String.format("Values('%s')", this.getPositionName()));
            result = this.dbAccess.save(sql.toString());
            if (result.next()) {
                this.setPositionId(result.getInt(1));
                res = true;
            } else {
                throw new SQLException("There is an error, It was not possible to insert the Position");
            }
            result.close();
            this.dbAccess.closeConnection();
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return res;
    }

    /**
     * The method updates a position and give back true through of updated variable if the date was modify successfully
     * using the method update from DataAccess class.
     *
     * @return updated true if the date was modify successfully and false if it wasn't modify
     */
    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Position set ");
        sql.append(String.format("positionName = '%s' ", this.getPositionName()));
        sql.append(String.format("where positionId = %s", this.positionId));
        updated = this.dbAccess.update(sql.toString());
        this.dbAccess.closeConnection();
        return updated;
    }

    /**
     * The method delete a position and give back true through of deleted variable if the date was delete successfully
     * using the method deleted from DataAccess class.
     *
     * @return deleted true if the date was deleted successfully
     */
    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Position ");
        sql.append(String.format("where positionId = %s", this.positionId));
        deleted = dbAccess.delete(sql.toString());
        dbAccess.closeConnection();
        return deleted;
    }
}
