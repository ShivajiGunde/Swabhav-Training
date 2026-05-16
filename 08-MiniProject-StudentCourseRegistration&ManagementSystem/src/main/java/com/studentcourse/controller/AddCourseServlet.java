package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseName = request.getParameter("courseName");
        String duration = request.getParameter("duration");
        String feesStr = request.getParameter("fees");
        String trainerName = request.getParameter("trainerName");

        String errorMessage = null;
        double fees = 0;

        // ✅ SAFE validation (prevents NullPointerException)
        if (isNullOrEmpty(courseName) ||
            isNullOrEmpty(duration) ||
            isNullOrEmpty(trainerName) ||
            isNullOrEmpty(feesStr)) {

            errorMessage = "All fields are required.";
        }

        // ✅ Parse fees only if previous validation passed
        if (errorMessage == null) {
            try {
                fees = Double.parseDouble(feesStr);

                if (fees <= 0) {
                    errorMessage = "Fees must be greater than 0.";
                }

            } catch (NumberFormatException e) {
                errorMessage = "Fees must be a valid number.";
            }
        }

        // ❌ If error → return to form
        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/course-form.jsp");
            rd.forward(request, response);
            return;
        }

        // ✅ Save to DB
        Course course = new Course();
        course.setCourseName(courseName.trim());
        course.setDuration(duration.trim());
        course.setFees(fees);
        course.setTrainerName(trainerName.trim());

        CourseDAO dao = new CourseDAO();
        dao.addCourse(course);

        response.sendRedirect("ViewCoursesServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	doPost(req, resp);
    }

    // ✅ Helper method to avoid NullPointerException
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}