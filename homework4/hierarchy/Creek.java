package edu.nyu.cs9053.homework4.hierarchy;

public class Creek extends Stream {

    private final String location;

    public Creek(String name, double volume, int connectedWaterBodiesCount, double flow, String location) {
        super(name, volume, connectedWaterBodiesCount, flow);
        this.location = location;
    }

    public String getLocation() { return location; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Creek other = (Creek) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && (this.getFlow() == other.getFlow())
                && ((location == null) ? false : location.equals(other.getLocation()));
    }

    @Override
    public int hashCode() {

        return  7 * this.getName().hashCode()
                + 11 * Double.hashCode(this.getVolume())
                + 13 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 17 * Double.hashCode(this.getFlow())
                + 23 * location.hashCode();
    }
}