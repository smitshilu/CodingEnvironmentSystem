package database.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoadLeaderboard {

	StringBuilder names;
	ArrayList<String> name = new ArrayList<String>();

	public LoadLeaderboard(String contestname, String question)
			throws ClassNotFoundException, SQLException {

		StringBuilder sb = new StringBuilder(contestname);
		sb.append("_colreg");
		contestname = sb.toString();
		
		//System.out.println("side322"+question);

		String sql = "select * from " + contestname
				+ " ORDER BY TotalAccepted DESC";

		if (!question.equals("TotalAccepted")) {
			StringBuilder sb2 = new StringBuilder(question);
			sb2.append("_colreg");
			question = sb2.toString();
			
			sql = "select * from " + contestname + " ORDER BY " + question
					+ " ASC";
		
			//System.out.println("side2:"+sql);
			
		}

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ SettingsHash.getSetting("Host")
				+ "/resultofcontest?zeroDateTimeBehavior=convertToNull",
				SettingsHash.getSetting("DB username"),
				SettingsHash.getSetting("DB password"));

		names = new StringBuilder();

		Statement s = conn.createStatement();

		ResultSet rs = s.executeQuery(sql);
		ResultSetMetaData rsm = rs.getMetaData();
		int i = rsm.getColumnCount();
		int x = 0;

		while (x++ < i) {
			names.append(rsm.getColumnLabel(x).replace("_colreg", ""));
			names.append("____");
		}

		name.add(names.toString());

		while (rs.next()) {
			int j = 0;
			while (j++ < i) {
				names.append(rs.getString(j));
				names.append("____");
			}
			name.add(names.toString());
		}

		@SuppressWarnings("unused")
		Object[] sre = name.toArray();
	}

	public ArrayList<String> loadNames() {
		return name;
	}

}
