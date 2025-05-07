package com.example.servlet;

import com.example.entity.User;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            boolean exists = session.createQuery("FROM User WHERE username = :username", User.class)
                                    .setParameter("username", username)
                                    .uniqueResult() != null;

            if (exists) {
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h3 style='color:red'>Username already exists!</h3>");
                out.println("<a href='register.html'>Try again</a>");
                out.println("</body></html>");
            } else {
                session.save(new User(username, password));
                tx.commit();
                resp.sendRedirect("login.html");
            }
        }
    }
}
