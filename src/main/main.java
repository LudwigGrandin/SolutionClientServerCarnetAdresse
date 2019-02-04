package main;

import java.sql.DriverManager;
import java.sql.SQLException;

import lp.dip.CarnetAdresse.ServeurSocketTCP;

import java.sql.Connection;

public class main {

	public static void main(String[] args) {
		try {
			ServeurSocketTCP serveur = new ServeurSocketTCP();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
