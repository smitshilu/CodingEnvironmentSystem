package database.login;

import gui.CommonPackage.SettingsHash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerLogin {

	boolean ret = false;

	public boolean Log_in(String Username, String Password)
			throws SQLException, IOException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ SettingsHash.getSetting("Host") + "/",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String sql = "CREATE DATABASE IF NOT EXISTS login";
		stmt.executeUpdate(sql);

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + SettingsHash.getSetting("Host") + "/login",
				"root", "");
		stmt = conn.createStatement();
		String query = "select * from moderator_login where Username = '"
				+ Username + "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String pass = rs.getString("Password");
			String username = rs.getString("Username");

			if (pass.equals(Password) && username.equals(Username)) {

				ret = true;
			}
		}

		conn.close();
		return ret;
	}

}
