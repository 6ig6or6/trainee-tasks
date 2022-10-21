package org.example.maincollections.set;

public interface Set<K> {
    int size();
    boolean isEmpty();
    boolean contains(K k);
    boolean add(K k);
    boolean remove(K k);
}
