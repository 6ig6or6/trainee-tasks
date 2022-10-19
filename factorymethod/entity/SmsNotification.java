package org.example.gofpatterns.factorymethod.entity;

public class SmsNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending sms notification...");
    }
}
