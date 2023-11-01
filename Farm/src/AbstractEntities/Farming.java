package AbstractEntities;

import java.io.Serializable;

public abstract class Farming implements Serializable
{
    private String name;
    public int ID;

    public String GetName()
    {
        return name;
    }
    public void SetName(String name)
    {
        if (!name.isEmpty())
            this.name = name;
        else
            this.name = "unknown";
    }

    public abstract void Eat() ;
    public abstract void Drink();
    public abstract void GrowUp();


}
