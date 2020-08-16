package edu.nyu.cs9053.homework4.hierarchy;

public abstract class SaltWater extends BodyOfWater {

	private final int connectedWaterBodiesCount;

	protected SaltWater(String name, double volume, int connectedWaterBodiesCount) {
    	super(name, volume);
    	this.connectedWaterBodiesCount = connectedWaterBodiesCount;
	}

	public int getConnectedWaterBodiesCount() {
		return connectedWaterBodiesCount;
	}
}