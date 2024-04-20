package com.example.parkinglot.service;

import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;

public interface SlotFinder {

    Slot findSlot(Vehicle vehicle);

}
