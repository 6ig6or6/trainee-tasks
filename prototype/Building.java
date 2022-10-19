package org.example.gofpatterns.prototype;

public abstract class Building {
    public double height;
    public int countOfFloors;
    public String address;

    public Building(double height, int countOfFloors, String address) {
        this.height = height;
        this.countOfFloors = countOfFloors;
        this.address = address;
    }

    public abstract Building clone(String newAddress);

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCountOfFloors() {
        return countOfFloors;
    }

    public void setCountOfFloors(int countOfFloors) {
        this.countOfFloors = countOfFloors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
