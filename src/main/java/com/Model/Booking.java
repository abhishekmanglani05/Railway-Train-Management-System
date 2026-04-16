package com.Model;

import java.time.LocalDate;
import java.util.List;



public class Booking {
	
	
	int bookingId;
    private int customerId;
    private int trainNumber;
    private String bookingDate;
    private int number_of_seats;
    double fare;
    private String status;
    
    
    
	public Booking(int customerId, int trainNumber, String bookingDate, int number_of_seats,
			double fare, String status) {
		super();
		this.customerId = customerId;
		this.trainNumber = trainNumber;
		this.bookingDate = bookingDate;
		this.number_of_seats = number_of_seats;
		this.fare = fare;
		this.status = status;
	}
	
	
	public Booking() {
		super();
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", trainNumber=" + trainNumber
				+ ", bookingDate=" + bookingDate + ", number_of_seats=" + number_of_seats + ", fare=" + fare
				+ ", status=" + status + "]";
	}


	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
    
	
    
	
	
    
}

