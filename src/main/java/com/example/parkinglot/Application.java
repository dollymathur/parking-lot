package com.example.parkinglot;

import com.example.parkinglot.model.*;
import com.example.parkinglot.service.FirstEmptySlotFinder;
import com.example.parkinglot.service.ParkingLotManager;
import com.example.parkinglot.service.SlotFinder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {

	static ParkingLotManager parkingLotManager = new ParkingLotManager();
	static ParkingLot parkingLot;

	static SlotFinder firstEmptySlotFinder;

	public static void main(String[] args) {
		// Question - https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8

		// create_parking_lot 1234 2 5
		// display free_count CAR
		// park_vehicle CAR KA-01-DB-1234 black
		// park_vehicle CAR KA-02-CB-1334 red
		// park_vehicle CAR KA-01-DB-1133 black
		// park_vehicle CAR KA-05-HJ-8432 white
		// park_vehicle CAR WB-45-HO-9032 white
		// unpark_vehicle 1
		// unpark_vehicle 2
		// display free_count CAR
		// display free_count BIKE
		// park_vehicle BIKE KA-01-DB-1541 black
		// park_vehicle CAR KA-21-HS-2347 red
		// display free_slots CAR
		// display free_slots BIKE

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String[] commands = scanner.nextLine().split(" ");
			if (Objects.equals(commands[0], "create_parking_lot")) {
				int parkingLotId = Integer.parseInt(commands[1]);
				int numberOfFloors = Integer.parseInt(commands[2]);
				int numberOfSlotsPerFloors = Integer.parseInt(commands[3]);
				parkingLot = parkingLotManager.addParkingLot(parkingLotId, numberOfFloors, numberOfSlotsPerFloors);
				Booking booking = new Booking(new ArrayList<>());
				firstEmptySlotFinder = new FirstEmptySlotFinder(parkingLot);
				parkingLotManager = new ParkingLotManager(parkingLot, firstEmptySlotFinder, booking);
				System.out.println("Parking lot created with id:" + parkingLot.getId());
			}
			if (Objects.equals(commands[0], "park_vehicle")) {
				String vehicleType = commands[1];
				String registrationNumber = commands[2];
				String color = commands[3];

				Vehicle vehicle = new Vehicle(VehicleType.valueOf(vehicleType), registrationNumber, color);
				Ticket ticket = parkingLotManager.parkVehicle(vehicle);

			}
			if (Objects.equals(commands[0], "unpark_vehicle")) {
				int ticketId = Integer.parseInt(commands[1]);
				parkingLotManager.unparkVehicle(ticketId);
			}
			if (Objects.equals(commands[0], "display")) {
				String displayType = commands[1];
				String vehicleType = commands[2];

				if (Objects.equals(displayType, "free_count")) {
					parkingLotManager.getEmptySlotCount(VehicleType.valueOf(vehicleType));
				} else if (Objects.equals(displayType, "free_slots")) {
					parkingLotManager.displayEmptySlots(VehicleType.valueOf(vehicleType));
				} else if (Objects.equals(displayType, "occupied_slots")) {
					parkingLotManager.displayOccupiedSlots(VehicleType.valueOf(vehicleType));
				}
			}
		}
	}

}
