package ordermanagement;

import ordermanagement.model.Order;
import ordermanagement.service.OrderService;

/**
 * Main class
 * ----------
 * Entry point for the order management system demo.

 * Demonstrates:
 * - Creating an Order with an initial CREATED status.
 * - Using OrderService to perform lifecycle operations (pay, ship, deliver, cancel).
 * - Shows how state transitions are enforced by the Order class.
 */
public class Main {
    public static void main(String[] args) {

        // Create a new order with ID "ODR-1"
        Order order = new Order("ODR-1");

        // Initialize the service layer
        OrderService service = new OrderService();

        // Pay the order (CREATED → PAID)
        service.payOrder(order);

        // Ship the order (PAID → SHIPPED)
        service.shipOrder(order);

        // Deliver the order (SHIPPED → DELIVERED)
        service.deliverOrder(order);

        // Attempt to cancel the order (DELIVERED → CANCELLED not allowed)
        service.cancelOrder(order);
    }
}