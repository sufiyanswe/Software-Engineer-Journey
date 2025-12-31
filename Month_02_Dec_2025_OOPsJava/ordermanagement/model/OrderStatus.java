package ordermanagement.model;

/**
 * OrderStatus enum
 * ----------------
 * Represents the possible states of an Order in the order management system.
 * Lifecycle:
 * - CREATED   → Initial state when the order is placed.
 * - PAID      → Order has been paid successfully.
 * - SHIPPED   → Order has been shipped to the customer.
 * - DELIVERED → Order has been delivered to the customer.
 * - CANCELLED → Order has been cancelled (before delivery).

 * This enum is used by the Order class to enforce valid state transitions.
 */
public enum OrderStatus {
    CREATED,    // Order is created but not yet paid
    PAID,       // Order has been paid
    SHIPPED,    // Order has been shipped
    DELIVERED,  // Order has been delivered
    CANCELLED   // Order has been cancelled
}