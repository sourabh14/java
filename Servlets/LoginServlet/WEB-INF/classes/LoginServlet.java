import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		// RequestDispatcher interface provides the facility of 
		// dispatching the request to another resource it may be html, servlet or jsp

		// forward() - :Forwards a request from a servlet to another resource
		// include() - Includes the content of a resource (servlet, JSP page, or HTML file) 
		// in the response.

		if (uname.equals("admin") && pass.equals("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome");
			rd.forward(req, res);
		}
		else {
			pw.println("Incorrect Username/Password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}

		pw.close();
	}
}