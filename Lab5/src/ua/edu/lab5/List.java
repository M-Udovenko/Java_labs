package ua.edu.lab5;

import java.util.Collection;

public interface List<E> {

    void add(E e);

    E put(int index, E element);

    E remove(int index);

    boolean addAll(Collection<? extends E> c);

    boolean remove(Object o);

    boolean contains(Object o);

    int size();
}