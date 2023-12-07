package com.solvd.mavenThread.Connections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConnectionPool
{
    private String name = "DBname";
    private String password = "DBpassword";
    public int maxSize;
    private int currentSize;
    private ConcurrentLinkedDeque<Connection> freeConnections = new ConcurrentLinkedDeque<>();
    private ConcurrentLinkedDeque<Connection> occupiedConnections = new ConcurrentLinkedDeque<>();

    public ConnectionPool(int size)
    {
        this.maxSize = size;
        if(size <= 1)
            this.maxSize = 5;

    }
    public synchronized Connection getConnection()
    {
        Connection connection = null;
        if (isFull())
            throw new RuntimeException("The connectionPool is fool");

        connection = getPoolConnection();

        if (connection == null)
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
         return new Connection(name, password);
    }

    private Connection getPoolConnection()
    {
        Connection connection = null;
        if (!freeConnections.isEmpty())
            occupiedConnections.add(freeConnections.pop());

        return connection;
    }

    public synchronized boolean freeConnectionsAvailable()
    {
        return !freeConnections.isEmpty();
    }
    private boolean isFull()
    {
        return freeConnections.isEmpty() && this.currentSize >= this.maxSize;
    }
    public synchronized void returnConnection(Connection connection)
    {
        freeConnections.push(connection);
    }
}
