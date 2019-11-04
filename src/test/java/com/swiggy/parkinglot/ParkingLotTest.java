package com.swiggy.parkinglot;

import com.swiggy.parkinglot.exception.ParkingFullException;
import com.swiggy.parkinglot.ticket.ParkingTicket;
import com.swiggy.parkinglot.vehicle.Color;
import com.swiggy.parkinglot.vehicle.Vehicle;

public class ParkingLotTest {
	public static void main(String[] args) {
		try {
			ParkingLot parkingLot = ParkingLotFactory.createParkingLot(100);
			Vehicle vehicle1 = new Vehicle("asd", Color.BLACK);
			ParkingTicket parkingTicket1 = parkingLot.getNewParkingTicket(vehicle1);
			Vehicle vehicle2 = new Vehicle("rewr", Color.BLACK);
			ParkingTicket parkingTicket2 = parkingLot.getNewParkingTicket(vehicle2);
			parkingLot.exit(1);
			Vehicle vehicle3 = new Vehicle("qwe", Color.BLACK);
			ParkingTicket parkingTicket3 = parkingLot.getNewParkingTicket(vehicle3);
		} catch (ParkingFullException e) {
			System.out.println(e.getMessage());
		}
	}
}
