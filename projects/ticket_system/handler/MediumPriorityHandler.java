package handler;

import model.Ticket;

public class MediumPriorityHandler extends SupportHandler {
    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getPriority() == Ticket.Priority.MEDIUM) {
            if (!assignToAvailableAgent(ticket)) {
                System.out.println("No available agent for MEDIUM priority.");
            }
        } else if (next != null) {
            next.handleTicket(ticket);
        }
    }
}
