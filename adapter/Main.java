package org.example.gofpatterns.adapter;

import org.example.gofpatterns.adapter.vehicles.BugattiVeyron;
import org.example.gofpatterns.adapter.vehicles.Movable;
import org.example.gofpatterns.adapter.vehicles.ToyotaCorolla;

public class Main {
    public static void main(String[] args) {
        Movable toyota = new ToyotaCorolla();
        Movable bugatti = new BugattiVeyron();
        MovableAdapter toyotaAdapter = new MovableAdapterImpl(toyota);
        System.out.println("Max speed of toyota in miles " + toyota.getMaxSpeed());
        System.out.println("Max speed of toyota in kilometers " + toyotaAdapter.getMaxSpeed());
        MovableAdapter bugattiAdapter = new MovableAdapterImpl(bugatti);
        System.out.println("Max speed of bugatti in miles " + bugatti.getMaxSpeed());
        System.out.println("Max speed of bugatti in kilometers " + bugattiAdapter.getMaxSpeed());
    }
}
