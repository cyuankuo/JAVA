package edu.nyu.cs9053.homework7;

import java.util.Arrays;

public class CreateHorseArray implements ArrayCreator<Horse> {

    private Object[] elementData;

    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};

    public <Horse> Horse[] create(int size){
        this.elementData = DEFAULT_EMPTY_ELEMENT_DATA;
        Horse[] horse = (Horse[]) elementData;
        this.elementData = Arrays.copyOf(elementData, size, horse.getClass());
        return(Horse[]) elementData;
    }
}