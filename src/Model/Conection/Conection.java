package Model.Conection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 7/7/2016.
 */
public class Conection {
    // asigno a una variable la direccion de mi bd
    String url = "D:\\Afundacion\\KeepUFocus\\focus.sqlite";
    //es un componente del JDCB, esta la coenxion con la bd
    public java.sql.Connection connectDataBase;
    //metodo para conectar la bd
    public void connectDataBase(){
        //Drive manager este método establece una conexión con la base de datos
        try {
            connectDataBase = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connectDataBase!=null) {
                System.out.println("Conectadooooo");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }

    //metodo para cerrar la bd
    public void closeDataBase() {
        try {
            connectDataBase.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
