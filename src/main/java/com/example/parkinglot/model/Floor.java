package com.example.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorNumber;
    int totalSlots;
    List<Slot> slots;

    public Floor(int floorNumber, int totalSlots) {
        this.floorNumber = floorNumber;
        this.totalSlots = totalSlots;
        this.slots = initializeFloor(floorNumber, totalSlots);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> initializeFloor(int floorNumber, int numberOfSlotsPerFloor) {
        List<Slot> slots = new ArrayList<>();
        if (numberOfSlotsPerFloor > 0) {
            slots.add(new Slot(1, VehicleType.TRUCK, false, floorNumber));
            numberOfSlotsPerFloor--;
        }

        if (numberOfSlotsPerFloor > 0) {
            slots.add(new Slot(2, VehicleType.BIKE, false, floorNumber));
            numberOfSlotsPerFloor--;
        }

        if (numberOfSlotsPerFloor > 0) {
            slots.add(new Slot(3, VehicleType.BIKE, false, floorNumber));
            numberOfSlotsPerFloor--;
        }

        if (numberOfSlotsPerFloor > 0) {
            for (int i = 0; i < numberOfSlotsPerFloor; i++) {
                slots.add(new Slot(i + 4, VehicleType.CAR, false, floorNumber));
            }
        }

        return slots;
    }
}
