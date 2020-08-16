package edu.nyu.cs9053.homework4.hierarchy;

/**
 * According to Wikipedia -- https://en.wikipedia.org/wiki/Lagoon
 * Geology professor "Richard A. Davis Jr. restricts 'lagoon' to bodies of water with little or no fresh water inflow, and little or no tidal flow."
 * Hence for this exercise, a lagoon is classified as a subclass of SaltWater
 */

public class Lagoon extends SaltWater {

    private final String lagoonType;

    public Lagoon(String name, double volume, int connectedWaterBodiesCount, String lagoonType) {
        super(name, volume, connectedWaterBodiesCount);
        this.lagoonType = lagoonType;
    }

    public String getLagoonType() { return lagoonType; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Lagoon other = (Lagoon) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((lagoonType == null) ? false : lagoonType.equals(other.getLagoonType()));
    }

    @Override
    public int hashCode() {

        return 17 * this.getName().hashCode()
            + 19 * Double.hashCode(this.getVolume())
            + 23 * Integer.hashCode(this.getConnectedWaterBodiesCount())
            + 29 * lagoonType.hashCode();
    }
}