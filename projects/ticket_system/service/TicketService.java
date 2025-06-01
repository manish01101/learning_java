package service;

import model.Ticket;
import storage.DataStore;
import handler.*;

public class TicketService {
    private final SupportHandler handlerChain;

    public TicketService() {
        // Set up Chain of Responsibility
        SupportHandler low = new LowPriorityHandler();
        SupportHandler medium = new MediumPriorityHandler();
        SupportHandler high = new HighPriorityHandler();

        low.setNext(medium);
        medium.setNext(high);

        this.handlerChain = low;
    }

    public void createTicket(String customerName, String description, Ticket.Priority priority) {
        Ticket ticket = new Ticket(customerName, description, priority);
        handlerChain.handleTicket(ticket);
        DataStore.addTicket(ticket);

        System.out.println("Ticket created successfully!");
        System.out.println(ticket);
    }
}
