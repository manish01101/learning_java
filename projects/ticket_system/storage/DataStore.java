package storage;

import model.Agent;
import model.Ticket;

import java.util.*;

public class DataStore {
    private static final List<Agent> agents = new ArrayList<>();
    private static final List<Ticket> tickets = new ArrayList<>();

    static {
        agents.add(new Agent("Alice"));
        agents.add(new Agent("Bob"));
        agents.add(new Agent("Charlie"));
    }

    public static boolean assignAgent(Ticket ticket) {
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                agent.assignTicket();
                ticket.assignAgent(agent.getName());
                return true;
            }
        }
        return false;
    }

    public static void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static List<Agent> getAgents() {
        return agents;
    }
}
