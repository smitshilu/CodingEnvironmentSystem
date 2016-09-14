package database.edit;

import gui.CommonPackage.SettingsHash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditQuestion {
	int i = 0;

	public EditQuestion(String contestName, String oldproblemcode,
			String problemcode, String question, String constraints,
			String inputs, String outputs, String examples, String test_input,
			String test_output) throws IOException, ClassNotFoundException,
			SQLException {
		StringBuilder sb = new StringBuilder(contestName);
		sb.append("_colreg");
		contestName = sb.toString();
		StringBuilder sb2 = new StringBuilder(oldproblemcode);
		sb2.append("_colreg");
		oldproblemcode = sb2.toString();
		StringBuilder sb3 = new StringBuilder(problemcode);
		sb3.append("_colreg");
		problemcode = sb3.toString();
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ SettingsHash.getSetting("Host") + "/contest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		String updatequery = "UPDATE " + contestName + " SET Problemcode='"
				+ problemcode + "', Question='" + question + "', Constraints='"
				+ constraints + "', Inputs='" + inputs + "', Outputs='"
				+ outputs + "', Examples='" + examples + "', TestInputs='"
				+ test_input + "', TestOutputs='" + test_output
				+ "' WHERE Problemcode='" + oldproblemcode + "'";

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(updatequery);

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + SettingsHash.getSetting("Host")
						+ "/resultofcontest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		updatequery = "ALTER TABLE  "
				+ contestName
				+ " CHANGE "
				+ oldproblemcode
				+ "_result "
				+ problemcode
				+ "_result VARCHAR(255) NULL DEFAULT 'still not uploaded', CHANGE "
				+ oldproblemcode + " " + problemcode
				+ " TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'";

		stmt = conn.createStatement();
		stmt.executeUpdate(updatequery);
		conn.close();

	}

}
