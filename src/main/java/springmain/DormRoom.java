package springmain;

public class DormRoom
{
    private int number;
    private String building;

    public DormRoom(int number, String building)
    {
        this.number = number;
        this.building = building;
    }

    public String getLocation()
    {
        return "Dorm #" + number + " in " + building;
    }
}
