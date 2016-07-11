package Model.AdminUser;

import Model.Conection.Connection;


public class ModelUser extends Connection
{
    public ModelUser()
    {
        super();
    }
    public boolean InsertPerson()
    {
        String sql = "Insert into Person(firstName,lastName,gender,positionId) Values('pepe','gonzales',0,1)";
        this.execute(sql);
        return true;
    }
}
