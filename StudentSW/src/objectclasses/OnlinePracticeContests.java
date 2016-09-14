package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadPracticeContests;

public class OnlinePracticeContests {

	static List<String> onlinePracticeContests = new ArrayList<String>();

	public static List<String> getOnlinePracticeContests() {
		return onlinePracticeContests;
	}

	public static void setOnlinePracticeContests(List<String> contests) {
		for (String s : contests) {
			onlinePracticeContests.add(s);
		}
	}

	public static void reload() throws SQLException
	{
		onlinePracticeContests=null;
		onlinePracticeContests=new ArrayList<String>();
		LoadPracticeContests lc = new LoadPracticeContests();
		onlinePracticeContests = lc.loadAllContests();
	}

}
