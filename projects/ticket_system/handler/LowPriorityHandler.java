package handler;

import model.Ticket;

public class LowPriorityHandler extends SupportHandler {
    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getPriority() == Ticket.Priority.LOW) {
            if (!assignToAvailableAgent(ticket)) {
                System.out.println("No available agent for LOW priority.");
            }
        } else if (next != null) {
            next.handleTicket(ticket);
        }
    }
}
