package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.HelperFunction;
import com.Model.Customer;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	
	
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		
		
		// Login Admin : 
		PrintWriter p=resp.getWriter();
		String uname=req.getParameter("username");
		String password=req.getParameter("password");
	
	//System.out.println(password);
	//System.out.println(uname);
	//
		if(uname.equalsIgnoreCase("admin") && password.equalsIgnoreCase("Admin@123")) {
			resp.sendRedirect("admin_UI_Task_3.jsp");
//		p.print("you have successfully logged in ");;
		}
		else {
			resp.getWriter().print("Registration Failed");
//		p.print("Incorrect Credentials");
		}

	 }
	
	
//	// Login Admin : 
////PrintWriter p=resp.getWriter();
////String uname=req.getParameter("username");
////String password=req.getParameter("password");
////
////System.out.println(password);
////System.out.println(uname);
////
////if(uname.equalsIgnoreCase("admin") && password.equalsIgnoreCase("Admin@123")) {
////	p.print("you have successfully logged in ");;
////}
////else {
////	p.print("Incorrect Credentials");
////}

}
