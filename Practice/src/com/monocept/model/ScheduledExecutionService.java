package com.monocept.model;
import java.util.concurrent.*;

public class ScheduledExecutionService {
	

	    public static void main(String[] args) {
	        ScheduledExecutorService scheduler =
	                Executors.newScheduledThreadPool(2);

	        Runnable task = () ->
	                System.out.println("Running at " + System.currentTimeMillis());

	        scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	    }
	}


