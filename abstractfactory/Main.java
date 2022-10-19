package org.example.gofpatterns.abstractfactory;


import org.example.gofpatterns.abstractfactory.device.computer.Computer;
import org.example.gofpatterns.abstractfactory.device.smartphone.Smartphone;
import org.example.gofpatterns.abstractfactory.factory.ComputerFactory;
import org.example.gofpatterns.abstractfactory.factory.SmartphoneFactory;

public class Main {
    public static void main(String[] args) {
        SmartphoneFactory smartphoneFactory = (SmartphoneFactory) FactoryProvider.getFactory("smartphone");
        Smartphone iphone = smartphoneFactory.create("iphone");
        iphone.call("567899");

        ComputerFactory computerFactory = (ComputerFactory) FactoryProvider.getFactory("computer");
        Computer oldPC = computerFactory.create("old PC");
        oldPC.multiply(100, 10);

        Computer laptop = computerFactory.create("laptop");
        laptop.openDesktopApp();
    }
}