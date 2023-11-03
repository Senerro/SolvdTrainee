package Resourses;

import java.io.Serializable;

public class Watter extends AbstractResourse implements Serializable
{
    public Watter()
    {
        this.SetDefaultCost(1);
        this.SetName("Water");
        ID = 2;
    }
}
