package org.example.maincollections.map;

import java.util.Objects;
import java.util.function.Predicate;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node<K, V> root;
    private int size;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    @Override
    public V get(Object key) {
        Node<K, V> p = getNode(key);
        return (p == null ? null : p.value);
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V remove(K key) {
        Node<K, V> p = getNode(key);
        if (p == null) {
            return null;
        }
        V oldValue = p.value;
        deleteNode(p);
        return oldValue;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> t = root;
        if (t == null) {
            addEntryToEmptyMap(key, value);
            return null;
        }
        int comparableValue;
        Node<K, V> parent;
        Objects.requireNonNull(key);
        do {
            parent = t;
            comparableValue = key.compareTo(t.key);
            if (comparableValue < 0) {
                t = t.left;
            } else if (comparableValue > 0) {
                t = t.right;
            } else {
                V oldValue = t.value;
                t.value = value;

                return oldValue;
            }
        } while (t != null);
        addNode(key, value, parent, comparableValue < 0);
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<K, V> getNode(Object key) {
        Objects.requireNonNull(key);
        @SuppressWarnings("unchecked") Comparable<? super K> k = (Comparable<? super K>) key;
        Node<K, V> p = root;
        while (p != null) {
            int comparableValue = k.compareTo(p.key);
            if (comparableValue < 0) {
                p = p.left;
            } else if (comparableValue > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    private void addNode(K key, V value, Node<K, V> parent, boolean addToLeft) {
        Node<K, V> e = new Node<>(key, value, parent);
        if (addToLeft) {
            parent.left = e;
        } else {
            parent.right = e;
        }
        fixAfterInsertion(e);
        size++;
    }

    private final Predicate<Node<K, V>> isChildElementsNotNull = x -> x.left != null && x.right != null;

    private void deleteNode(Node<K, V> p) {
        size--;
        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (isChildElementsNotNull.test(p)) {
            Node<K, V> s = Node.successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children
        // Start fixup at replacement node, if it exists.
        Node<K, V> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {
            linkReplacementToParent(p, replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { // No children
            if (p.color == BLACK) {
                fixAfterDeletion(p); //use itself as a phantom replacement
            }
            unlinkNodes(p);
        }
    }

    private void linkReplacementToParent(Node<K, V> p, Node<K, V> replacement) {
        replacement.parent = p.parent;
        if (p.parent == null) {
            root = replacement;
        } else if (p == p.parent.left) {
            p.parent.left = replacement;
        } else {
            p.parent.right = replacement;
        }
        // Null out links so they are OK to use by fixAfterDeletion.
        p.left = p.right = p.parent = null;
        // Fix replacement
        if (p.color == BLACK) {
            fixAfterDeletion(replacement);
        }
    }

    private void unlinkNodes(Node<K, V> p) {
        if (p.parent != null) {
            if (p == p.parent.left) {
                p.parent.left = null;
            } else if (p == p.parent.right) {
                p.parent.right = null;
            }
            p.parent = null;
        }
    }

    private void addEntryToEmptyMap(K key, V value) {
        root = new Node<>(key, value, null);
        size = 1;
    }

    private void rotateRight(Node<K, V> node) {
        if (node != null) {
            Node<K, V> l = node.left;
            node.left = l.right;
            if (l.right != null) {
                l.right.parent = node;
            }
            l.parent = node.parent;
            if (node.parent == null) {
                root = l;
            } else if (node.parent.right == node) {
                node.parent.right = l;
            } else {
                node.parent.left = l;
            }
            l.right = node;
            node.parent = l;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        if (node != null) {
            Node<K, V> r = node.right;
            node.right = r.left;
            if (r.left != null) {
                r.left.parent = node;
            }
            r.parent = node.parent;
            if (node.parent == null) {
                root = r;
            } else if (node.parent.left == node) {
                node.parent.left = r;
            } else {
                node.parent.right = r;
            }
            r.left = node;
            node.parent = r;
        }
    }

    private final Predicate<Node<K, V>> isColorRed = n -> colorOf(n) == RED;
    private final Predicate<Node<K, V>> isColorBlack = n -> colorOf(n) == BLACK;

    private void fixAfterInsertion(Node<K, V> x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                x = fixRightChildAfterInsertion(x);
            } else {
                x = fixLeftChildAfterInsertion(x);
            }
        }
        root.color = BLACK;
    }

    private Node<K, V> fixRightChildAfterInsertion(Node<K, V> x) {
        Node<K, V> y = rightOf(parentOf(parentOf(x)));
        if (isColorRed.test(y)) {
            setColor(parentOf(x), BLACK);
            setColor(y, BLACK);
            setColor(parentOf(parentOf(x)), RED);
            x = parentOf(parentOf(x));
        } else {
            if (x == rightOf(parentOf(x))) {
                x = parentOf(x);
                rotateLeft(x);
            }
            setColor(parentOf(x), BLACK);
            setColor(parentOf(parentOf(x)), RED);
            rotateRight(parentOf(parentOf(x)));
        }
        return x;
    }

    private Node<K, V> fixLeftChildAfterInsertion(Node<K, V> x) {
        Node<K, V> y = leftOf(parentOf(parentOf(x)));
        if (isColorRed.test(y)) {
            setColor(parentOf(x), BLACK);
            setColor(y, BLACK);
            setColor(parentOf(parentOf(x)), RED);
            x = parentOf(parentOf(x));
        } else {
            if (x == leftOf(parentOf(x))) {
                x = parentOf(x);
                rotateRight(x);
            }
            setColor(parentOf(x), BLACK);
            setColor(parentOf(parentOf(x)), RED);
            rotateLeft(parentOf(parentOf(x)));
        }
        return x;
    }

    private void fixAfterDeletion(Node<K, V> x) {
        while (x != root && isColorBlack.test(x)) {
            if (x == leftOf(parentOf(x))) {
                x = replaceRightParentsChildForDeletion(x);
            } else { // symmetric
                x = replaceLeftParentsChildForDeletion(x);
            }
        }
        setColor(x, BLACK);
    }

    private Node<K, V> replaceRightParentsChildForDeletion(Node<K, V> x) {
        Node<K, V> sib = rightOf(parentOf(x));
        if (isColorRed.test(sib)) {
            setColor(sib, BLACK);
            setColor(parentOf(x), RED);
            rotateLeft(parentOf(x));
            sib = rightOf(parentOf(x));
        }
        if (isColorBlack.test(leftOf(sib)) && isColorBlack.test(rightOf(sib))) {
            setColor(sib, RED);
            x = parentOf(x);
        } else {
            if (isColorBlack.test(rightOf(sib))) {
                setColor(leftOf(sib), BLACK);
                setColor(sib, RED);
                rotateRight(sib);
                sib = rightOf(parentOf(x));
            }
            setColor(sib, colorOf(parentOf(x)));
            setColor(parentOf(x), BLACK);
            setColor(rightOf(sib), BLACK);
            rotateLeft(parentOf(x));
            x = root;
        }
        return x;
    }

    private Node<K, V> replaceLeftParentsChildForDeletion(Node<K, V> x) {
        Node<K, V> sib = leftOf(parentOf(x));
        if (isColorRed.test(sib)) {
            setColor(sib, BLACK);
            setColor(parentOf(x), RED);
            rotateRight(parentOf(x));
            sib = leftOf(parentOf(x));
        }

        if (isColorBlack.test(leftOf(sib)) && isColorBlack.test(rightOf(sib))) {
            setColor(sib, RED);
            x = parentOf(x);
        } else {
            if (isColorBlack.test(leftOf(sib))) {
                setColor(rightOf(sib), BLACK);
                setColor(sib, RED);
                rotateLeft(sib);
                sib = leftOf(parentOf(x));
            }
            setColor(sib, colorOf(parentOf(x)));
            setColor(parentOf(x), BLACK);
            setColor(leftOf(sib), BLACK);
            rotateRight(parentOf(x));
            x = root;
        }
        return x;
    }

    private static <K, V> boolean colorOf(Node<K, V> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <K, V> Node<K, V> parentOf(Node<K, V> p) {
        return (p == null ? null : p.parent);
    }

    private static <K, V> void setColor(Node<K, V> p, boolean color) {
        if (p != null) {
            p.color = color;
        }
    }

    private static <K, V> Node<K, V> leftOf(Node<K, V> p) {
        return (p == null) ? null : p.left;
    }

    private static <K, V> Node<K, V> rightOf(Node<K, V> p) {
        return (p == null) ? null : p.right;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;
        boolean color;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        static <K, V> Node<K, V> successor(Node<K, V> t) {
            if (t == null) {
                return null;
            } else if (t.right != null) {
                Node<K, V> p = t.right;
                while (p.left != null) {
                    p = p.left;
                }
                return p;
            } else {
                Node<K, V> p = t.parent;
                Node<K, V> ch = t;
                while (p != null && ch == p.right) {
                    ch = p;
                    p = p.parent;
                }
                return p;
            }
        }
    }
}
