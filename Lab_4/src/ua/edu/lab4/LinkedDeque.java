package ua.edu.lab4;

import java.util.Collection;
import java.util.NoSuchElementException;

public class LinkedDeque<E> implements Deque<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        E data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        E data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    @Override
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        return head.data;
    }

    @Override
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        return tail.data;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E element : c) {
            addLast(element);
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = head;
        while (current != null) {
            if ((o == null && current.data == null) ||
                    (o != null && o.equals(current.data))) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if ((o == null && current.data == null) ||
                    (o != null && o.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}