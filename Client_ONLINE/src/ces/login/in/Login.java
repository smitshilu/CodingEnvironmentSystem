package ces.login.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int i = 0;
	public Login() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String username = request.getParameter("username");
		String pass = request.getParameter("pass");

		String sql = "select * from student_login where username='" + username + "'";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/login",
					"root", "");
			Statement s = conn.createStatement();

			java.sql.ResultSet rs = s.executeQuery(sql);
			String un = "null";
			String pw = "null";

			while (rs.next()) {
				un = rs.getString("Username");
				pw = rs.getString("Password");
			}

			if (un.equals(username) && pw.equals(pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", un);
				
				response.sendRedirect("contest");
				
				
			} else {
				
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.write("<h1>Coding Environment System</h1>");
				out.write("<b>Wrong Username or Password<br>");
				out.write("For login: <a href='index.jsp'>Click here</a></b>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
