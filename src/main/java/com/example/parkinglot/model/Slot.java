package com.example.parkinglot.model;

public class Slot {
    int slotNumber;
    VehicleType vehicleType;
    boolean isOccupied;
    int floorNumber;

    public Slot(int slotNumber, VehicleType vehicleType, boolean isOccupied, int floorNumber) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
        this.floorNumber = floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setSlotType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
