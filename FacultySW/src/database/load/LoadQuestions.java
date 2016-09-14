package database.load;

import gui.CommonPackage.SettingsHash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objectclasses.Question;


public class LoadQuestions {
	
	ResultSet rs;
	List<Question> questions;

	public LoadQuestions(String tablename) {
		
		StringBuilder sb = new StringBuilder(tablename);
		sb.append("_colreg");
		tablename = sb.toString();
		try {
			questions = new ArrayList<Question>();
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ SettingsHash.getSetting("Host") + "/contest",
					SettingsHash.getSetting("DB username"),
					SettingsHash.getSetting("DB password"));

			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from " + tablename);

			while (rs.next()) {
				Question q1 = new Question();
				
				q1.setQ_name(rs.getString(1).replace("_colreg", ""));
				q1.setQ_qstn(rs.getString(2));
				q1.setQ_ip(rs.getString(3));
				q1.setQ_op(rs.getString(4));
				q1.setQ_cons(rs.getString(5));
				q1.setQ_ex(rs.getString(6));
				q1.setTest_ip(rs.getString(7));
				q1.setTest_op(rs.getString(8));
				questions.add(q1);
			}

			conn.close();
		} catch (Exception e) {
			rs = null;
			System.out.println(e.toString());
		}
	}

	public List<Question> loadAllQuestions() {
		return questions;

	}
}
