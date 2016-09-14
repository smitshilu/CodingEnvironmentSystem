package database.delete;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteOnlineContest {

	public DeleteOnlineContest(String ContestName) {
		StringBuilder sb=new StringBuilder(ContestName);
		sb.append("_colreg");
		ContestName=sb.toString();
		ContestName=ContestName.replace(' ', '_');
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/onlineContests", SettingsHash.getSetting("DB username"), SettingsHash.getSetting("DB password"));
			Statement stmt = conn.createStatement();
			String querytomaketable = "drop table " + ContestName;

			stmt.executeUpdate(querytomaketable);

			conn.close();

		} catch (Exception e) {

		}
	}
}
