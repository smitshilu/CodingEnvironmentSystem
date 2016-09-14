package database.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoadOnlineContests {
	ResultSet rs;
	List<String> onlineContests = new ArrayList<String>();

	public LoadOnlineContests() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://"
					+ SettingsHash.getSetting("Host") + "/",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			Statement stmt = conn.createStatement();

			String sql = "CREATE DATABASE IF NOT EXISTS onlineContests";
			stmt.executeUpdate(sql);

			conn = DriverManager.getConnection(
					"jdbc:mysql://" + SettingsHash.getSetting("Host")
							+ "/onlineContests",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			DatabaseMetaData md = conn.getMetaData();
			rs = md.getTables(null, null, "%", null);

			conn.close();
		} catch (Exception e) {
			rs = null;
		}
	}

	public List<String> loadAllContests() throws SQLException {
		while (rs.next()) {
			onlineContests.add(rs.getString(3).replace("_colreg", ""));
		}
		return onlineContests;

	}
}
