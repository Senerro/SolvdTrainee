package Resourses;

import java.io.Serializable;

public class Corn extends AbstractResourse implements Serializable {
    public Corn()
    {
        this.DefaultCost(0.5f);
        this.Name("Corn");
        ID = 1;
    }
}
