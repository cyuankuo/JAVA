package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 */
public class ModernFortification extends AbstractFactorClass implements Fortification<ExecutorService> {

    private final ExecutorService executorService;

    public ModernFortification(int concurrencyFactor) {
        super(concurrencyFactor);
        this.executorService = Executors.newFixedThreadPool(concurrencyFactor);
    }

    @Override
    public void handleAttack(AttackHandler handler) {
        executorService.execute(handler::soldiersReady);
    }

    @Override
    public void surrender() {
        executorService.shutdownNow();
    }

}
