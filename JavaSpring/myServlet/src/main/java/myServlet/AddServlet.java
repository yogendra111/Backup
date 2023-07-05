package myServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
//		PrintWriter out = res.getWriter();
//		out.println(i+j);

		//Session Manangement
		req.setAttribute("add", i+j);
		
		RequestDispatcher rd = req.getRequestDispatcher("sqrt");
		rd.forward(req, res);
	}
}
