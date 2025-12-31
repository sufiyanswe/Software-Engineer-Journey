# Order Management System (Core Java)

## Project Overview

This project is a **Core Java–based Order Management System** built to model how real backend systems handle **order lifecycles, state transitions, and business rules**.

The focus of this project is not CRUD operations, but **correct modeling of order states**, enforcing valid transitions, and preventing invalid actions through clean object-oriented design.

The system simulates how orders move through different stages such as creation, payment, shipping, delivery, and cancellation — exactly how real e‑commerce and logistics systems work.

---

## Key Learning Objectives

* Modeling real-world business workflows
* Designing stateful domain entities
* Enforcing business rules at the entity level
* Preventing invalid state transitions
* Separating orchestration logic from domain logic
* Writing clean, maintainable Core Java code

---

## Project Structure

The project follows a clean, package-oriented structure similar to real backend services:

```
com.ordermanagement
 ├── model
 │    ├── Order.java
 │    └── OrderStatus.java
 ├── service
 │    └── OrderService.java
 └── Main.java
```

---

## Core Components Explained

### OrderStatus (Enum)

`OrderStatus` represents the fixed set of valid states an order can have.

States included:

* CREATED
* PAID
* SHIPPED
* DELIVERED
* CANCELLED

**Why enum is used:**
Using an enum ensures type safety, prevents invalid states, and makes the order lifecycle explicit and self-documenting.

---

### Order (Domain Entity)

The `Order` class is the heart of the system. It represents a real-world order and **owns its state and lifecycle**.

Responsibilities:

* Maintains the current order status
* Enforces valid state transitions
* Rejects invalid operations

Key design decisions:

* No public setter for status
* All transitions happen through intent-revealing methods like `pay()`, `ship()`, `deliver()`, and `cancel()`
* Business rules are enforced inside the entity itself

This design ensures that the order can never enter an invalid state.

---

### OrderService (Orchestration Layer)

`OrderService` acts as a coordinator between the application and the domain entity.

Responsibilities:

* Exposes operations such as pay, ship, deliver, and cancel
* Delegates actual decision-making to the `Order` entity

Important design decision:
The service does **not** contain business rules or state transition logic. It simply coordinates actions.

---

### Main (Simulation Entry Point)

The `Main` class is used to simulate real order flows.

It demonstrates:

* Valid transitions (CREATED → PAID → SHIPPED → DELIVERED)
* Invalid transitions (shipping before payment, cancelling after delivery)

This helps verify that business rules are enforced correctly.

---

## Order Lifecycle Rules

The system enforces the following rules:

* An order must be **paid** before it can be shipped
* A shipped order cannot be cancelled
* A delivered order cannot be cancelled
* Invalid actions are rejected with clear messages

These rules are enforced automatically by the `Order` entity.

---

## Object-Oriented Principles Applied

* **Encapsulation**: Order state is private and modified only through controlled methods
* **Single Responsibility Principle**: Each class has one clear responsibility
* **Information Hiding**: Internal state transitions are hidden from external classes
* **Domain-Driven Design Thinking**: Business rules live with the domain entity

---

## How to Run the Project

1. Clone the repository
2. Open the project in a Java IDE (IntelliJ IDEA recommended)
3. Run the `Main` class
4. Observe valid and invalid order transitions in the console output

---

## Sample Output

```
Order cannot be shipped in status: CREATED
Order paid successfully
Order shipped
Order cannot be cancelled in status: SHIPPED
Order delivered
Delivered order cannot be cancelled
```

---

## Why This Project Matters

This project demonstrates **real backend engineering thinking** rather than basic Java practice. It shows how to model workflows, protect invariants, and design systems that are robust against invalid usage.

It reflects how production systems handle order processing and is a strong signal of backend fundamentals to recruiters.

---

## Future Enhancements

* Add refund and return workflows
* Integrate inventory management
* Add persistence layer (database)
* Introduce payment integration
* Add audit logging and timestamps

---

## Final Note

This project was intentionally built using **pure Core Java** to highlight strong fundamentals. The same design principles can later be extended to frameworks like Spring Boot with minimal changes.
