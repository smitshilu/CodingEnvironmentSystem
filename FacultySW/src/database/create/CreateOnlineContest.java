package database.create;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateOnlineContest {

	public CreateOnlineContest(String ContestName) {
		
		StringBuilder sb=new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName=sb.toString();
		
		ContestName=ContestName.replace(' ', '_');
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));

			Statement stmt = conn.createStatement();

			String sql = "CREATE DATABASE IF NOT EXISTS onlineContests";
			stmt.executeUpdate(sql);

			conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/onlineContests", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
			stmt = conn.createStatement();
			String querytomaketable = "create table " + ContestName
					+ " (ID VARCHAR(50))";

			stmt.executeUpdate(querytomaketable);

			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
