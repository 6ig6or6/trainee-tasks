package org.example.gofpatterns.adapter;

import org.example.gofpatterns.adapter.vehicles.Movable;

public class MovableAdapterImpl implements MovableAdapter {
    private static final double COEFFICIENT = 1.60934;
    private Movable vehicle;
    public MovableAdapterImpl(Movable vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public double getMaxSpeed() {
        return convertFromMPHtoMPK(vehicle.getMaxSpeed());
    }

    private double convertFromMPHtoMPK(double speedInMiles) {
        return speedInMiles * COEFFICIENT;
    }
}
