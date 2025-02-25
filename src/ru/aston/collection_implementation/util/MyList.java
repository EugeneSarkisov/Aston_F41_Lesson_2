package ru.aston.collection_implementation.util;

import java.util.Comparator;

public interface MyList<T> {
    void add(T object);
    void add(T object, int index);
    T get(int index);
    void remove(int index);
    void addAll(MyList myList);
    int size();
    void sort(Comparator<T> comparator);
}
