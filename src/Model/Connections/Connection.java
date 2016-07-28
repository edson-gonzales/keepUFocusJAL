package Model.Connections;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class does the connection to the dbKeepUFocus.sqlite data base
 *
 * @autor JuanaRodriguez
 */

public class Connection {
    String url = "database\\f.sqlite";
    public java.sql.Connection connectDataBase;

    /**
     * This method connect to the dbFocusUTime.sqlite database and use a try-catch for get the exceptions
     *
     * @return true if the connection was successful
     */
    public boolean connect() {
        try {
            connectDataBase = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connectDataBase != null) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Error connect \n" + ex.getMessage());
        }
        return false;
    }

    /**
     * This method close the connection to dbFocusUTime.sqlite database.
     */
    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
