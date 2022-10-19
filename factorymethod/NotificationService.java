package org.example.gofpatterns.factorymethod;


import org.example.gofpatterns.factorymethod.entity.Notification;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification firstNotification = notificationFactory.createNotification("SMS");
        firstNotification.notifyUser();
        Notification secondNotification = notificationFactory.createNotification("email");
        secondNotification.notifyUser();
    }
}