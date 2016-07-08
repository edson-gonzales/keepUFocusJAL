package Model.AdminUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ModelUser extends Model.Conection.Conection{

    public boolean InsertPerson(String id, String firstname, String lastname, String email, String status)
    {
        //armamos la consulta
        String insert = "Insert into person(id, firstname, lastname, email, status)" + "Values('" + id + "', '" + firstname + "', '" + lastname + "', '" + email + "', '" + status + "')";
        //ejecutamos la consulta
        try {
            PreparedStatement ps = connectDataBase.prepareStatement(insert);
            ps.execute();
            ps.close();
            return true;
        }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return false;
    }
}
