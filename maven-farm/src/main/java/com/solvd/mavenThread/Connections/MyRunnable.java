package com.solvd.mavenThread.Connections;

public class MyRunnable implements Runnable
{
    Connection connection;
    public MyRunnable(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void run()
    {
        Long starTime = System.currentTimeMillis();
        System.out.printf("thread name is %s, url is [%s] ", Thread.currentThread().getName(), connection.url);
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e)
        {

        }
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime-starTime;
        System.out.printf("%d ms", resultTime);

    }
}
