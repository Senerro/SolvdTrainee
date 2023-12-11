package com.solvd.mavenThread;

import com.solvd.mavenThread.Connections.Connection;
import com.solvd.mavenThread.Connections.ConnectionPool;
import com.solvd.mavenThread.Connections.MyRunnable;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool(6);

        ExecutorService service = Executors.newFixedThreadPool(5);
        ArrayList<CompletableFuture<Void>> completableFutureList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            Connection connection  = connectionPool.getConnection();
            completableFutureList.add(CompletableFuture.runAsync(new MyRunnable(connection)));
        }
        service.shutdown();

        for (int i = 0; i < 4; i++)
        {
            Connection connection = connectionPool.getConnection();
            Thread thread = new Thread(new MyRunnable(connection));
            thread.start();
        }

        Thread[] threads = new Thread[]{new Thread(new MyRunnable(connectionPool.getConnection())),
                                        new Thread(new MyRunnable(connectionPool.getConnection())),
                                        new Thread(new MyRunnable(connectionPool.getConnection())) };
        for (var element: threads ) {
            element.start();
        }

    }
}
