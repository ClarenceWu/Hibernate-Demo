<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>All Students</h2>
    <table class="table table-bordered">
        <thead>
            <tr><th>ID</th><th>Name</th><th>Actions</th></tr>
        </thead>
        <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                for (Student s : students) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td>
                    <form style="display:inline;" action="update" method="post" class="d-inline me-2">
                        <input type="hidden" name="id" value="<%= s.getId() %>"/>
                        <input type="text" name="name" value="<%= s.getName() %>" class="form-control d-inline w-auto"/>
                        <input type="submit" value="Update" class="btn btn-warning btn-sm"/>
                    </form>
                    <a href="delete?id=<%= s.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Delete?')">Delete</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <a href="index.html" class="btn btn-secondary">Back</a>
    <a href="logout" class="btn btn-outline-dark ms-2">Logout</a>
</body>
</html>
