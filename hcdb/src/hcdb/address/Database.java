package hcdb.address;

import java.sql.*;

import hcdb.address.model.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
	
	public static String URL = "jdbc:mysql://localhost:3306/hcdatabase";
	public static String USERNAME = "java";
	public static String PASSWORD = "password";
	public static Connection conn;
	
	public static ObservableList<Card> selectAllCards() {
		
		ObservableList<Card> cards = FXCollections.observableArrayList();
		//cards.add(new Card("Sidney Crosby", "Upper Deck", "Young Guns", 2005, 200,true,"autograph"));
		
		System.out.println("Connecting database...");
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    System.out.println("Database connected!");
		    
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM cards");
			while (rs.next()) {
		    	String playerName = rs.getString("player_name");
		    	String company = rs.getString("card_company");
		    	String series = rs.getString("card_series");
		    	int season = rs.getInt("season");
		    	int value = rs.getInt("approx_value");
		    	boolean rookie = rs.getBoolean("rookie");
		    	boolean autograph = rs.getBoolean("autograph");
		    	boolean jersey = rs.getBoolean("jersey");
		    	boolean equipment = rs.getBoolean("equipment");
		    	
		    	String memorabilia = "";
		    	if (autograph && jersey && equipment) {
		    		memorabilia = "Autograph, Jersey, Equipment";
		    	}
		    	else if (autograph && jersey && !equipment) {
		    		memorabilia = "Autograph, Jersey";
		    	}
		    	else if (autograph && !jersey && equipment) {
		    		memorabilia = "Autograph, Equipment";
				}
		    	else if (!autograph && jersey && equipment) {
		    		memorabilia = "Jersey, Equipment";
		    	}
		    	else if (autograph && !jersey && !equipment) {
		    		memorabilia = "Autograph";
		    	}
		    	else if (!autograph && jersey && !equipment) {
		    		memorabilia = "Jersey";
		    	}
		    	else if (!autograph && !jersey && equipment) {
		    		memorabilia = "Equipment";
		    	}
		    	else {
		    		memorabilia = "None";
		    	}
		    	cards.add(new Card(playerName, company, series, season, value, rookie,memorabilia));
		    }
		    stmt.close();
			conn.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		return cards;
	}

	public static void addCard(String playerName, String company, String series, int season, int value, boolean rookie, String memorabilia) {
		
	}

	public static void updateCard(String playerName, String company, String series, int season, int value, boolean rookie, String memorabilia) {
		
	}

	public static void deleteCard(String playerName, String company, String series, int season, int value, boolean rookie, String memorabilia) {
		
	}
}