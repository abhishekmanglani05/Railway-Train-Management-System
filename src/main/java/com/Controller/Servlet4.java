//package com.Controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.Dao.HelperFunction;
//import com.Modal.Customer;
//import com.Modal.Train;
//
///**
// * Servlet implementation class Servlet4
// */
//@WebServlet("/Servlet4")
//public class Servlet4 extends HttpServlet {
//	
//	
//	@Override
//	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//	         throws ServletException, IOException {
//		
//		PrintWriter p=resp.getWriter();
//		
//		// Fetch form values
//	    int trainNumber = Integer.parseInt(req.getParameter("train_number"));
//	    String trainName = req.getParameter("train_name");
//	    String originStation = req.getParameter("origin_station");
//	    String destinationStation = req.getParameter("destination_station");
//	    String departureTime = req.getParameter("departure_time"); // HH:mm
//	    String arrivalTime = req.getParameter("arrival_time");     // HH:mm
//	    int numberOfSeats = Integer.parseInt(req.getParameter("number_of_seats"));
//
//	    // Create Train object
//	    Train t = new Train(trainNumber,trainName,originStation,destinationStation,departureTime,arrivalTime,numberOfSeats);
//	    p.print(new HelperFunction().addtrain(t));
//		
//	 }
//	
//	
//}



package com.Controller;

import com.Dao.HelperFunction;
import com.Model.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {

	// Load the page (GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HelperFunction dao = new HelperFunction();
		List<Train> trains = dao.getAllTrains();

		req.setAttribute("trains", trains);
		req.getRequestDispatcher("RegisterTrain_UI_Task_3.jsp").forward(req, resp);
	}

	// Handle Add Train (POST)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String msg = null;
		String type = "error";

		try {
			// Fetch form values
			int trainNumber = Integer.parseInt(req.getParameter("train_number"));
			String trainName = trim(req.getParameter("train_name"));
			String originStation = trim(req.getParameter("origin_station"));
			String destinationStation = trim(req.getParameter("destination_station"));
			String departureTime = trim(req.getParameter("departure_time")); // HH:mm
			String arrivalTime = trim(req.getParameter("arrival_time")); // HH:mm
			int numberOfSeats = Integer.parseInt(req.getParameter("number_of_seats"));

			// Basic validations (optional but recommended)
			if (isBlank(trainName) || isBlank(originStation) || isBlank(destinationStation) || isBlank(departureTime)
					|| isBlank(arrivalTime)) {
				msg = "All fields are required and cannot be null or empty.";
			} else if (numberOfSeats <= 0) {
				msg = "Number of seats must be a positive integer.";
			} else if (originStation.equalsIgnoreCase(destinationStation)) {
				msg = "Destination must be different from Origin.";
			}

			if (msg == null) {
				// Create Train object (you have an all-args constructor)
				Train t = new Train(trainNumber, trainName, originStation, destinationStation, departureTime,
						arrivalTime, numberOfSeats);

				int result = new HelperFunction().addtrain(t);
				if (result == 1) {
					type = "success";
					msg = "Train registered successfully.";
				} else {
					// If you later add duplicate checks and return -2, handle here
					msg = "Failed to register train. Please check the data or database status.";
				}
			}
		} catch (NumberFormatException nfe) {
			msg = "Train Number and Number of Seats must be valid integers.";
		} catch (Exception e) {
			msg = "Unexpected server error while registering train.";
		}

		// Always fetch the list and forward to JSP
		HelperFunction dao = new HelperFunction();
		List<Train> trains = dao.getAllTrains();

		req.setAttribute("serverMessage", msg);
		req.setAttribute("serverMessageType", type);
		req.setAttribute("trains", trains);

		req.getRequestDispatcher("RegisterTrain_UI_Task_3.jsp").forward(req, resp);
	}

	private static String trim(String s) {
		return s == null ? null : s.trim();
	}

	private static boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}
}

