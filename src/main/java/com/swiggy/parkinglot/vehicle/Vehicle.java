package com.swiggy.parkinglot.vehicle;

public class Vehicle {
	private String registrationNo;
	private Color color;

	public Vehicle(String registrationNo, Color color) {
		this.registrationNo = registrationNo;
		this.color = color;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

}
