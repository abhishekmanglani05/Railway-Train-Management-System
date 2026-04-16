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
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    private HelperFunction helper = new HelperFunction();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	PrintWriter p=resp.getWriter();

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("customerId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("customerId");

        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String contactNumber = req.getParameter("contactNumber");

        Customer c = new Customer();
        c.setUserId(userId);
        c.setEmail(email);
        c.setAddress(address);
        c.setContactNumber(contactNumber);

        int result = new HelperFunction().updateCustomerDetails(c);
        p.print(result);
//        if (result > 0) {
//            // Update session values too
//            session.setAttribute("email", email);
//
//            req.setAttribute("msg", "Profile updated successfully.");
//        } else {
//            req.setAttribute("msg", "Update failed. Please try again.");
//        }
//
//        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
//        rd.forward(req, resp);
    }
}
