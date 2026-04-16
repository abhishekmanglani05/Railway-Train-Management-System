package com.Controller;


import com.Dao.HelperFunction;
import com.Model.Train;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req2")
public class SearchTrainsServlet extends HttpServlet {

    @Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String boarding = request.getParameter("boarding");
        String destination = request.getParameter("destination");

        List<Train> trains =
                new HelperFunction().getTrainsByRoute(boarding, destination);

        request.setAttribute("trains", trains);
        request.setAttribute("boarding", boarding);
        request.setAttribute("destination", destination);

        // 🔁 SAME PAGE RENDER
        
        request.setAttribute("showBookingForm", true);
        request.getRequestDispatcher("home.jsp")
               .forward(request, response);
    }
}
