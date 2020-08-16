package edu.nyu.cs9053.homework4.hierarchy;

public class Tributary extends Stream {

    private final String orientation;

    public Tributary(String name, double volume, int connectedWaterBodiesCount, double flow, String orientation) {
        super(name, volume, connectedWaterBodiesCount, flow);
        this.orientation = orientation;
    }

    public String getOrientation() { return orientation; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Tributary other = (Tributary) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((orientation == null) ? false : orientation.equals(other.getOrientation()));
    }

    @Override
    public int hashCode() {

        return  7 * this.getName().hashCode()
                + 11 * Double.hashCode(this.getVolume())
                + 13 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 17 * Double.hashCode(this.getFlow())
                + 23 * orientation.hashCode();
    }
}