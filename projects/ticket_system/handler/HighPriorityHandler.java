package handler;

import model.Ticket;

public class HighPriorityHandler extends SupportHandler {
    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getPriority() == Ticket.Priority.HIGH) {
            if (!assignToAvailableAgent(ticket)) {
                System.out.println("No available agent for HIGH priority.");
            }
        } else {
            System.out.println("Unhandled ticket priority: " + ticket.getPriority());
        }
    }
}
