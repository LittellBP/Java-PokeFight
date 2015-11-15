import java.sql.*;
import java.util.Random;

import javax.swing.*;

public class Connect {
	static Connection con = null;
	static Statement stmt = null;
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "*", "*");
			con.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public static void listAll(JComboBox display) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "*", "*");
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select Name from Pokemon");
			while (rs.next()) {
				display.addItem(rs.getString("Name"));
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public static Pokemon getPokemon(JComboBox select) {
		Pokemon result;
		int hp = 0;
		int atk = 0;
		int def = 0;
		int spatk = 0;
		int spdef = 0;
		int spd = 0;
		String choice = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "*", "*");
			stmt = con.createStatement();

			choice = select.getSelectedItem().toString();

			ResultSet rs = stmt
					.executeQuery("select * from Pokemon where Name = '"
							+ choice + "';");
			if (rs.next()) {
				hp = Integer.parseInt(rs.getString("Hp"));
				atk = Integer.parseInt(rs.getString("Atk"));
				def = Integer.parseInt(rs.getString("Def"));
				spatk = Integer.parseInt(rs.getString("Spatk"));
				spdef = Integer.parseInt(rs.getString("Spdef"));
				spd = Integer.parseInt(rs.getString("Spd"));
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		result = new Pokemon(choice, hp, atk, def, spatk, spdef, spd);
		return result;
	}

	public static Pokemon getComp(JComboBox select) {
		Pokemon result;
		String name = null;
		int hp = 0;
		int atk = 0;
		int def = 0;
		int spatk = 0;
		int spdef = 0;
		int spd = 0;
		Random random = new Random();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb", "*", "*YowaneYuuka!3");
			stmt = con.createStatement();

			int id = random.nextInt(124) + 1;

			ResultSet rs = stmt
					.executeQuery("select * from Pokemon where id = '" + id
							+ "';");
			if (rs.next()) {
				name = rs.getString("Name");
				hp = Integer.parseInt(rs.getString("Hp"));
				atk = Integer.parseInt(rs.getString("Atk"));
				def = Integer.parseInt(rs.getString("Def"));
				spatk = Integer.parseInt(rs.getString("Spatk"));
				spdef = Integer.parseInt(rs.getString("Spdef"));
				spd = Integer.parseInt(rs.getString("Spd"));
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		result = new Pokemon(name, hp, atk, def, spatk, spdef, spd);
		return result;
	}
}
