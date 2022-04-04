import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AboutUsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession(false);

		if (session != null) {
			pw.println("<h1>");
			pw.println("About Us Page");
			pw.println("</h1>");
			pw.println("<br>");

			pw.println("<a href='/httpsessiondemo/home'>Home</a>");
			pw.println("<br>");
			pw.println("<a href='/httpsessiondemo/products'>Products</a>");
			pw.println("<br>");
			pw.println("<a href='/httpsessiondemo/logout'>Log Out</a>");
			pw.println("<br>");
			pw.println("<br>");
			
			pw.println("Welome user: " + (String)session.getAttribute("uname"));
			pw.println("Session Id: " + (String)session.getId());
		}
		else {
			pw.println("Please Login!!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}

		pw.close();
	}
}