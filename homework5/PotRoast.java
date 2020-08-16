package edu.nyu.cs9053.homework5;

public class PotRoast extends Food {

    private Double cookedSeconds = (double)0;
    private int ovenTemperature = 0;
    private static final int VOLUME = 10000;
    private static final int SEC_IN_MIN = 60;

    @Override
    public Double getRemainingSecondsUntilDone() {
        return (SEC_IN_MIN * (double)this.ovenTemperature / 5) - this.cookedSeconds;
    }
}