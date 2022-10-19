package org.example.gofpatterns.prototype;

public class Hovel extends Building{
    public Hovel(double height, int countOfFloors, String address) {
        super(height, countOfFloors, address);
    }

    @Override
    public Building clone(String newAddress) {
        return new Hovel(this.getHeight(), this.getCountOfFloors(), newAddress);
    }
}
