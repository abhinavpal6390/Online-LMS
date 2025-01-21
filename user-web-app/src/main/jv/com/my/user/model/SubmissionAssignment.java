package com.user.model;

public class SubmissionAssignment {
    private int userId;
    private int assignmentId;
    private int courseId;
    private String assignment;
    private String assignmentLink;
    private String createdDate;
    private String lastDate;
    private String submittedDate;

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getAssignmentId() { return assignmentId; }
    public void setAssignmentId(int assignmentId) { this.assignmentId = assignmentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getAssignment() { return assignment; }
    public void setAssignment(String assignment) { this.assignment = assignment; }

    public String getAssignmentLink() { return assignmentLink; }
    public void setAssignmentLink(String assignmentLink) { this.assignmentLink = assignmentLink; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getLastDate() { return lastDate; }
    public void setLastDate(String lastDate) { this.lastDate = lastDate; }

    public String getSubmittedDate() { return submittedDate; }
    public void setSubmittedDate(String submittedDate) { this.submittedDate = submittedDate; }
}
