import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		
		HttpSession session = req.getSession(false);
		session.invalidate();

		pw.println("Logged Out Successfully!!");

		pw.close();
	}
}