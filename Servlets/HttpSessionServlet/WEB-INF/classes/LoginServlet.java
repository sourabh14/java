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

		if (uname.equals("admin") && pass.equals("admin")) {
			HttpSession session = req.getSession();  
        	session.setAttribute("uname", uname); 

			res.sendRedirect("home");
		}
		else {
			pw.println("Incorrect Username/Password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}

		pw.close();
	}
}