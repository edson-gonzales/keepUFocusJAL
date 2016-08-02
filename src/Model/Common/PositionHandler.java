package Model.Common;

import Model.Connections.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class PositionHandler, it handles of the Position class
 *
 * @autor: JuanaRodriguez
 */
public class PositionHandler {
    /**
     * The method get a specific position given an Id
     *
     * @param idPosition the id of the position to get a specific position
     * @return the Position object
     */
    public static Position getPositionById(int idPosition) {
        Position position = null;
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        try {
            StringBuilder sql = new StringBuilder("Select * from Position ");
            sql.append(String.format("where positionId = %s;", idPosition));
            result = dbAccess.getDataById(sql.toString());
            if (result.next()) {
                position = new Position();
                position.setPositionId(result.getInt(1));
                position.setPositionName(result.getString(2));
            }
            result.close();
            dbAccess.closeConnection();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return position;
    }

    /**
     * The method return the position objects and set in an ArrayList
     *
     * @return positions return a set positions
     */
    public static ArrayList<Position> getListPosition() {
        ArrayList<Position> positions = new ArrayList<Position>();
        ResultSet result = null;
        DataAccess dbAccess = new DataAccess();
        StringBuilder sql = new StringBuilder("Select * from position");
        try {
            result = dbAccess.select(sql.toString());
            while (result.next()) {
                Position position = new Position();
                position.setPositionId(result.getInt(1));
                position.setPositionName(result.getString(2));
                positions.add(position);
            }
            result.close();
            dbAccess.closeConnection();

        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return positions;
    }
}
