package hcdb;

import java.sql.*;

public class Main {
	
	public static void main(String[] Args){
		
		// Connecting to Database
		String url = "jdbc:mysql://localhost:3306/Javabase";
		String username = "java";
		String password = "password";
	
		System.out.println("Connecting database...");
	
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
