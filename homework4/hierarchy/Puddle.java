package edu.nyu.cs9053.homework4.hierarchy;

public class Puddle extends BodyOfWater{

    private final String puddleLocation;

    public Puddle(String name, double volume, String puddleLocation) {
        super(name, volume);
        this.puddleLocation = puddleLocation;
    }

    public String getPuddleLocation() { return puddleLocation; }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (this.getClass() != otherObject.getClass())
            return false;

        Puddle other = (Puddle) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && ((puddleLocation == null) ? false : puddleLocation.equals(other.getPuddleLocation()));
    }

    @Override
    public int hashCode() {

        return 17 * this.getName().hashCode()
                + 19 * new Double(this.getVolume()).hashCode()
                + 23 * puddleLocation.hashCode();
    }
}