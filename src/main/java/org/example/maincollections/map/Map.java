package org.example.maincollections.map;

public interface Map<K, V> {
    int size();
    boolean isEmpty();
    V put(K key, V value);
    V get(Object key);
    boolean contains(K key);
    V remove(K key);
}
