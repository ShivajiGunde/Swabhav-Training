package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {

    CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("courseId");

        // VALIDATION 1: empty or null check
        if (idStr == null || idStr.trim().isEmpty()) {

            request.setAttribute("errorMessage", "Invalid Course ID");

            request.getRequestDispatcher("/WEB-INF/views/course-list.jsp")
                   .forward(request, response);

            return; // IMPORTANT
        }

        int courseId;

        // VALIDATION 2: number format check
        try {
            courseId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {

            request.setAttribute("errorMessage", "Course ID must be a number");

            request.getRequestDispatcher("/WEB-INF/views/course-list.jsp")
                   .forward(request, response);

            return;
        }

        // DELETE OPERATION
        boolean deleted = courseDAO.deleteCourse(courseId);

        if (deleted) {

            response.sendRedirect("ViewCoursesServlet");

        } else {

            request.setAttribute("errorMessage", "Failed to delete course");

            request.getRequestDispatcher("/WEB-INF/views/course-list.jsp")
                   .forward(request, response);
        }
    }
}