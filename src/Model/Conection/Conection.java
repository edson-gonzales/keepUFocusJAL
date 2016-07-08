package Model.Conection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 7/7/2016.
 */
public class Conection {

    String url = "D:\\Afundacion\\KeepUFocus\\focus.sqlite";

    public java.sql.Connection connectDataBase;

    public void connectDataBase(){

        try {
            connectDataBase = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connectDataBase!=null) {
                System.out.println("Connect");
            }
        }catch (SQLException ex) {
            System.err.println("Isn't possible to connect  with the data base.\n"+ex.getMessage());
        }
    }

    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
