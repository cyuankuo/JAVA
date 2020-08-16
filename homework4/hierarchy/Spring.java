package edu.nyu.cs9053.homework4.hierarchy;

public class Spring extends FreshWater {

    private final String mineral;

    public Spring(String name, double volume, int connectedWaterBodiesCount, String mineral) {
        super(name, volume, connectedWaterBodiesCount);
        this.mineral = mineral;
    }

    public String getMineral() { return mineral; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Spring other = (Spring) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((mineral == null) ? false : mineral.equals(other.getMineral()));
    }

    @Override
    public int hashCode() {

        return 61 * this.getName().hashCode()
                + 67 * Double.hashCode(this.getVolume())
                + 71 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 73 * mineral.hashCode();
    }
}