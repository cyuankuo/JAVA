package edu.nyu.cs9053.homework4.hierarchy;

public class Gulf extends SaltWater {

    private final String neighboringCoastline;

    public Gulf(String name, double volume, int connectedWaterBodiesCount, String neighboringCoastline) {
        super(name, volume, connectedWaterBodiesCount);
        this.neighboringCoastline = neighboringCoastline;
    }

    public String getNeighboringCoastline() { return neighboringCoastline; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Gulf other = (Gulf) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((neighboringCoastline == null) ? false : neighboringCoastline.equals(other.getNeighboringCoastline()));
    }

    @Override
    public int hashCode() {

        return 53 * this.getName().hashCode()
                + 57 * Double.hashCode(this.getVolume())
                + 59 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 61 * neighboringCoastline.hashCode();
    }
}