package org.example.gofpatterns.singleton;

public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong during instantiation of Singleton instance");
        }
    }

    private StaticBlockSingleton() {
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
