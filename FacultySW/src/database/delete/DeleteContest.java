package database.delete;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteContest {

	public DeleteContest(String ContestName) throws Exception {

		StringBuilder sb=new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName=sb.toString();
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String sql = "DROP TABLE " + ContestName;

		stmt.executeUpdate(sql);

		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/onlineContests", "root", "");
		stmt = conn.createStatement();
		String droptable = "drop table " + ContestName;
		try {
			stmt.executeUpdate(droptable);
		} catch (Exception e) {

		}
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/practicecontests", "root", "");
		stmt = conn.createStatement();
		droptable = "drop table " + ContestName;
		try {
			stmt.executeUpdate(droptable);
		} catch (Exception e) {

		}
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/testcontests", "root", "");
		stmt = conn.createStatement();
		droptable = "drop table " + ContestName;
		try {
			stmt.executeUpdate(droptable);
		} catch (Exception e) {

		}
		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/resultofcontest", "root", "");
		stmt = conn.createStatement();
		droptable = "drop table " + ContestName;

		stmt.executeUpdate(droptable);

		conn.close();

	}

}
