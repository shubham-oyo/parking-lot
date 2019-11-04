package com.swiggy.parkinglot;

import com.swiggy.parkinglot.exception.ParkingFullException;
import com.swiggy.parkinglot.slot.ParkingSlot;
import com.swiggy.parkinglot.ticket.ParkingTicket;
import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.*;

public abstract class ParkingLot {
	private Map<Integer, ParkingSlot> parkingSlots;
	private Address address;
	private PriorityQueue<Integer> freeSlots;
	private Map<Integer, Vehicle> occupiedSlots;

	public abstract ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException;
	public abstract void exit(Integer slotId);
	public abstract Map<ParkingSlot, Vehicle> getAllocatedSlots();
	public abstract List<ParkingSlot> getAvailableSlots();

	protected ParkingLot(Map<Integer, ParkingSlot> parkingSlots, Address address) {
		this.parkingSlots = parkingSlots;
		this.address = address;
		this.freeSlots = new PriorityQueue<>();
		for (Map.Entry<Integer, ParkingSlot> parkingSlot: parkingSlots.entrySet()) {
			freeSlots.add(parkingSlot.getKey());
		}
		this.occupiedSlots = new HashMap<>();
	}

	public boolean isFull() {
		return freeSlots.size() == 0;
	}

	protected void addToOccupiedSlots(Integer slotId, Vehicle vehicle) {
		occupiedSlots.put(slotId, vehicle);
	}

	protected void removeFromOccupiedSlots(Integer slotId) {
		occupiedSlots.remove(slotId);
	}

	protected void addToAvailableSlots(Integer slotId) {
		freeSlots.add(slotId);
	}

	protected Map<Integer, ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	protected PriorityQueue<Integer> getFreeSlots() {
		return freeSlots;
	}

	protected Map<Integer, Vehicle> getOccupiedSlots() {
		return occupiedSlots;
	}
}
