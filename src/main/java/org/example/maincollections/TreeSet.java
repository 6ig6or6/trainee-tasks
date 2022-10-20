package org.example.maincollections;

import java.util.TreeMap;

public class TreeSet<K extends Comparable<K>> {
    private TreeMap<K, Object> map;
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
        return map.containsKey(k);
    }

    public boolean add(K k) {
        return map.put(k, STUB) == null;
    }

    public boolean remove(Object object) {
        return map.remove(object) == STUB;
    }

}
