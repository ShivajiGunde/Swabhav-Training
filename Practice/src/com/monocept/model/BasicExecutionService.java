package com.monocept.model;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class  BasicExecutionService{
	 public static void main(String[] args) throws Exception {
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        Callable<String> task = () -> {
	            Thread.sleep(1000);
	            return "Task executed by " + Thread.currentThread().getName();
	        };

	        Future<String> future = executor.submit(task);

	        System.out.println("Result: " + future.get());

	        executor.shutdown();
	    }
	}
	
	


