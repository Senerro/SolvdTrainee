package com.solvd.mavenThread.Connections;
import java.util.Random;

public class Connection
{
    String dbName;
    String password;
    String id;
    ConnectionPool connectionPool;
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
       this.id =  buffer.toString();
    }
    public Connection(String dbName, String password, ConnectionPool pool)
    {
        this();
        this.dbName = dbName;
        this.password = password;
        this.connectionPool = pool;
    }
    public String id()
    {
        return this.id;
    }
    @Override
    public int hashCode()
    {
        return this.id.hashCode()+31;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        if(this.id().equals(((Connection) obj).id()))
            if(this.dbName.equals( ((Connection) obj).dbName))
                return this.password.equals(((Connection) obj).password);
        return false;
    }
}
