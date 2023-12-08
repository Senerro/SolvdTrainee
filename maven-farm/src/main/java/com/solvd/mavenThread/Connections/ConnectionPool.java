package com.solvd.mavenThread.Connections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConnectionPool
{
    private static ConnectionPool connectionPool;
    private String name = "DBname";
    private String password = "DBpassword";
    public int maxSize;
    private int currentSize;
    private volatile ConcurrentLinkedDeque<Connection> freeConnections = new ConcurrentLinkedDeque<>();
    private volatile ConcurrentLinkedDeque<Connection> occupiedConnections = new ConcurrentLinkedDeque<>();

    public static synchronized ConnectionPool getConnectionPool(int size)
    {
        if(connectionPool == null)
        {
            connectionPool = new ConnectionPool(size);
        }
        return connectionPool;
    }

    private ConnectionPool(int size)
    {
        this.maxSize = size;
        if(size <= 1)
            this.maxSize = 5;

    }
    public synchronized Connection getConnection()
    {
        Connection connection = null;
        /*if (isFull())
            throw new RuntimeException("The connectionPool is fool");*/

        connection = getPoolConnection();

        if (connection == null && occupiedConnections.size()<5)
            connection = createPoolConnection();

        return connection;
    }

    private Connection createPoolConnection()
    {
        Connection connection = createConnection();
        this.currentSize++;
        occupiedConnections.add(connection);
        return connection;
    }

    private Connection createConnection()
    {
         return new Connection(name, password, this);
    }

    private Connection getPoolConnection()
    {
        Connection connection = null;
        if (!freeConnections.isEmpty())
        {
            connection = freeConnections.pop();
            occupiedConnections.add(connection);
        }
        return connection;
    }


    public synchronized boolean isFull()
    {
        return freeConnections.isEmpty() && this.currentSize >= this.maxSize;
    }
    public  synchronized void returnConnection(Connection connection)
    {
        occupiedConnections.remove(connection);
        freeConnections.push(connection);
    }
}
