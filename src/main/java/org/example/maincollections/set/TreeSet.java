package org.example.maincollections.set;

import org.example.maincollections.map.TreeMap;

public class TreeSet<K extends Comparable<K>> implements Set<K> {
    private final TreeMap<K, Object> map;
    private static final Object STUB = new Object();

    public TreeSet() {
        this.map = new TreeMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(K k) {
        return map.contains(k);
    }

    public boolean add(K k) {
        return map.put(k, STUB) == null;
    }

    public boolean remove(K k) {
        return map.remove(k) == STUB;
    }

}
