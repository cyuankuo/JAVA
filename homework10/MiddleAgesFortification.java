package edu.nyu.cs9053.homework10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * User: blangel
 */
public class MiddleAgesFortification extends AbstractFactorClass implements Fortification<Thread> {

    private final BlockingQueue<Runnable> queue;
    private final Thread[] threadArray;

    public MiddleAgesFortification(int concurrencyFactor) {
        super(concurrencyFactor);
        this.queue = new ArrayBlockingQueue<>(concurrencyFactor);
        this.threadArray = new Thread[concurrencyFactor];
        for (int i = 0; i < getConcurrencyFactor(); i++) {
            threadArray[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable handler = queue.poll(1, TimeUnit.SECONDS);
                        handler.run();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    @Override
    public final void handleAttack(final AttackHandler handler) {
        try {
            queue.put(() -> {
            handler.soldiersReady();
            });
            for (Thread thread : threadArray) {
                if (thread == null) {
                    throw new NullPointerException();
                }
                thread.start();
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    @Override
    public void surrender() {
        for (Thread thread : threadArray) {
            if (thread != null) {
                thread.interrupt();
            }
        }
    }
}
