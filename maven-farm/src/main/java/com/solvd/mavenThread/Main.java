package com.solvd.mavenThread;

import com.solvd.mavenThread.Connections.Connection;
import com.solvd.mavenThread.Connections.ConnectionPool;
import com.solvd.mavenThread.Connections.MyRunnable;

import java.util.concurrent.CompletableFuture;

public class Main
{
    public static void main(String[] args) throws InterruptedException {

       /* CompletableFuture cf1 = CompletableFuture.runAsync(new MyRunnable());
        CompletableFuture cf2 = CompletableFuture.runAsync(new MyRunnable());
        CompletableFuture[] cfs = new CompletableFuture[]{cf1, cf2};
        //cf1.join();
        var cf3 = CompletableFuture.allOf(cfs);*/

      //  thread.start();
        //////////////////////////////////////
        ConnectionPool connectionPool = new ConnectionPool(2);
        for (int i = 0; i < 3; i++)
        {
            Connection connection = null;
            do {
                 connection = connectionPool.getConnection();
            }
            while (connection==null);

            Thread thread = new Thread(new MyRunnable(connection));
            thread.start();
            connectionPool.returnConnection(connection);
        }

    }
}
