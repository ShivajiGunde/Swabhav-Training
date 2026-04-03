package com.monocept.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueExecutionService {
	

	    public static void main(String[] args) {
	        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

	        ThreadPoolExecutor executor = new ThreadPoolExecutor(
	                2, 4,
	                60, TimeUnit.SECONDS,
	                queue
	        );

	        for (int i = 1; i <= 10; i++) {
	            int taskId = i;
	            executor.execute(() -> {
	                System.out.println("Executing Task " + taskId +
	                        " by " + Thread.currentThread().getName());
	                try { Thread.sleep(1000); } catch (InterruptedException e) {}
	            });
	        }

	        executor.shutdown();
	    }
	}


