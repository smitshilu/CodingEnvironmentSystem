package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadTestContests;

public class OnlineTestContests {

	static List<String> onlineTestContests = new ArrayList<String>();

	public static List<String> getOnlineTestContests() {
		return onlineTestContests;
	}

	public static void setOnlineTestContests(List<String> contests) {
		for (String s : contests) {
			onlineTestContests.add(s);
		}
	}
	
	public static void reload() throws SQLException
	{
		onlineTestContests=null;
		onlineTestContests=new ArrayList<String>();
		LoadTestContests lc = new LoadTestContests();
		onlineTestContests = lc.loadAllContests();
	}
}
