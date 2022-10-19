package org.example.gofpatterns.state.states;

import org.example.gofpatterns.state.Package;

public class DeliveredState implements PackageState {
    @Override
    public void next(Package pkg) {
      pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(Package pkg) {
     pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("The package is delivered to the post office, but isn't picked up yet");
    }
}
