package com.user.servlet;

import com.user.dao.AssignmentDAO;
import com.user.model.Assignment;
import com.user.utility.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AssignmentServlet", urlPatterns = {"/createAssignment", "/viewAssignments"})
public class AssignmentServlet extends HttpServlet {
    private AssignmentDAO assignmentDAO;

    @Override
    public void init() throws ServletException {
        Connection connection = DBConnection.getConnection();
        assignmentDAO = new AssignmentDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/createAssignment")) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            String assignmentText = request.getParameter("assignment");
            Date lastDate = Date.valueOf(request.getParameter("lastDate"));

            Assignment assignment = new Assignment();
            assignment.setCourseId(courseId);
            assignment.setAssignment(assignmentText);
            assignment.setLastDate(lastDate);

            boolean success = assignmentDAO.createAssignment(assignment);
            response.sendRedirect("assignmentManagement.jsp?status=" + (success ? "success" : "failure"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/viewAssignments")) {
            List<Assignment> assignments = assignmentDAO.getAllAssignments();
            request.setAttribute("assignments", assignments);
            request.getRequestDispatcher("assignmentManagement.jsp").forward(request, response);
        }
    }
}
