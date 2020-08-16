package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;


public class SeniorBarista implements Barista {

    /**
     * Processes an {@linkplain OrderNumber} within {@link Queue} from {@code from} only if there's orders within it.
     *
     * @param from to extract a {@link OrderNumber} if any
     * @return the extracted {@link OrderNumber} or null if none available to be extracted
     */
    final Semaphore availablePosition;

    SeniorBarista(Semaphore semaphore) {
         availablePosition = semaphore;
    }

    @Override
    public OrderNumber handle(Queue from) {

        if (from == null) {
            throw new IllegalArgumentException();
        }

        try {
            availablePosition.acquire();
        }
        catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }

        try {
            if (!from.isEmpty()) {
                OrderNumber orderNumber = from.getOrderNumber();
                return orderNumber;
            }
            else {
                return null;
            }
        }
        finally {
            availablePosition.release();
        }
    }
}
