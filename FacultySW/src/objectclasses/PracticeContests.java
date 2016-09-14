package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadPracticeContests;

public class PracticeContests {

	static List<String> practiceContests = new ArrayList<String>();

	public PracticeContests() throws SQLException {
		practiceContests=null;
		practiceContests=new ArrayList<String>();
		LoadPracticeContests lc = new LoadPracticeContests();
		practiceContests = lc.loadAllContests();
	}

	public static List<String> getPracticeContests() {
		return practiceContests;
	}

	
	
	public static void reload() throws SQLException
	{
		practiceContests=null;
		practiceContests=new ArrayList<String>();
		LoadPracticeContests lc = new LoadPracticeContests();
		practiceContests = lc.loadAllContests();
	}

}
