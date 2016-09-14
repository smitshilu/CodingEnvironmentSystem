package database.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objectclasses.Question;

public class LoadSpecificQuestion {

	ResultSet rs;
	List<Question> questions;

	public LoadSpecificQuestion(String tablename, String qcode, String username) {

		StringBuilder sb = new StringBuilder(tablename);
		sb.append("_colreg");
		tablename = sb.toString();

		StringBuilder sb2 = new StringBuilder(qcode);
		sb2.append("_colreg");
		qcode = sb2.toString();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://"
					+ SettingsHash.getSetting("Host") + "/resultofcontest",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			Statement stmt1 = con.createStatement();		
			stmt1.executeUpdate("INSERT IGNORE INTO `"+tablename+"` SET `ID` = '"+username+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			questions = new ArrayList<Question>();
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://"
					+ SettingsHash.getSetting("Host") + "/contest",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			Statement stmt = conn.createStatement();

			if (qcode == null) {
				rs = stmt.executeQuery("select * from " + tablename);
			} else {
				rs = stmt.executeQuery("select * from " + tablename
						+ " where Problemcode='" + qcode + "'");
			}
			while (rs.next()) {
				Question q1 = new Question();

				q1.setQ_name(rs.getString(1).replace("_colreg", ""));
				q1.setQ_qstn(rs.getString(2));
				q1.setQ_ip(rs.getString(3));
				q1.setQ_op(rs.getString(4));
				q1.setQ_cons(rs.getString(5));
				q1.setQ_ex(rs.getString(6));

				questions.add(q1);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Question> loadAllQuestions() {
		return questions;

	}
}
