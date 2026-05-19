<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.studentcourse.model.Course"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Courses</title>

<style>
body {
	font-family: Arial;
	background-color: #f4f4f4;
	margin: 20px;
}

h2 {
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	background-color: white;
}

table, th, td {
	border: 1px solid #ccc;
}

th {
	background-color: #007bff;
	color: white;
	padding: 10px;
}

td {
	padding: 10px;
	text-align: center;
}

a {
	text-decoration: none;
	padding: 6px 10px;
	border-radius: 4px;
	color: white;
}

.edit-btn {
	background-color: green;
}

.delete-btn {
	background-color: red;
}

.add-btn {
	background-color: blue;
	padding: 10px 15px;
	display: inline-block;
	margin-bottom: 15px;
	color: white;
}
</style>

</head>
<body>

	<h2>Course List</h2>

	<a href="${pageContext.request.contextPath}/AddCourseServlet"
		class="add-btn"> Add New Course </a>

	<!-- <a href="/WEB-INF/views/course-form.jsp" class="add-btn"> -->
	<!--     Add New Course -->
	<!-- </a> -->

	<table>

		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Duration</th>
			<th>Fees</th>
			<th>Instructor</th>
			<th>Actions</th>
		</tr>

		<%
		List<Course> courseList = (List<Course>) request.getAttribute("courseList");

		if (courseList != null && !courseList.isEmpty()) {

			for (Course course : courseList) {
		%>

		<tr>

			<td><%=course.getCourseId()%></td>

			<td><%=course.getCourseName()%></td>

			<td><%=course.getDuration()%></td>

			<td><%=course.getFees()%></td>

			<td><%=course.getTrainerName()%></td>

			<td><a
				href="${pageContext.request.contextPath}/EditCourseServlet?courseId=<%= course.getCourseId() %>"
				class="edit-btn"> Edit </a> <a
				
				href="${pageContext.request.contextPath}/DeleteCourseServlet?courseId=<%= course.getCourseId() %>"
				class="delete-btn"
				onclick="return confirm('Are you sure to delete?')"> Delete </a></td>

		</tr>

		<%
		}
		} else {
		%>

		<tr>
			<td colspan="6">No Courses Found</td>
		</tr>

		<%
		}
		%>

	</table>

</body>
</html>