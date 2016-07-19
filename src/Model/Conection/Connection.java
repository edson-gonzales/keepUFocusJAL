package Model.Conection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 7/7/2016.
 */
public class Connection {
    //String url = "\\\\172.20.0.16\\mt01at01\\AT01\\Database\\dbFocusUTime.sqlite";
    String url = "dataBase\\dbFocusUTime.sqlite";
    public java.sql.Connection connectDataBase;

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

    //Method
    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean execute(String sql) {
        try {
            connect();
            PreparedStatement ps = connectDataBase.prepareStatement(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}