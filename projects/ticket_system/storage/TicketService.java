package storage;

import model.Ticket;
import handler.*;

public class TicketService {
    private final SupportHandler handlerChain;

    public TicketService() {
        SupportHandler low = new LowPriorityHandler();
        SupportHandler medium = new MediumPriorityHandler();
        SupportHandler high = new HighPriorityHandler();

        low.setNext(medium);
        medium.setNext(high);

        this.handlerChain = low;
    }

    public void createTicket(String name, String desc, Ticket.Priority priority) {
        Ticket ticket = new Ticket(name, desc, priority);
        handlerChain.handleTicket(ticket);
        DataStore.addTicket(ticket);
    }
}
