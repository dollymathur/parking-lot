package com.example.parkinglot.model;

import java.util.List;

public class ParkingLot {
    int id;
    int numberOfFloors;
    List<Floor> floors;

    public ParkingLot(int id, int numberOfFloors, List<Floor> floors) {
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.floors = floors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void updateSlotStatus(int floorNumber, int slotNumber, boolean status) {
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                for (Slot slot : floor.getSlots()) {
                    if (slot.getSlotNumber() == slotNumber) {
                        slot.setOccupied(status);
                    }
                }
            }
        }
    }

    public void updateSlotCount(int floorNumber, int slotNumber, int count) {
        floors.get(floorNumber).setTotalSlots(count);
    }
}
