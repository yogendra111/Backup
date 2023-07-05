package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int num = (int) req.getAttribute("add");
		PrintWriter out = res.getWriter();
		out.println("Hii Buddy\nSquare of number is "+ num*num);
	}
	
}
