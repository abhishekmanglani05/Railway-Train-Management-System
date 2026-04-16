package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.HelperFunction;
import com.Model.Booking;

/**
 * Servlet implementation class insertbooking
 */
@WebServlet("/insertbooking")
public class insertbooking extends HttpServlet {
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	PrintWriter p=resp.getWriter();
	
	// Fetch form values
	int customer_id = Integer.parseInt(req.getParameter("customerId"));
	int  train_number= Integer.parseInt(req.getParameter("trainNumber"));
	String booking_date= req.getParameter("bookingDate");
	int number_of_seats= Integer.parseInt(req.getParameter("numberOfSeats"));
	Double fare = Double.parseDouble(req.getParameter("fare")); 
	String status = req.getParameter("status");  
	
	Booking b=new Booking(customer_id,train_number,booking_date,number_of_seats,fare,status);
	
	p.print(new HelperFunction().insertbooking(b));
	 }

}
