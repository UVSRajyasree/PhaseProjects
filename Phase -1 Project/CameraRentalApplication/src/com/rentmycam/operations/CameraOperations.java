package com.rentmycam.operations;

import java.util.List;
import java.util.Scanner;

import com.rentmycam.Camera;
import com.rentmycam.User;
import com.rentmycam.exceptions.InsufficientBalanceException;

public class CameraOperations {

	public static void listCameras(List<Camera> cameraList) {
		if(cameraList.isEmpty()) {
			System.out.println("NO DATA PRESENT AT THIS MOMENT. ");
		}else {
            // Display top border
            displayTableTop();

            // Display table header with borders
            System.out.printf("| %-12s | %-24s | %-24s | %-14s | %-14s |\n",
                    "CameraID", "Brand", "Model", "PerDayRent", "RentalStatus");

            // Display line between column headings and details
            displayTableHeaderSeparator();

            // Display camera details in table format with borders
            for (Camera camera : cameraList) {
                System.out.printf("| %-12d | %-23s | %-23s | %-13.2f | %-13s |\n",
                        camera.getCameraId(), camera.getBrand(), camera.getModel(),
                        camera.getPerDayRent(), camera.getRentalStatus());
            }

            // Display bottom border
            displayTableBottom();
        }
    }

	 public static void listAvailableCameras(List<Camera> cameraList) {
	        if (cameraList.isEmpty()) {
	            System.out.println("NO CAMERAS AVAILABLE FOR RENT. THE CAMERA LIST IS EMPTY.");
	        } else {
	            System.out.println("AVAILABLE CAMERAS:");
	            System.out.printf("| %-12s | %-24s | %-24s | %-14s |\n",
	                    "CameraID", "Brand", "Model", "PerDayRent");
	            System.out.println("+" + repeatChar('-', 13) + "+" + repeatChar('-', 25) + "+" +
	                               repeatChar('-', 25) + "+" + repeatChar('-', 15) + "+");

	            for (Camera camera : cameraList) {
	                if ("Available".equals(camera.getRentalStatus())) {
	                    System.out.printf("| %-12d | %-23s | %-23s | %-13.2f |\n",
	                            camera.getCameraId(), camera.getBrand(), camera.getModel(),
	                            camera.getPerDayRent());
	                }
	            }

	            System.out.println("+" + repeatChar('-', 13) + "+" + repeatChar('-', 25) + "+" +
	                               repeatChar('-', 25) + "+" + repeatChar('-', 15) + "+");
	        }
	    }
    private static void displayTableTop() {
        System.out.println("+" + repeatChar('-', 13) + "+" + repeatChar('-', 25) + "+" +
                           repeatChar('-', 25) + "+" + repeatChar('-', 15) + "+" +
                           repeatChar('-', 15) + "+");
    }

    private static void displayTableHeaderSeparator() {
        System.out.println("+" + repeatChar('-', 13) + "+" + repeatChar('-', 25) + "+" +
                           repeatChar('-', 25) + "+" + repeatChar('-', 15) + "+" +
                           repeatChar('-', 15) + "+");
    }

    private static void displayTableBottom() {
        System.out.println("+" + repeatChar('-', 13) + "+" + repeatChar('-', 25) + "+" +
                           repeatChar('-', 25) + "+" + repeatChar('-', 15) + "+" +
                           repeatChar('-', 15) + "+");
    }

    private static String repeatChar(char ch, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(ch);
        }
        return result.toString();
    }
//			else {
//            // Display table header
//            System.out.printf("%-10s%-20s%-20s%-15s%-15s\n", "CameraID", "Brand", "Model", "PerDayRent", "RentalStatus");
//
//            // Display camera details in table format
//            for (Camera camera : cameraList) {
//                System.out.printf("%-10d%-20s%-20s%-15.2f%-15s\n",
//                        camera.getCameraId(), camera.getBrand(), camera.getModel(),
//                        camera.getPerDayRent(), camera.getRentalStatus());
//				
//			}
			//Can Use This Else Block If We Don't Want Details In Table Format
			 //else {
	           // System.out.println("Available Cameras for Rent:");
	           // for (Camera camera : cameraList) {
	            //    System.out.println(camera.getCameraId() + ". "
	            //            + camera.getBrand() + " " + camera.getModel()
	            //            + " - $" + camera.getPerDayRent() + " per day (Status: " + camera.getRentalStatus() + ")");
	           // }
//		}
//	}
	
	public static boolean rentCamera(User user, Camera camera) throws InsufficientBalanceException {
		if (user.getMyCameras().contains(camera)) {
			System.out.println("YOU ALREADY RENTED THIS CAMERA.YOU CANNOT RENT IT AGAIN. ");
			return false;
		}
		
		if ("Rented".equals(camera.getRentalStatus())) {
            System.out.println("SORRY, THE CAMERA IS CURRENTLY RENTED BY ANOTHER USER.");
            return false;
        }
		if(user.getWalletBalance() < camera.getPerDayRent()) {
			throw new InsufficientBalanceException("Insufficient wallet amount. Please deposit funds.");
		}else {
			user.setWalletBalance(user.getWalletBalance() - camera.getPerDayRent());
			camera.setRentalStatus("Rented");
			user.addCamera(camera);
			System.out.println("CAMERA RENTED SUCCESSFULLY. INR " + camera.getPerDayRent() + " DEDUCTED FROM YOUR WALLET. ");
			return true;
		}
	}
	
	public static void viewWallet(User user) {
		System.out.println("CURRENT WALLET BALANCE: INR" + user.getWalletBalance());
	}
	
	public static void depositAmount(User user,double amount) {
		user.setWalletBalance(user.getWalletBalance() + amount);
		System.out.println("DEPOSIT OF INR " + amount + " SUCCESSFUL. CURRENT WALLET BALANCE : INR " + user.getWalletBalance());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
