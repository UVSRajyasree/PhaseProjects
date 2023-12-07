package com.rentmycam;

import java.util.ArrayList;
import java.util.List;

public class User {
    //User Details For Their Camera
	double walletBalance;
	List<Camera> myCameras;
	
	//Constructors
	public User(double walletBalance) {
		this.walletBalance = walletBalance;
		this.myCameras = new ArrayList<>();
	}

    //Getter Methods
	public double getWalletBalance() {
		return walletBalance;
	}

    //Setter Methods
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

   //To List All Cameras In Their Personal Account
	public List<Camera> getMyCameras() {
		return myCameras;
	}

    //User Can Add The Camera In Their Account
	public void addCamera(Camera camera) {
		myCameras.add(camera);
	}

	//User Can Remove The Camera In Their Account
	public void removeCamera(Camera camera) {
		 myCameras.remove(camera);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
