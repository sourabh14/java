import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;  

@WebServlet("/home")
public class AnnotationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		pw.println("<h1>");
		pw.println("Welcome to the website!");
		pw.println("</h1>");

		pw.close();
	}
}