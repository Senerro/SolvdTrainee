package AbstractEntities;

public abstract class Farming
{
    private String name;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
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
