// Parameter Demo 
// Through URL - http://localhost:8080/paramdemo/welcome?fname=Sourabh&lname=Shrivastava
// Through Form - index.html	

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		String firstName = req.getParameter("fname");
		String lastname = req.getParameter("lname");

		PrintWriter pw = res.getWriter();

		pw.println("<h1>");
		pw.println("Welcome to the website!");
		pw.println("</h1>");

		pw.println("<h2>");
		pw.println("Parameter Demo");
		pw.println("Hello " + firstName + " " + lastname);
		pw.println("</h2>");

		pw.close();
	}
}