package com.monocept.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParllelExecutionService {
	public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            tasks.add(() -> {
                Thread.sleep(1000);
                return "Task " + taskId + " done by " + Thread.currentThread().getName();
            });
        }

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> f : results) {
            System.out.println(f.get());
        }

        executor.shutdown();
    }

}
