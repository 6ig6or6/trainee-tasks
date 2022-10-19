package org.example.gofpatterns.abstractfactory.factory;


import org.example.gofpatterns.abstractfactory.device.smartphone.GooglePixel;
import org.example.gofpatterns.abstractfactory.device.smartphone.Iphone;
import org.example.gofpatterns.abstractfactory.device.smartphone.Smartphone;

import java.util.Locale;

public class SmartphoneFactory implements AbstractFactory<Smartphone> {
    @Override
    public Smartphone create(String deviceType) {
        return switch (deviceType.toLowerCase(Locale.ROOT)) {
            case "iphone" -> new Iphone();
            case "google pixel" -> new GooglePixel();
            default -> throw new IllegalArgumentException("Unknown smartphone type " + deviceType);
        };
    }
}
