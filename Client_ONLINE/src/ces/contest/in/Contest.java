package ces.contest.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.GetCount;
import classes.GetTableName;

@WebServlet("/contest")
public class Contest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Contest() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null)
			response.sendRedirect("index.jsp");

		String sessionname = (String) session.getAttribute("name");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			out.write("<html><head>");
			out.write("<link rel='stylesheet' href='style.css'>");
			out.write("<title>Coding Environment System</title>");
			out.write("<script>function f1(){window.open('about.html','','width=1200,height=600');}</script>");
			out.write("<script>function f2(){window.open('help.html','','width=1000,height=800');}</script>");
			
			out.write("</head>");

			out.write("<body style='font-size:28px;'>");
			out.write("<div id=\"top\">");
			out.write("<ul>");

			GetCount gc = new GetCount();

			int totaltablecount = gc.GetCounts("contest");
			int totaltesttablecount = gc.GetCounts("testcontests");
			int totalpracticetablecount = gc.GetCounts("practicecontests");
			int totalonlinetablecount = gc.GetCounts("onlinecontests");

			out.write("<li><a href='#'>Total Contest:" + totaltablecount
					+ "</a></li>");
			out.write("<li><a href='#'>Test Contest:" + totaltesttablecount
					+ "</a></li>");
			out.write("<li><a href='#'>Practice Contest:"
					+ totalpracticetablecount + "</a></li>");
			out.write("<li><a href='#'>Total Online Contest:"
					+ totalonlinetablecount + "</a></li>");

			out.write("</ul>");
			out.write("</div>");
			out.write("</br></br></br>");

			out.write("<div id='midsection'>");
			out.println("<h5><img src='img/testtypeicon.png' width='40' height='40'>  TEST CONTESTS</img></h5>");

			/* get all tables */

			GetTableName gtn = new GetTableName();
			ResultSet testcontest = gtn.TestContest("testcontests");
			ResultSet onlinecontest = gtn.TestContest("onlinecontests");
			ResultSet practicecontest = gtn.TestContest("practicecontests");
			ResultSet Contests = null;

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/contest", "root", "");

			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			Contests = dbmd.getTables(null, null, "%", null);

			/* complete the process */

			/* access test mode contest */
			
			out.write("<div>");

			while (testcontest.next()) {

				String testcontests = testcontest.getString(3);
				onlinecontest.first();
				onlinecontest.beforeFirst();
				
				while (onlinecontest.next()) {
					String onlinecontests = onlinecontest.getString(3);

					if (testcontests.equals(onlinecontests)) {
						while (Contests.next()) {

							String Contest1 = Contests.getString(3);

							if (Contest1.equals(testcontests)) {

								String Contest = Contest1
										.replace("_colreg", "");
								Contest = Contest.replace("_", " ");

								out.write("<blockquote><blockquote>");
								out.write("<p><a href='AccessContest?Contest="
										+ Contest1
										+ "'><img src='img/table.png' width='40' height='40'/><br>"+Contest+"</a></p></blockquote></blockquote>");
							}
						}
					}
				}
				Contests.first();
				Contests.beforeFirst();
			}

			/* accessed test mode contest */

			out.write("</div>");
			out.write("<h5><img src='img/practicetypeicon.png' width='40' height='40'>  PRACTICE CONTESTS</img></h5>");

			/* access practice tables */
			
			out.write("<div>");

			while (practicecontest.next()) {

				String practicecontests = practicecontest.getString(3);

				onlinecontest.first();
				onlinecontest.beforeFirst();
				
				while (onlinecontest.next()) {
					String onlinecontests = onlinecontest.getString(3);

					if (practicecontests.equals(onlinecontests)) {
						while (Contests.next()) {

							String Contest1 = Contests.getString(3);

							if (Contest1.equals(practicecontests)) {

								String Contest = Contest1
										.replace("_colreg", "");
								Contest = Contest.replace("_", " ");

								out.write("<blockquote><blockquote>");
								out.write("<p><a href='AccessContest?Contest="
										+ Contest1
										+ "'><img src='img/table.png' width='40' height='40'/><br>"+Contest+"</a></p></blockquote></blockquote>");
							}
						}
					}
				}
				Contests.first();
				Contests.beforeFirst();
			}
			
			out.write("</div>");

			/* practice test contest table accessed */

			out.write("</div>");

			out.write("<div id='bottom'>");
			out.write("<ul>");
			out.write("<li><a href='refresh'><img src='img/Refreshicon.png'></img>");
			out.write("<figcaption>Refresh</figcaption>");
			out.write("</figure></a></li>");
			out.write("<li><a onClick='f1()' style='cursor:pointer;'><img src='img/jaricon.png'></img>");
			out.write("<figcaption>About CES</figcaption>");
			out.write("</figure></a></li></a></li>");
			out.write("<li><a onClick='f2()' style='cursor:pointer;'><img src='img/help.png'></img>");
			out.write("<figcaption>Help</figcaption>");
			out.write("</figure></a></li></a></li>");
			out.write("<li><a href='logout'><img src='img/logout.png'></img>");
			out.write("<figcaption>Logout</figcaption>");
			out.write("</figure></a></li></a></li>");
			out.write("<li><a href='#'><img src='img/basic.png'></img>");
			out.write("<figcaption>" + sessionname + "</figcaption>");
			out.write("</figure></a></li></a></li>");
			out.write("</ul>");
			out.write("</div>");

		} catch (Exception e) {
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
