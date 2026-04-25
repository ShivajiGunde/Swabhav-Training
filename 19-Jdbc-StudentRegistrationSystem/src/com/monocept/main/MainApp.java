package com.monocept.main;

import java.sql.SQLException;

import com.monocept.exception.StudentNotFoundException;

public class MainApp {
	
	public static void main(String[] args) throws SQLException, StudentNotFoundException {
		
		StudentManager app = new StudentManager();
		app.start();
	}

}
