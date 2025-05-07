package com.example.servlet;

import com.example.entity.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private final StudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = service.listAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
