package org.example.gofpatterns.state;

import org.example.gofpatterns.state.states.OrderedState;
import org.example.gofpatterns.state.states.PackageState;

public class Package {
    private PackageState state = new OrderedState();

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }
}
