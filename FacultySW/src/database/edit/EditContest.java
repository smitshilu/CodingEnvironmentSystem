package database.edit;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EditContest {

	public EditContest(String oldName, String ContestName) throws Exception {
		StringBuilder sb = new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName = sb.toString();
		StringBuilder sb2 = new StringBuilder(oldName);
		sb2.append("_colreg");
		oldName = sb2.toString();
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String sql = "RENAME TABLE " + oldName + " TO " + ContestName;
		stmt.executeUpdate(sql);
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/onlinecontests", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
			stmt = conn.createStatement();
			sql = "RENAME TABLE " + oldName + " TO " + ContestName;
			stmt.executeUpdate(sql);

		} catch (Exception e) {

		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/testcontests", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
			stmt = conn.createStatement();
			sql = "RENAME TABLE " + oldName + " TO " + ContestName;
			stmt.executeUpdate(sql);

		} catch (Exception e) {

		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/practicecontests", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
			stmt = conn.createStatement();
			sql = "RENAME TABLE " + oldName + " TO " + ContestName;
			stmt.executeUpdate(sql);

		} catch (Exception e) {

		}
		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/resultofcontest", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
		stmt = conn.createStatement();
		sql = "RENAME TABLE " + oldName + " TO " + ContestName;
		stmt.executeUpdate(sql);

		conn.close();

	}
}
