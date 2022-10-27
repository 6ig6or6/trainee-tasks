package org.example.multithreading;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class ExampleCallable implements Callable<String> {
    @Override
    public String call() {
        CommonStorage.saveThreadInfo();
        return "Call method invocation by "
                + Thread.currentThread().getName()
                + " at "
                + LocalTime.now();
    }
}
