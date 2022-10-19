package org.example.gofpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        EagerInitSingleton eagerInitSingleton1 = EagerInitSingleton.getInstance();
        EagerInitSingleton eagerInitSingleton2 = EagerInitSingleton.getInstance();
        System.out.println(eagerInitSingleton2 == eagerInitSingleton1); //true
        LazyThreadSafeSingleton lazyThreadSafeSingleton1 = LazyThreadSafeSingleton.getInstance();
        LazyThreadSafeSingleton lazyThreadSafeSingleton2 = LazyThreadSafeSingleton.getInstance();
        System.out.println(lazyThreadSafeSingleton2 == lazyThreadSafeSingleton1); //true
        StaticBlockSingleton staticBlockSingleton1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton staticBlockSingleton2 = StaticBlockSingleton.getInstance();
        System.out.println(staticBlockSingleton2 == staticBlockSingleton1); // true
    }
}
