package edu.nyu.cs9053.homework4.hierarchy;

public class Brook extends Stream {

    private final int depth;

    public Brook(String name, double volume, int connectedWaterBodiesCount, double flow, int depth) {
        super(name, volume, connectedWaterBodiesCount, flow);
        this.depth = depth;
    }

    public int getDepth() { return depth; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Brook other = (Brook) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && (this.getFlow() == other.getFlow())
                && (depth == other.getDepth());
    }

    @Override
    public int hashCode() {

        return  71 * this.getName().hashCode()
                + 101 * Double.hashCode(this.getVolume())
                + 127 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 131 * Double.hashCode(this.getFlow())
                + 7 * Integer.hashCode(depth);
    }
}