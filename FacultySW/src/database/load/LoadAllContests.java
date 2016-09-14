package database.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class LoadAllContests {
	ResultSet rs;

	public LoadAllContests() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			DatabaseMetaData md = conn.getMetaData();
			rs = md.getTables(null, null, "%", null);

			conn.close();
		} catch (Exception e) {
			rs = null;
		}
	}

	public ResultSet loadAllContests() {
		return rs;

	}

}
