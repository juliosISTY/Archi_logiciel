package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	
	public static Connection Connect() {
		Connection cn=null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			cn=DriverManager.getConnection("jdbc:sqlite:Bddarchi.db");
			System.out.println("Connection reussite!");
		} catch (ClassNotFoundException | SQLException e) {
		
			System.out.println(e+"");
		}
		
		return cn;
	}

}
