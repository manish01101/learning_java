# Customer Support Ticket System (Java, Console-based)

A console-based Customer Support Ticket System developed in Java, demonstrating solid **OOP principles**, the **Chain of Responsibility** design pattern, and usage of the **Java Collections Framework** for in-memory ticket and agent management.

---

## Features

- Create customer support tickets with priority levels (LOW, MEDIUM, HIGH)
- Route tickets dynamically based on priority using Chain of Responsibility pattern
- Assign available agents to tickets automatically
- View all created tickets and agents
- Clean object-oriented design with modular packages
- In-memory data storage using Java Collections

---

## Project Structure
ticket_system
  - Main.java
  - model
    - Agent.java
    - Ticket.java
  - handler
    - SupportHandler.java
    - LowPriorityHandler.java
    - MediumPriorityHandler.java
    - HighPriorityHandler.java
  - service
    - TicketService.java
  - storage
    - DataStore.java


---

## Getting Started

### Requirements

- Java 17+ (or any version compatible with your Java SDK)
- Terminal or console to run the program

### Compile and Run

**Step 1: Compile**

```bash
javac Main.java
```
**Step 2: Run**
```bash
java Main
```

### Example Usage
=== Customer Support Ticket System ===
1. Create Ticket
2. View Tickets
3. View Agents
4. Exit
Choose an option: 1

Customer Name: your_name
Issue Description: Login error
Priority (LOW, MEDIUM, HIGH): high

Ticket created successfully!
Ticket{id=1, customerName='customer_name', priority=HIGH, assignedAgent=Agent{id=3, name='Charlie'}}
