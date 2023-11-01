package AbstractEntities;

public abstract class Farming
{
    private String name;

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
