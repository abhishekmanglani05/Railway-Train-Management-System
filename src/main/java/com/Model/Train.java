package com.Model;

import java.time.LocalTime;

public class Train {
	
	private int trainNumber;
    private String trainName;
    private String originStation;
    private String destinationStation;
    private String departureTime;
    private String arrivalTime;
    public Train() {
		super();
	}
	private int numberOfSeats;
	public Train(int trainNumber, String trainName, String originStation, String destinationStation,
			String departureTime, String arrivalTime, int numberOfSeats) {
		super();
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.numberOfSeats = numberOfSeats;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getOriginStation() {
		return originStation;
	}
	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", trainName=" + trainName + ", originStation=" + originStation
				+ ", destinationStation=" + destinationStation + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", numberOfSeats=" + numberOfSeats + "]";
	}
    
    

}

