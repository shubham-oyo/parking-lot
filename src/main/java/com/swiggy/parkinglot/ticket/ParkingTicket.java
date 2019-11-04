package com.swiggy.parkinglot.ticket;

import com.swiggy.parkinglot.util.RandomIdGenerator;

import java.util.Date;

public class ParkingTicket {
	private String id;
	private String registrationNo;
	private Date entryTime;
	private Integer parkingSlotId;
	private Integer floorNo;

	public ParkingTicket(String registrationNo, Date entryTime, Integer parkingSlotNo, Integer floorNo) {
		this.id = RandomIdGenerator.getId();
		this.registrationNo = registrationNo;
		this.entryTime = entryTime;
		this.parkingSlotId = parkingSlotNo;
		this.floorNo = floorNo;
	}

	public Integer getParkingSlotId() {
		return parkingSlotId;
	}

	@Override
	public String toString() {
		return "ParkingTicket{" +
				"id='" + id + '\'' +
				", registrationNo='" + registrationNo + '\'' +
				", entryTime=" + entryTime +
				", parkingSlotId=" + parkingSlotId +
				", floorNo=" + floorNo +
				'}';
	}
}
