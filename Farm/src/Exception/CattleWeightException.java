package Exception;

public class CattleWeightException extends Exception {
    private final float value;
    public CattleWeightException(final float value)
    {

        super("Value isn't able to be negative");
        this.value = value;
    }
    private float GetEnteredValue()
    {
        return this.value;
    }
    public String GetInfo()
    {
        return super.getMessage() + " You entered " + GetEnteredValue();
    }

}
