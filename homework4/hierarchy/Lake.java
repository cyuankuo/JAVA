package edu.nyu.cs9053.homework4.hierarchy;

public class Lake extends FreshWater {

    public Lake(String name, double volume, int connectedWaterBodiesCount) { super(name, volume, connectedWaterBodiesCount); }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Lake other = (Lake) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount());
    }

    @Override
    public int hashCode() {

        return 73 * this.getName().hashCode()
                + 79 * Double.hashCode(this.getVolume())
                + 83 * Integer.hashCode(this.getConnectedWaterBodiesCount());
    }
}