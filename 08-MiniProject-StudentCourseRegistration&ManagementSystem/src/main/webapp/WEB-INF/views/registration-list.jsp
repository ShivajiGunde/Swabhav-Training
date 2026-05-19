<%@ page import="java.util.*, com.studentcourse.model.Registration" %>

<%
    List<Registration> list = (List<Registration>) request.getAttribute("list");
%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Student ID</th>
        <th>Course ID</th>
        <th>Date</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

<%
    for (Registration r : list) {
%>

<tr>
    <td><%= r.getRegistrationId() %></td>
    <td><%= r.getStudentId() %></td>
    <td><%= r.getCourseId() %></td>
    <td><%= r.getRegistrationDate() %></td>
    <td><%= r.getStatus() %></td>

    <td>
        <a href="UpdateRegistrationStatusServlet?registrationId=<%= r.getRegistrationId() %>&status=COMPLETED">Complete</a>
        |
        <a href="DeleteRegistrationServlet?registrationId=<%= r.getRegistrationId() %>">Delete</a>
    </td>
</tr>

<% } %>

</table>