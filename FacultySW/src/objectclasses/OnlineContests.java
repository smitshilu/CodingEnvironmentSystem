package objectclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.load.LoadOnlineContests;

public class OnlineContests {

	static List<String> onlineContests = new ArrayList<String>();

	public OnlineContests() throws SQLException {
		onlineContests=null;
		onlineContests=new ArrayList<String>();
		LoadOnlineContests lc = new LoadOnlineContests();
		onlineContests = lc.loadAllContests();
	}

	public static List<String> getOnlineContests() {
		return onlineContests;
	}

	public static void addContest(String contestname)
	{
		onlineContests.add(contestname);
	}
	
	public static void removeContest(String contestname)
	{
		onlineContests.remove(contestname);
	}
	
	public static void reload() throws SQLException
	{
		onlineContests=null;
		onlineContests=new ArrayList<String>();
		LoadOnlineContests lc = new LoadOnlineContests();
		onlineContests = lc.loadAllContests();
	}

}
