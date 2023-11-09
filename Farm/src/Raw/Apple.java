package Raw;
import Exception.*;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class Apple extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = Logger.getLogger(Apple.class);
    public Apple()
    {
        try{
            this.ShelfLife(45);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.EnteredShelfLife());
        }
        this.DefaultCost(0.9f/6);
        this.Name("Apple");
        ID = 1;
    }
}
