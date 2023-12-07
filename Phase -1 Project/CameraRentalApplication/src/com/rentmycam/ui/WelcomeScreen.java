package com.rentmycam.ui;

import java.util.Scanner;

public class WelcomeScreen {
    //Default UserName
	private static final String DEFAULT_USERNAME = "Rajyasree12345";
	private static final String DEFAULT_PASSWORD = "123456789";
	
	//Welcome Message Displayed On Screen
	public static String login() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("+------------------------------------+");
		System.out.println("|    WELCOME TO CAMERA RENTAL APP    |");
		System.out.println("+------------------------------------+");
		
		System.out.println("PLEASE LOGIN TO CONTINUE - ");
		//Enter Username
		System.out.println("USERNAME -  ");
		String username = scanner.nextLine();
		//Enter Password
		System.out.println("PASSWORD - ");
        String password = scanner.nextLine();
		//If New User Ask To Create New Username
		if(DEFAULT_USERNAME.equals(username)) {
			System.out.println("WELCOME BACK, " + DEFAULT_USERNAME + "!");
		}else {
			System.out.println("NEW USER DETECTED. PLEASE CREATE A NEW USERNAME. ");
			System.out.print("ENTER NEW USERNAME: " );
			String newUsername = scanner.nextLine();
		    System.out.println("NEW USERNAME CREATED: ");
		    System.out.print("ENTER YOUR NEW PASSWORD: ");
            String newPassword = scanner.nextLine();
            System.out.println("NEW PASSWORD CREATED FOR USER: " + username);
			return newUsername;			
		}
		return DEFAULT_USERNAME;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
