package edu.nyu.cs9053.homework4.hierarchy;

public class Stream extends FreshWater {

    private final double flow;

    public Stream(String name, double volume, int connectedWaterBodiesCount, double flow) {
        super(name, volume, connectedWaterBodiesCount);
        this.flow = flow;
    }

    public double getFlow() {
        return flow;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Stream other = (Stream) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount());
    }

    @Override
    public int hashCode() {

        return 101 * this.getName().hashCode()
                + 113 * Double.hashCode(this.getVolume())
                + 127 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 131 * Double.hashCode(flow);
    }
}