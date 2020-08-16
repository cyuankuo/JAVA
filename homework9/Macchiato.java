package edu.nyu.cs9053.homework9;

public class Macchiato implements CoffeeDrink {

    @Override
    public boolean containsMilk() { return true; }

    @Override
    public boolean isDecaf() {
        return false;
    }
}
