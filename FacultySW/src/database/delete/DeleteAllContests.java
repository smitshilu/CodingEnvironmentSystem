package database.delete;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteAllContests {

	public DeleteAllContests() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		Statement stmt = conn.createStatement();

		String dropdb = "DROP DATABASE contest";

		stmt.executeUpdate(dropdb);

		dropdb = "DROP DATABASE onlinecontests";

		stmt.executeUpdate(dropdb);
		
		dropdb = "DROP DATABASE testcontests";

		stmt.executeUpdate(dropdb);
		
		dropdb = "DROP DATABASE practicecontests";

		stmt.executeUpdate(dropdb);

		dropdb = "DROP DATABASE resultofcontest";

		stmt.executeUpdate(dropdb);

		conn.close();

	}

}
