package edu.nyu.cs9053.homework4.hierarchy;

public class Swamp extends BodyOfWater {

    private final String waterType;

    private final int connectedWaterBodiesCount;

    public Swamp(String name, double volume, int connectedWaterBodiesCount, String waterType) {
        super(name, volume);
        this.connectedWaterBodiesCount = connectedWaterBodiesCount;
        this.waterType = waterType;
    }

    public int getConnectedWaterBodiesCount() {
        return connectedWaterBodiesCount;
    }

    public String getWaterType() { return waterType; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Swamp other = (Swamp) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((waterType == null) ? false : waterType.equals(other.getWaterType()));
    }

    @Override
    public int hashCode() {

        return 17 * this.getName().hashCode()
                + 19 * Double.hashCode(this.getVolume())
                + 23 * this.getConnectedWaterBodiesCount()
                + 29 * waterType.hashCode();
    }
}