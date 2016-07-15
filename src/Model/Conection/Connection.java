package Model.Conection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class does the connection to the dbKeepUFocus.sqlite data base
 * @autor JuanaRodriguez
 */
public class Connection
{

    String url = "dataBase\\dbFocusUTime.sqlite";
    public java.sql.Connection connectDataBase;

    /**
     * This method connect to the dbFocusUTime.sqlite database and use a try-catch for get the exceptions
     */
    public void connect()
    {
        try {
            connectDataBase = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connectDataBase!=null) {
                System.out.println("Connect ok");
            }
        }catch (SQLException ex) {
            System.err.println("Error connect \n"+ex.getMessage());
        }
    }

     /**
     * This method close the connection to dbFocusUTime.sqlite database
     */
    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method receives a string containing a sql query to execute and get back a boolean value (false) if isn't successfully
     * @param sql
     * @return
     */
    public boolean execute(String sql)
    {
        try {
            connect();
            PreparedStatement ps = connectDataBase.prepareStatement(sql);
            ps.execute();
            ps.close();
            return true;
        }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return false;
    }
}
