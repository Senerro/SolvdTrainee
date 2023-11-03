package Resourses;

import java.io.Serializable;

public class Watter extends AbstractResourse implements Serializable
{
    public Watter()
    {
        this.DefaultCost(1);
        this.Name("Water");
        ID = 2;
    }
}
