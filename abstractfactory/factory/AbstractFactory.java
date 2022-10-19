package org.example.gofpatterns.abstractfactory.factory;

public interface AbstractFactory<T> {
    T create(String deviceType);
}
