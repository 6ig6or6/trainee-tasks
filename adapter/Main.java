package org.example.gofpatterns.adapter;

import org.example.gofpatterns.adapter.vehicles.BugattiVeyron;
import org.example.gofpatterns.adapter.vehicles.Movable;
import org.example.gofpatterns.adapter.vehicles.ToyotaCorolla;

public class Main {
    public static void main(String[] args) {
        Movable toyota = new ToyotaCorolla();
        Movable bugatti = new BugattiVeyron();
        MovableAdapter toyotaAdapter = new MovableAdapterImpl(toyota);
        System.out.println("Max speed of toyota in miles " + toyota.getMaxSpeedInMiles());
        System.out.println("Max speed of toyota in kilometers " + toyotaAdapter.getMaxSpeedInKilometers());
        MovableAdapter bugattiAdapter = new MovableAdapterImpl(bugatti);
        System.out.println("Max speed of bugatti in miles " + bugatti.getMaxSpeedInMiles());
        System.out.println("Max speed of bugatti in kilometers " + bugattiAdapter.getMaxSpeedInKilometers());
    }
}
