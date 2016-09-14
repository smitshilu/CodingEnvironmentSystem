package database.server.update;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateResult {

	public UpdateResult(String contestname, String questionname,
			String username, String result) throws Exception {
		//System.out.println("reached updateresult");
		StringBuilder sb = new StringBuilder(contestname);
		sb.append("_colreg");
		contestname = sb.toString();

		StringBuilder sb2 = new StringBuilder(questionname);
		sb2.append("_colreg");
		questionname = sb2.toString();

		Connection conn = null;

		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + SettingsHash.getSetting("Host")
						+ "/resultofcontest",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		// String sqll = "INSERT IGNORE INTO " + contestname + "(ID) VALUES('"
		// + username + "')";
		// Statement ss = conn.createStatement();
		// ss.executeUpdate(sqll);

		String sql = "";
		Statement s = conn.createStatement();

		//
		Date d = new Date();
		String dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

		sql = "UPDATE " + contestname + " SET " + questionname + "='" + dd
				+ "'," + questionname + "_result = '" + result + "' WHERE ID='"
				+ username + "'";
		s = conn.createStatement();
		s.executeUpdate(sql);
		//

		// new
		conn = DriverManager
				.getConnection(
						"jdbc:mysql://"
								+ SettingsHash.getSetting("Host")
								+ "/resultofcontest?zeroDateTimeBehavior=convertToNull",
						SettingsHash.getSetting("DB username"),
						SettingsHash.getSetting("DB password"));

		s = conn.createStatement();
		sql = "select * from `" + contestname + "` where `ID`='" + username
				+ "'";
		ResultSet rs = s.executeQuery(sql);
		ResultSetMetaData rsm = rs.getMetaData();

		int i = 2;
		int answer = 0;
		while (rs.next()) {
			while (!rsm.getColumnLabel(i).equals("TotalAccepted")) {
			//	System.out.println(rs.getString(i));
				if (rs.getString(i).equals("accepted")) {
					answer++;
				}
				i += 2;
			}
		}

	//	System.out.println(answer);

		String sqll = "UPDATE `" + contestname + "` SET TotalAccepted='"
				+ answer + "' WHERE `ID`='" + username + "'";
		s.executeUpdate(sqll);

	}
}
