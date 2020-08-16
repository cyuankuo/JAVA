package edu.nyu.cs9053.homework5;

abstract class Food implements Recipe {

    private Double cookedSeconds = (double)0;
    private int ovenTemperature;

    public Double getCookedSeconds() {
        return cookedSeconds;
    }

    public int getOvenTemperature() {
        return ovenTemperature;
    }

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
    public Double getRemainingSecondsUntilDone();

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
