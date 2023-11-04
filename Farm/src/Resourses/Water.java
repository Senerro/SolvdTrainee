package Resourses;

import java.io.Serializable;

public class Water extends AbstractResourse implements Serializable
{
    public Water()
    {
        this.DefaultCost(1);
        this.Name("Water");
        ID = 2;
    }
}
