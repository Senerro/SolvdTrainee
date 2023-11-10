package Exception;

public class NameFarmingException extends Exception
{
    private final String name;
    public NameFarmingException()
    {
        super("Name can not be empty");
        this.name = "unknown";
    }
    public String Name()
    {
        return this.name;
    }
    public String GetInfo()
    {
        return super.getMessage() + " You entered empty name. Now it was given an " + Name() + " name";
    }
}
