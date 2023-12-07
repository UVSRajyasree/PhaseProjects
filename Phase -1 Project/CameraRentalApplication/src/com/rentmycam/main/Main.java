package com.rentmycam.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rentmycam.Camera;
import com.rentmycam.User;
import com.rentmycam.exceptions.InsufficientBalanceException;
import com.rentmycam.operations.CameraOperations;
import com.rentmycam.ui.WelcomeScreen;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String username = WelcomeScreen.login();
		
		//Intialize User And Camera Data
		User user = new User(100.0);
		List<Camera> cameraList = new ArrayList<>();
		cameraList.add(new Camera("Panasonic", "LUMIC DC ZS80D", 100));
		cameraList.add(new Camera("Sony", "RX10 IV", 1000));
		cameraList.add(new Camera("Panasonic", "LUMIX DC FZ1000M2", 2000));
		cameraList.add(new Camera("Nikon", "D850", 1000));
		cameraList.add(new Camera("Canon", "EOS R8", 500));
		cameraList.add(new Camera("Fuji", "GFX 100S", 600));
		cameraList.add(new Camera("GoPro", "HERO 11", 500));
		cameraList.add(new Camera("Ricoh", "THETA SC2 4K ", 700));
		cameraList.add(new Camera("Yashica", "MF 2", 800));
		cameraList.add(new Camera("Olympus", "TG 6", 900));
		
		//Display Welcome Message
		System.out.println("Welcome, " + username + "!");
		
		//Handle User Interactions
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. VIEW ALL CAMERAS");
			System.out.println("2. RENT A CAMERA");
			System.out.println("3. VIEW WALLET BALANCE");
			System.out.println("4. DEPOSIT MONEY");
			System.out.println("5. MY CAMERAS");
			System.out.println("6. NAVIGATE TO MAIN SCREEN");
			System.out.println("7. CLOSE APPLICATION");
			System.out.println("Enter your choice: ");
			
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume The New Line Character
			
			switch (choice) {
			case 1:
				CameraOperations.listCameras(cameraList);
				break;
			case 2:
				CameraOperations.listAvailableCameras(cameraList);
				handleRentCamera(scanner, user, cameraList);
				break;
			case 3:
				CameraOperations.viewWallet(user);
				System.out.println("IF YOU WANT TO DEPOSIT MORE MONEY, PLEASE CLICK 4 AND DEPOSIT ");
				break;
			case 4: 
				System.out.println("ENTER THE AMOUNT TO DEPOSIT: INR");
				double depositAmount = scanner.nextDouble();
				CameraOperations.depositAmount(user,  depositAmount);
				break;
			case 5:
				handleMyCamerasSubMenu(scanner, user);
				break;
			case 6:
				//Logic To Navigate To The Main Screen
				returnToWelcomeScreen(scanner);
				break;
			case 7: 
				System.out.println("CLOSING THE APPLICATION. HAVE A NICE DAY");
				break;
			default:
				System.out.println("INVALID CHOIVE. PLEASE ENTER A VALID OPTION. ");
			}
		}while(choice != 7);
	}

	private static void handleMyCamerasSubMenu(Scanner scanner, User user) {
        int myCamerasChoice;
        do {
            System.out.println("\nMY CAMERAS:");
            System.out.println("1. ADD CAMERA");
            System.out.println("2. REMOVE CAMERA");
            System.out.println("3. VIEW MY CAMERAS");
            System.out.println("4. GO TO PREVIOUS MENU");
            System.out.print("ENTER YOUR CHOICE: ");

            myCamerasChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (myCamerasChoice) {
                case 1:
                    handleAddCamera(scanner, user);
                    break;
                case 2:
                    handleRemoveCamera(scanner, user);
                    break;
                case 3:
                    CameraOperations.listCameras(user.getMyCameras());
                    break;
                case 4:
                    System.out.println("RETURNING TO THE MAIN MENU.");
                    break;
                default:
                    System.out.println("INVALID CHOICE. PLEASE ENTER A VALID OPTION.");
            }
        } while (myCamerasChoice != 4);
	}
	
	private static void returnToWelcomeScreen(Scanner scanner) {
        System.out.println("Returning to the main welcome screen...");
        WelcomeScreen.login();  // Call the login method to display the welcome screen
    }

	private static void handleAddCamera(Scanner scanner, User user) {
	    //scanner.nextLine(); // Consume the newline character from the previous input

	    System.out.print("ENTER CAMERA BRAND: ");
	    String brand = scanner.nextLine();
	    System.out.print("ENTER CAMERA MODEL: ");
	    String model = scanner.nextLine();  // Read the camera model as a string

	    System.out.print("ENTER PER-DAY RENT AMOUNT: INR");
	    double perDayRent = scanner.nextDouble();

	    Camera newCamera = new Camera(brand, model, perDayRent);
	    user.addCamera(newCamera);

	    System.out.println("YOUR CAMERA HAS BEEN SUCCESFULLY ADDED TO THE LIST: " + brand + " " + model);
	}
    private static void handleRemoveCamera(Scanner scanner, User user) {
        if (user.getMyCameras().isEmpty()) {
            System.out.println("NO CAMERAS TO REMOVE. YOUR CAMERA COLLECTION IS EMPTY.");
        } else {
            CameraOperations.listCameras(user.getMyCameras());
            System.out.print("ENTER THE CAMERA ID TO REMOVE: ");
            int cameraIdToRemove = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            boolean removed = false;
            for (Camera camera : user.getMyCameras()) {
                if (camera.getCameraId() == cameraIdToRemove) {
                    user.removeCamera(camera);
                    System.out.println("CAMERA REMOVED SUCCESSFULLY: " + camera.getBrand() + " " + camera.getModel());
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                System.out.println("CAMERA NOT FOUND. PLEASE ENTER A VALID CAMERA ID.");
            }
        }
    }
    private static void handleRentCamera(Scanner scanner, User user, List<Camera> cameraList) {
        System.out.print("ENTER THE CAMERA ID TO RENT: ");
        int cameraIdToRent = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Find the camera with the specified Camera ID
        Camera selectedCamera = null;
        for (Camera camera : cameraList) {
            if (camera.getCameraId() == cameraIdToRent && "Available".equals(camera.getRentalStatus())) {
                selectedCamera = camera;
                break;
            }
        }

        if (selectedCamera != null) {
        	//Check if the user has sufficient balance
        	double rentalAmount = selectedCamera.getPerDayRent();
        	if(user.getWalletBalance() >= rentalAmount) {
        		//Deduct the rental amount from the User's Wallet
        		user.setWalletBalance(user.getWalletBalance() - rentalAmount);
        //Update the rentalStatus of the selected Camera to "Rented"
        	selectedCamera.setRentalStatus("Rented");
        
       //Add the rented camera to the user's camera list
        	user.addCamera(selectedCamera);
        	
        	System.out.println("CAMERA RENTED SUCCESSFULLY: " + selectedCamera.getBrand() + " " + selectedCamera.getModel());
        	System.out.println("WALLET BALANCE AFTER RENTAL INR: " + user.getWalletBalance());
        	
        } else {
        	System.out.println("INSUFFICIENT BALANCE CANNOT RENT THE CAMERA.");
        }
    }else {
            System.out.println("INVALID CAMERA ID OR THE CAMERA IS NOT AVAILABLE FOR RENT.");
        }
    }
}
