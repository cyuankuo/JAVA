package edu.nyu.cs9053.homework9;


import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {
    // instantiates implementations
    public static final int MAX_AVAILABLE = 1;

    public static final Semaphore available = new Semaphore(MAX_AVAILABLE, false);

    public static Customer createCustomer() {
        return new RegularCustomer(available);
    }

    public static Barista createBarista() {
        return new SeniorBarista(available);
    }
}
