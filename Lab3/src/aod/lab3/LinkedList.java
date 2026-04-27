package aod.lab3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * En enkel implementation av en länkad lista.
 * Listan lagrar element i noder där varje nod pekar på nästa nod.
 * Klassen innehåller vanliga listmetoder samt stöd för iterator.
 *
 * @param <T> typen av element som lagras i listan
 * @author Khalid Abdi Hashi
 */

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T data) {
        add(data, size);
    }

    @Override
    public void add(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
    }

    @Override
    public void set(T data, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.element = data;
    }

    @Override
    public void remove() {
        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = current.element;
            current = current.next;
            return data;
        }
    }
}