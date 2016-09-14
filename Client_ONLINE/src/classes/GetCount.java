package classes;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/GetCount")
public class GetCount {

	public int GetCounts(String contesttype) {
		
		int i = 0;
		
		try {
			java.sql.Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + contesttype, "root", "");

			java.sql.DatabaseMetaData totaltable = conn.getMetaData();
			ResultSet totalcontesttable = totaltable.getTables(null, null, "%",
					null);

			while (totalcontesttable.next()) {
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}
}
