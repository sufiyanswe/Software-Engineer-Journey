package ordermanagement.model;



/**
 * Order class
 * -----------
 * Represents an order in the order management system.
 *
 * Features:
 * - Tracks order ID and current status.
 * - Supports state transitions: CREATED → PAID → SHIPPED → DELIVERED.
 * - Allows cancellation unless the order is already delivered or cancelled.
 *
 * This class demonstrates a simple state machine pattern,
 * where each action is only valid in certain states.
 */
public class Order {

    // Unique identifier for the order
    private final String orderId;

    // Current status of the order
    private OrderStatus status;

    /**
     * Constructor to initialize a new order with CREATED status.
     *
     * @param orderId Unique identifier for the order
     */
    public Order(String orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.CREATED;
    }

    /** @return the unique order ID */
    public String getOrderId() {
        return orderId;
    }

    /** @return the current status of the order */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Pay for the order.
     * Allowed only when the order is in CREATED status.
     */
    public void pay() {
        if (status != OrderStatus.CREATED) {
            System.out.println("Order cannot be paid in status: " + status);
            return;
        }
        status = OrderStatus.PAID;
        System.out.println("Order paid successfully");
    }

    /**
     * Ship the order.
     * Allowed only when the order is in PAID status.
     */
    public void ship() {
        if (status != OrderStatus.PAID) {
            System.out.println("Order cannot be shipped in status: " + status);
            return;
        }
        status = OrderStatus.SHIPPED;
        System.out.println("Order shipped");
    }

    /**
     * Deliver the order.
     * Allowed only when the order is in SHIPPED status.
     */
    public void deliver() {
        if (status != OrderStatus.SHIPPED) {
            System.out.println("Order cannot be delivered in status: " + status);
            return;
        }
        status = OrderStatus.DELIVERED;
        System.out.println("Order delivered");
    }

    /**
     * Cancel the order.
     * Allowed unless the order is already delivered or cancelled.
     */
    public void cancel() {
        if (status == OrderStatus.DELIVERED) {
            System.out.println("Delivered order cannot be cancelled");
            return;
        }
        if (status == OrderStatus.CANCELLED) {
            System.out.println("Order is already cancelled");
            return;
        }
        status = OrderStatus.CANCELLED;
        System.out.println("Order cancelled");
    }
}