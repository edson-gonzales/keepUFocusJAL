package Model.Conection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 7/7/2016.
 */
public class Connection
{
    String url = "C:\\Users\\ALDO\\Documents\\Fundacion-Jala\\PROG-102\\keepUFocusJAL\\dataBase\\dbFocusUTime.sqlite";
    public java.sql.Connection connectDataBase;

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

    //Method
    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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
