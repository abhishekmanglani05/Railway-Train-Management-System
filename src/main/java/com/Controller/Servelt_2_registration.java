package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.HelperFunction;
import com.Model.Customer;

/**
 * Servlet implementation class Servelt_2_registration
 */
@WebServlet("/Servlet2")
public class Servelt_2_registration extends HttpServlet {
	private HelperFunction helper = new HelperFunction();
	
	
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		PrintWriter p=resp.getWriter();
		String uname=req.getParameter("ename");
		String uemail=req.getParameter("eemail");
		String upassword=req.getParameter("epassword");
		String uaddress=req.getParameter("eaddress");
		String ucontact=req.getParameter("econtact");
		
		Customer c=new Customer(uname,uemail,upassword,uaddress,ucontact);
		
//		p.print(new HelperFunction().insertCustomer(c));

		int result = new HelperFunction().insertCustomer(c);
		
		

		if(result > 0){
		    resp.sendRedirect("index_UI_Task_1.html"); // success → login page
		}else{
		    resp.getWriter().print("Registration Failed");
		}
	 }

}
