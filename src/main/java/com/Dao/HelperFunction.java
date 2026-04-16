package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.Model.Booking;
import com.Model.Customer;
import com.Model.Train;

public class HelperFunction {

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
            "jdbc:postgresql://ep-withered-heart-am94fy7r.c-5.us-east-1.aws.neon.tech/neondb?sslmode=require",
            "neondb_owner",
            "npg_hk78EzVLquWb"
        );
    }

    // Register Customer
    public int insertCustomer(Customer c) {
        int check = 0;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "insert into Customer (user_name, email, password, address, contact_number) values(?,?,?,?,?)")) {

            pst.setString(1, c.getUserName());
            pst.setString(2, c.getEmail());
            pst.setString(3, c.getPassword());
            pst.setString(4, c.getAddress());
            pst.setString(5, c.getContactNumber());

            check = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // Login Customer
    public Customer loginCustomer(String username, String password) {
        Customer c = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT user_id, user_name, email, address, contact_number FROM Customer WHERE user_name = ? AND password = ?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Customer();
                c.setUserId(rs.getInt("user_id"));
                c.setUserName(rs.getString("user_name"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));
                c.setContactNumber(rs.getString("contact_number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    // Add Train
    public int addtrain(Train t) {
        int check = 0;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "insert into Train (train_number, train_name, origin_station, destination_station, departure_time, arrival_time, number_of_seats) values(?,?,?,?,?,?,?)")) {

            pst.setInt(1, t.getTrainNumber());
            pst.setString(2, t.getTrainName());
            pst.setString(3, t.getOriginStation());
            pst.setString(4, t.getDestinationStation());
            pst.setTime(5, Time.valueOf(t.getDepartureTime() + ":00"));
            pst.setTime(6, Time.valueOf(t.getArrivalTime() + ":00"));
            pst.setInt(7, t.getNumberOfSeats());

            check = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // Insert Booking
    public int insertbooking(Booking b) {
        int check = 0;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "insert into Booking (customer_id, train_number, booking_date, number_of_seat, fare, status) values(?,?,?,?,?,?)")) {

            pst.setInt(1, b.getCustomerId());
            pst.setInt(2, b.getTrainNumber());
            pst.setDate(3, java.sql.Date.valueOf(b.getBookingDate()));
            pst.setInt(4, b.getNumber_of_seats());
            pst.setDouble(5, b.getFare());
            pst.setString(6, b.getStatus());

            check = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // Delete Booking
    public int deletebooking(int bookingid) {
        int check = 0;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "delete from Booking where booking_id=?")) {

            pst.setInt(1, bookingid);
            check = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    // Get All Trains
    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(
                     "SELECT train_number, train_name, origin_station, destination_station, departure_time, arrival_time, number_of_seats FROM Train ORDER BY train_number")) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Train t = new Train();
                t.setTrainNumber(rs.getInt("train_number"));
                t.setTrainName(rs.getString("train_name"));
                t.setOriginStation(rs.getString("origin_station"));
                t.setDestinationStation(rs.getString("destination_station"));

                Time dep = rs.getTime("departure_time");
                Time arr = rs.getTime("arrival_time");

                t.setDepartureTime(dep != null ? dep.toString().substring(0, 5) : null);
                t.setArrivalTime(arr != null ? arr.toString().substring(0, 5) : null);

                t.setNumberOfSeats(rs.getInt("number_of_seats"));

                trains.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trains;
    }

    // Get Trains By Route
    public static List<Train> getTrainsByRoute(String boarding, String destination) {

        List<Train> list = new ArrayList<>();

        String sql = "SELECT * FROM TRAIN WHERE ORIGIN_STATION = ? AND DESTINATION_STATION = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://ep-withered-heart-am94fy7r.c-5.us-east-1.aws.neon.tech/neondb?sslmode=require",
                "neondb_owner",
                "npg_hk78EzVLquWb"
            );

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, boarding);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Train t = new Train();
                t.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                t.setTrainName(rs.getString("TRAIN_NAME"));
                t.setOriginStation(rs.getString("ORIGIN_STATION"));
                t.setDestinationStation(rs.getString("DESTINATION_STATION"));
                t.setDepartureTime(rs.getString("DEPARTURE_TIME"));
                t.setArrivalTime(rs.getString("ARRIVAL_TIME"));
                t.setNumberOfSeats(rs.getInt("NUMBER_OF_SEATS"));

                list.add(t);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Get Bookings By Customer
    public List<Booking> getBookingsByCustomerId(int customerId) {

        List<Booking> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT booking_id, train_number, booking_date, number_of_seat, fare, status FROM Booking WHERE customer_id = ? ORDER BY booking_date DESC")) {

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                b.setTrainNumber(rs.getInt("train_number"));
                b.setBookingDate(rs.getDate("booking_date").toString());
                b.setNumber_of_seats(rs.getInt("number_of_seat"));
                b.setFare(rs.getDouble("fare"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update Customer
    public int updateCustomerDetails(Customer c) {

        int check = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE Customer SET email = ?, address = ?, contact_number = ? WHERE user_id = ?")) {

            ps.setString(1, c.getEmail());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getContactNumber());
            ps.setInt(4, c.getUserId());

            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}