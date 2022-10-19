package org.example.gofpatterns.factorymethod.entity;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending email...");
    }
}
