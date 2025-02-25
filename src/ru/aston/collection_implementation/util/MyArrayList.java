package ru.aston.collection_implementation.util;

import java.util.Comparator;

public class MyArrayList<T> implements MyList<T> {
    private final int initCapacity = 10;
    private Object[] data;
    public int size = 0;

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.data = new Object[capacity];
        } else if (capacity == 0) {
            this.data = new Object[initCapacity];
        }
    }

    @Override
    public void add(Object object) {
        for (int i = 0; i < data.length; i++) {
            if (data[data.length - 1] != null) {
                incrementCapacity(10);
                add(object);
                break;
            }
            if (data[i] != null) {
                continue;
            } else {
                data[i] = object;
                size++;
                break;
            }
        }
    }

    @Override
    public void add(Object object, int index) {
        if (data[data.length - 1] != null) {
            incrementCapacity(10);
        }
        for (int i = size - 1; i > index - 2; i--) {
            data[i + 1] = data[i];
        }
        data[index - 1] = object;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return (T) data[index];
        } else {
            System.out.println("No such element in collection");
            return null;
        }
    }

    @Override
    public void remove(int index) {
        if (index > size) {
            System.out.println("No such element in collection");
        } else {
            data[index] = null;
            int counter = 1;
            for (int i = index; i < size - 1; i++) {
                data[index] = data[index + counter];
                counter++;
            }
            size--;
        }

    }

    @Override
    public void addAll(MyList myList) {
        for (int i = 0; i <= myList.size() - 1; i++) {
            if (myList.size() >= data.length - size) {
                incrementCapacity(10);
            }
            data[size] = myList.get(i);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            for (int i = 0; i < size - 1; i++) {
                isSorted = true;
                for (int j = 0; j < size - 1; j++) {
                    Object o;
                    if (comparator.compare((T) data[j], (T) data[j + 1]) > 0) {
                        o = data[j + 1];
                        data[j + 1] = data[j];
                        data[j] = o;
                        isSorted = false;
                    }
                }
            }
        }
    }

    private void incrementCapacity(int externalCapacity) {
        Object[] newData = new Object[data.length + externalCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

}
