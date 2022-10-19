package org.example.gofpatterns.state.states;

import org.example.gofpatterns.state.Package;

public class ReceivedState implements PackageState {
    @Override
    public void next(Package pkg) {
        System.out.println("The package is in the final state");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("The package is received by the client");
    }
}
