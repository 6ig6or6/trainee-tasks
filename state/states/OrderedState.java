package org.example.gofpatterns.state.states;

import org.example.gofpatterns.state.Package;

public class OrderedState implements PackageState {
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("The package is in the first state");
    }

    @Override
    public void printStatus() {
        System.out.println("The package is ordered, but not delivered yet");
    }
}
