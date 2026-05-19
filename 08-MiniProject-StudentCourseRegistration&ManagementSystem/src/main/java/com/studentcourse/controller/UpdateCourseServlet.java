package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String idStr = req.getParameter("courseId");
        String courseName = req.getParameter("courseName");
        String duration = req.getParameter("duration");
        String feesStr = req.getParameter("fees");
        String trainerName = req.getParameter("trainerName");

        String errorMessage = null;

        // VALIDATION
        if (courseName == null || courseName.trim().isEmpty()) {

            errorMessage = "Course Name is required";

        } else if (duration == null || duration.trim().isEmpty()) {

            errorMessage = "Duration is required";

        } else if (feesStr == null || feesStr.trim().isEmpty()) {

            errorMessage = "Fees is required";

        } else if (trainerName == null || trainerName.trim().isEmpty()) {

            errorMessage = "Trainer Name is required";
        }

        int courseId = 0;

        if (idStr == null || idStr.trim().isEmpty()) {
            errorMessage = "Course ID is missing";
        } else {
            try {
                courseId = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                errorMessage = "Invalid Course ID";
            }
        }

        double fees = 0;

        if (errorMessage == null) {

            try {
                fees = Double.parseDouble(feesStr);

                if (fees <= 0) {
                    errorMessage = "Fees must be greater than 0";
                }

            } catch (NumberFormatException e) {
                errorMessage = "Fees must be a valid number";
            }
        }

        Course course = new Course();

        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setFees(fees);
        course.setTrainerName(trainerName);

        // IF ERROR
        if (errorMessage != null) {

            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("course", course);

            req.getRequestDispatcher("/WEB-INF/views/course-edit.jsp")
                    .forward(req, resp);

            return;
        }

        CourseDAO dao = new CourseDAO();

        boolean status = false;

        try {
            status = dao.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (status) {

            resp.sendRedirect("ViewCoursesServlet");

        } else {

            req.setAttribute("errorMessage", "Failed to Update Course");
            req.setAttribute("course", course);

            req.getRequestDispatcher("/WEB-INF/views/course-edit.jsp")
                    .forward(req, resp);
        }
    }
}