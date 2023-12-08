package com.solvd.mavenThread.Connections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConnectionPool
{
    private static ConnectionPool connectionPool;
    private String name = "DBname";
    private String password = "DBpassword";
    public int maxSize;
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
    public synchronized Connection getConnection() throws InterruptedException {
        Connection connection = null;


        connection = getPoolConnection();

        if (connection == null && occupiedConnections.size() < this.maxSize)
            connection = createPoolConnection();

        if(connection == null)
        {
            wait();
            connection = getPoolConnection();
        }
        return connection;
    }

    private Connection createPoolConnection()
    {
        Connection connection = createConnection();
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

    public  synchronized void returnConnection(Connection connection)
    {
        occupiedConnections.remove(connection);
        freeConnections.push(connection);
        notify();
    }
}
