package ces.contest.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccessContest")
public class AccessContest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccessContest() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null)
			response.sendRedirect("index.jsp");

		String Contest = request.getParameter("Contest");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.write("<html><head>");
		out.write("<link rel='stylesheet' href='style.css'>");
		out.write("<title>Coding Environment System</title>");
		out.write("<script>function f1(){window.open('about.html','','width=1200,height=600');}</script>");
		out.write("<script>function f2(){window.open('help.html','','width=1000,height=800');}</script>");

		out.write("</head>");

		out.write("<body style='font-size:28px;'>");
		out.write("<table id='table' style='width:100%; height:100%;' cellpadding='0' cellspacing='0'>");
		out.write("<tr><td colspan='2' style='background-image:url(img/background.png);'>");
		out.write("<ul><li><a href=''>Menu</a></li><li><a href=''>Help</a></li></ul></td></tr>");
		out.write("<tr><td width='25%' height='840' style='background-image:url(img/background2.png);width:25%;vertical-align:top;'>");
		out.write("<b><a href='contest' style='color:#CCC;font-size:30px; text-decoration:none; padding-top:20%; padding-left:10%'>");
		out.write("<img src='img/backicon_small.png'>Back to Contests</img></a></b><br>");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/contest", "root", "");

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from " + Contest);

			while (rs.next()) {
				String ProblemCode = rs.getString("ProblemCode");
				String code = ProblemCode.replace("colreg", "");
				code = code.replace("_", " ");

				out.write("<br><a href='AccessQuestion?Contest="
						+ Contest
						+ "&ProblemCode="
						+ ProblemCode
						+ "' style='color:#CCC;font-size:30px; text-decoration:none; padding-top:10%; padding-left:30%'>"
						+ code + "</a>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.write("</td>");

		out.write("<td width='75%' style='background-image:url(img/background1.png);vertical-align:top; font-size:50px;padding-left:5%;'></br>");
		out.write("Click on question code to access the full information");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td height='10%' colspan='2' style='background-image:url(img/background.png);text-align:center;'>");
		out.write("<ul style='margin-left:25%;'>");
		out.write("<li style='padding-right:9%;'><input type='radio' name='lang' value='JAVA'>JAVA</li>");
		out.write("<li style='padding-right:9%;'><input type='radio' name='lang' value='C'>C</li>");
		out.write("<li style='padding-right:9%;'><input type='radio' name='lang' value='C++'>C++</li>");
		out.write("<li style='padding-right:9%;'><input type='radio' name='lang' value='Other'>Other</li>");
		out.write("<li style='padding-right:9%;'><a href=''><img src='img/browse_small.png'> Select File</a></li>");
		out.write("<li><a href=''><img src='img/submit_small.png'> Submit</a></li></ul></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</body></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
