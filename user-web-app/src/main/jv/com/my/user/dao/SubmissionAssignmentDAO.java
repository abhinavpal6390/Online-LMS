package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.SubmissionAssignment;

public class SubmissionAssignmentDAO {
    private Connection conn;

    /**
     * Constructor to initialize DAO with a database connection.
     * @param conn the database connection to be used
     */
    public SubmissionAssignmentDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Filters submissions by course ID and assignment ID.
     *
     * @param courseId the ID of the course
     * @param assignmentId the ID of the assignment
     * @return a list of SubmissionAssignment objects matching the criteria
     * @throws SQLException if a database error occurs
     */
    public List<SubmissionAssignment> filterByCourseAndAssignment(int courseId, int assignmentId) throws SQLException {
        String query = "SELECT * FROM submission_assignment WHERE course_id = ? AND assignment_id = ?";
        List<SubmissionAssignment> submissions = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courseId);
            ps.setInt(2, assignmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SubmissionAssignment sa = new SubmissionAssignment();
                    sa.setUserId(rs.getInt("user_id"));
                    sa.setAssignmentId(rs.getInt("assignment_id"));
                    sa.setCourseId(rs.getInt("course_id"));
                    sa.setAssignment(rs.getString("assignment"));
                    sa.setAssignmentLink(rs.getString("assignment_link"));
                    sa.setCreatedDate(rs.getString("created_date"));
                    sa.setLastDate(rs.getString("last_date"));
                    sa.setSubmittedDate(rs.getString("submitted_date"));
                    submissions.add(sa);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching submissions: " + e.getMessage(), e);
        }

        return submissions;
    }
}
