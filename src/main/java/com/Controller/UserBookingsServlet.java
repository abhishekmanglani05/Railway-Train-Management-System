package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.HelperFunction;
import com.Model.Booking;

/**
 * Servlet implementation class UserBookingsServlet
 */
@WebServlet("/home")
public class UserBookingsServlet extends HttpServlet {

    private HelperFunction helper = new HelperFunction();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("customerId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int customerId = (int) session.getAttribute("customerId");

        List<Booking> bookings = helper.getBookingsByCustomerId(customerId);

        req.setAttribute("bookings", bookings);
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);
    }
}

