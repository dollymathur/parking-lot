package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;

public class FirstEmptySlotFinder implements SlotFinder{

    ParkingLot parkingLot;

    public FirstEmptySlotFinder(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public Slot findSlot(Vehicle vehicle) {

        for (int i = 0; i < parkingLot.getFloors().size(); i++) {
            for (int j = 0; j < parkingLot.getFloors().get(i).getSlots().size(); j++) {
                if (!parkingLot.getFloors().get(i).getSlots().get(j).isOccupied() &&
                        parkingLot.getFloors().get(i).getSlots().get(j).getVehicleType().equals(vehicle.getVehicleType())) {
                    return parkingLot.getFloors().get(i).getSlots().get(j);
                }
            }
        }

        System.out.println("No empty slot found for vehicle type: " + vehicle.getVehicleType());
        return null;
    }
}
