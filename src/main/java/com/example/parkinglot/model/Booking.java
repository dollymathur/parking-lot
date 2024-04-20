package com.example.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    List<Ticket> tickets;

    public Booking(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        List<Ticket> localTickets = new ArrayList<>();
        localTickets.add(ticket);
        localTickets.addAll(this.tickets);
        setTickets(localTickets);
    }

    public void removeTicket(Ticket ticket) {
        this.tickets = tickets.stream()
                .filter(ticket1 -> ticket1.getTicketId() != ticket.getTicketId())
                .toList();
    }

    public Ticket getTicketFromId(int ticketId) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketId() == ticketId)
                .findFirst()
                .orElse(null);
    }
}
