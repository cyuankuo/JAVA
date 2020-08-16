package edu.nyu.cs9053.homework5;

public class RoastedSweetPotato implements Recipe {

    private Double cookedSeconds = (double)0;
    private int ovenTemperature = 0;
    private static final int VOLUME = 6000;
    private static final int SEC_IN_MIN = 60;

    @Override
    public void initializeFromOven(Oven oven) {
        if(oven == null) {
            throw new NullPointerException("Oven input is null");
        }
        this.ovenTemperature = oven.getSetTemperature();
    }

    @Override
    public int getVolumeCubicInches() {
        return VOLUME;
    }

    @Override
    public Double getRemainingSecondsUntilDone() {
        return (SEC_IN_MIN * (double)this.ovenTemperature / 10) - this.cookedSeconds;
    }

    @Override
    public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == null) {
            throw new IllegalArgumentException();
        }
        this.cookedSeconds += (unit == Time.Minutes) ? (double)amount * SEC_IN_MIN : (double)amount;
        this.ovenTemperature = ovenTemperature;
    }

    @Override
    public boolean isRecipeDone() {
        return this.getRemainingSecondsUntilDone() <= 0;
    }
}