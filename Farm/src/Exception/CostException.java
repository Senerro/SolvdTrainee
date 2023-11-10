package Exception;

public class CostException extends Exception {
    private final float cost;
    public CostException(String message, float cost)
    {
        super(message);
        this.cost = cost;
    }
    public float EnteredCost()
    {
        return this.cost;
    }
}
