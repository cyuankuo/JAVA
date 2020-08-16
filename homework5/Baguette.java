package edu.nyu.cs9053.homework5;

public class Baguette implements Recipe {

    private AtomicReference<Double> cookedSeconds;
    private int ovenTemperature = 0;
    private static final int VOLUME = 2000;
    private static final int SEC_IN_MIN = 60;
    private static final double ZERO_APPROXIMATION = 0.01d;
    private final double decayRate;

    public Baguette(double decayRate) {
        this.decayRate = decayRate;
        this.cookedSeconds = new AtomicReference<>(0d);
    }

    public double timeCheck(Time unit, int amount) {
        if (unit == Time.Minutes) {
            return (double)amount * SEC_IN_MIN;
        }
        else if (unit == Time.Seconds) {
            return (double) amount;
        }
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
    public Double getRemainingSecondsUntilDone() {
        return (((-Math.log(ZERO_APPROXIMATION / ovenTemperature)) / decayRate) * SEC_IN_MIN) - cookedSeconds;
    }

    @Override
    public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == null) {
            throw new IllegalArgumentException();
        }
        this.cookedSeconds += timeCheck(unit, amount);
        this.ovenTemperature = ovenTemperature;
    }

    @Override
    public boolean isRecipeDone() {
        return this.getRemainingSecondsUntilDone() <= 0;
    }

}