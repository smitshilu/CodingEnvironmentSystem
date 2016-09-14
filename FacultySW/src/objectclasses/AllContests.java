package objectclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadAllContests;

public class AllContests {
	static List<Contest> allContests = new ArrayList<Contest>();

	public AllContests() {
		loadAllContests();
	}

	void loadAllContests() {
		LoadAllContests lc = new LoadAllContests();
		ResultSet rs = lc.loadAllContests();

		try {
			if (rs != null) {
				while (rs.next()) {
					Contest c = new Contest(rs.getString(3).replace("_colreg",
							""));
					allContests.add(c);
				}
			}
		} catch (SQLException e) {

		}

	}

	public static List<Contest> getAllContests() {
		return allContests;
	}

	public static void reload() throws SQLException {
		allContests = null;
		allContests = new ArrayList<Contest>();
		LoadAllContests lc = new LoadAllContests();
		ResultSet rs = lc.loadAllContests();
		if (rs != null) {
			while (rs.next()) {
				Contest c = new Contest(rs.getString(3).replace("_colreg", ""));
				allContests.add(c);
			}
		}

	}
}
