package com.solvd.mavenThread;

import com.solvd.mavenThread.Connections.Connection;
import com.solvd.mavenThread.Connections.ConnectionPool;
import com.solvd.mavenThread.Connections.MyRunnable;

import java.util.concurrent.*;

public class Main
{
    public static void main(String[] args) throws InterruptedException, ExecutionException {

       /* CompletableFuture cf1 = CompletableFuture.runAsync(new MyRunnable());
        CompletableFuture cf2 = CompletableFuture.runAsync(new MyRunnable());
        CompletableFuture[] cfs = new CompletableFuture[]{cf1, cf2};
        //cf1.join();
        var cf3 = CompletableFuture.allOf(cfs);*/

      //  thread.start();
        //////////////////////////////////////
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool(5);


        /*Callable<Connection> task = () ->
        {
            Connection connection = null;
            do {
                connection = connectionPool.getConnection();
            }
            while (connection == null);
            System.out.printf("Thread is %s, url is %s\n", Thread.currentThread().getName(), connection.id());
            new MyRunnable(connection);
            return connection;
        };
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 8; i++) {
            Future<Connection> result = service.submit(task);
           // connectionPool.returnConnection(result.get());
        }
        service.shutdown();*/

        for (int i = 0; i < 7; i++)
        {
           Connection connection = null;
           while (connection == null)
           {
               connection = connectionPool.getConnection();
           }
            Thread thread = new Thread(new MyRunnable(connection));
            thread.start();
        }

        System.out.print("Something is working\n");
    }
}
