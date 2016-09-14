package database.create;

import gui.CommonPackage.SettingsHash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateQuestion {
	int i = 0;

	public CreateQuestion(String contestName, String problemcode,
			String question, String constraints, String inputs, String outputs,
			String examples, String test_inputs, String test_outputs)
			throws IOException, ClassNotFoundException, SQLException {

		StringBuilder sb = new StringBuilder(problemcode);
		sb.append("_colreg");
		problemcode = sb.toString();

		StringBuilder sb2 = new StringBuilder(contestName);
		sb2.append("_colreg");
		contestName = sb2.toString();

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ SettingsHash.getSetting("Host") + "/contest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		String querytoinsert = "insert into " + contestName + " VALUES('"
				+ problemcode + "','" + question + "','" + constraints + "','"
				+ inputs + "','" + outputs + "','" + examples + "','"
				+ test_inputs + "','" + test_outputs + "')";

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(querytoinsert);

		conn.close();

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + SettingsHash.getSetting("Host")
						+ "/resultofcontest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		String querytoaddcolumn = "alter table " + contestName + " ADD "
				+ problemcode + " TIMESTAMP DEFAULT 0 after ID, ADD "
				+ problemcode
				+ "_result VARCHAR(255) DEFAULT 'still not uploaded' after ID";

		Statement stmt1 = conn.createStatement();
		stmt1.executeUpdate(querytoaddcolumn);

		conn.close();

	}

}
