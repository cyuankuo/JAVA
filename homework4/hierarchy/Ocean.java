package edu.nyu.cs9053.homework4.hierarchy;

public class Ocean extends SaltWater {

    public Ocean(String name, double volume, int connectedWaterBodiesCount) { super(name, volume, connectedWaterBodiesCount); }

    @Override
    public boolean equals(Object otherObject) {

    	if (this == otherObject)
    	    return true;

    	if (otherObject == null)
    	    return false;

    	if (this.getClass() != otherObject.getClass())
    		return false;
        
        Ocean other = (Ocean) otherObject;

        return ((this.getName() == null) ? false : this.getName().equals(other.getName()))
                && (this.getVolume() == other.getVolume())
                && (this.getConnectedWaterBodiesCount() == other.getConnectedWaterBodiesCount());
    }
 
    @Override
    public int hashCode() {

	    return 7 * this.getName().hashCode()
            + 11 * Double.hashCode(this.getVolume())
            + 13 * Integer.hashCode(this.getConnectedWaterBodiesCount());
    }
}