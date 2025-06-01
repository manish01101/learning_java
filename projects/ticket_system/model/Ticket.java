package model;

public class Ticket {
    private static int counter = 1;
    private final int id;
    private final String customerName;
    private final String description;
    private final Priority priority;
    private String assignedAgent;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Ticket(String customerName, String description, Priority priority) {
        this.id = counter++;
        this.customerName = customerName;
        this.description = description;
        this.priority = priority;
        this.assignedAgent = "Unassigned";
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAssignedAgent() {
        return assignedAgent;
    }

    public void assignAgent(String agentName) {
        this.assignedAgent = agentName;
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d [%s] - %s | Assigned to: %s",
                id, priority, description, assignedAgent);
    }
}
