package database.delete;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteQuestion {

	public DeleteQuestion(String ContestName, String problemcode)
			throws Exception {
		StringBuilder sb = new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName = sb.toString();

		StringBuilder sb2 = new StringBuilder(problemcode);
		sb2.append("_colreg");
		problemcode = sb2.toString();

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ SettingsHash.getSetting("Host") + "/contest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String sql = "DELETE FROM " + ContestName + " WHERE Problemcode='"
				+ problemcode + "'";

		stmt.executeUpdate(sql);

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + SettingsHash.getSetting("Host")
						+ "/resultofcontest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));
		stmt = conn.createStatement();

		sql = "ALTER TABLE " + ContestName + " DROP COLUMN " + problemcode;

		stmt.executeUpdate(sql);

		sql = "ALTER TABLE " + ContestName + " DROP COLUMN " + problemcode
				+ "_result";

		stmt.executeUpdate(sql);

		conn.close();

	}

}
