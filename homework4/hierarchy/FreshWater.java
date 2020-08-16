package edu.nyu.cs9053.homework4.hierarchy;

public abstract class FreshWater extends BodyOfWater {

	private final int connectedWaterBodiesCount;

	protected FreshWater(String name, double volume, int connectedWaterBodiesCount) {
		super(name, volume);
		this.connectedWaterBodiesCount = connectedWaterBodiesCount;
	}

	public int getConnectedWaterBodiesCount() {
		return connectedWaterBodiesCount;
	}
}