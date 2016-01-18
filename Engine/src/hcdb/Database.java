package hcdb;

import java.sql.*;

public class Database {
	
	private final String URL = "jdbc:mysql://localhost:3306/hcdatabase";
	private final String USERNAME = "java";
	private final String PASSWORD = "password";
	private Connection conn;
	
	// Constructor
	public Database() {
		// Connecting to Database
		System.out.println("Connecting database...");
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public ResultSet execute(String query){
	    try {
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
		    	String id = rs.getString("player_name");
		    	System.out.println(id);
		    }
			
			// use the data from resultSet
			// then
		    //stmt.close();
			

		    return rs;
	    } catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute SQL query!", e);
		}	
	}
	

	
			
	public void disconnect(){
		try {
			conn.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot disconnect from the database!", e);
		}
	}


}
