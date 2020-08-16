package edu.nyu.cs9053.homework4.hierarchy;

public class Bay extends SaltWater {

    private final double indentationArea;

    public Bay(String name, double volume, int connectedWaterBodiesCount, double indentationArea) {
        super(name, volume, connectedWaterBodiesCount);
        this.indentationArea = indentationArea;
    }

    public double getIndentationArea() { return indentationArea; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Bay other = (Bay) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
            && (this.getVolume() == other.getVolume())
            && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
            && (indentationArea == other.getIndentationArea());
    }

    @Override
    public int hashCode() {

        return 29 * this.getName().hashCode()
            + 31 * Double.hashCode(this.getVolume())
            + 37 * Integer.hashCode(this.getConnectedWaterBodiesCount())
            + 41 * Double.hashCode(indentationArea);
    }
}