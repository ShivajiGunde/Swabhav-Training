package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String studentIdStr = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String ageStr = req.getParameter("age");
        String city = req.getParameter("city");

        String errorMessage = null;

        int studentId = 0;
        int age = 0;

        // VALIDATION
        if (studentName == null || studentName.trim().isEmpty()) {
            errorMessage = "Student Name is required";
        } else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email is required";
        } else if (phone == null || phone.trim().isEmpty()) {
            errorMessage = "Phone is required";
        } else if (ageStr == null || ageStr.trim().isEmpty()) {
            errorMessage = "Age is required";
        } else if (city == null || city.trim().isEmpty()) {
            errorMessage = "City is required";
        }

        // ID validation
        try {
            studentId = Integer.parseInt(studentIdStr);
        } catch (Exception e) {
            errorMessage = "Invalid Student ID";
        }

        // AGE validation
        if (errorMessage == null) {
            try {
                age = Integer.parseInt(ageStr);

                if (age < 18) {
                    errorMessage = "Age must be 18 or above";
                }
            } catch (Exception e) {
                errorMessage = "Age must be a number";
            }
        }

        // CREATE STUDENT OBJECT
        Student student = new Student();
      student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAge(age);
        student.setCity(city);

        // IF ERROR → BACK TO EDIT PAGE
        if (errorMessage != null) {
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("student", student);

            req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp")
               .forward(req, resp);
            return;
        }

        // UPDATE DB
        StudentDAO dao = new StudentDAO();
        boolean status = false;

        try {
            status = dao.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // SUCCESS
        if (status) {
            resp.sendRedirect("ViewStudentsServlet");
            
        } else {
        	
            req.setAttribute("errorMessage", "Failed to update student");
            req.setAttribute("student", student);

            req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp")
               .forward(req, resp);
        }
    }
}