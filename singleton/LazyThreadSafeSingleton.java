package org.example.gofpatterns.singleton;


public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton instance;

    private LazyThreadSafeSingleton() {
    }

    public synchronized static LazyThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyThreadSafeSingleton();
        }
        return instance;
    }

}
