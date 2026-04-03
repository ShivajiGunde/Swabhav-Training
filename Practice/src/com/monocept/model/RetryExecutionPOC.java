package com.monocept.model;

	
	import java.util.concurrent.*;

	public class RetryExecutionPOC {

	    static class RetryTask implements Callable<String> {
	        private int attempt = 0;

	        @Override
	        public String call() throws Exception {
	            attempt++;
	            if (attempt < 3) {
	                System.out.println("Failing attempt " + attempt);
	                throw new RuntimeException("Failure");
	            }
	            return "Success on attempt " + attempt;
	        }
	    }

	    public static void main(String[] args) {
	        ExecutorService executor = Executors.newFixedThreadPool(2);

	        RetryTask task = new RetryTask();

	        Future<String> future = executor.submit(() -> {
	            int retries = 3;
	            while (retries-- > 0) {
	                try {
	                    return task.call();
	                } catch (Exception e) {
	                    System.out.println("Retrying...");
	                }
	            }
	            throw new RuntimeException("Failed after retries");
	        });

	        try {
	            System.out.println(future.get());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        executor.shutdown();
	    }
	}

