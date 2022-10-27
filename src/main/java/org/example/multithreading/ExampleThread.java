package org.example.multithreading;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        CommonStorage.saveThreadInfo();
    }
}
