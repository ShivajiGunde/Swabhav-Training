package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Course;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationFormServlet")
public class RegistrationFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();

        try {
            List<Student> studentList = studentDAO.getAllStudents();
            List<Course> courseList = courseDAO.getAllCourses();

            req.setAttribute("studentList", studentList);
            req.setAttribute("courseList", courseList);

            req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            throw new ServletException("Failed to load registration form data", e);
        }
    }
}