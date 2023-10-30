package SortingClass;

import java.util.ArrayList;
import java.util.List;

public class Sorting<T>
{
    private ArrayList<T> array;
    public Sorting()
    {
        this.array = new ArrayList<T>();
    }
    public Sorting(ArrayList<T> array)
    {
        this.array = new ArrayList<T>();
        for (T arrayElement:array)
        {
            this.array.add(arrayElement);
        }

    }
    public  ArrayList<T> SomeMethood ()
    {
        for (int i = 0; i < array.size(); i++)
        {
            System.out.println("Something opposed");
        }



        return array;
    }

}
