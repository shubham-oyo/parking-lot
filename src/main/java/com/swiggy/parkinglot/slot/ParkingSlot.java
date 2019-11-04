package com.swiggy.parkinglot.slot;

public class ParkingSlot {
	private Integer id;
	private Integer floorNo;

	public ParkingSlot(Integer id, Integer floorNo) {
		this.id = id;
		this.floorNo = floorNo;
	}

	public Integer getId() {
		return id;
	}

	public Integer getFloorNo() {
		return floorNo;
	}
}
