package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;

/**
 * User: blangel
 */
public class FortificationFactory {

    public static Fortification<Thread> createMiddleAges(int concurrencyFactor) {
        MiddleAgesFortification fortification = new MiddleAgesFortification(concurrencyFactor);
        return fortification;
    }

    public static Fortification<ExecutorService> createModern(int concurrencyFactor) {
        return new ModernFortification(concurrencyFactor);
    }

}
