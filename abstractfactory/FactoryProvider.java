package org.example.gofpatterns.abstractfactory;


import org.example.gofpatterns.abstractfactory.factory.AbstractFactory;
import org.example.gofpatterns.abstractfactory.factory.ComputerFactory;
import org.example.gofpatterns.abstractfactory.factory.SmartphoneFactory;

import java.util.Locale;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice) {
        return switch (choice.toLowerCase(Locale.ROOT)) {
            case "smartphone" -> new SmartphoneFactory();
            case "computer" -> new ComputerFactory();
            default -> throw new IllegalArgumentException("Unknown factory type " + choice);
        };
    }
}
