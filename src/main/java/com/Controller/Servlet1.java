//package com.Controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.Dao.HelperFunction;
//import com.Model.Booking;
//import com.Model.Customer;
//import com.Model.Train;
//
//
//@WebServlet("/req1")
//public class Servlet1 extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		// to insert / register CUSTOMER :  
//		
////		PrintWriter p=resp.getWriter();
////		String uname=req.getParameter("ename");
////		String uemail=req.getParameter("eemail");
////		String upassword=req.getParameter("epassword");
////		String uaddress=req.getParameter("eaddress");
////		String ucontact=req.getParameter("econtact");
////		
////		Customer c=new Customer(uname,uemail,upassword,uaddress,ucontact);
////		
////		
////		
////		p.print(new HelperFunction().insertCustomer(c));
//		// TODO Auto-generated method stub
//		
//		
//		// To Login Customer : 
//		
////		PrintWriter p=resp.getWriter();
////		String uname=req.getParameter("username");
////		String password=req.getParameter("password");
////		
//////		Customer c=HelperFunction().loginCustomer(uname, password);
////		p.print(new HelperFunction().loginCustomer(uname, password));
//		
//		
//		// To add Trains: 
////		PrintWriter p=resp.getWriter();
////		
////		// Fetch form values
////        int trainNumber = Integer.parseInt(req.getParameter("train_number"));
////        String trainName = req.getParameter("train_name");
////        String originStation = req.getParameter("origin_station");
////        String destinationStation = req.getParameter("destination_station");
////        String departureTime = req.getParameter("departure_time"); // HH:mm
////        String arrivalTime = req.getParameter("arrival_time");     // HH:mm
////        int numberOfSeats = Integer.parseInt(req.getParameter("number_of_seats"));
////
////        // Create Train object
////        Train t = new Train(trainNumber,trainName,originStation,destinationStation,departureTime,arrivalTime,numberOfSeats);
////        p.print(new HelperFunction().addtrain(t));
//        
//        
//        
//        
////        t.setTrainNumber(trainNumber);
////        t.setTrainName(trainName);
////        t.setOriginStation(originStation);
////        t.setDestinationStation(destinationStation);
////        t.setDepartureTime(departureTime);
////        t.setArrivalTime(arrivalTime);
////        t.setNumberOfSeats(Integer.parseInt(numberOfSeats));
//        
//        
//        
//        // date - 08/01/26
//        
////        PrintWriter p=resp.getWriter();
////		
////		// Fetch form values
////        int customer_id = Integer.parseInt(req.getParameter("customerId"));
////        int  train_number= Integer.parseInt(req.getParameter("trainNumber"));
////        String booking_date= req.getParameter("bookingDate");
////        int number_of_seats= Integer.parseInt(req.getParameter("numberOfSeats"));
////        Double fare = Double.parseDouble(req.getParameter("fare")); 
////        String status = req.getParameter("status");     
////
////        // Create Train object
//////        Train t = new Train(trainNumber,trainName,originStation,destinationStation,departureTime,arrivalTime,numberOfSeats);
////        Booking b=new Booking(customer_id,train_number,booking_date,number_of_seats,fare,status);
////        p.print(new HelperFunction().insertbooking(b));
//		
//		
//		 PrintWriter p=resp.getWriter();
//		 int bookingid=Integer.parseInt(req.getParameter("bookingid"));
//		 
//		 p.print(new HelperFunction().deletebooking(bookingid));
//		
//        
//        
//        
//	}
//	
//}



// day - saturday - 10/01/26

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


//@WebServlet("/req1")
//public class Servlet1 extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		PrintWriter p=resp.getWriter();
//		String uname=req.getParameter("ename");
//		String uemail=req.getParameter("eemail");
//		String upassword=req.getParameter("epassword");
//		String uaddress=req.getParameter("eaddress");
//		String ucontact=req.getParameter("econtact");
//		
//		Customer c=new Customer(uname,uemail,upassword,uaddress,ucontact);
//		
//		
//		
//		p.print(new HelperFunction().insertCustomer(c));
//		
//		
//		
//		// Update Customer 
////		PrintWriter p=resp.getWriter();
////		int userid=Integer.parseInt(req.getParameter("user_id"));
////		String email=req.getParameter("email");
////		String contact_number=req.getParameter("contact_number");
////		String address=req.getParameter("address");
////		String password=req.getParameter("password");
////		
////		p.print(new HelperFunction().updateCustomer(userid,email,contact_number,address,password));
//		
//		
//		// Login Admin : 
////		PrintWriter p=resp.getWriter();
////		String uname=req.getParameter("username");
////		String password=req.getParameter("password");
////		
////		System.out.println(password);
////		System.out.println(uname);
////		
////		if(uname.equalsIgnoreCase("admin") && password.equalsIgnoreCase("Admin@123")) {
////			p.print("you have successfully logged in ");;
////		}
////		else {
////			p.print("Incorrect Credentials");
////		}
//		
//		// TODO Auto-generated method stub
//		
//		
//		 // date - 08/01/26
//        
////      PrintWriter p=resp.getWriter();
////		
////		// Fetch form values
////      int customer_id = Integer.parseInt(req.getParameter("customerId"));
////      int  train_number= Integer.parseInt(req.getParameter("trainNumber"));
////      String booking_date= req.getParameter("bookingDate");
////      int number_of_seats= Integer.parseInt(req.getParameter("numberOfSeats"));
////      Double fare = Double.parseDouble(req.getParameter("fare")); 
////      String status = req.getParameter("status");     
////
////      // Create Train object
//////      Train t = new Train(trainNumber,trainName,originStation,destinationStation,departureTime,arrivalTime,numberOfSeats);
////      Booking b=new Booking(customer_id,train_number,booking_date,number_of_seats,fare,status);
////      p.print(new HelperFunction().insertbooking(b));
//		
//		
////		 PrintWriter p=resp.getWriter();
////		 int bookingid=Integer.parseInt(req.getParameter("bookingid"));
////		 
////		 p.print(new HelperFunction().deletebooking(bookingid));
//		
//		
//		
//		// Login Customer : 
//		
////		PrintWriter p=resp.getWriter();
////		String uname=req.getParameter("username");
////		String password=req.getParameter("password");
////		
//////		Customer c=HelperFunction().loginCustomer(uname, password);
////		p.print(new HelperFunction().loginCustomer(uname, password));
//		
//      
//
//	}
//	
//}



//For Tomcat 9 / Servlet 4:

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;

//For Tomcat 10+ / Servlet 5+, use:
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;

 // <-- adjust to your package


//PrintWriter p=resp.getWriter();
//String uname=req.getParameter("ename");
//String uemail=req.getParameter("eemail");
//String upassword=req.getParameter("epassword");
//String uaddress=req.getParameter("eaddress");
//String ucontact=req.getParameter("econtact");
//
//Customer c=new Customer(uname,uemail,upassword,uaddress,ucontact);
//
//
//
//p.print(new HelperFunction().insertCustomer(c));



// Update Customer 
//PrintWriter p=resp.getWriter();
//int userid=Integer.parseInt(req.getParameter("user_id"));
//String email=req.getParameter("email");
//String contact_number=req.getParameter("contact_number");
//String address=req.getParameter("address");
//String password=req.getParameter("password");
//
//p.print(new HelperFunction().updateCustomer(userid,email,contact_number,address,password));


// Login Admin : 
//PrintWriter p=resp.getWriter();
//String uname=req.getParameter("username");
//String password=req.getParameter("password");
//
//System.out.println(password);
//System.out.println(uname);
//
//if(uname.equalsIgnoreCase("admin") && password.equalsIgnoreCase("Admin@123")) {
//	p.print("you have successfully logged in ");;
//}
//else {
//	p.print("Incorrect Credentials");
//}

// TODO Auto-generated method stub


 // date - 08/01/26

//PrintWriter p=resp.getWriter();
//
//// Fetch form values
//int customer_id = Integer.parseInt(req.getParameter("customerId"));
//int  train_number= Integer.parseInt(req.getParameter("trainNumber"));
//String booking_date= req.getParameter("bookingDate");
//int number_of_seats= Integer.parseInt(req.getParameter("numberOfSeats"));
//Double fare = Double.parseDouble(req.getParameter("fare")); 
//String status = req.getParameter("status");     
//
//// Create Train object
////Train t = new Train(trainNumber,trainName,originStation,destinationStation,departureTime,arrivalTime,numberOfSeats);
//Booking b=new Booking(customer_id,train_number,booking_date,number_of_seats,fare,status);
//p.print(new HelperFunction().insertbooking(b));


// PrintWriter p=resp.getWriter();
// int bookingid=Integer.parseInt(req.getParameter("bookingid"));
// 
// p.print(new HelperFunction().deletebooking(bookingid));

@WebServlet("/req1")
public class Servlet1 extends HttpServlet {

 private HelperFunction helper = new HelperFunction();

 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {

     String uname = req.getParameter("username");
     String password = req.getParameter("password");

     Customer customer = helper.loginCustomer(uname, password);

     if (customer != null) {
         HttpSession session = req.getSession(true);
         // Store whole customer (handy later)
         session.setAttribute("customer", customer);
         // Also store username separately for easy access in JSP
         session.setAttribute("customerId",customer.getUserId());
         session.setAttribute("userName", customer.getUserName());
         session.setAttribute("userId", customer.getUserId());
         session.setAttribute("email", customer.getEmail());

         // Go to the portal JSP
//         System.out.println("i am here.");
         resp.sendRedirect("home");
     } else {
         req.setAttribute("error", "Invalid username or password.");
         RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
         rd.forward(req, resp);
     }
 }
}

