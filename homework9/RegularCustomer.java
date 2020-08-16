package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.HashMap;


public class RegularCustomer implements Customer {

    /**
     * Attempts to order by checking {@code queue} and if there's an available position places an order resulting in
     * an {@link OrderNumber}.
     *
     * @param queue to place the order and get a new {@link OrderNumber} if possible
     * @return the produced {@link OrderNumber} or null if the {@link Customer} must continue to wait before ordering
     */
    final Semaphore availablePosition;
    private final Random random;

    RegularCustomer(Semaphore semaphore) {
        availablePosition = semaphore;
        random = new Random();
    }

    @Override
    public OrderNumber order(Queue queue) {

        if (queue == null) {
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
            if (!queue.full()) {
                OrderNumber order = queue.addOrder(DrinkGenerator());
                return order;
            }
            else {
                return null;
            }
        }
        finally {
            availablePosition.release();
        }
    }

    private CoffeeDrink DrinkGenerator() {
        HashMap<Integer, CoffeeDrink> map = new HashMap<>();
        map.put(1, new Espresso());
        map.put(2, new Latte());
        map.put(3, new Macchiato());

        int orderNum = random.nextInt(map.size()) + 1;
        return map.get(orderNum);
        Integer.parseInt();
    }
}
