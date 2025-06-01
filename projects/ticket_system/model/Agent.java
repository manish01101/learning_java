package model;

public class Agent {
  private final String name;
  private boolean available = true;

  public Agent(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isAvailable() {
    return available;
  }

  public void assignTicket() {
    this.available = false;
  }

  public void resolveTicket() {
    this.available = true;
  }

  @Override
  public String toString() {
    return name + (available ? " (Available)" : " (Busy)");
  }
}
