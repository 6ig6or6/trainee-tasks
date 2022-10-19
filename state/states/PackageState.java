package org.example.gofpatterns.state.states;

import org.example.gofpatterns.state.Package;

public interface PackageState {
    void next(Package pkg);
    void prev(Package pkg);
    void printStatus();
}
