package ordermanagement.service;

import ordermanagement.model.Order;

/**
 * OrderService class
 * ------------------
 * Provides service methods to manage order lifecycle operations.
 *
 * Features:
 * - Delegates actions (pay, ship, deliver, cancel) to the Order object.
 * - Acts as a service layer between higher-level application logic and the Order model.
 *
 * This class demonstrates separation of concerns:
 * - The Order class enforces state rules.
 * - The OrderService provides a clean API for external use.
 */
public class OrderService {

    /**
     * Pay for the given order.
     *
     * @param order The order to be paid
     */
    public void payOrder(Order order) {
        order.pay();
    }

    /**
     * Ship the given order.
     *
     * @param order The order to be shipped
     */
    public void shipOrder(Order order) {
        order.ship();
    }

    /**
     * Deliver the given order.
     *
     * @param order The order to be delivered
     */
    public void deliverOrder(Order order) {
        order.deliver();
    }

    /**
     * Cancel the given order.
     *
     * @param order The order to be cancelled
     */
    public void cancelOrder(Order order) {
        order.cancel();
    }
}