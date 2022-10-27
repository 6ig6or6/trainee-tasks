package org.example.multithreading;


public class ExampleRunnable implements Runnable {
    @Override
    public void run() {
        CommonStorage.saveThreadInfo();
    }
}
