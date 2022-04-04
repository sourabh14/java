import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		Cookie cks[] = req.getCookies();

		if (cks != null) {
			pw.println("<h1>");
			pw.println("Home Page");
			pw.println("</h1>");
			pw.println("<br>");

			pw.println("<a href='/cookiedemo/products'>Products</a>");
			pw.println("<br>");
			pw.println("<a href='/cookiedemo/aboutus'>About Us</a>");
			pw.println("<br>");
			pw.println("<a href='/cookiedemo/logout'>Log Out</a>");
			pw.println("<br>");
			pw.println("<br>");
			
			pw.println("Welome user: " + cks[0].getValue());
		}
		else {
			pw.println("Please Login!!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}

		pw.close();
	}
}