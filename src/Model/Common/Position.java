package Model.Common;

/**
 * Created by AldoBalderrama on 7/7/2016.
 */
public class Position
{
    //Attribute
    private int positionId;
    private String positionName;
    private boolean enable;

    //Property
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    //Constructor
    public Position()
    {
        this.setPositionId(0);
        this.setPositionName("");
        this.setEnable(false);
    }

    //Methods
    public boolean save()
    {
        System.out.printf("method will implements");
        return true;
    }
    public boolean update()
    {
        System.out.printf("method will implements");
        return true;
    }
    public boolean delete()
    {
        System.out.printf("method will implements");
        return true;
    }
    public  static Position getPosition(int positionId)
    {
        Position position = new Position();
        position.setPositionId(positionId);
        return position;
    }
}
