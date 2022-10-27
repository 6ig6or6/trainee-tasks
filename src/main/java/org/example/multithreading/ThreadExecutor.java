package org.example.multithreading;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class ThreadExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ThreadExecutor.class);
    public static void main(String[] args) {
        executeThreads();
        CommonStorage.printMapData();
        CommonStorage.refreshData();
        logger.info("______________________________");
        executeRunnable();
        CommonStorage.printMapData();
        CommonStorage.refreshData();
        logger.info("______________________________");
        executeCallableWithSingleThreadExecutor();
        CommonStorage.printMapData();
        CommonStorage.refreshData();
        logger.info("______________________________");
        executeCallableWithFixedThreadExecutor();
        CommonStorage.printMapData();
    }

    private static void executeThreads() {
        Stream.generate(ExampleThread::new)
                .limit(10)
                .forEach(Thread::start);
    }

    private static void executeRunnable() {
        Stream.generate(() -> new Thread(new ExampleRunnable()))
                .limit(10)
                .forEach(Thread::start);
    }

    private static void executeCallableWithSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> futureList = new ArrayList<>();
        Stream.generate(ExampleCallable::new)
                .limit(10)
                .map(executorService::submit)
                .forEach(futureList::add);
        executorService.shutdown();
        futureList.stream().map(x -> {
            try {
                return x.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).forEach(logger::info);
    }

    private static void executeCallableWithFixedThreadExecutor() {
        ExecutorService executorService = Executors
                .newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        Stream.generate(ExampleCallable::new)
                .limit(10)
                .forEach(executorService::submit);
        executorService.shutdown();
    }
}
