package Resourses;

import java.io.Serializable;

public class Corn extends AbstractResourse implements Serializable {
    public Corn()
    {
        this.SetDefaultCost(0.5f);
        this.SetName("Corn");
        ID = 1;
    }
}
