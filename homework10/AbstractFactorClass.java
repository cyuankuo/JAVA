package edu.nyu.cs9053.homework10;

public abstract class AbstractFactorClass implements ConcurrencyFactorProvider {

    private final int concurrencyFactor;

    protected AbstractFactorClass(int concurrencyFactor) {
        this.concurrencyFactor = concurrencyFactor;
    }

    @Override
    public int getConcurrencyFactor() {
        return concurrencyFactor;
    }
}
