package classes;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/GetTableName")
public class GetTableName {

	public ResultSet TestContest(String Contestname) {

		ResultSet totalcontesttable = null;

		try {
			java.sql.Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/"+Contestname, "root", "");

			java.sql.DatabaseMetaData totaltable = conn.getMetaData();
			totalcontesttable = totaltable.getTables(null, null, "%",
					null);
		} catch (Exception e) {
		}
		return totalcontesttable;
	}

}
