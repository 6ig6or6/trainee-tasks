package org.example.gofpatterns.abstractfactory.device.computer;

public class Laptop implements Computer {
    @Override
    public void openDesktopApp() {
        System.out.println("Desktop app is working on the laptop now!");
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println(a * b);
    }
}
