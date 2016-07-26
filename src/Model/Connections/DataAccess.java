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

    public void closeConnection() {
        try {
            statement.close();
            connection.closeDataBase();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
