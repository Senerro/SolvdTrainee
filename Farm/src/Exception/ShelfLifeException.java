package Exception;

public class ShelfLifeException extends Exception
{
    private final float shelfLife;
    public ShelfLifeException(String message, float seedingArea)
    {
        super(message);
        this.shelfLife = seedingArea;
    }
    public float EnteredShelfLife()
    {
        return this.shelfLife;
    }
}
