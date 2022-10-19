package org.example.gofpatterns.abstractfactory.device.smartphone;

public class GooglePixel implements Smartphone{
    @Override
    public void call(String number) {
        System.out.println("Calling to " + number + " from our GooglePixel");
    }

    @Override
    public String multiply(int a, int b) {
        return String.valueOf(a * b);
    }
}
