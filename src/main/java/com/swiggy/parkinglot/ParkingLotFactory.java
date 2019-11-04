package com.swiggy.parkinglot;

import com.swiggy.parkinglot.slot.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotFactory {

	public static ParkingLot createParkingLot(int totalSlots) {
		Map<Integer, ParkingSlot> parkingSlots = createDummyParkingSlots(totalSlots);
		ParkingLot parkingLot = new ParkingLotImpl(parkingSlots, new Address(12.12, 12.12));
		return parkingLot;
	}

	private static Map<Integer, ParkingSlot> createDummyParkingSlots(int num) {
		Map<Integer, ParkingSlot> parkingSlots = new HashMap<>();
		for (int i = 0; i < num; i++) {
			parkingSlots.putIfAbsent(i+1, new ParkingSlot(i+1, 1));
		}
		return parkingSlots;
	}

}
