package org.example.gofpatterns.factorymethod.entity;

public class CallNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Calling to the user...");
    }
}
