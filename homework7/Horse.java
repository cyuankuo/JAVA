package edu.nyu.cs9053.homework7;

public class Horse implements Animal {

    private final String name;

    private final String DEFAULT_NAME = "";

    public Horse() {
        this.name = DEFAULT_NAME;
    }

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Horse other = (Horse) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        if (this.getName() == null) {
            throw new NullPointerException();
        }
        return 17 * this.getName().hashCode();
    }


}