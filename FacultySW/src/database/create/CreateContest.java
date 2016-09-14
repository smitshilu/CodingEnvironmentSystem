package database.create;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateContest {

	public CreateContest(String ContestName) throws Exception {

		StringBuilder sb=new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName=sb.toString();
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String sql = "CREATE DATABASE IF NOT EXISTS contest";
		stmt.executeUpdate(sql);

		conn = DriverManager.getConnection("jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest",
				SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
		stmt = conn.createStatement();
		String querytomaketable = "create table "
				+ ContestName
				+ " (Problemcode VARCHAR(30) PRIMARY KEY NOT NULL,Question TEXT(25000),Constraints TEXT(10000),Inputs TEXT(10000),Outputs TEXT(10000),Examples TEXT(20000),TestInputs TEXT(10000),TestOutputs TEXT(10000))";

		stmt.executeUpdate(querytomaketable);

		conn.close();

		conn = DriverManager.getConnection("jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/", "root",
				"");

		stmt = conn.createStatement();

		sql = "CREATE DATABASE IF NOT EXISTS resultofcontest";
		stmt.executeUpdate(sql);

		conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/resultofcontest", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
		stmt = conn.createStatement();
		String querytomakeresult = "create table "
				+ ContestName
				+ " (ID VARCHAR(10) PRIMARY KEY,TotalAccepted INTEGER DEFAULT 0)";

		stmt.executeUpdate(querytomakeresult);

		conn.close();

	}

}
