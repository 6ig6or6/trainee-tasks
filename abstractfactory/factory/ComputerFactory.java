package org.example.gofpatterns.abstractfactory.factory;


import org.example.gofpatterns.abstractfactory.device.computer.Computer;
import org.example.gofpatterns.abstractfactory.device.computer.Laptop;
import org.example.gofpatterns.abstractfactory.device.computer.OldPC;

import java.util.Locale;

public class ComputerFactory implements AbstractFactory<Computer> {
    @Override
    public Computer create(String deviceType) {
        return switch (deviceType.toLowerCase(Locale.ROOT)) {
            case "laptop" -> new Laptop();
            case "old pc" -> new OldPC();
            default -> throw new IllegalArgumentException("Unknown computer type " + deviceType);
        };
    }
}
