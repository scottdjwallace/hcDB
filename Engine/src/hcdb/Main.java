package hcdb;

import java.sql.*;

public class Main {
	
	public static void main(String[] Args){
		
		Database db = new Database();
		ResultSet rs = db.execute("SELECT * FROM cards");
		db.disconnect();
		

	}

}
