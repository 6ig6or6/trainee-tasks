package org.example.gofpatterns.prototype;

public class Skyscraper extends Building {

    public Skyscraper(double height, int countOfFloors, String address) {
        super(height, countOfFloors, address);
    }

    @Override
    public Building clone(String newAddress) {
        return new Skyscraper(this.getHeight(), this.getCountOfFloors(), newAddress);
    }
}
