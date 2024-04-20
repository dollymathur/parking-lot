package com.example.parkinglot.model;

public class Ticket {
    int ticketId;
    Vehicle vehicle;
    Slot slot;

    public Ticket(int ticketId, Vehicle vehicle, Slot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
