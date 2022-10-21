package org.example.maincollections.list;

public interface List<T> {
    int size();
    void add(T t);
    void add(int index, T t);
    boolean contains(T t);
    T get(int index);
    int indexOf(T t);
    T remove(int index);
    boolean removeFirstOccurrence(T t);


}
