package Raw;
import Exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Serializable;

public class Egg extends AbstractRaw implements Serializable
{
    static final Logger LOGGER = LogManager.getLogger(Egg.class);
    static
    {
        System.setProperty("log4j.configurationFile","log4j.xml");
    }
    public Egg()
    {
        try{
            this.ShelfLife(25);
        }
        catch (ShelfLifeException ex)
        {
            LOGGER.error(ex.getMessage() +" entered shelflife was "+ ex.EnteredShelfLife());
        }

        this.DefaultCost(0.1f);
        this.Name("Egg");
        ID =2;
    }
}
