package handler;

import model.Ticket;
import storage.DataStore;

public abstract class SupportHandler {
    protected SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handleTicket(Ticket ticket);

    protected boolean assignToAvailableAgent(Ticket ticket) {
        return DataStore.assignAgent(ticket);
    }
}
