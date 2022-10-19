package org.example.gofpatterns.factorymethod;


import org.example.gofpatterns.factorymethod.entity.CallNotification;
import org.example.gofpatterns.factorymethod.entity.EmailNotification;
import org.example.gofpatterns.factorymethod.entity.Notification;
import org.example.gofpatterns.factorymethod.entity.SmsNotification;

import java.util.Locale;

public class NotificationFactory {
    public Notification createNotification(String channel) {
        return switch (channel.toLowerCase(Locale.ROOT)) {
            case "call" -> new CallNotification();
            case "sms" -> new SmsNotification();
            case "email" -> new EmailNotification();
            default -> throw new IllegalArgumentException("Unknown way of notification " + channel);
        };
    }
}
