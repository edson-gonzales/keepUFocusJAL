package Model.Common;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class contains the information of every position, save, update and delete a position of dbKeepUFocus.sqlite data base
 *
 * @autor: JuanaRodriguez
 */

public class Position {
    private int positionId;
    private String positionName;
    private DataAccess dbAccess;
    private boolean enable;

    /**
     * Construct by default
     */
    public Position() {
        this.setPositionId(0);
        this.setPositionName("");
        this.setEnable(false);
        this.dbAccess = new DataAccess();
    }

    /**
     * Give back the Id from position
     *
     * @return positionId
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Modify the Id of the  position
     *
     * @param positionId
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Give back the position name
     *
     * @return positionName
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * Modify the Name from position
     *
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public ArrayList<Position> getListPosition() {
        ArrayList<Position> positions = new ArrayList<Position>();
        ResultSet result = null;
        StringBuilder sql = new StringBuilder("Select * from position");
        try {
            result = this.dbAccess.select(sql.toString());
            while (result.next()) {
                Position position = new Position();
                position.setPositionId(result.getInt(1));
                position.setPositionName(result.getString(2));
                positions.add(position);
            }
            result.close();
            this.dbAccess.closeConnection();

        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return positions;
    }

    /**
     * This method save a position in the dbKeepUFocus.sqlite database
     *
     * @return
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

    public Position getPositionById(int idPosition) {
        Position position = null;
        ResultSet result = null;

        try {
            StringBuilder sql = new StringBuilder("Select * from Position ");
            sql.append(String.format("where positionId = %s;", idPosition));
            result = this.dbAccess.getDataById(sql.toString());

            if (result.next()) {
                position = new Position();
                position.setPositionId(result.getInt(1));
                position.setPositionName(result.getString(2));
            }

            result.close();
            this.dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        return position;
    }

    public boolean update() {
        boolean updated = false;
        StringBuilder sql = new StringBuilder("update Position set ");
        sql.append(String.format("positionName = '%s' ", this.getPositionName()));
        sql.append(String.format("where positionId = %s", this.positionId));

        updated = this.dbAccess.update(sql.toString());
        this.dbAccess.closeConnection();

        return updated;
    }

    public boolean delete() {
        boolean deleted = false;
        StringBuilder sql = new StringBuilder("delete from Position ");
        sql.append(String.format("where positionId = %s", this.positionId));
        deleted = this.dbAccess.delete(sql.toString());
        this.dbAccess.closeConnection();
        return deleted;
    }

    public static Position getPosition(int positionId) {
        Position position = new Position();
        return position.getPositionById(positionId);
    }
}
