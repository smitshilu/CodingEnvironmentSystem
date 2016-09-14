package database.server.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoadTestIOP {

	List<String> iop;

	public LoadTestIOP(String tablename, String questionname) {
		StringBuilder sb=new StringBuilder(tablename);
		sb.append("_colreg");
		tablename=sb.toString();
		
		StringBuilder sb2=new StringBuilder(questionname);
		sb2.append("_colreg");
		questionname=sb2.toString();
		try {			
			iop = new ArrayList<String>();
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select TestInputs, TestOutputs from "
							+ tablename + " where Problemcode='" + questionname
							+ "'");

			while (rs.next()) {

				iop.add(rs.getString(1));
				iop.add(rs.getString(2));
			}

			conn.close();
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

	public List<String> loadAllQuestions() {
		return iop;

	}
}
