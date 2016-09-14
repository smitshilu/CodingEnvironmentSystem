package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadTestContests;

public class TestContests {

	static List<String> testContests = new ArrayList<String>();

	public TestContests() throws SQLException {
		testContests = null;
		testContests = new ArrayList<String>();
		LoadTestContests lc = new LoadTestContests();
		testContests = lc.loadAllContests();
	}

	public static List<String> getTestContests() {
		return testContests;
	}

	
	
	public static void reload() throws SQLException {
		testContests = null;
		testContests = new ArrayList<String>();
		LoadTestContests lc = new LoadTestContests();
		testContests = lc.loadAllContests();
	}

}
