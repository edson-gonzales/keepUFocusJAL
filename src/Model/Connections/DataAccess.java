package Model.Connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AldoBalderrama on 7/25/2016.
 */
public class DataAccess {
    private Connection connection;
    private PreparedStatement statement;
    public ResultSet result;

    public DataAccess() {
        connection = new Connection();
    }

    /**
     * The method gives a set of objects of the database
     *
     * @param sql
     * @return result, return the ResultSet
     */
    public ResultSet select(String sql) {
        ResultSet result = null;
        try {
            connection.connect();
            statement = connection.connectDataBase.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return result;
    }

    /**
     * The method gives a set of results of the query
     *
     * @param sql, gets a query
     * @return result, return the ResultSet
     */
    public ResultSet getDataById(String sql) {
        ResultSet result = null;
        try {
            connection.connect();
            statement = connection.connectDataBase.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return result;
    }

    /**
     * The method return the inserted object
     *
     * @param sql, gets a query
     * @return result, return the ResultSet
     */
    public ResultSet save(String sql) {
        ResultSet result = null;
        try {
            connection.connect();
            statement = connection.connectDataBase.prepareStatement(sql);
            statement.executeUpdate();
            statement = connection.connectDataBase.prepareStatement("select last_insert_rowid();");
            result = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return result;
    }

    /**
     * The method return a boolean value given a query, true if the execute query was successfully
     *
     * @param sql, gets a query
     * @return deleted, return true if the execute query was successfully and false if it wasn't
     */
    public boolean delete(String sql) {
        boolean deleted = false;
        try {
            connection.connect();
            statement = connection.connectDataBase.prepareStatement(sql);
            deleted = (statement.executeUpdate() > 0);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return deleted;
    }

    /**
     * The method return a boolean value given a query, true if the execute query was successfully
     *
     * @param sql, gets a query
     * @return updated, return true if the execute query was successfully and false if it wasn't
     */
    public boolean update(String sql) {
        boolean updated = false;
        try {
            connection.connect();
            statement = connection.connectDataBase.prepareStatement(sql);
            if (statement.executeUpdate() > 0) {
                updated = true;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return updated;
    }

    /**
     * The method close the connection to the database
     */
    public void closeConnection() {
        try {
            statement.close();
            connection.closeDataBase();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
