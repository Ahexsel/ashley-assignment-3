package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {
	

		public User[] readFile(String fileName) {
			
			User[] users = new User[4];
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				int i = 0; 
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] myUserInfo = line.split(",");
					String username = myUserInfo[0];
					String password = myUserInfo[1];
					String name = myUserInfo[2];
					User user = createUser(username, password, name);
					users[i] = user;
					
					i++;
					
				
				}
				
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			return users;
			}
		
		public User createUser (String username, String password, String name) {
			return new User(username, password, name);
			
		}
			

	public void userLogin() throws Exception {
		
		int maxAttempts = 5;
		int attempts = 0;
		Scanner scanner = new Scanner(System.in);	
		UserApplication userApplication = new UserApplication();
		User[] users = userApplication.readFile("data.txt");
		User validatedUser = null;
		
		while (attempts < maxAttempts) {
			  		
			System.out.println("Enter username: ");
			String enteredUsername = scanner.nextLine();
			System.out.println("Enter password: ");
			String enteredPassword = scanner.nextLine();
			
	
			validatedUser = validateUser(users, enteredUsername, enteredPassword);
			if(validatedUser != null) {
				System.out.println("Welcome" + validatedUser.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again");
				attempts++;		
			}
			
			if (attempts == 5 && validatedUser == null) {
				System.out.println("Too many failed login atempts, you are now locked out.");
			}
		}
		
		scanner.close();
		
		}
		
		
		public User validateUser(User[] users, String enteredUsername, String enteredPassword) {
			for (User user : users) {
					if (enteredUsername.equalsIgnoreCase(user.getUsername()) && enteredPassword.equalsIgnoreCase(user.getPassword())) {
					return user;
				}
					
			}

				return null;	
				
			}
			 
		}
	
