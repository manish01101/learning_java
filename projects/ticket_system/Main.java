import model.Ticket;
import service.TicketService;
import storage.DataStore;

import java.util.Scanner;

public class Main {

  private static final TicketService service = new TicketService();

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      runMenu(sc);
    }
  }

  private static void runMenu(Scanner sc) {
    while (true) {
      System.out.println("\n=== Customer Support Ticket System ===");
      System.out.println("1. Create Ticket");
      System.out.println("2. View Tickets");
      System.out.println("3. View Agents");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      switch (sc.nextInt()) {
        case 1 -> handleCreateTicket(sc);
        case 2 -> handleViewTickets();
        case 3 -> handleViewAgents();
        case 4 -> {
          System.out.println("Exiting... Goodbye!");
          System.exit(0);
        }
        default -> System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private static void handleCreateTicket(Scanner sc) {
    sc.nextLine(); // consume leftover newline
    System.out.print("Customer Name: ");
    String name = sc.nextLine();

    System.out.print("Issue Description: ");
    String desc = sc.nextLine();

    System.out.print("Priority (LOW, MEDIUM, HIGH): ");
    String input = sc.nextLine().trim().toUpperCase();

    try {
      Ticket.Priority priority = Ticket.Priority.valueOf(input);
      service.createTicket(name, desc, priority);
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid priority. Please enter LOW, MEDIUM, or HIGH.");
    }
  }

  private static void handleViewTickets() {
    if (DataStore.getTickets().isEmpty()) {
      System.out.println("No tickets available.");
    } else {
      DataStore.getTickets().forEach(System.out::println);
    }
  }

  private static void handleViewAgents() {
    if (DataStore.getAgents().isEmpty()) {
      System.out.println("No agents available.");
    } else {
      DataStore.getAgents().forEach(System.out::println);
    }
  }
}
