package edu.nyu.cs9053.homework4.hierarchy;

public class Tarn extends Lake {

    private final String mountain;

    public Tarn(String name, double volume, int connectedWaterBodiesCount, String mountain) {
        super(name, volume, connectedWaterBodiesCount);
        this.mountain = mountain;
    }

    public String getMountain() { return mountain; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Tarn other = (Tarn) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && ((mountain == null) ? false : mountain.equals(other.getMountain()));
    }


    @Override
    public int hashCode() {

        return 87 * this.getName().hashCode()
                + 89 * Double.hashCode(this.getVolume())
                + 97 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 101 * mountain.hashCode();
    }
}