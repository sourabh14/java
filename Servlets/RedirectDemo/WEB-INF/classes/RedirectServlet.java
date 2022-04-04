import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RedirectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException {

		res.setContentType("text/html");

		String searchtext = req.getParameter("searchtext");

		// The sendRedirect() method of HttpServletResponse interface 
		// can be used to redirect response to another resource, 
		// it may be servlet, jsp or html file
		res.sendRedirect("http://www.google.com/search?q=" + searchtext);

		//differences between the forward() method of RequestDispatcher and 
		// sendRedirect() method of HttpServletResponse interface. They 
		// are given below:

		// 1. 
		// forward() method works at server side.	
		// sendRedirect() method works at client side.

		// 2. 
		// forward() It sends the same request and response objects to another servlet.	
		// sendRedirect() It always sends a new request.
	}
}