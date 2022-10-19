package org.example.gofpatterns.abstractfactory.device.computer;

public class OldPC implements Computer {
    @Override
    public void openDesktopApp() {
        System.out.println("Desktop app is working on the old PC now!");
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println(a * b);
    }
}
