package main;

import java.sql.DriverManager;
import java.sql.Connection;

public class main {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//java.sql.Connection = DriverManager.getConnection("127.0.0.1", "rt", "rtlry");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
