package com.invalidpassword.custom;

public class PasswordValidator {
	
public static void checkPassword(String pwd) throws InvalidPasswordException{
		
		if(pwd.length() < 8 || !pwd.matches(".*\\d.*")) {
			
			throw new InvalidPasswordException("Password length must be 8 character or least 1 digit");
		}
		
		System.out.println("password is valid");
	}

}
