package edu.nyu.cs9053.homework4.hierarchy;

/**
* According to Wikipedia -- https://en.wikipedia.org/wiki/List_of_seas
* The definition of Sea is - a marginal sea is a division of an ocean, partially enclosed by islands, archipelagos, or peninsulas, 
* adjacent to or widely open to the open ocean at the surface, and/or bounded by submarine ridges on the sea floor.
* Hence my decision to extend it from the Ocean class.
*/
public class Sea extends Ocean {

    private final double salinity;

    public Sea(String name, double volume, int connectedWaterBodiesCount, double salinity) {
        super(name, volume, connectedWaterBodiesCount);
        this.salinity = salinity;
    }

    public double getSalinity() { return salinity; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Sea other = (Sea) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount())
                && (salinity == other.getSalinity());
    }

    @Override
    public int hashCode() {

        return 41 * this.getName().hashCode()
                + 43 * Double.hashCode(this.getVolume())
                + 47 * Integer.hashCode(this.getConnectedWaterBodiesCount())
                + 53 * Double.hashCode(salinity);
    }
}