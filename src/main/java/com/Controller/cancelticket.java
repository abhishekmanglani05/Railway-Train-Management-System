package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.HelperFunction;

/**
 * Servlet implementation class cancelticket
 */
@WebServlet("/cancelticket")
public class cancelticket extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 PrintWriter p=resp.getWriter();
		 int bookingid=Integer.parseInt(req.getParameter("bookingid"));
		 
		 p.print(new HelperFunction().deletebooking(bookingid));
	}

}
