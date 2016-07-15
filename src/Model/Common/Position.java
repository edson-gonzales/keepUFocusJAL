package Model.Common;

import Model.Conection.Connection;

/**
 * This class contains the information of every position, save, update and delete a position of dbKeepUFocus.sqlite data base
 * @autor: JuanaRodriguez
 */
public class Position {

    private int positionId;
    private String positionName;
    private Connection db;

    /**
     * Give back the Id from position
     * @return positionId
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Modify the Id of the  position
     * @param positionId
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Give back the position name
     * @return positionName
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * Modify the Name from position
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * Construct by default
     */
    public Position() {
        this.setPositionId(0);
        this.setPositionName("");
        db = new Connection();
    }

    /**
     * This method save a position in the dbKeepUFocus.sqlite database
     * @return: the sql query.
     */
    public boolean save() {

        StringBuilder sql = new StringBuilder();
        sql.append("insert into Position(positionName)");
        sql.append(String.format("Values('%s')", this.getPositionName()));
        return db.execute(sql.toString());
    }

    /**
     *
     * @return
     */
    public boolean update() {
        System.out.printf("method will implements");
        return true;
    }

    public boolean delete() {
        System.out.printf("method will implements");
        return true;
    }
}
