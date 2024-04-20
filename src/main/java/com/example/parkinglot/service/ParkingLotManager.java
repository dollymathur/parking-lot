package com.example.parkinglot.service;

import com.example.parkinglot.model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

    ParkingLot parkingLot;
    SlotFinder slotFinder;
    Booking booking;
    int bookingCount = 0;

    public ParkingLotManager() {
    }

    public ParkingLotManager(ParkingLot parkingLot, SlotFinder slotFinder, Booking booking) {
        this.parkingLot = parkingLot;
        this.slotFinder = slotFinder;
        this.booking = booking;
    }

    public ParkingLot addParkingLot(int parkingLotId, int numberOfFloors, int numberOfSlotsPerFloor) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            floors.add(new Floor(i, numberOfSlotsPerFloor));
        }

        return new ParkingLot(parkingLotId, numberOfFloors, floors);

    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Slot slot = slotFinder.findSlot(vehicle);
        if (slot == null) {
            return null;
        }
        Ticket ticket = new Ticket(bookingCount + 1, vehicle, slot);
        slot.setOccupied(true);
        bookingCount++;
        booking.addTicket(ticket);
        parkingLot.updateSlotStatus(slot.getFloorNumber(), slot.getSlotNumber(), true);
        int slotCount = parkingLot.getFloors().get(slot.getFloorNumber()).getTotalSlots();
        parkingLot.updateSlotCount(slot.getFloorNumber(), slot.getSlotNumber(), slotCount - 1);
        System.out.println("Vehicle " + slot.getVehicleType() + " parked at floor: " + slot.getFloorNumber() + " slot: " + slot.getSlotNumber());
        System.out.println("ticket no.:" + ticket.getTicketId());
        return ticket;
    }

    public void unparkVehicle(int ticketId) {
        Ticket ticket = booking.getTicketFromId(ticketId);
        Slot slot = ticket.getSlot();
        slot.setOccupied(false);
        booking.removeTicket(ticket);
        parkingLot.updateSlotStatus(slot.getFloorNumber(), slot.getSlotNumber(), false);
        int slotCount = parkingLot.getFloors().get(slot.getFloorNumber()).getTotalSlots();
        parkingLot.updateSlotCount(slot.getFloorNumber(), slot.getSlotNumber(), slotCount + 1);
        System.out.println("Vehicle unparked at floor: " + slot.getFloorNumber() + " slot: " + slot.getSlotNumber());
    }

    public void displayEmptySlots(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getFloors().size(); i++) {
            for (int j = 0; j < parkingLot.getFloors().get(i).getSlots().size(); j++) {
                if (!parkingLot.getFloors().get(i).getSlots().get(j).isOccupied() &&
                        parkingLot.getFloors().get(i).getSlots().get(j).getVehicleType().equals(vehicleType)) {
                    System.out.println("Empty slot for " + vehicleType + " found at floor: " + i + " slot: " + parkingLot.getFloors().get(i).getSlots().get(j).getSlotNumber());
                }
            }
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getFloors().size(); i++) {
            for (int j = 0; j < parkingLot.getFloors().get(i).getSlots().size(); j++) {
                if (parkingLot.getFloors().get(i).getSlots().get(j).isOccupied() &&
                        parkingLot.getFloors().get(i).getSlots().get(j).getVehicleType().equals(vehicleType)) {
                    System.out.println("Occupied slot for " + vehicleType + " found at floor: " + i + " slot: " + parkingLot.getFloors().get(i).getSlots().get(j).getSlotNumber());
                }
            }
        }
    }

    public void getEmptySlotCount(VehicleType vehicleType) {
        for (int i = 0; i < parkingLot.getFloors().size(); i++) {
            int emptySlotCount = 0;
            for (int j = 0; j < parkingLot.getFloors().get(i).getSlots().size(); j++) {
                if (!parkingLot.getFloors().get(i).getSlots().get(j).isOccupied() &&
                        parkingLot.getFloors().get(i).getSlots().get(j).getVehicleType().equals(vehicleType)) {
                    emptySlotCount++;
                }
            }
            System.out.println("Empty slots at floor: " + i + " are: " + emptySlotCount);
        }
    }

}
