package org.example.gofpatterns.abstractfactory.device.smartphone;

public class Iphone implements Smartphone {
    @Override
    public void call(String number) {
        System.out.println("Calling to " + number + " from our Iphone");
    }

    @Override
    public String multiply(int a, int b) {
        return String.valueOf(a * b);
    }
}
