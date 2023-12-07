package com.solvd.mavenThread.Connections;

import com.solvd.mavenFarm.abstractEntities.Food;

import java.util.Random;

public class Connection
{
    String dbName;
    String password;
    String url;
    public Connection()
    {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++)
        {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
       this.url =  buffer.toString();
    }
    public Connection(String dbName, String password)
    {
        this();
        this.dbName = dbName;
        this.password = password;
    }
    public String url()
    {
        return this.url;
    }
    @Override
    public int hashCode()
    {
        return this.url.hashCode()+31;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        if(this.url().equals(((Connection) obj).url()))
            if(this.dbName.equals( ((Connection) obj).dbName))
                return this.password.equals(((Connection) obj).password);
        return false;
    }
}
