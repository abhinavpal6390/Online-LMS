// Servlet Package
package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.AdminDAO;
import com.user.utility.AdminDBC;

@WebServlet("/adminLogin")
public class Adminservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = AdminDBC.getConnection();
        AdminDAO adminDAO = new AdminDAO(connection);

        boolean isValid = adminDAO.validateAdmin(email, password);

        if (isValid) {
            response.sendRedirect("Admin-dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
