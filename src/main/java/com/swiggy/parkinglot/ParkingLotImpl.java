package com.swiggy.parkinglot;

import com.swiggy.parkinglot.exception.ParkingFullException;
import com.swiggy.parkinglot.slot.ParkingSlot;
import com.swiggy.parkinglot.ticket.ParkingTicket;
import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.*;

public class ParkingLotImpl extends ParkingLot {

	protected ParkingLotImpl(Map<Integer, ParkingSlot> parkingSlots, Address address) {
		super(parkingSlots, address);
	}

	@Override
	public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
		if (isFull()) {
			throw new ParkingFullException("Sorry, parking lot is full");
		}
		Integer parkingSlotId = getNearestParkingSlot();
		ParkingSlot parkingSlot = getParkingSlots().get(parkingSlotId);
		ParkingTicket parkingTicket = new ParkingTicket(vehicle.getRegistrationNo(), new Date(), parkingSlot.getId(), parkingSlot.getFloorNo());
		addToOccupiedSlots(parkingSlot.getId(), vehicle);
		System.out.println(parkingTicket);
		return parkingTicket;
	}

	@Override
	public synchronized void exit(Integer slotId) {
		this.removeFromOccupiedSlots(slotId);
		this.addToAvailableSlots(slotId);
		System.out.println("Slot " + slotId + " is freed.");
	}

	@Override
	public Map<ParkingSlot, Vehicle> getAllocatedSlots() {
		Map<ParkingSlot, Vehicle> allocatedSlots = new HashMap<>();
		for (Map.Entry<Integer, Vehicle> allocatedSlot: getOccupiedSlots().entrySet()) {
			allocatedSlots.put(getParkingSlots().get(allocatedSlot.getKey()), allocatedSlot.getValue());
		}
		return allocatedSlots;
	}

	@Override
	public List<ParkingSlot> getAvailableSlots() {
		List<ParkingSlot> availableSlotList = new ArrayList<>();
		for (Integer slotId: getFreeSlots()) {
			availableSlotList.add(getParkingSlots().get(slotId));
		}
		return availableSlotList;
	}

	private Integer getNearestParkingSlot() {
		if (this.getFreeSlots().size() > 0) {
			return this.getFreeSlots().poll();
		} else {
			throw new ParkingFullException();
		}
	}

}
