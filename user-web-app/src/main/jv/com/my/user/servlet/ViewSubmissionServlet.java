package com.user.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation to define the Servlet URL mapping
@WebServlet("/ViewSubmissionServlet")
public class ViewSubmissionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Add attributes to the request if needed
            request.setAttribute("message", "Welcome to View Submission Page!");

            // Forwarding to the JSP page
            request.getRequestDispatcher("/viewSubmission.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle errors gracefully
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if needed
        doGet(request, response); // Default behavior: handle POST as GET
    }
}
