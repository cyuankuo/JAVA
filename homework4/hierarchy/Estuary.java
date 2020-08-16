package edu.nyu.cs9053.homework4.hierarchy;

public class Estuary extends BodyOfWater {

    private final String geomorphology;

    private final int connectedWaterBodiesCount;

    public Estuary(String name, double volume, int connectedWaterBodiesCount, String geomorphology) {
        super(name, volume);
        this.connectedWaterBodiesCount = connectedWaterBodiesCount;
        this.geomorphology = geomorphology;
    }

    public int getConnectedWaterBodiesCount() {
        return connectedWaterBodiesCount;
    }

    public String getGeomorphology() { return geomorphology; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Estuary other = (Estuary) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((geomorphology == null) ? false : geomorphology.equals(other.getGeomorphology()));
    }

    @Override
    public int hashCode() {

        return 17 * this.getName().hashCode()
                + 19 * Double.hashCode(this.getVolume())
                + 23 * this.getConnectedWaterBodiesCount()
                + 29 * geomorphology.hashCode();
    }
}