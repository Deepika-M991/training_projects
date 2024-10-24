package com.assessment1.javaEmailSender;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class QueryScheduler {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(new QueryTask(), 0, 1, TimeUnit.HOURS);
    }
}

class QueryTask implements Runnable {
    @Override
    public void run() {

        QueryExecutor.executeQuery();
        EmailSender.sendEmail();
    }
}