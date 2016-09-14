package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadOnlineContests;

public class OnlineContests {

	static List<String> onlineContests = new ArrayList<String>();

	public static List<String> getOnlineContests() {
		return onlineContests;
	}

	public static void setOnlineContests(List<String> contests) {
		for (String s : contests) {
			onlineContests.add(s);
		}
	}
	
	public static void reload() throws SQLException
	{
		onlineContests=null;
		onlineContests=new ArrayList<String>();
		LoadOnlineContests lc = new LoadOnlineContests();
		onlineContests = lc.loadAllContests();
	}
}
