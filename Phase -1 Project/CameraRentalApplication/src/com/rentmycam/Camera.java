package com.rentmycam;

import java.util.ArrayList;
import java.util.List;

public class Camera {
    //To Automatically Increment CameraId
	private static int nextCameraId = 1;
	//Creating Camera Rent Details
	private int cameraId;
	private String brand;
	private String model;
	private double perDayRent;
	private String rentalStatus;
	
	//Creating Constructors
	public Camera(String brand, String model, double perDayRent) {
		this.cameraId = nextCameraId++;
		this.brand = brand;
		this.model = model;
		this.perDayRent = perDayRent;
		this.rentalStatus = "Available";
	}

    //Getter Methods
	public int getCameraId() {
		return cameraId;
	}


	public String getBrand() {
		return brand;
	}


	public String getModel() {
		return model;
	}


	public double getPerDayRent() {
		return perDayRent;
	}


	public String getRentalStatus() {
		return rentalStatus;
	}

    //Setter Method For RentalStatus
	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
