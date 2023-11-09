package Exception;

public class CattleAgeException extends Exception
{
    private final int age;
    public CattleAgeException(final int age)
    {
        super("Age isn't able to be negative or unnatural");
        this.age = age;
    }
    private float GetEnteredValue()
    {
        return this.age;
    }
    public String GetInfo()
    {
        return super.getMessage() + ". You entered " + GetEnteredValue();
    }
}
