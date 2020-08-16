package edu.nyu.cs9053.homework7;

import java.util.Arrays;

public class Barn <T extends Animal> extends Repository<T> {

    protected Object[] elementData;

    private final int size;

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};

    public Barn() {
        this.elementData = DEFAULT_EMPTY_ELEMENT_DATA;
        this.size = 0;
    }

    public Barn(T[] elementData) {
        this.elementData = elementData;
        this.size = elementData.length;
        if (this.size == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        }
        if (this.size != 0) {
            if (elementData.getClass() != Object[].class)
                this.elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }

    public int size() {
        // returns the current amount of items inside the underlying array (returning an `int`)
        return size;
    }

}