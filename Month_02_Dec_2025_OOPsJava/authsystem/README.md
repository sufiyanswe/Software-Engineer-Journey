# Authentication System (Core Java)

## Project Overview

This project is a **Core Java–based Authentication System** designed using real-world backend engineering principles. The purpose of this project is not to demonstrate basic Java syntax, but to showcase **clean object-oriented design**, **separation of concerns**, and **extensibility using interfaces**.

The system simulates a realistic authentication flow where users can log in using different authentication strategies. The current version supports **password-based authentication**, and the architecture allows new authentication methods to be added without modifying existing core logic.

The project is intentionally built **without frameworks** (Spring, Hibernate, etc.) to demonstrate strong fundamentals.

---

## Key Design Goals

* Loose coupling between authentication logic and application flow
* Clear separation of responsibilities
* Extensible design using interfaces
* Proper encapsulation of user state
* Realistic business rules (failed attempts, account lock)

---

## Project Structure

The project follows a clean, package-based structure similar to real backend services:

```
com.authsystem
 ├── model
 │    └── User.java
 ├── auth
 │    ├── AuthStrategy.java
 │    └── PasswordAuth.java
 ├── service
 │    └── AuthService.java
 └── Main.java
```

---

## Core Components Explained

### User (Domain Model)

The `User` class represents the core domain entity. It is responsible only for holding and managing **user-related state**.

**Responsibilities:**

* Stores user credentials and state
* Tracks failed login attempts
* Maintains account lock status

**Design decision:**
The `User` class does **not** perform authentication. This ensures that business rules and authentication logic remain separate.

---

### AuthStrategy (Interface)

`AuthStrategy` defines a contract for all authentication mechanisms.

**Responsibility:**

* Defines what it means to authenticate a user

**Why an interface is used:**
Authentication methods change frequently in real systems (password, OTP, biometric, third-party login). Using an interface keeps the system stable while allowing new authentication strategies to be added.

---

### PasswordAuth (Authentication Strategy)

`PasswordAuth` is a concrete implementation of `AuthStrategy`.

**Responsibilities:**

* Verifies user credentials
* Updates failed login attempts
* Locks the account after multiple failures

**Design decision:**
`PasswordAuth` contains only authentication logic. It does not handle output or application flow.

---

### AuthService (Orchestrator)

`AuthService` coordinates the authentication process.

**Responsibilities:**

* Initiates authentication
* Interprets authentication results
* Controls user-facing outcomes

**Design decision:**
`AuthService` depends only on the `AuthStrategy` interface, not on concrete implementations. This enables easy extension and maintainability.

---

## Authentication Flow

1. A `User` object is created
2. An `AuthStrategy` implementation is selected
3. `AuthService` receives the strategy via constructor injection
4. `AuthService` calls `authenticate()`
5. Based on the result, success or failure is handled

User state (failed attempts and account lock status) persists across authentication attempts.

---

## Object-Oriented Principles Applied

* **Encapsulation**: User state is private and modified only through methods
* **Abstraction**: Authentication logic is abstracted using an interface
* **Polymorphism**: Authentication strategies can be swapped at runtime
* **Single Responsibility Principle**: Each class has one clear responsibility
* **Open/Closed Principle**: New authentication methods can be added without modifying existing code

---

## How to Run the Project

1. Clone the repository
2. Open the project in any Java IDE (IntelliJ IDEA recommended)
3. Run the `Main` class
4. Observe authentication attempts and account lock behavior

---

## Sample Output

```
Invalid credentials
Invalid credentials
Account is locked. Please contact support.
```

---

## Future Improvements

* Add OTP-based authentication
* Add biometric or third-party authentication
* Persist user data using a database
* Add password hashing
* Add role-based authorization

---

## Why This Project Matters

This project demonstrates **real backend engineering thinking** rather than basic Java practice. It focuses on **design, extensibility, and maintainability**.
