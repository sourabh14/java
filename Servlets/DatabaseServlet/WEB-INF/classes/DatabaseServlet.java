import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		// JDBC driver name and database URL
      	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      	final String DB_URL="jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";

      	//  Database credentials
      	final String USER = "root";
      	final String PASS = "root";

		// Set response content type
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<h1>");
		pw.println("Employee Database");
		pw.println("</h1>");

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			String sql = "SELECT * FROM empdetails;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");

				//Display values
				pw.println("ID: " + id + "<br>");
				pw.println(", Name: " + name + "<br>");
				pw.println(", Age: " + age + "<br>");
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.close();
	}
}