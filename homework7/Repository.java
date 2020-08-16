package edu.nyu.cs9053.homework7;
import java.util.Arrays;
import java.util.Objects;
import java.lang.System;

public class Repository<T> {

    protected Object[] elementData;

    private int size;

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};

    public Repository() { this.elementData = DEFAULT_EMPTY_ELEMENT_DATA; }

    public Repository(T[] elementData) {
        this.elementData = elementData;
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class)
                this.elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
        else {
            this.elementData = EMPTY_ELEMENT_DATA;
        }
    }

    public void add(T t, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = Arrays.copyOf(elementData, s + 1);
        elementData[s] = t;
        size = s + 1;
    }

    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (contains(t)) {
            return false;
        }
        add(t, elementData, size);
        return true;
    }

    public boolean contains(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        for (Object o: elementData) {
            if (t == o)
                return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - 1);
        es[size = newSize] = null;
    }

    public T get(int index) {
        // returning the generic type which is the value at the index,
        // if the index does not exist an exception or null can be returned
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    public int size() {
        // returns the current amount of items inside the underlying array (returning an `int`)
        return size;
    }
}
